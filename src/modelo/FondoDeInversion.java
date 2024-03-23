package modelo;

public interface FondoDeInversion {
	boolean validarRequisitos(Usuario usuario);
    void invertirEnFondo(double monto);
    double retirarFondo(double monto);
    double consultarValorFondo();
}

