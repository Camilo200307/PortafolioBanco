package servicios;

import datos.BaseDeDatosSimulada;
import modelo.Usuario;

public class ServicioValidacionProductos {
    private BaseDeDatosSimulada baseDeDatos;

    public ServicioValidacionProductos(BaseDeDatosSimulada baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public void validarProductosDisponibles(String numeroDocumento) {
        Usuario usuario = baseDeDatos.obtenerUsuarioPorDocumento(numeroDocumento);

        // Aquí implementarías la lógica para validar cada producto con el usuario
        // Por ejemplo:
        // if (productoCuentaNomina.validarRequisitos(usuario)) {
        //     System.out.println("Cuenta Nómina disponible para este usuario.");
        // }
    }
}
