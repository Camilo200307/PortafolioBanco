package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.CuentaNomina;

public class VistaCuentaNomina extends JFrame {
    private CuentaNomina cuentaNomina;
    private JTextField txtMonto;
    private JButton btnDepositar, btnRetirar, btnConsultarSaldo;

    public VistaCuentaNomina(CuentaNomina cuentaNomina) {
        this.cuentaNomina = cuentaNomina;
        initComponents();
    }

    private void initComponents() {
        setTitle("Cuenta Nómina");
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
                cuentaNomina.depositar(monto);
                JOptionPane.showMessageDialog(VistaCuentaNomina.this, "Depósito realizado con éxito.");
            }
        });

        btnRetirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText());
                cuentaNomina.retirar(monto);
                JOptionPane.showMessageDialog(VistaCuentaNomina.this, "Retiro realizado con éxito.");
            }
        });

        btnConsultarSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double saldo = cuentaNomina.consultarSaldo();
                JOptionPane.showMessageDialog(VistaCuentaNomina.this, "Saldo actual: " + saldo);
            }
        });

        add(new JLabel("Monto:"));
        add(txtMonto);
        add(btnDepositar);
        add(btnRetirar);
        add(btnConsultarSaldo);
    }
}
