package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.CDT;

public class VistaCDT extends JFrame {
    private CDT cdt;
    private JTextField txtMonto, txtPlazoDias;
    private JButton btnCrearCDT, btnCerrarCDT, btnConsultarValorActual;

    public VistaCDT(CDT cdt) {
        this.cdt = cdt;
        initComponents();
    }

    private void initComponents() {
        setTitle("CDT");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        txtMonto = new JTextField(10);
        txtPlazoDias = new JTextField(10);
        btnCrearCDT = new JButton("Crear CDT");
        btnCerrarCDT = new JButton("Cerrar CDT");
        btnConsultarValorActual = new JButton("Consultar Valor Actual");

        btnCrearCDT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText());
                int plazoDias = Integer.parseInt(txtPlazoDias.getText());
                cdt.crearCDT(monto, plazoDias);
                JOptionPane.showMessageDialog(VistaCDT.this, "CDT creado con éxito.");
            }
        });

        btnCerrarCDT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = cdt.cerrarCDT();
                JOptionPane.showMessageDialog(VistaCDT.this, "Valor del CDT cerrado: " + valor);
            }
        });

        btnConsultarValorActual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = cdt.consultarValorActual();
                JOptionPane.showMessageDialog(VistaCDT.this, "Valor actual del CDT: " + valor);
            }
        });

        add(new JLabel("Monto:"));
        add(txtMonto);
        add(new JLabel("Plazo (días):"));
        add(txtPlazoDias);
        add(btnCrearCDT);
        add(btnCerrarCDT);
        add(btnConsultarValorActual);
    }
}
