package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeSelectionPanel extends JPanel {
    private JButton[] shapeButtons;
    private JFrame parentFrame; // Tambahkan referensi ke parent frame

    // Modifikasi constructor untuk menerima parent frame
    public ShapeSelectionPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new GridLayout(5, 2));
        String[] shapes = {
                "Persegi", "Persegi Panjang", "Segitiga",
                "Lingkaran", "Jajar Genjang", "Trapesium",
                "Belah Ketupat", "Layang-layang", "Keluar"
        };

        shapeButtons = new JButton[shapes.length];
        for (int i = 0; i < shapes.length; i++) {
            shapeButtons[i] = new JButton(shapes[i]);
            shapeButtons[i].addActionListener(new ShapeButtonListener());
            add(shapeButtons[i]);
        }
    }

    private class ShapeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if ("Keluar".equals(command)) {
                System.exit(0);
            } else {
                // Gunakan parentFrame yang disimpan
                new ShapeCalculationFrame(command, parentFrame);
            }
        }
    }
}