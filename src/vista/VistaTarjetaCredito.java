package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.TarjetaCredito;

public class VistaTarjetaCredito extends JFrame {
    private TarjetaCredito tarjetaCredito;
    private JTextField txtMonto;
    private JButton btnAutorizarCompra, btnPagarSaldo, btnConsultarSaldo, btnConsultarLimiteCredito;

    public VistaTarjetaCredito(TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
        initComponents();
    }

    private void initComponents() {
        setTitle("Tarjeta Crédito");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        txtMonto = new JTextField(10); // Campo de texto para ingresar el monto
        btnAutorizarCompra = new JButton("Autorizar Compra");
        btnPagarSaldo = new JButton("Pagar Saldo");
        btnConsultarSaldo = new JButton("Consultar Saldo");
        btnConsultarLimiteCredito = new JButton("Consultar Límite de Crédito");

        JLabel lblNumeroTarjeta = new JLabel("Número de Tarjeta: " + tarjetaCredito.getNumeroTarjeta());
        JLabel lblFechaVencimiento = new JLabel("Fecha de Vencimiento: " + tarjetaCredito.getFechaVencimiento());
        JLabel lblCodigoSeguridad = new JLabel("Código de Seguridad: " + tarjetaCredito.getCodigoSeguridad());

        // Agregar el campo de texto al panel
        add(txtMonto);
        add(lblNumeroTarjeta);
        add(lblFechaVencimiento);
        add(lblCodigoSeguridad);

        add(btnAutorizarCompra);
        add(btnPagarSaldo);
        add(btnConsultarSaldo);
        add(btnConsultarLimiteCredito);

        // Agregar ActionListener a los botones
        btnAutorizarCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText());
                boolean autorizado = tarjetaCredito.autorizarCompra(monto);
                JOptionPane.showMessageDialog(VistaTarjetaCredito.this, autorizado ? "Compra autorizada." : "Compra no autorizada.");
            }
        });

        btnPagarSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(txtMonto.getText());
                tarjetaCredito.pagarSaldo(monto);
                JOptionPane.showMessageDialog(VistaTarjetaCredito.this, "Pago realizado con éxito.");
            }
        });

        btnConsultarSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double saldo = tarjetaCredito.consultarSaldo();
                JOptionPane.showMessageDialog(VistaTarjetaCredito.this, "Saldo actual: " + saldo);
            }
        });

        btnConsultarLimiteCredito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double limite = tarjetaCredito.consultarLimiteCredito();
                JOptionPane.showMessageDialog(VistaTarjetaCredito.this, "Límite de crédito: " + limite);
            }
        });
    }
}
