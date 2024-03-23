package modelo;

public interface LibreInversion {
	boolean validarRequisitos(Usuario usuario);
    void invertir(double monto);
    double liquidarInversion();
    double consultarValorActual();
}

