package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.CreditoHipotecario;

public class VistaCreditoHipotecario extends JFrame {
    private CreditoHipotecario creditoHipotecario;
    private JTextField txtMonto;
    private JButton btnSolicitarCredito, btnAmortizarCredito, btnConsultarSaldoPendiente;

    public VistaCreditoHipotecario(CreditoHipotecario creditoHipotecario) {
        this.creditoHipotecario = creditoHipotecario;
        initComponents();
    }

    private void initComponents() {
        setTitle("Crédito Hipotecario");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        txtMonto = new JTextField(10);
        btnSolicitarCredito = new JButton("Solicitar Crédito");
        btnAmortizarCredito = new JButton("Amortizar Crédito");
        btnConsultarSaldoPendiente = new JButton("Consultar Saldo Pendiente");

        btnSolicitarCredito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText());
                creditoHipotecario.solicitarCredito(monto);
                JOptionPane.showMessageDialog(VistaCreditoHipotecario.this, "Crédito solicitado con éxito.");
            }
        });

        btnAmortizarCredito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText());
                creditoHipotecario.amortizarCredito(monto);
                JOptionPane.showMessageDialog(VistaCreditoHipotecario.this, "Crédito amortizado con éxito.");
            }
        });

        btnConsultarSaldoPendiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double saldo = creditoHipotecario.consultarSaldoPendiente();
                JOptionPane.showMessageDialog(VistaCreditoHipotecario.this, "Saldo pendiente: " + saldo);
            }
        });

        add(new JLabel("Monto:"));
        add(txtMonto);
        add(btnSolicitarCredito);
        add(btnAmortizarCredito);
        add(btnConsultarSaldoPendiente);
    }
}
