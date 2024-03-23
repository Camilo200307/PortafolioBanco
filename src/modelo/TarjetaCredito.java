package modelo;

public interface TarjetaCredito {
	boolean validarRequisitos(Usuario usuario);
    boolean autorizarCompra(double monto);
    void pagarSaldo(double monto);
    double consultarSaldo();
    double consultarLimiteCredito();
}

