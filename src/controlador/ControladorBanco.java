package controlador;

import datos.BaseDeDatosSimulada;
import factories.*;
import modelo.*;
import servicios.AprobadorDeCreditos;
import vista.VistaInicio;
import vista.VistaProductos;

public class ControladorBanco {

    private BaseDeDatosSimulada baseDeDatos;
    private VistaInicio vistaInicio;
    private VistaProductos vistaProductos;

    public ControladorBanco() {
        baseDeDatos = new BaseDeDatosSimulada();
        AprobadorDeCreditos aprobador = AprobadorDeCreditos.obtenerInstancia(baseDeDatos);
        
        vistaInicio = new VistaInicio(this);
        vistaInicio.setVisible(true);
    }

    public void buscarProductosParaUsuario(String numeroDocumento) {
        Usuario usuario = baseDeDatos.obtenerUsuarioPorDocumento(numeroDocumento);
        if (usuario != null) {
            AbstractFactoryPortafolio factory = getFactory(usuario.getTipoCliente(), usuario);
            if (factory != null) {
            	if (vistaProductos == null) {
                    vistaProductos = new VistaProductos(this);
                }
                vistaProductos.mostrarProductos(factory, usuario);
                vistaProductos.setVisible(true);
            } else {
                vistaProductos.mostrarMensaje("No hay productos disponibles para este tipo de cliente.");
            }
        } else {
            vistaProductos.mostrarMensaje("Usuario no encontrado.");
        }
    }

    private AbstractFactoryPortafolio getFactory(TipoCliente tipo, Usuario usuario) {
        AprobadorDeCreditos aprobador = AprobadorDeCreditos.obtenerInstancia(baseDeDatos);
        switch (tipo) {
            case EMPLEADO:
                return new PortafolioEmpleadoFactory(aprobador);
            case INDEPENDIENTE:
                return new PortafolioIndependienteFactory(aprobador);
            case PENSIONADO:
                return new PortafolioPensionadoFactory(aprobador);
            case ESTUDIANTE:
                return new PortafolioEstudianteFactory(aprobador);
            case DUENO_EMPRESA:
                return new PortafolioDueñoEmpresaFactory(aprobador);
            case PRESTADOR_SERVICIOS:
                return new PortafolioPrestadorDeServiciosFactory(aprobador);
            case RENTISTA_CAPITAL:
                return new PortafolioRentistaDeCapitalFactory(aprobador);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        new ControladorBanco();
    }
}
