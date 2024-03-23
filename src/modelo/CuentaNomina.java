package modelo;

public interface CuentaNomina {
	boolean validarRequisitos(Usuario usuario);
    void depositar(double monto);
    void retirar(double monto);
    double consultarSaldo();
}

