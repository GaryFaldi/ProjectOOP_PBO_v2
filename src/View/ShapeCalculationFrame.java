package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import BangunGeometry.*;

public class ShapeCalculationFrame extends JFrame {
    private String shapeName;
    private JTextField[] inputFields;
    private JLabel resultLabel;
    private JLabel editedResultLabel;
    private Object shapeObject;
    private Object editedShapeObject;
    private JFrame parentFrame;

    public ShapeCalculationFrame(String shapeName, JFrame parentFrame) {
        this.shapeName = shapeName;
        this.parentFrame = parentFrame;

        if (parentFrame != null) {
            parentFrame.setVisible(false);
        }

        initializeUI();
    }
        private void initializeUI() {
            setTitle("Hitung " + shapeName);
            setSize(800, 600); // Diperbesar untuk menampung dua panel hasil
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Hitung " + shapeName);
        setSize(450, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        // Input panel with GridLayout
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 8));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input Parameter"));

        // Add input fields based on shape
        switch (shapeName) {
            case "Persegi":
                inputFields = new JTextField[1];
                addInputField(inputPanel, "Panjang Sisi:", 0);
                break;
            case "Persegi Panjang":
                inputFields = new JTextField[2];
                addInputField(inputPanel, "Panjang:", 0);
                addInputField(inputPanel, "Lebar:", 1);
                break;
            case "Segitiga":
                inputFields = new JTextField[5];
                addInputField(inputPanel, "Alas:", 0);
                addInputField(inputPanel, "Tinggi:", 1);
                addInputField(inputPanel, "Sisi A:", 2);
                addInputField(inputPanel, "Sisi B:", 3);
                addInputField(inputPanel, "Sisi C:", 4);
                break;
            case "Lingkaran":
                inputFields = new JTextField[1];
                addInputField(inputPanel, "Jari-jari:", 0);
                break;
            case "Jajar Genjang":
                inputFields = new JTextField[3];
                addInputField(inputPanel, "Alas:", 0);
                addInputField(inputPanel, "Tinggi:", 1);
                addInputField(inputPanel, "Sisi Miring:", 2);
                break;
            case "Trapesium":
                inputFields = new JTextField[5];
                addInputField(inputPanel, "Sisi Atas:", 0);
                addInputField(inputPanel, "Sisi Bawah:", 1);
                addInputField(inputPanel, "Tinggi:", 2);
                addInputField(inputPanel, "Sisi Miring Kiri:", 3);
                addInputField(inputPanel, "Sisi Miring Kanan:", 4);
                break;
            case "Belah Ketupat":
                inputFields = new JTextField[3];
                addInputField(inputPanel, "Diagonal 1:", 0);
                addInputField(inputPanel, "Diagonal 2:", 1);
                addInputField(inputPanel, "Panjang Sisi:", 2);
                break;
            case "Layang-layang":
                inputFields = new JTextField[4];
                addInputField(inputPanel, "Diagonal 1:", 0);
                addInputField(inputPanel, "Diagonal 2:", 1);
                addInputField(inputPanel, "Sisi Pendek:", 2);
                addInputField(inputPanel, "Sisi Panjang:", 3);
                break;
        }

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        JButton backButton = createStyledButton("Kembali", new Color(169, 169, 169));
        backButton.addActionListener(e -> {
            this.dispose();
            if (parentFrame != null) {
                parentFrame.setVisible(true);
            }
        });

        JButton calculateButton = createStyledButton("Hitung", new Color(70, 130, 180));
        calculateButton.addActionListener(new CalculateButtonListener());

        JButton editButton = createStyledButton("Edit (Multithreading)", new Color(60, 179, 113));
        editButton.addActionListener(new EditButtonListener());

        buttonPanel.add(backButton);
        buttonPanel.add(calculateButton);
        buttonPanel.add(editButton);

        // Result panels - sekarang ada dua panel hasil
        JPanel resultPanel = new JPanel(new GridLayout(1, 2, 10, 0));

        // Panel hasil asli
        JPanel originalResultPanel = new JPanel(new BorderLayout());
        resultLabel = new JLabel("<html><div style='text-align:center;padding:10px;'>Hasil akan ditampilkan di sini</div></html>");
        resultLabel.setBorder(BorderFactory.createTitledBorder("Hasil Original"));
        resultLabel.setPreferredSize(new Dimension(350, 150));
        originalResultPanel.add(resultLabel, BorderLayout.CENTER);

        // Panel hasil edit
        JPanel editedResultPanel = new JPanel(new BorderLayout());
        editedResultLabel = new JLabel("<html><div style='text-align:center;padding:10px;'>Hasil edit akan ditampilkan di sini</div></html>");
        editedResultLabel.setBorder(BorderFactory.createTitledBorder("Hasil Edit (Multithreading)"));
        editedResultLabel.setPreferredSize(new Dimension(350, 150));
        editedResultPanel.add(editedResultLabel, BorderLayout.CENTER);

        resultPanel.add(originalResultPanel);
        resultPanel.add(editedResultPanel);

        // Advanced options panel
        JPanel advancedPanel = new JPanel();
        advancedPanel.setLayout(new BoxLayout(advancedPanel, BoxLayout.Y_AXIS));
        advancedPanel.setBorder(BorderFactory.createTitledBorder("Opsi Lanjutan"));

        switch (shapeName) {
            case "Persegi":
                addAdvancedButton(advancedPanel, "Limas Persegi");
                addAdvancedButton(advancedPanel, "Prisma Persegi");
                break;
            case "Persegi Panjang":
                addAdvancedButton(advancedPanel, "Limas Persegi Panjang");
                addAdvancedButton(advancedPanel, "Prisma Persegi Panjang");
                break;
            case "Segitiga":
                addAdvancedButton(advancedPanel, "Limas Segitiga");
                addAdvancedButton(advancedPanel, "Prisma Segitiga");
                break;
            case "Lingkaran":
                addAdvancedButton(advancedPanel, "Juring Lingkaran");
                addAdvancedButton(advancedPanel, "Tembereng Lingkaran");
                addAdvancedButton(advancedPanel, "Bangun Ruang");
                break;
            case "Jajar Genjang":
                addAdvancedButton(advancedPanel, "Limas Jajar Genjang");
                addAdvancedButton(advancedPanel, "Prisma Jajar Genjang");
                break;
            case "Trapesium":
                addAdvancedButton(advancedPanel, "Limas Trapesium");
                addAdvancedButton(advancedPanel, "Prisma Trapesium");
                break;
            case "Belah Ketupat":
                addAdvancedButton(advancedPanel, "Limas Belah Ketupat");
                addAdvancedButton(advancedPanel, "Prisma Belah Ketupat");
                break;
            case "Layang-layang":
                addAdvancedButton(advancedPanel, "Limas Layang-layang");
                addAdvancedButton(advancedPanel, "Prisma Layang-layang");
                break;
        }

