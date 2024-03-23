package productosImpl;

import modelo.TarjetaCredito;
import modelo.Usuario;
import java.util.Random;


public class TarjetaCreditoImpl implements TarjetaCredito {
    private String titular;
	private double limiteCredito;
    private double saldo;
    private static final double TASA_INTERES = 0.0298;
    private String numeroTarjeta;
    private String fechaVencimiento;
    private int codigoSeguridad;


    private TarjetaCreditoImpl(Builder builder) {
    	this.titular = builder.titular;
        this.limiteCredito = builder.limiteCredito;
        this.saldo = 0; 
        this.numeroTarjeta = generarNumeroTarjeta();
        this.fechaVencimiento = generarFechaVencimiento();
        this.codigoSeguridad = generarCodigoSeguridad();
    }

    @Override
    public boolean validarRequisitos(Usuario usuario) {
        return usuario.getScoreDatacredito() >= 800 && usuario.getIngresoMensual() >= 1800000 && usuario.getEdad() >= 21;
    }

    @Override
    public boolean autorizarCompra(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }
        if (monto + saldo <= limiteCredito) {
            saldo += monto;
            return true;
        }
        return false;
    }

    @Override
    public void pagarSaldo(double monto) {
        if (monto > saldo) {
            throw new IllegalArgumentException("El monto a pagar excede el saldo actual.");
        }
        saldo -= monto;
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public double consultarLimiteCredito() {
        return limiteCredito;
    }
    
    public static String generarNumeroTarjeta() {
        Random random = new Random();
        String numeroTarjeta = "";
        do {
            for (int i = 0; i < 16; i++) {
                numeroTarjeta += random.nextInt(10); 
            }
        } while (!esNumeroTarjetaValido(numeroTarjeta));
        
      
        String numeroTarjetaFormateado = numeroTarjeta.replaceAll("(.{4})(?!$)", "$1-");
        return numeroTarjetaFormateado;
    }

    
    private static boolean esNumeroTarjetaValido(String numeroTarjeta) {
        
        return true; 
    }

    public static String generarFechaVencimiento() {
        Random random = new Random();
        int year = random.nextInt(20) + 2025; 
        int month = random.nextInt(12) + 1; 
        return String.format("%02d/%02d", month, year); 
    }


    public static int generarCodigoSeguridad() {
        Random random = new Random();
        return random.nextInt(1000);
    }

    
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }



    public static class Builder {
    	private String titular;
        private double limiteCredito;
        
        public Builder setTitular(String titular) {
            this.titular = titular;
            return this;
        }

        public Builder setLimiteCredito(double limiteCredito) {
            this.limiteCredito = limiteCredito;
            return this;
        }

        public TarjetaCreditoImpl build() {
            return new TarjetaCreditoImpl(this);
        }
    }
}
