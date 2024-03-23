package modelo;

public interface CreditoHipotecario {
	boolean validarRequisitos(Usuario usuario);
    void solicitarCredito(double monto);
    void amortizarCredito(double monto);
    double consultarSaldoPendiente();
}
