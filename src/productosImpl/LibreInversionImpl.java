package productosImpl;

import modelo.LibreInversion;
import modelo.Usuario;

public class LibreInversionImpl implements LibreInversion {
	private String titular;
	private double montoInvertido;
    private static final double TASA_INTERES_MIN = 0.015;
    private static final double TASA_INTERES_MAX = 0.023;

    private LibreInversionImpl(Builder builder) {
    	this.titular = builder.titular;
        this.montoInvertido = builder.montoInvertido;
    }

    @Override
    public boolean validarRequisitos(Usuario usuario) {
        return usuario.getScoreDatacredito() >= 850 && usuario.getIngresoMensual() >= 2650000 && usuario.getEdad() >= 21;
    }

    @Override
    public void invertir(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a invertir debe ser positivo.");
        }
        montoInvertido += monto;
    }

    @Override
    public double liquidarInversion() {
        double intereses = montoInvertido * TASA_INTERES_MIN; // Usar la tasa mínima para el ejemplo
        double total = montoInvertido + intereses;
        montoInvertido = 0; // Resetea la inversión a 0 tras la liquidación
        return total;
    }

    @Override
    public double consultarValorActual() {
        return montoInvertido;
    }

    public static class Builder {
    	private String titular;
        private double montoInvertido;
        
        public Builder setTitular(String titular) {
            this.titular = titular;
            return this;
        }

        public Builder setMontoInvertido(double montoInvertido) {
            this.montoInvertido = montoInvertido;
            return this;
        }

        public LibreInversionImpl build() {
            return new LibreInversionImpl(this);
        }
    }
}
