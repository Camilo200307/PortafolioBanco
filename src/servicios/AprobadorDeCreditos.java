package servicios;

import datos.BaseDeDatosSimulada;
import modelo.Usuario;

public class AprobadorDeCreditos {
    private static AprobadorDeCreditos instancia;
    private BaseDeDatosSimulada baseDeDatos; 

    private AprobadorDeCreditos(BaseDeDatosSimulada baseDeDatos) {
        this.baseDeDatos = baseDeDatos; 
    }

    public static synchronized AprobadorDeCreditos obtenerInstancia(BaseDeDatosSimulada baseDeDatos) {
        if (instancia == null) {
            instancia = new AprobadorDeCreditos(baseDeDatos);
        }
        return instancia;
    }

    public boolean aprobarCredito(String numeroDocumento, double montoSolicitado, TipoCredito tipo) {
        Usuario usuario = baseDeDatos.obtenerUsuarioPorDocumento(numeroDocumento);

        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return false;
        }

        switch (tipo) {
            case HIPOTECARIO:
                return aprobarCreditoHipotecario(usuario, montoSolicitado);
            case LIBRE_INVERSION:
                return aprobarCreditoLibreInversion(usuario, montoSolicitado);
            case TARJETA_CREDITO:
                return aprobarTarjetaCredito(usuario); 
            default:
                System.out.println("Tipo de crédito no reconocido.");
                return false;
        }
    }
    
    private boolean aprobarCreditoHipotecario(Usuario usuario, double montoSolicitado) {
        
        double relacionDeudaIngreso = (montoSolicitado / usuario.getIngresoMensual()) * 100;
        return usuario.getScoreDatacredito() >= 850 && usuario.getEdad() >= 21 && relacionDeudaIngreso < 50; 
    }
    
    private boolean aprobarCreditoLibreInversion(Usuario usuario, double montoSolicitado) {
        
        boolean criterioScore = usuario.getScoreDatacredito() >= 850;
        boolean criterioIngreso = usuario.getIngresoMensual() >= 2650000;
        boolean criterioEdad = usuario.getEdad() >= 21;

        
        boolean criterioMonto = montoSolicitado <= usuario.getIngresoMensual() * 0.3;

        return criterioScore && criterioIngreso && criterioEdad && criterioMonto;
    }
    
    private boolean aprobarTarjetaCredito(Usuario usuario) {
        
        if (usuario.getScoreDatacredito() >= 800 && usuario.getIngresoMensual() >= 1800000 && usuario.getEdad() >= 21) {
            
            double cupoAsignado = calcularCupoTarjetaCredito(usuario.getIngresoMensual());
            System.out.println("Tarjeta de crédito aprobada con un cupo de: " + cupoAsignado);
            return true;
        } else {
            System.out.println("Tarjeta de crédito rechazada.");
            return false;
        }
    }
    
    public double calcularCupoTarjetaCredito(double ingresoMensual) {
        return ingresoMensual * 0.5;
    }
    
    public enum TipoCredito {
        HIPOTECARIO,
        LIBRE_INVERSION,
        TARJETA_CREDITO 
    }
    
}
