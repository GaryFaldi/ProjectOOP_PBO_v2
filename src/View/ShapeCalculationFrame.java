package View;

import javax.swing.*;
import java.awt.*;

public class ShapeCalculationFrame extends JFrame {
    public ShapeCalculationFrame(String shapeName) {
        setTitle("Hitung " + shapeName);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel untuk input dan hasil
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        // Tambahkan input sesuai dengan bentuk yang dipilih
        switch (shapeName) {
            case "Persegi":
                panel.add(new JLabel("Panjang Sisi:"));
                panel.add(new JTextField());
                break;
            case "Persegi Panjang":
                panel.add(new JLabel("Panjang:"));
                panel.add(new JTextField());
                panel.add(new JLabel("Lebar:"));
                panel.add(new JTextField());
                break;
            case "Segitiga":
                panel.add(new JLabel("Alas:"));
                panel.add(new JTextField());
                panel.add(new JLabel("Tinggi:"));
                panel.add(new JTextField());
                break;
            case "Lingkaran":
                panel.add(new JLabel("Jari-jari:"));
                panel.add(new JTextField());
                break;
            case "Jajar Genjang":
                panel.add(new JLabel("Alas:"));
                panel.add(new JTextField());
                panel.add(new JLabel("Tinggi:"));
                panel.add(new JTextField());
                break;
            case "Trapesium":
                panel.add(new JLabel("Sisi Atas:"));
                panel.add(new JTextField());
                panel.add(new JLabel("Sisi Bawah:"));
                panel.add(new JTextField());
                break;
            case "Belah Ketupat":
                panel.add(new JLabel("Diagonal 1:"));
                panel.add(new JTextField());
                panel.add(new JLabel("Diagonal 2:"));
                panel.add(new JTextField());
                break;
            case "Layang-layang":
                panel.add(new JLabel("Diagonal 1:"));
                panel.add(new JTextField());
                panel.add(new JLabel("Diagonal 2:"));
                panel.add(new JTextField());
                break;
        }

        JButton calculateButton = new JButton("Hitung");
        calculateButton.addActionListener(e -> {
            // Logika perhitungan bisa ditambahkan di sini
            JOptionPane.showMessageDialog(this, "Perhitungan untuk " + shapeName + " dilakukan.");
        });

        panel.add(calculateButton);
        add(panel);
        setVisible(true);
    }
}
