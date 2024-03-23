package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.CuentaAhorros;

public class VistaCuentaAhorros extends JFrame {
    private CuentaAhorros cuentaAhorros;
    private JTextField txtMonto;
    private JButton btnDepositar, btnRetirar, btnConsultarSaldo;

    public VistaCuentaAhorros(CuentaAhorros cuentaAhorros) {
        this.cuentaAhorros = cuentaAhorros;
        initComponents();
    }

    private void initComponents() {
        setTitle("Cuenta de Ahorros");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        txtMonto = new JTextField(10);
        btnDepositar = new JButton("Depositar");
        btnRetirar = new JButton("Retirar");
        btnConsultarSaldo = new JButton("Consultar Saldo");

        btnDepositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText());
                cuentaAhorros.depositar(monto);
                JOptionPane.showMessageDialog(VistaCuentaAhorros.this, "Depósito realizado con éxito.");
            }
        });

        btnRetirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText());
                cuentaAhorros.retirar(monto);
                JOptionPane.showMessageDialog(VistaCuentaAhorros.this, "Retiro realizado con éxito.");
            }
        });

        btnConsultarSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double saldo = cuentaAhorros.consultarSaldo();
                JOptionPane.showMessageDialog(VistaCuentaAhorros.this, "Saldo actual: " + saldo);
            }
        });

        add(new JLabel("Monto:"));
        add(txtMonto);
        add(btnDepositar);
        add(btnRetirar);
        add(btnConsultarSaldo);
    }
}
