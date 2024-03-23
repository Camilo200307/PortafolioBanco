package productosImpl;

import modelo.FondoDeInversion;
import modelo.Usuario;

public class FondoDeInversionImpl implements FondoDeInversion {
    private String titular;
    private double montoInvertido;

    private FondoDeInversionImpl(Builder builder) {
        this.titular = builder.titular;
        this.montoInvertido = builder.montoInvertido;
    }

    @Override
    public boolean validarRequisitos(Usuario usuario) {

        return this.montoInvertido >= 500000;
    }

    @Override
    public void invertirEnFondo(double monto) {
        if (monto < 500000) {
            throw new IllegalArgumentException("El monto mínimo para invertir en un Fondo de Inversión es de 500.000 COP.");
        }
        this.montoInvertido += monto;
    }

    @Override
    public double retirarFondo(double monto) {
        if (monto > montoInvertido) {
            throw new IllegalArgumentException("No se puede retirar más de lo invertido.");
        }
        montoInvertido -= monto;
        return monto;
    }

    @Override
    public double consultarValorFondo() {
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

        public FondoDeInversionImpl build() {
            return new FondoDeInversionImpl(this);
        }
    }
}