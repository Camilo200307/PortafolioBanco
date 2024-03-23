package datos;

import modelo.TipoCliente;
import modelo.Usuario;
import java.util.HashMap;
import java.util.Map;

public class BaseDeDatosSimulada {
    private Map<String, Usuario> usuarios;

    public BaseDeDatosSimulada() {
        usuarios = new HashMap<>();
        // Agregando 20 usuarios de prueba
        usuarios.put("1001", new Usuario("1001", TipoCliente.EMPLEADO, true, "NIT123", 30, 850, 2500000));
        usuarios.put("1002", new Usuario("1002", TipoCliente.INDEPENDIENTE, false, "", 25, 800, 1800000));
        usuarios.put("1003", new Usuario("1003", TipoCliente.PENSIONADO, false, "", 65, 900, 3500000));
        usuarios.put("1004", new Usuario("1004", TipoCliente.ESTUDIANTE, false, "", 22, 750, 1200000));
        usuarios.put("1005", new Usuario("1005", TipoCliente.DUENO_EMPRESA, false, "NIT456", 40, 950, 5000000));
        usuarios.put("1006", new Usuario("1006", TipoCliente.PRESTADOR_SERVICIOS, false, "", 32, 780, 2000000));
        usuarios.put("1007", new Usuario("1007", TipoCliente.RENTISTA_CAPITAL, false, "", 55, 880, 4000000));
        usuarios.put("1008", new Usuario("1008", TipoCliente.EMPLEADO, true, "NIT789", 28, 810, 2200000));
        usuarios.put("1009", new Usuario("1009", TipoCliente.INDEPENDIENTE, false, "", 45, 830, 3000000));
        usuarios.put("1010", new Usuario("1010", TipoCliente.PENSIONADO, false, "", 70, 910, 3200000));
        usuarios.put("1011", new Usuario("1011", TipoCliente.ESTUDIANTE, false, "", 20, 760, 1000000));
        usuarios.put("1012", new Usuario("1012", TipoCliente.DUENO_EMPRESA, false, "NIT012", 50, 960, 6000000));
        usuarios.put("1013", new Usuario("1013", TipoCliente.PRESTADOR_SERVICIOS, false, "", 35, 790, 2100000));
        usuarios.put("1014", new Usuario("1014", TipoCliente.RENTISTA_CAPITAL, false, "", 60, 890, 4500000));
        usuarios.put("1015", new Usuario("1015", TipoCliente.EMPLEADO, true, "NIT345", 33, 820, 2300000));
        usuarios.put("1016", new Usuario("1016", TipoCliente.INDEPENDIENTE, false, "", 38, 840, 3100000));
        usuarios.put("1017", new Usuario("1017", TipoCliente.PENSIONADO, false, "", 68, 920, 3300000));
        usuarios.put("1018", new Usuario("1018", TipoCliente.ESTUDIANTE, false, "", 19, 770, 900000));
        usuarios.put("1019", new Usuario("1019", TipoCliente.DUENO_EMPRESA, false, "NIT678", 42, 970, 5500000));
        usuarios.put("1020", new Usuario("1020", TipoCliente.PRESTADOR_SERVICIOS, false, "", 29, 800, 1900000));
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNumeroDocumento(), usuario);
    }

    public Usuario obtenerUsuarioPorDocumento(String numeroDocumento) {
        return usuarios.get(numeroDocumento);
    }
}
