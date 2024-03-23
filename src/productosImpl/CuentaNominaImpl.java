package productosImpl;

import modelo.CuentaNomina;
import modelo.Usuario;

public class CuentaNominaImpl implements CuentaNomina {
    private String titular;
    private String nitEmpresa;
    private double saldo;

    private CuentaNominaImpl(Builder builder) {
        this.titular = builder.titular;
        this.nitEmpresa = builder.nitEmpresa;
        this.saldo = 0;  
    }

    @Override
    public boolean validarRequisitos(Usuario usuario) {
        return usuario.isEsEmpleado() && usuario.getNitEmpresa().equals(this.nitEmpresa);
    }

    @Override
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        }
        this.saldo += monto;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0 || monto > saldo) {
            throw new IllegalArgumentException("El monto a retirar es inválido.");
        }
        this.saldo -= monto;
    }

    @Override
    public double consultarSaldo() {
        return this.saldo;
    }

    public static class Builder {
        private String titular;
        private String nitEmpresa;

        public Builder setTitular(String titular) {
            this.titular = titular;
            return this;
        }

        public Builder setNitEmpresa(String nitEmpresa) {
            this.nitEmpresa = nitEmpresa;
            return this;
        }

        public CuentaNominaImpl build() {
            return new CuentaNominaImpl(this);
        }
    }
}
