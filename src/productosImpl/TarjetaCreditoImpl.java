package productosImpl;

import modelo.TarjetaCredito;
import modelo.Usuario;

public class TarjetaCreditoImpl implements TarjetaCredito {
    private String titular;
	private double limiteCredito;
    private double saldo;
    private static final double TASA_INTERES = 0.0298;

    private TarjetaCreditoImpl(Builder builder) {
    	this.titular = builder.titular;
        this.limiteCredito = builder.limiteCredito;
        this.saldo = 0; 
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
