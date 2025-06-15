//package view;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class ShapeSelectionPanel extends JPanel {
//    private JButton[] shapeButtons;
//
//    public ShapeSelectionPanel() {
//        setLayout(new GridLayout(5, 2));
//        String[] shapes = {
//                "Persegi", "Persegi Panjang", "Segitiga",
//                "Lingkaran", "Jajar Genjang", "Trapesium",
//                "Belah Ketupat", "Layang-layang", "Keluar"
//        };
//
//        shapeButtons = new JButton[shapes.length];
//        for (int i = 0; i < shapes.length; i++) {
//            shapeButtons[i] = new JButton(shapes[i]);
//            shapeButtons[i].addActionListener(new ShapeButtonListener());
//            add(shapeButtons[i]);
//        }
//    }
//
//    private class ShapeButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String command = e.getActionCommand();
//            switch (command) {
//                case "Persegi":
//                    new ShapeCalculationFrame("Persegi");
//                    break;
//                case "Persegi Panjang":
//                    new ShapeCalculationFrame("Persegi Panjang");
//                    break;
//                case "Segitiga":
//                    new ShapeCalculationFrame("Segitiga");
//                    break;
//                case "Lingkaran":
//                    new ShapeCalculationFrame("Lingkaran");
//                    break;
//                case "Jajar Genjang":
//                    new ShapeCalculationFrame("Jajar Genjang");
//                    break;
//                case "Trapesium":
//                    new ShapeCalculationFrame("Trapesium");
//                    break;
//                case "Belah Ketupat":
//                    new ShapeCalculationFrame("Belah Ketupat");
//                    break;
//                case "Layang-layang":
//                    new ShapeCalculationFrame("Layang-layang");
//                    break;
//                case "Keluar":
//                    System.exit(0);
//                    break;
//            }
//        }
//    }
//}