        // Add scroll to advanced panel if needed
        JScrollPane advancedScrollPane = new JScrollPane(advancedPanel);
        advancedScrollPane.setPreferredSize(new Dimension(400, 120));

        // Center panel for input and results
        JPanel centerPanel = new JPanel(new BorderLayout(0, 10));
        centerPanel.add(inputPanel, BorderLayout.NORTH);
        centerPanel.add(resultPanel, BorderLayout.CENTER);
        centerPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add components to main panel
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(advancedScrollPane, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private void addInputField(JPanel panel, String labelText, int index) {
        panel.add(new JLabel(labelText));
        inputFields[index] = new JTextField();
        panel.add(inputFields[index]);
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setPreferredSize(new Dimension(150, 30));
        return button;
    }

    private void addAdvancedButton(JPanel panel, String buttonText) {
        JButton button = new JButton(buttonText);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(250, 25));
        button.setBackground(new Color(72, 61, 139));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 11));
        button.addActionListener(new AdvancedButtonListener());
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                switch (shapeName) {
                    case "Persegi":
                        double sisi = Double.parseDouble(inputFields[0].getText());
                        shapeObject = new Persegi(sisi);
                        break;
                    case "Persegi Panjang":
                        double panjang = Double.parseDouble(inputFields[0].getText());
                        double lebar = Double.parseDouble(inputFields[1].getText());
                        shapeObject = new PersegiPanjang(panjang, lebar);
                        break;
                    case "Segitiga":
                        double alas = Double.parseDouble(inputFields[0].getText());
                        double tinggi = Double.parseDouble(inputFields[1].getText());
                        double sisiA = Double.parseDouble(inputFields[2].getText());
                        double sisiB = Double.parseDouble(inputFields[3].getText());
                        double sisiC = Double.parseDouble(inputFields[4].getText());
                        shapeObject = new Segitiga(alas, tinggi, sisiA, sisiB, sisiC);
                        break;
                    case "Lingkaran":
                        double jariJari = Double.parseDouble(inputFields[0].getText());
                        shapeObject = new Lingkaran(jariJari);
                        break;
                    case "Jajar Genjang":
                        double alasJG = Double.parseDouble(inputFields[0].getText());
                        double tinggiJG = Double.parseDouble(inputFields[1].getText());
                        double sisiMiring = Double.parseDouble(inputFields[2].getText());
                        shapeObject = new JajarGenjang(alasJG, tinggiJG, sisiMiring);
                        break;
                    case "Trapesium":
                        double sisiAtas = Double.parseDouble(inputFields[0].getText());
                        double sisiBawah = Double.parseDouble(inputFields[1].getText());
                        double tinggiT = Double.parseDouble(inputFields[2].getText());
                        double sisiMiringKiri = Double.parseDouble(inputFields[3].getText());
                        double sisiMiringKanan = Double.parseDouble(inputFields[4].getText());
                        shapeObject = new Trapesium(sisiAtas, sisiBawah, tinggiT, sisiMiringKiri, sisiMiringKanan);
                        break;
                    case "Belah Ketupat":
                        double d1 = Double.parseDouble(inputFields[0].getText());
                        double d2 = Double.parseDouble(inputFields[1].getText());
                        double sisiBK = Double.parseDouble(inputFields[2].getText());
                        shapeObject = new BelahKetupat(d1, d2, sisiBK);
                        break;
                    case "Layang-layang":
                        double d1L = Double.parseDouble(inputFields[0].getText());
                        double d2L = Double.parseDouble(inputFields[1].getText());
                        double sisiPendek = Double.parseDouble(inputFields[2].getText());
                        double sisiPanjang = Double.parseDouble(inputFields[3].getText());
                        shapeObject = new LayangLayang(d1L, d2L, sisiPendek, sisiPanjang);
                        break;
                }

                displayResults();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ShapeCalculationFrame.this,
                        "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class EditButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (shapeObject == null) {
                JOptionPane.showMessageDialog(ShapeCalculationFrame.this,
                        "Hitung terlebih dahulu sebelum mengedit", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                // Buat objek baru berdasarkan input terbaru
                switch (shapeName) {
                    case "Persegi":
                        double newSisi = Double.parseDouble(inputFields[0].getText());
                        editedShapeObject = new Persegi(newSisi);
                        break;
                    case "Persegi Panjang":
                        double newPanjang = Double.parseDouble(inputFields[0].getText());
                        double newLebar = Double.parseDouble(inputFields[1].getText());
                        editedShapeObject = new PersegiPanjang(newPanjang, newLebar);
                        break;
                    case "Segitiga":
                        double newAlas = Double.parseDouble(inputFields[0].getText());
                        double newTinggi = Double.parseDouble(inputFields[1].getText());
                        double newSisiA = Double.parseDouble(inputFields[2].getText());
                        double newSisiB = Double.parseDouble(inputFields[3].getText());
                        double newSisiC = Double.parseDouble(inputFields[4].getText());
                        editedShapeObject = new Segitiga(newAlas, newTinggi, newSisiA, newSisiB, newSisiC);
                        break;
                    case "Lingkaran":
                        double newJariJari = Double.parseDouble(inputFields[0].getText());
                        editedShapeObject = new Lingkaran(newJariJari);
                        break;
                    case "Jajar Genjang":
                        double newAlasJG = Double.parseDouble(inputFields[0].getText());
                        double newTinggiJG = Double.parseDouble(inputFields[1].getText());
                        double newSisiMiring = Double.parseDouble(inputFields[2].getText());
                        editedShapeObject = new JajarGenjang(newAlasJG, newTinggiJG, newSisiMiring);
                        break;
                    case "Trapesium":
                        double newSisiAtas = Double.parseDouble(inputFields[0].getText());
                        double newSisiBawah = Double.parseDouble(inputFields[1].getText());
                        double newTinggiT = Double.parseDouble(inputFields[2].getText());
                        double newSisiMiringKiri = Double.parseDouble(inputFields[3].getText());
                        double newSisiMiringKanan = Double.parseDouble(inputFields[4].getText());
                        editedShapeObject = new Trapesium(newSisiAtas, newSisiBawah, newTinggiT,
                                newSisiMiringKiri, newSisiMiringKanan);
                        break;
                    case "Belah Ketupat":
                        double newD1 = Double.parseDouble(inputFields[0].getText());
                        double newD2 = Double.parseDouble(inputFields[1].getText());
                        double newSisiBK = Double.parseDouble(inputFields[2].getText());
                        editedShapeObject = new BelahKetupat(newD1, newD2, newSisiBK);
                        break;
                    case "Layang-layang":
                        double newD1L = Double.parseDouble(inputFields[0].getText());
                        double newD2L = Double.parseDouble(inputFields[1].getText());
                        double newSisiPendek = Double.parseDouble(inputFields[2].getText());
                        double newSisiPanjang = Double.parseDouble(inputFields[3].getText());
                        editedShapeObject = new LayangLayang(newD1L, newD2L, newSisiPendek, newSisiPanjang);
                        break;
                }

                // Multithreading calculation
                Thread originalThread = new Thread(() -> {
                    if (shapeObject instanceof Runnable) {
                        ((Runnable) shapeObject).run();
                    }
                    SwingUtilities.invokeLater(() -> displayOriginalResults());
                });

                Thread newThread = new Thread(() -> {
                    if (editedShapeObject instanceof Runnable) {
                        ((Runnable) editedShapeObject).run();
                    }
                    SwingUtilities.invokeLater(() -> {
                        // Update shapeObject dengan nilai baru setelah perhitungan selesai
                        shapeObject = editedShapeObject;
                        displayEditedResults();
                        displayOriginalResults(); // Perbarui juga tampilan original
                    });
                });

                originalThread.start();
                newThread.start();

                JOptionPane.showMessageDialog(ShapeCalculationFrame.this,
                        "Perhitungan dengan multithreading sedang diproses!", "Info", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ShapeCalculationFrame.this,
                        "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class AdvancedButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (shapeObject == null) {
                JOptionPane.showMessageDialog(ShapeCalculationFrame.this,
                        "Hitung bentuk dasar terlebih dahulu", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String option = ((JButton) e.getSource()).getText();

            switch (option) {
                case "Limas Persegi":
                    if (shapeObject instanceof Persegi) {
                        String input = JOptionPane.showInputDialog("Masukkan tinggi limas:");
                        try {
                            double tinggi = Double.parseDouble(input);
                            LimasPersegi limas = new LimasPersegi(((Persegi) shapeObject).getSisi(), tinggi);
                            showAdvancedResults(limas);
                        } catch (NumberFormatException ex) {
                            showError("Masukkan angka yang valid!");
                        }
                    }
                    break;
                case "Prisma Persegi":
                    if (shapeObject instanceof Persegi) {
                        String input = JOptionPane.showInputDialog("Masukkan tinggi prisma:");
                        try {
                            double tinggi = Double.parseDouble(input);
                            PrismaPersegi prisma = new PrismaPersegi(((Persegi) shapeObject).getSisi(), tinggi);
                            showAdvancedResults(prisma);
                        } catch (NumberFormatException ex) {
                            showError("Masukkan angka yang valid!");
                        }
                    }
                    break;
                case "Limas Persegi Panjang":
                    if (shapeObject instanceof PersegiPanjang) {
                        String input = JOptionPane.showInputDialog("Masukkan tinggi limas:");
                        try {
                            double tinggi = Double.parseDouble(input);
                            LimasPersegiPanjang limas = new LimasPersegiPanjang(
                                    ((PersegiPanjang) shapeObject).getPanjang(),
                                    ((PersegiPanjang) shapeObject).getLebar(),
                                    tinggi);
                            showAdvancedResults(limas);
                        } catch (NumberFormatException ex) {
                            showError("Masukkan angka yang valid!");
                        }
                    }
                    break;
                case "Prisma Persegi Panjang":
                    if (shapeObject instanceof PersegiPanjang) {
                        String input = JOptionPane.showInputDialog("Masukkan tinggi prisma:");
                        try {
                            double tinggi = Double.parseDouble(input);
                            PrismaPersegiPanjang prisma = new PrismaPersegiPanjang(
                                    ((PersegiPanjang) shapeObject).getPanjang(),
                                    ((PersegiPanjang) shapeObject).getLebar(),
                                    tinggi);
                            showAdvancedResults(prisma);
                        } catch (NumberFormatException ex) {
                            showError("Masukkan angka yang valid!");
                        }
                    }
                    break;
                case "Limas Segitiga":
                    if (shapeObject instanceof Segitiga) {
                        String input = JOptionPane.showInputDialog("Masukkan tinggi limas:");
                        try {
                            double tinggi = Double.parseDouble(input);
                            LimasSegitiga limas = new LimasSegitiga(
                                    ((Segitiga) shapeObject).getSisiA(),
                                    ((Segitiga) shapeObject).getTinggi(),
                                    ((Segitiga) shapeObject).getSisiA(),
                                    ((Segitiga) shapeObject).getSisiB(),
                                    ((Segitiga) shapeObject).getSisiC(),
                                    tinggi);
                            showAdvancedResults(limas);
                        } catch (NumberFormatException ex) {
                            showError("Masukkan angka yang valid!");
                        }
                    }
                    break;
                case "Prisma Segitiga":
                    if (shapeObject instanceof Segitiga) {
                        String input = JOptionPane.showInputDialog("Masukkan tinggi prisma:");
                        try {
                            double tinggi = Double.parseDouble(input);
                            PrismaSegitiga prisma = new PrismaSegitiga(
                                    ((Segitiga) shapeObject).getSisiA(),
                                    ((Segitiga) shapeObject).getTinggi(),
                                    ((Segitiga) shapeObject).getSisiA(),
                                    ((Segitiga) shapeObject).getSisiB(),
                                    ((Segitiga) shapeObject).getSisiC(),
                                    tinggi);
                            showAdvancedResults(prisma);
                        } catch (NumberFormatException ex) {
                            showError("Masukkan angka yang valid!");
                        }
                    }
                    break;
                case "Juring Lingkaran":
                    if (shapeObject instanceof Lingkaran) {
                        String input = JOptionPane.showInputDialog("Masukkan sudut juring (derajat):");
                        try {
                            double sudut = Double.parseDouble(input);
                            JuringLingkaran juring = new JuringLingkaran(((Lingkaran) shapeObject).getJariJari(), sudut);
                            showAdvancedResults(juring);
                        } catch (NumberFormatException ex) {
                            showError("Masukkan angka yang valid!");
                        }
                    }
                    break;
                case "Tembereng Lingkaran":
                    if (shapeObject instanceof Lingkaran) {
                        String input = JOptionPane.showInputDialog("Masukkan panjang tali busur:");
                        try {
                            double taliBusur = Double.parseDouble(input);
                            TemberengLingkaran tembereng = new TemberengLingkaran(
                                    ((Lingkaran) shapeObject).getJariJari(), taliBusur);
                            showAdvancedResults(tembereng);
                        } catch (NumberFormatException ex) {
                            showError("Masukkan angka yang valid!");
                        }
                    }
                    break;
                case "Bangun Ruang":
                    if (shapeObject instanceof Lingkaran) {
                        String[] options = {"Tabung", "Kerucut", "Bola"};
                        int choice = JOptionPane.showOptionDialog(
                                ShapeCalculationFrame.this,
                                "Pilih bangun ruang:",
                                "Bangun Ruang Lingkaran",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[0]);

                        if (choice == 0) { // Tabung
                            String input = JOptionPane.showInputDialog("Masukkan tinggi tabung:");
                            try {
                                double tinggi = Double.parseDouble(input);
                                Tabung tabung = new Tabung(((Lingkaran) shapeObject).getJariJari(), tinggi);
                                showAdvancedResults(tabung);
                            } catch (NumberFormatException ex) {
                                showError("Masukkan angka yang valid!");
                            }
                        } else if (choice == 1) { // Kerucut
                            String input = JOptionPane.showInputDialog("Masukkan tinggi kerucut:");
                            try {
                                double tinggi = Double.parseDouble(input);
                                Kerucut kerucut = new Kerucut(((Lingkaran) shapeObject).getJariJari(), tinggi);
                                showAdvancedResults(kerucut);
                            } catch (NumberFormatException ex) {
                                showError("Masukkan angka yang valid!");
                            }
                        } else if (choice == 2) { // Bola
                            Bola bola = new Bola(((Lingkaran) shapeObject).getJariJari());
                            showAdvancedResults(bola);
                        }
                    }
                    break;
                case "Limas Jajar Genjang":
                    if (shapeObject instanceof JajarGenjang) {
                        String input = JOptionPane.showInputDialog("Masukkan tinggi limas:");
                        try {
                            double tinggi = Double.parseDouble(input);
                            LimasJajarGenjang limas = new LimasJajarGenjang(
                                    ((JajarGenjang) shapeObject).getAlas(),
                                    ((JajarGenjang) shapeObject).getTinggi(),
                                    ((JajarGenjang) shapeObject).getSisiMiring(),
                                    tinggi);
                            showAdvancedResults(limas);
                        } catch (NumberFormatException ex) {
                            showError("Masukkan angka yang valid!");
                        }
                    }
                    break;
                case "Prisma Jajar Genjang":
                    if (shapeObject instanceof JajarGenjang) {
                        String input = JOptionPane.showInputDialog("Masukkan tinggi prisma:");
                        try {
                            double tinggi = Double.parseDouble(input);
                            PrismaJajarGenjang prisma = new PrismaJajarGenjang(
                                    ((JajarGenjang) shapeObject).getAlas(),
                                    ((JajarGenjang) shapeObject).getTinggi(),
                                    ((JajarGenjang) shapeObject).getSisiMiring(),
                                    tinggi);
                            showAdvancedResults(prisma);
                        } catch (NumberFormatException ex) {
                            showError("Masukkan angka yang valid!");
                        }
                    }
                    break;
                case "Limas Trapesium":
                    if (shapeObject instanceof Trapesium) {
                        String input = JOptionPane.showInputDialog("Masukkan tinggi limas:");
                        try {
                            double tinggi = Double.parseDouble(input);
                            LimasTrapesium limas = new LimasTrapesium(
                                    ((Trapesium) shapeObject).getSisiAtas(),
                                    ((Trapesium) shapeObject).getSisiBawah(),
                                    ((Trapesium) shapeObject).getTinggi(),
                                    ((Trapesium) shapeObject).getSisiMiringKiri(),
                                    ((Trapesium) shapeObject).getSisiMiringKanan(),
                                    tinggi);
                            showAdvancedResults(limas);
                        } catch (NumberFormatException ex) {
                            showError("Masukkan angka yang valid!");
                        }
                    }
                    break;
                case "Prisma Trapesium":
                    if (shapeObject instanceof Trapesium) {
                        String input = JOptionPane.showInputDialog("Masukkan tinggi prisma:");
                        try {
                            double tinggi = Double.parseDouble(input);
                            PrismaTrapesium prisma = new PrismaTrapesium(
                                    ((Trapesium) shapeObject).getSisiAtas(),
                                    ((Trapesium) shapeObject).getSisiBawah(),
                                    ((Trapesium) shapeObject).getTinggi(),
                                    ((Trapesium) shapeObject).getSisiMiringKiri(),
                                    ((Trapesium) shapeObject).getSisiMiringKanan(),
                                    tinggi);
                            showAdvancedResults(prisma);
                        } catch (NumberFormatException ex) {
                            showError("Masukkan angka yang valid!");
                        }
                    }
                    break;
                case "Limas Belah Ketupat":
                    if (shapeObject instanceof BelahKetupat) {
                        String input = JOptionPane.showInputDialog("Masukkan tinggi limas:");
                        try {
                            double tinggi = Double.parseDouble(input);
                            BelahKetupat limas = new LimasBelahKetupat(
                                    ((BelahKetupat) shapeObject).getDiagonal1(),
                                    ((BelahKetupat) shapeObject).getDiagonal2(),
                                    ((BelahKetupat) shapeObject).getSisi(),
                                    tinggi);
                            showAdvancedResults(limas);
                        } catch (NumberFormatException ex) {
                            showError("Masukkan angka yang valid!");
                        }
                    }
                    break;
                case "Prisma Belah Ketupat":
                    if (shapeObject instanceof BelahKetupat) {
                        String input = JOptionPane.showInputDialog("Masukkan tinggi prisma:");
                        try {
                            double tinggi = Double.parseDouble(input);
                            PrismaBelahKetupat prisma = new PrismaBelahKetupat(
                                    ((BelahKetupat) shapeObject).getDiagonal1(),
                                    ((BelahKetupat) shapeObject).getDiagonal2(),
                                    ((BelahKetupat) shapeObject).getSisi(),
                                    tinggi);
                            showAdvancedResults(prisma);
                        } catch (NumberFormatException ex) {
                            showError("Masukkan angka yang valid!");
                        }
                    }
                    break;
                case "Limas Layang-layang":
                    if (shapeObject instanceof LayangLayang) {
                        String input = JOptionPane.showInputDialog("Masukkan tinggi limas:");
                        try {
                            double tinggi = Double.parseDouble(input);
                            LimasLayangLayang limas = new LimasLayangLayang(
                                    ((BelahKetupat) shapeObject).getDiagonal1(),
                                    ((BelahKetupat) shapeObject).getDiagonal2(),
                                    ((LayangLayang) shapeObject).getSisiPendek(),
                                    ((LayangLayang) shapeObject).getSisiPanjang(),
                                    tinggi);
                            showAdvancedResults(limas);
                        } catch (NumberFormatException ex) {
                            showError("Masukkan angka yang valid!");
                        }
                    }
                    break;
                case "Prisma Layang-layang":
                    if (shapeObject instanceof LayangLayang) {
                        String input = JOptionPane.showInputDialog("Masukkan tinggi prisma:");
                        try {
                            double tinggi = Double.parseDouble(input);
                            PrismaLayangLayang prisma = new PrismaLayangLayang(
                                    ((BelahKetupat) shapeObject).getDiagonal1(),
                                    ((BelahKetupat) shapeObject).getDiagonal2(),
                                    ((LayangLayang) shapeObject).getSisiPendek(),
                                    ((LayangLayang) shapeObject).getSisiPanjang(),
                                    tinggi);
                            showAdvancedResults(prisma);
                        } catch (NumberFormatException ex) {
                            showError("Masukkan angka yang valid!");
                        }
                    }
                    break;
            }
        }
    }

    private void displayResults() {
        displayOriginalResults();
        if (editedShapeObject != null) {
            displayEditedResults();
        }
    }

    private void displayOriginalResults() {
        StringBuilder sb = new StringBuilder("<html><div style='text-align:center;'><b>Hasil Original:</b><br>");        sb.append("Nama Bangun: ").append(shapeName).append("<br>");
        sb.append("Nama Bangun: ").append(shapeName).append("<br>");

        if (shapeObject instanceof Persegi) {
            Persegi p = (Persegi) shapeObject;
            sb.append("Sisi: ").append(p.getSisi()).append("<br>");
            sb.append("Luas: ").append(p.luas).append("<br>");
            sb.append("Keliling: ").append(p.keliling).append("<br>");
        } else if (shapeObject instanceof PersegiPanjang) {
            PersegiPanjang pp = (PersegiPanjang) shapeObject;
            sb.append("Panjang: ").append(pp.getPanjang()).append("<br>");
            sb.append("Lebar: ").append(pp.getLebar()).append("<br>");
            sb.append("Luas: ").append(pp.luas).append("<br>");
            sb.append("Keliling: ").append(pp.keliling).append("<br>");
        } else if (shapeObject instanceof Segitiga) {
            Segitiga s = (Segitiga) shapeObject;
            sb.append("Alas: ").append(s.getSisiA()).append("<br>");
            sb.append("Tinggi: ").append(s.getTinggi()).append("<br>");
            sb.append("Sisi A: ").append(s.getSisiA()).append("<br>");
            sb.append("Sisi B: ").append(s.getSisiB()).append("<br>");
            sb.append("Sisi C: ").append(s.getSisiC()).append("<br>");
            sb.append("Luas: ").append(s.luas).append("<br>");
            sb.append("Keliling: ").append(s.keliling).append("<br>");
        } else if (shapeObject instanceof Lingkaran) {
            Lingkaran l = (Lingkaran) shapeObject;
            sb.append("Jari-jari: ").append(l.getJariJari()).append("<br>");
            sb.append("Luas: ").append(l.luas).append("<br>");
            sb.append("Keliling: ").append(l.keliling).append("<br>");
        } else if (shapeObject instanceof JajarGenjang) {
            JajarGenjang jg = (JajarGenjang) shapeObject;
            sb.append("Alas: ").append(jg.getAlas()).append("<br>");
            sb.append("Tinggi: ").append(jg.getTinggi()).append("<br>");
            sb.append("Sisi Miring: ").append(jg.getSisiMiring()).append("<br>");
            sb.append("Luas: ").append(jg.luas).append("<br>");
            sb.append("Keliling: ").append(jg.keliling).append("<br>");
        } else if (shapeObject instanceof Trapesium) {
            Trapesium t = (Trapesium) shapeObject;
            sb.append("Sisi Atas: ").append(t.getSisiAtas()).append("<br>");
            sb.append("Sisi Bawah: ").append(t.getSisiBawah()).append("<br>");
            sb.append("Tinggi: ").append(t.getTinggi()).append("<br>");
            sb.append("Sisi Miring Kiri: ").append(t.getSisiMiringKiri()).append("<br>");
            sb.append("Sisi Miring Kanan: ").append(t.getSisiMiringKanan()).append("<br>");
            sb.append("Luas: ").append(t.luas).append("<br>");
            sb.append("Keliling: ").append(t.keliling).append("<br>");
        } else if (shapeObject instanceof BelahKetupat) {
            BelahKetupat bk = (BelahKetupat) shapeObject;
            sb.append("Diagonal 1: ").append(bk.getDiagonal1()).append("<br>");
            sb.append("Diagonal 2: ").append(bk.getDiagonal2()).append("<br>");
            sb.append("Sisi: ").append(bk.getSisi()).append("<br>");
            sb.append("Luas: ").append(bk.luas).append("<br>");
            sb.append("Keliling: ").append(bk.keliling).append("<br>");
        } else if (shapeObject instanceof LayangLayang) {
            LayangLayang ll = (LayangLayang) shapeObject;
            sb.append("Diagonal 1: ").append(ll.getDiagonal1()).append("<br>");
            sb.append("Diagonal 2: ").append(ll.getDiagonal2()).append("<br>");
            sb.append("Sisi Pendek: ").append(ll.getSisiPendek()).append("<br>");
            sb.append("Sisi Panjang: ").append(ll.getSisiPanjang()).append("<br>");
            sb.append("Luas: ").append(ll.luas).append("<br>");
            sb.append("Keliling: ").append(ll.keliling).append("<br>");
        }

        resultLabel.setText(sb.toString());
    }

    private void displayEditedResults() {
        if (editedShapeObject == null) return;
        StringBuilder sb = new StringBuilder("<html><div style='text-align:center;'><b>Hasil Edit:</b><br>");
        sb.append("Nama Bangun: ").append(shapeName).append("<br>");

        if (editedShapeObject instanceof Persegi) {
            Persegi p = (Persegi) editedShapeObject;
            sb.append("Sisi: ").append(p.getSisi()).append("<br>");
            sb.append("Luas: ").append(p.luas).append("<br>");
            sb.append("Keliling: ").append(p.keliling).append("<br>");
        } else if (editedShapeObject instanceof PersegiPanjang) {
            PersegiPanjang pp = (PersegiPanjang) editedShapeObject;
            sb.append("Panjang: ").append(pp.getPanjang()).append("<br>");
            sb.append("Lebar: ").append(pp.getLebar()).append("<br>");
            sb.append("Luas: ").append(pp.luas).append("<br>");
            sb.append("Keliling: ").append(pp.keliling).append("<br>");
        } else if (editedShapeObject instanceof Segitiga) {
            Segitiga s = (Segitiga) editedShapeObject;
            sb.append("Alas: ").append(s.getSisiA()).append("<br>");
            sb.append("Tinggi: ").append(s.getTinggi()).append("<br>");
            sb.append("Sisi A: ").append(s.getSisiA()).append("<br>");
            sb.append("Sisi B: ").append(s.getSisiB()).append("<br>");
            sb.append("Sisi C: ").append(s.getSisiC()).append("<br>");
            sb.append("Luas: ").append(s.luas).append("<br>");
            sb.append("Keliling: ").append(s.keliling).append("<br>");
        } else if (editedShapeObject instanceof Lingkaran) {
            Lingkaran l = (Lingkaran) editedShapeObject;
            sb.append("Jari-jari: ").append(l.getJariJari()).append("<br>");
            sb.append("Luas: ").append(l.luas).append("<br>");
            sb.append("Keliling: ").append(l.keliling).append("<br>");
        } else if (editedShapeObject instanceof JajarGenjang) {
            JajarGenjang jg = (JajarGenjang) editedShapeObject;
            sb.append("Alas: ").append(jg.getAlas()).append("<br>");
            sb.append("Tinggi: ").append(jg.getTinggi()).append("<br>");
            sb.append("Sisi Miring: ").append(jg.getSisiMiring()).append("<br>");
            sb.append("Luas: ").append(jg.luas).append("<br>");
            sb.append("Keliling: ").append(jg.keliling).append("<br>");
        } else if (editedShapeObject instanceof Trapesium) {
            Trapesium t = (Trapesium) editedShapeObject;
            sb.append("Sisi Atas: ").append(t.getSisiAtas()).append("<br>");
            sb.append("Sisi Bawah: ").append(t.getSisiBawah()).append("<br>");
            sb.append("Tinggi: ").append(t.getTinggi()).append("<br>");
            sb.append("Sisi Miring Kiri: ").append(t.getSisiMiringKiri()).append("<br>");
            sb.append("Sisi Miring Kanan: ").append(t.getSisiMiringKanan()).append("<br>");
            sb.append("Luas: ").append(t.luas).append("<br>");
            sb.append("Keliling: ").append(t.keliling).append("<br>");
        } else if (editedShapeObject instanceof BelahKetupat) {
            BelahKetupat bk = (BelahKetupat) editedShapeObject;
            sb.append("Diagonal 1: ").append(bk.getDiagonal1()).append("<br>");
            sb.append("Diagonal 2: ").append(bk.getDiagonal2()).append("<br>");
            sb.append("Sisi: ").append(bk.getSisi()).append("<br>");
            sb.append("Luas: ").append(bk.luas).append("<br>");
            sb.append("Keliling: ").append(bk.keliling).append("<br>");
        } else if (editedShapeObject instanceof LayangLayang) {
            LayangLayang ll = (LayangLayang) editedShapeObject;
            sb.append("Diagonal 1: ").append(ll.getDiagonal1()).append("<br>");
            sb.append("Diagonal 2: ").append(ll.getDiagonal2()).append("<br>");
            sb.append("Sisi Pendek: ").append(ll.getSisiPendek()).append("<br>");
            sb.append("Sisi Panjang: ").append(ll.getSisiPanjang()).append("<br>");
            sb.append("Luas: ").append(ll.luas).append("<br>");
            sb.append("Keliling: ").append(ll.keliling).append("<br>");
        }

        sb.append("</div></html>");
        editedResultLabel.setText(sb.toString());
    }

        private void showAdvancedResults(Object advancedShape) {
        StringBuilder sb = new StringBuilder("<html><b>Hasil Perhitungan Lanjutan:</b><br>");

        if (advancedShape instanceof LimasPersegi) {
            LimasPersegi lp = (LimasPersegi) advancedShape;
            sb.append("Nama Bangun: Limas Persegi<br>");
            sb.append("Sisi Alas: ").append(lp.getSisi()).append("<br>");
            sb.append("Tinggi Limas: ").append(((LimasPersegi) advancedShape).getTinggiLimas()).append("<br>");
            sb.append("Volume: ").append(lp.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(lp.luasPermukaan).append("<br>");
        } else if (advancedShape instanceof PrismaPersegi) {
            PrismaPersegi pp = (PrismaPersegi) advancedShape;
            sb.append("Nama Bangun: Prisma Persegi<br>");
            sb.append("Sisi Alas: ").append(pp.getSisi()).append("<br>");
            sb.append("Tinggi Prisma: ").append(((PrismaPersegi) advancedShape).getTinggiPrisma()).append("<br>");
            sb.append("Volume: ").append(pp.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(pp.luasPermukaan).append("<br>");
        } else if (advancedShape instanceof LimasPersegiPanjang) {
            LimasPersegiPanjang lpp = (LimasPersegiPanjang) advancedShape;
            sb.append("Nama Bangun: Limas Persegi Panjang<br>");
            sb.append("Panjang Alas: ").append(lpp.getPanjang()).append("<br>");
            sb.append("Lebar Alas: ").append(lpp.getLebar()).append("<br>");
            sb.append("Tinggi Limas: ").append(((LimasPersegiPanjang) advancedShape).getTinggiLimas()).append("<br>");
            sb.append("Volume: ").append(lpp.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(lpp.luasPermukaan).append("<br>");
        } else if (advancedShape instanceof PrismaPersegiPanjang) {
            PrismaPersegiPanjang ppp = (PrismaPersegiPanjang) advancedShape;
            sb.append("Nama Bangun: Prisma Persegi Panjang<br>");
            sb.append("Panjang Alas: ").append(ppp.getPanjang()).append("<br>");
            sb.append("Lebar Alas: ").append(ppp.getLebar()).append("<br>");
            sb.append("Tinggi Prisma: ").append(((PrismaPersegiPanjang) advancedShape).getTinggiPrisma()).append("<br>");
            sb.append("Volume: ").append(ppp.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(ppp.luasPermukaan).append("<br>");
        } else if (advancedShape instanceof LimasSegitiga) {
            LimasSegitiga ls = (LimasSegitiga) advancedShape;
            sb.append("Nama Bangun: Limas Segitiga<br>");
            sb.append("Alas Segitiga: ").append(ls.getSisiA()).append("<br>");
            sb.append("Tinggi Segitiga: ").append(ls.getTinggi()).append("<br>");
            sb.append("Sisi A: ").append(ls.getSisiA()).append("<br>");
            sb.append("Sisi B: ").append(ls.getSisiB()).append("<br>");
            sb.append("Sisi C: ").append(ls.getSisiC()).append("<br>");
            sb.append("Tinggi Limas: ").append(((LimasSegitiga) advancedShape).getTinggiLimas()).append("<br>");
            sb.append("Volume: ").append(ls.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(ls.luasPermukaan).append("<br>");
        } else if (advancedShape instanceof PrismaSegitiga) {
            PrismaSegitiga ps = (PrismaSegitiga) advancedShape;
            sb.append("Nama Bangun: Prisma Segitiga<br>");
            sb.append("Alas Segitiga: ").append(ps.getSisiA()).append("<br>");
            sb.append("Tinggi Segitiga: ").append(ps.getTinggi()).append("<br>");
            sb.append("Sisi A: ").append(ps.getSisiA()).append("<br>");
            sb.append("Sisi B: ").append(ps.getSisiB()).append("<br>");
            sb.append("Sisi C: ").append(ps.getSisiC()).append("<br>");
            sb.append("Tinggi Prisma: ").append(((PrismaSegitiga) advancedShape).getTinggiPrisma()).append("<br>");
            sb.append("Volume: ").append(ps.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(ps.luasPermukaan).append("<br>");
        } else if (advancedShape instanceof JuringLingkaran) {
            JuringLingkaran jl = (JuringLingkaran) advancedShape;
            sb.append("Nama Bangun: Juring Lingkaran<br>");
            sb.append("Jari-jari: ").append(jl.getJariJari()).append("<br>");
            sb.append("Sudut: ").append(((JuringLingkaran) advancedShape).getSudutDerajat()).append("°<br>");
            sb.append("Luas Juring: ").append(jl.luasJuringLingkaran).append("<br>");
            sb.append("Keliling Juring: ").append(jl.kelilingJuringLingkaran).append("<br>");
        } else if (advancedShape instanceof TemberengLingkaran) {
            TemberengLingkaran tl = (TemberengLingkaran) advancedShape;
            sb.append("Nama Bangun: Tembereng Lingkaran<br>");
            sb.append("Jari-jari: ").append(tl.getJariJari()).append("<br>");
            sb.append("Tinggi Tembereng: ").append(((TemberengLingkaran) advancedShape).getTinggiTembereng()).append("<br>");
            sb.append("Luas Tembereng: ").append(tl.luasTemberengLingkaran).append("<br>");
            sb.append("Keliling Tembereng: ").append(tl.kelilingTemberengLingkaran).append("<br>");
        } else if (advancedShape instanceof Tabung) {
            Tabung t = (Tabung) advancedShape;
            sb.append("Nama Bangun: Tabung<br>");
            sb.append("Jari-jari: ").append(t.getJariJari()).append("<br>");
            sb.append("Tinggi: ").append(((Tabung) advancedShape).getTinggi()).append("<br>");
            sb.append("Volume: ").append(t.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(t.luasPermukaan).append("<br>");
        } else if (advancedShape instanceof Kerucut) {
            Kerucut k = (Kerucut) advancedShape;
            sb.append("Nama Bangun: Kerucut<br>");
            sb.append("Jari-jari: ").append(k.getJariJari()).append("<br>");
            sb.append("Tinggi: ").append(((Kerucut) advancedShape).getTinggi()).append("<br>");
            sb.append("Volume: ").append(k.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(k.luasPermukaan).append("<br>");
        } else if (advancedShape instanceof Bola) {
            Bola b = (Bola) advancedShape;
            sb.append("Nama Bangun: Bola<br>");
            sb.append("Jari-jari: ").append(b.getJariJari()).append("<br>");
            sb.append("Volume: ").append(b.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(b.luasPermukaan).append("<br>");
        } else if (advancedShape instanceof LimasJajarGenjang) {
            LimasJajarGenjang ljg = (LimasJajarGenjang) advancedShape;
            sb.append("Nama Bangun: Limas Jajar Genjang<br>");
            sb.append("Alas: ").append(ljg.getAlas()).append("<br>");
            sb.append("Tinggi: ").append(ljg.getTinggi()).append("<br>");
            sb.append("Sisi Miring: ").append(ljg.getSisiMiring()).append("<br>");
            sb.append("Tinggi Limas: ").append(((LimasJajarGenjang) advancedShape).getTinggi()).append("<br>");
            sb.append("Volume: ").append(ljg.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(ljg.luasPermukaan).append("<br>");
        } else if (advancedShape instanceof PrismaJajarGenjang) {
            PrismaJajarGenjang pjg = (PrismaJajarGenjang) advancedShape;
            sb.append("Nama Bangun: Prisma Jajar Genjang<br>");
            sb.append("Alas: ").append(pjg.getAlas()).append("<br>");
            sb.append("Tinggi: ").append(pjg.getTinggi()).append("<br>");
            sb.append("Sisi Miring: ").append(pjg.getSisiMiring()).append("<br>");
            sb.append("Tinggi Prisma: ").append(((PrismaJajarGenjang) advancedShape).getTinggiPrisma()).append("<br>");
            sb.append("Volume: ").append(pjg.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(pjg.luasPermukaan).append("<br>");
        } else if (advancedShape instanceof LimasTrapesium) {
            LimasTrapesium lt = (LimasTrapesium) advancedShape;
            sb.append("Nama Bangun: Limas Trapesium<br>");
            sb.append("Sisi Atas: ").append(lt.getSisiAtas()).append("<br>");
            sb.append("Sisi Bawah: ").append(lt.getSisiBawah()).append("<br>");
            sb.append("Tinggi: ").append(lt.getTinggi()).append("<br>");
            sb.append("Sisi Miring Kiri: ").append(lt.getSisiMiringKiri()).append("<br>");
            sb.append("Sisi Miring Kanan: ").append(lt.getSisiMiringKanan()).append("<br>");
            sb.append("Tinggi Limas: ").append(((LimasTrapesium) advancedShape).getTinggiLimas()).append("<br>");
            sb.append("Volume: ").append(lt.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(lt.luasPermukaan).append("<br>");
        } else if (advancedShape instanceof PrismaTrapesium) {
            PrismaTrapesium pt = (PrismaTrapesium) advancedShape;
            sb.append("Nama Bangun: Prisma Trapesium<br>");
            sb.append("Sisi Atas: ").append(pt.getSisiAtas()).append("<br>");
            sb.append("Sisi Bawah: ").append(pt.getSisiBawah()).append("<br>");
            sb.append("Tinggi: ").append(pt.getTinggi()).append("<br>");
            sb.append("Sisi Miring Kiri: ").append(pt.getSisiMiringKiri()).append("<br>");
            sb.append("Sisi Miring Kanan: ").append(pt.getSisiMiringKanan()).append("<br>");
            sb.append("Tinggi Prisma: ").append(((PrismaTrapesium) advancedShape).getTinggiPrisma()).append("<br>");
            sb.append("Volume: ").append(pt.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(pt.luasPermukaan).append("<br>");
        } else if (advancedShape instanceof LimasBelahKetupat) {
            LimasBelahKetupat lbk = (LimasBelahKetupat) advancedShape;
            sb.append("Nama Bangun: Limas Belah Ketupat<br>");
            sb.append("Diagonal 1: ").append(lbk.getDiagonal1()).append("<br>");
            sb.append("Diagonal 2: ").append(lbk.getDiagonal2()).append("<br>");
            sb.append("Sisi: ").append(lbk.getSisi()).append("<br>");
            sb.append("Tinggi Limas: ").append(((LimasBelahKetupat) advancedShape).getTinggi()).append("<br>");
            sb.append("Volume: ").append(lbk.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(lbk.luasPermukaan).append("<br>");
        } else if (advancedShape instanceof PrismaBelahKetupat) {
            PrismaBelahKetupat pbk = (PrismaBelahKetupat) advancedShape;
            sb.append("Nama Bangun: Prisma Belah Ketupat<br>");
            sb.append("Diagonal 1: ").append(pbk.getDiagonal1()).append("<br>");
            sb.append("Diagonal 2: ").append(pbk.getDiagonal2()).append("<br>");
            sb.append("Sisi: ").append(pbk.getSisi()).append("<br>");
            sb.append("Tinggi Prisma: ").append(((PrismaBelahKetupat) advancedShape).getTinggi()).append("<br>");
            sb.append("Volume: ").append(pbk.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(pbk.luasPermukaan).append("<br>");
        } else if (advancedShape instanceof LimasLayangLayang) {
            LimasLayangLayang lll = (LimasLayangLayang) advancedShape;
            sb.append("Nama Bangun: Limas Layang-layang<br>");
            sb.append("Diagonal 1: ").append(lll.getDiagonal1()).append("<br>");
            sb.append("Diagonal 2: ").append(lll.getDiagonal2()).append("<br>");
            sb.append("Sisi Pendek: ").append(lll.getSisiPendek()).append("<br>");
            sb.append("Sisi Panjang: ").append(lll.getSisiPanjang()).append("<br>");
            sb.append("Tinggi Limas: ").append(((LimasLayangLayang) advancedShape).getTinggiLimas()).append("<br>");
            sb.append("Volume: ").append(lll.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(lll.luasPermukaan).append("<br>");
        } else if (advancedShape instanceof PrismaLayangLayang) {
            PrismaLayangLayang pll = (PrismaLayangLayang) advancedShape;
            sb.append("Nama Bangun: Prisma Layang-layang<br>");
            sb.append("Diagonal 1: ").append(pll.getDiagonal1()).append("<br>");
            sb.append("Diagonal 2: ").append(pll.getDiagonal2()).append("<br>");
            sb.append("Sisi Pendek: ").append(pll.getSisiPendek()).append("<br>");
            sb.append("Sisi Panjang: ").append(pll.getSisiPanjang()).append("<br>");
            sb.append("Tinggi Prisma: ").append(((PrismaLayangLayang) advancedShape).getTinggiPrisma()).append("<br>");
            sb.append("Volume: ").append(pll.volume).append("<br>");
            sb.append("Luas Permukaan: ").append(pll.luasPermukaan).append("<br>");
        }

        JOptionPane.showMessageDialog(this, sb.toString(), "Hasil Lanjutan", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}