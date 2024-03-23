package productosImpl;

import modelo.CDT;
import modelo.Usuario;

public class CDTImpl implements CDT {
    private String titular;
    private double montoInvertido;
    private int plazoDias;
    private static final double TASA_INTERES = 0.03;  

    private CDTImpl(Builder builder) {
        this.titular = builder.titular;
        this.montoInvertido = builder.montoInvertido;
        this.plazoDias = builder.plazoDias;
    }

    @Override
    public boolean validarRequisitos(Usuario usuario) {
    
        return this.montoInvertido >= 500000;
    }

    @Override
    public void crearCDT(double monto, int plazoDias) {
        if (monto >= 500000) {
            this.montoInvertido = monto;
            this.plazoDias = plazoDias;
        } else {
            throw new IllegalArgumentException("El monto mínimo para abrir un CDT es de 500.000 COP.");
        }
    }

    @Override
    public double cerrarCDT() {
        double intereses = montoInvertido * TASA_INTERES * (plazoDias / 365.0);
        this.montoInvertido = 0;  
        this.plazoDias = 0;  
        return montoInvertido + intereses;
    }

    @Override
    public double consultarValorActual() {
        
        double intereses = montoInvertido * TASA_INTERES * (plazoDias / 365.0);
        return montoInvertido + intereses;
    }

    public static class Builder {
        private String titular;
        private double montoInvertido;
        private int plazoDias;

        public Builder setTitular(String titular) {
        	this.titular = titular;
        	return this;
        	}
        
        public Builder setMontoInvertido(double montoInvertido) {
            this.montoInvertido = montoInvertido;
            return this;
        }

        public Builder setPlazoDias(int plazoDias) {
            this.plazoDias = plazoDias;
            return this;
        }

        public CDTImpl build() {
            return new CDTImpl(this);
        }
    }
    
}
