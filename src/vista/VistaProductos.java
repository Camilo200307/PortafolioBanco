package vista;

import controlador.ControladorBanco;
import modelo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaProductos extends JFrame {
    private ControladorBanco controlador;
    private JTextField txtNumeroDocumento;
    private JTextArea txtAreaProductos;

    public VistaProductos(ControladorBanco controlador) {
        this.controlador = controlador;
        initComponents();
    }

    private void initComponents() {
        // Configuración inicial del JFrame.
        setTitle("Consulta de Productos Bancarios");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        
        // Panel para ingresar el documento.
        JPanel panelDocumento = new JPanel();
        panelDocumento.setLayout(new FlowLayout());
        JLabel lblDocumento = new JLabel("Número de documento:");
        txtNumeroDocumento = new JTextField(20);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.buscarProductosParaUsuario(txtNumeroDocumento.getText());
            }
        });
        panelDocumento.add(lblDocumento);
        panelDocumento.add(txtNumeroDocumento);
        panelDocumento.add(btnBuscar);
        
        // Panel para mostrar los productos.
        JPanel panelProductos = new JPanel();
        panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));
        
        // Añadir componentes al JFrame.
        add(panelDocumento, BorderLayout.NORTH);
        add(new JScrollPane(panelProductos), BorderLayout.CENTER);
    }

    
    public void mostrarProductos(AbstractFactoryPortafolio factory, Usuario usuario) {
        JPanel panelProductos = new JPanel();
        panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));
        
        // Crear y agregar botones para cada producto
        agregarBotonProducto(panelProductos, "Cuenta Nómina", factory, usuario);
        agregarBotonProducto(panelProductos, "Cuenta Ahorros", factory, usuario);
        agregarBotonProducto(panelProductos, "Tarjeta Crédito", factory, usuario);
        agregarBotonProducto(panelProductos, "Libre Inversión", factory, usuario);
        agregarBotonProducto(panelProductos, "Crédito Hipotecario", factory, usuario);
        agregarBotonProducto(panelProductos, "CDT", factory, usuario);
        agregarBotonProducto(panelProductos, "Fondo de Inversión", factory, usuario);
        
        // Reemplazar el área de texto con el panel de productos
        add(new JScrollPane(panelProductos), BorderLayout.CENTER);
        revalidate(); // Actualizar el layout
        repaint(); // Redibujar el JFrame
    }

    private void agregarBotonProducto(JPanel panel, String nombreProducto, AbstractFactoryPortafolio factory, Usuario usuario) {
        JButton btnProducto = new JButton(nombreProducto);
        btnProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nombreProducto.equals("Cuenta de Ahorros")) {
                    CuentaAhorros cuentaAhorros = factory.createCuentaAhorros(usuario);
                    if (cuentaAhorros != null) {
                        new VistaCuentaAhorros(cuentaAhorros).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(VistaProductos.this, "El producto no está disponible.");
                    }
                } else if (nombreProducto.equals("Tarjeta de Crédito")) {
                    TarjetaCredito tarjetaCredito = factory.createTarjetaCredito(usuario);
                    if (tarjetaCredito != null) {
                        new VistaTarjetaCredito(tarjetaCredito).setVisible(true);
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
                } else if (nombreProducto.equals("Cuenta Nómina")) {
                    CuentaNomina cuentaNomina = factory.createCuentaNomina(usuario);
                    if (cuentaNomina != null) {
                        new VistaCuentaNomina(cuentaNomina).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(VistaProductos.this, "El producto no está disponible.");
                    }
                } else {
                    JOptionPane.showMessageDialog(VistaProductos.this, "Producto no reconocido.");
                }
            }
        });



        panel.add(btnProducto);
    }




    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
