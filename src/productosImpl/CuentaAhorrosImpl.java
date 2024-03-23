package productosImpl;

import modelo.CuentaAhorros;
import modelo.Usuario;

public class CuentaAhorrosImpl implements CuentaAhorros {
    private String titular;
    private double saldo;
    private double tasaInteres;


    private CuentaAhorrosImpl(Builder builder) {
        this.titular = titular;
        this.saldo = saldo;
        this.tasaInteres = tasaInteres;
    }

    @Override
    public boolean validarRequisitos(Usuario usuario) {
        return usuario.getEdad() > 20; 
    }

    @Override
    public void depositar(double monto) {
        this.saldo += monto;
    }

    @Override
    public void retirar(double monto) {
        this.saldo -= monto;
    }

    @Override
    public double consultarSaldo() {
        return this.saldo;
    }

    @Override
    public void calcularIntereses() {
        this.saldo += this.saldo * this.tasaInteres;
    }

    
    public static class Builder {
        private String titular;
        private double saldoInicial;
        private double tasaInteres;

        public Builder setTitular(String titular) {
            this.titular = titular;
            return this;
        }

        public Builder setSaldoInicial(double saldoInicial) {
            this.saldoInicial = saldoInicial;
            return this;
        }

        public Builder setTasaInteres(double tasaInteres) {
            this.tasaInteres = tasaInteres;
            return this;
        }

        public CuentaAhorrosImpl build() {
            return new CuentaAhorrosImpl(this);
        }
    }
}
