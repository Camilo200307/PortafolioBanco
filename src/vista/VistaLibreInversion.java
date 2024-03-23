package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.LibreInversion;

public class VistaLibreInversion extends JFrame {
    private LibreInversion libreInversion;
    private JTextField txtMonto;
    private JButton btnInvertir, btnLiquidarInversion, btnConsultarValorActual;

    public VistaLibreInversion(LibreInversion libreInversion) {
        this.libreInversion = libreInversion;
        initComponents();
    }

    private void initComponents() {
        setTitle("Libre Inversión");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        txtMonto = new JTextField(10);
        btnInvertir = new JButton("Invertir");
        btnLiquidarInversion = new JButton("Liquidar Inversión");
        btnConsultarValorActual = new JButton("Consultar Valor Actual");

        btnInvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText());
                libreInversion.invertir(monto);
                JOptionPane.showMessageDialog(VistaLibreInversion.this, "Inversión realizada con éxito.");
            }
        });

        btnLiquidarInversion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = libreInversion.liquidarInversion();
                JOptionPane.showMessageDialog(VistaLibreInversion.this, "Valor de la inversión liquidada: " + valor);
            }
        });

        btnConsultarValorActual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = libreInversion.consultarValorActual();
                JOptionPane.showMessageDialog(VistaLibreInversion.this, "Valor actual de la inversión: " + valor);
            }
        });

        add(new JLabel("Monto:"));
        add(txtMonto);
        add(btnInvertir);
        add(btnLiquidarInversion);
        add(btnConsultarValorActual);
    }
}
