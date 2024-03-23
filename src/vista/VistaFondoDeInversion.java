package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.FondoDeInversion;

public class VistaFondoDeInversion extends JFrame {
    private FondoDeInversion fondoDeInversion;
    private JTextField txtMonto;
    private JButton btnInvertirEnFondo, btnRetirarFondo, btnConsultarValorFondo;

    public VistaFondoDeInversion(FondoDeInversion fondoDeInversion) {
        this.fondoDeInversion = fondoDeInversion;
        initComponents();
    }

    private void initComponents() {
        setTitle("Fondo de Inversión");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        txtMonto = new JTextField(10);
        btnInvertirEnFondo = new JButton("Invertir en Fondo");
        btnRetirarFondo = new JButton("Retirar del Fondo");
        btnConsultarValorFondo = new JButton("Consultar Valor del Fondo");

        btnInvertirEnFondo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText());
                fondoDeInversion.invertirEnFondo(monto);
                JOptionPane.showMessageDialog(VistaFondoDeInversion.this, "Inversión realizada con éxito.");
            }
        });

        btnRetirarFondo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText());
                fondoDeInversion.retirarFondo(monto);
                JOptionPane.showMessageDialog(VistaFondoDeInversion.this, "Retiro realizado con éxito.");
            }
        });

        btnConsultarValorFondo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = fondoDeInversion.consultarValorFondo();
                JOptionPane.showMessageDialog(VistaFondoDeInversion.this, "Valor actual del Fondo: " + valor);
            }
        });

        add(new JLabel("Monto:"));
        add(txtMonto);
        add(btnInvertirEnFondo);
        add(btnRetirarFondo);
        add(btnConsultarValorFondo);
    }
}
