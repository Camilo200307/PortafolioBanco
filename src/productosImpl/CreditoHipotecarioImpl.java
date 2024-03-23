package productosImpl;

import modelo.CreditoHipotecario;
import modelo.Usuario;

public class CreditoHipotecarioImpl implements CreditoHipotecario {
    private String titular;
    private double montoCredito;
    private double saldoPendiente;
    private static final double TASA_INTERES = 0.011;  

    private CreditoHipotecarioImpl(Builder builder) {
        this.titular = builder.titular;
        this.montoCredito = builder.montoCredito;
        this.saldoPendiente = builder.montoCredito;  
    }

    @Override
    public boolean validarRequisitos(Usuario usuario) {
     
        return usuario.getScoreDatacredito() >= 850 && usuario.getEdad() >= 21;
    }

    @Override
    public void solicitarCredito(double monto) {
        
        this.montoCredito = monto;
        this.saldoPendiente = monto;
    }

    @Override
    public void amortizarCredito(double monto) {
        if (monto > 0 && monto <= saldoPendiente) {
            saldoPendiente -= monto;
        } else {
            throw new IllegalArgumentException("El monto a amortizar es inválido.");
        }
    }

    @Override
    public double consultarSaldoPendiente() {
        return saldoPendiente;
    }

    public static class Builder {
        private String titular;
        private double montoCredito;

        public Builder setTitular(String titular) {
            this.titular = titular;
            return this;
        }

        public Builder setMontoCredito(double montoCredito) {
            this.montoCredito = montoCredito;
            return this;
        }

        public CreditoHipotecarioImpl build() {
            return new CreditoHipotecarioImpl(this);
        }
    }
}
