package vista;

import controlador.ControladorBanco;
import modelo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaProductos extends JFrame {
    private ControladorBanco controlador;
    private JPanel panelProductos;

    public VistaProductos(ControladorBanco controlador) {
        this.controlador = controlador;
        initComponents();
    }

    private void initComponents() {
        
        setTitle("Consulta de Productos Bancarios"); 
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        
        
        panelProductos = new JPanel();
        panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));
        
        
        add(new JScrollPane(panelProductos), BorderLayout.CENTER);
    }

    
    public void mostrarProductos(AbstractFactoryPortafolio factory, Usuario usuario) {
        
        panelProductos.removeAll();
        
        
        agregarBotonProducto(panelProductos, "Cuenta Nómina", factory, usuario);
        agregarBotonProducto(panelProductos, "Cuenta Ahorros", factory, usuario);
        agregarBotonProducto(panelProductos, "Tarjeta Crédito", factory, usuario);
        agregarBotonProducto(panelProductos, "Libre Inversión", factory, usuario);
        agregarBotonProducto(panelProductos, "Crédito Hipotecario", factory, usuario);
        agregarBotonProducto(panelProductos, "CDT", factory, usuario);
        agregarBotonProducto(panelProductos, "Fondo de Inversión", factory, usuario);
        
        
        revalidate(); 
        repaint(); 
        
    }
    
    private void agregarBotonProducto(JPanel panel, String nombreProducto, AbstractFactoryPortafolio factory, Usuario usuario) {
        JButton btnProducto = new JButton(nombreProducto);
        btnProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nombreProducto.equals("Cuenta Ahorros")) {
                    CuentaAhorros cuentaAhorros = factory.createCuentaAhorros(usuario);
                    if (cuentaAhorros != null) {
                        new VistaCuentaAhorros(cuentaAhorros).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(VistaProductos.this, "El producto no está disponible.");
                    }
                } else if (nombreProducto.equals("Tarjeta Crédito")) {
                    TarjetaCredito tarjetaCredito = factory.createTarjetaCredito(usuario);
                    if (tarjetaCredito != null) {
                        new VistaTarjetaCredito(tarjetaCredito).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(VistaProductos.this, "El producto no está disponible.");
                    }
                } else if (nombreProducto.equals("Cuenta Nómina")) {
                    CuentaNomina cuentaNomina = factory.createCuentaNomina(usuario);
                    if (cuentaNomina != null) {
                        new VistaCuentaNomina(cuentaNomina).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(VistaProductos.this, "El producto no está disponible.");
                    }
                } else if (nombreProducto.equals("Libre Inversión")) {
                    LibreInversion libreInversion = factory.createLibreInversion(usuario);
                    if (libreInversion != null) {
                        new VistaLibreInversion(libreInversion).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(VistaProductos.this, "El producto no está disponible.");
                    }
                } else if (nombreProducto.equals("Crédito Hipotecario")) {
                    CreditoHipotecario creditoHipotecario = factory.createCreditoHipotecario(usuario);
                    if (creditoHipotecario != null) {
                        new VistaCreditoHipotecario(creditoHipotecario).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(VistaProductos.this, "El producto no está disponible.");
                    }
                } else if (nombreProducto.equals("CDT")) {
                    CDT cdt = factory.createCDT(usuario);
                    if (cdt != null) {
                        new VistaCDT(cdt).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(VistaProductos.this, "El producto no está disponible.");
                    }
                } else if (nombreProducto.equals("Fondo de Inversión")) {
                    FondoDeInversion fondoDeInversion = factory.createFondoDeInversion(usuario);
                    if (fondoDeInversion != null) {
                        new VistaFondoDeInversion(fondoDeInversion).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(VistaProductos.this, "El producto no está disponible.");
                    }
                } else {
                    JOptionPane.showMessageDialog(VistaProductos.this, "Producto no reconocido.");
                }
            }
        });



        panel.add(btnProducto);
        panel.add(Box.createVerticalGlue());
    }




    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
