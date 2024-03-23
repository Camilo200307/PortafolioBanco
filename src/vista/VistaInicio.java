package vista;

import javax.swing.*;

import controlador.ControladorBanco;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaInicio extends JFrame {
    private ControladorBanco controlador;
    private JTextField txtNumeroDocumento;
    private JButton btnIngresar;

    public VistaInicio(ControladorBanco controlador) {
        this.controlador = controlador;
        initComponents();
    }

    private void initComponents() {
        setTitle("Ingreso de Número de Documento");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JLabel lblDocumento = new JLabel("Ingrese número de documento:");
        txtNumeroDocumento = new JTextField(20);
        btnIngresar = new JButton("Ingresar");

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.buscarProductosParaUsuario(txtNumeroDocumento.getText());
                dispose(); // Cierra la ventana de inicio
            }
        });

        add(lblDocumento);
        add(txtNumeroDocumento);
        add(btnIngresar);
    }
}
