package modelo;

public interface CuentaAhorros {
	boolean validarRequisitos(Usuario usuario);
    void depositar(double monto);
    void retirar(double monto);
    double consultarSaldo();
    void calcularIntereses();
}

