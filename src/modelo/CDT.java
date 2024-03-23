package modelo;

public interface CDT {
	boolean validarRequisitos(Usuario usuario);
    void crearCDT(double monto, int plazoDias);
    double cerrarCDT();
    double consultarValorActual();
}

