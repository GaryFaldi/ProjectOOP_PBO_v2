package BangunGeometry;

import java.util.Scanner;

public class LimasLayangLayang extends LayangLayang {
    private final double tinggiLimas;
    public double volume;
    public double luasPermukaan;
    char jawab = 'Y';
    protected double newD1;
    protected double newD2;
    protected double newPendek;
    protected double newPanjang;

    public LimasLayangLayang(double diagonal1, double diagonal2,
                             double sisiPendek, double sisiPanjang,
                             double tinggiLimas) {
        super(diagonal1, diagonal2, sisiPendek, sisiPanjang);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    public double hitungVolume(double newD1, double newD2) {
        System.out.println("Apakah Anda akan mengedit nilai Diagonal1, dan Diagonal2?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.print("Masukkan nilai Diagonal1 baru: ");
            newD1 = inp.nextDouble();
            System.out.print("Masukkan nilai Diagonal2 baru: ");
            newD2 = inp.nextDouble();
            volume = (1.0 / 3.0) * super.hitungLuas(newD1, newD2) * tinggiLimas;
            return volume;
        } else {
            volume = (1.0 / 3.0) * super.luas * tinggiLimas;
            return volume;
        }
    }

    public double hitungLuasPermukaan() {
        // Gunakan Pythagoras untuk menghitung tinggi segitiga sisi tegak
        double tinggiSegitigaPendek  = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * super.diagonal1, 2));
        double tinggiSegitigaPanjang = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * super.diagonal2, 2));

        // Hitung luas sisi tegak
        double luasSisiPendek  = 2 * (0.5 * super.sisiPendek * tinggiSegitigaPendek);
        double luasSisiPanjang = 2 * (0.5 * super.sisiPanjang * tinggiSegitigaPanjang);
        luasPermukaan = super.luas + luasSisiPendek + luasSisiPanjang;;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newD1, double newD2, double newPendek, double newPanjang) {
        System.out.println("Apakah Anda akan mengedit nilai sisi Pendek, sisi Panjang, Diagonal1, dan Diagonal2?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.print("Masukkan nilai sisi Pendek baru: ");
            newPendek = inp.nextDouble();
            System.out.print("Masukkan nilai sisi Panjang baru: ");
            newPanjang = inp.nextDouble();
            System.out.print("Masukkan nilai Diagonal1 baru: ");
            newD1 = inp.nextDouble();
            System.out.print("Masukkan nilai Diagonal2 baru: ");
            newD2 = inp.nextDouble();
            // Gunakan Pythagoras untuk menghitung tinggi segitiga sisi tegak
            double tinggiSegitigaPendek  = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * newD1, 2));
            double tinggiSegitigaPanjang = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * newD2, 2));
            // Hitung luas sisi tegak
            double luasSisiPendek  = 2 * (0.5 * newPendek * tinggiSegitigaPendek);
            double luasSisiPanjang = 2 * (0.5 * newPanjang * tinggiSegitigaPanjang);
            luasPermukaan = super.hitungLuas(newD1, newD2) + luasSisiPendek + luasSisiPanjang;;
            return luasPermukaan;
        } else {
            // Gunakan Pythagoras untuk menghitung tinggi segitiga sisi tegak
            double tinggiSegitigaPendek  = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * super.diagonal1, 2));
            double tinggiSegitigaPanjang = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * super.diagonal2, 2));

            // Hitung luas sisi tegak
            double luasSisiPendek  = 2 * (0.5 * super.sisiPendek * tinggiSegitigaPendek);
            double luasSisiPanjang = 2 * (0.5 * super.sisiPanjang * tinggiSegitigaPanjang);
            luasPermukaan = super.luas + luasSisiPendek + luasSisiPanjang;;
            return luasPermukaan;
        }
    }

    @Override
    public String getNama() {
        return "Limas Layang-Layang";
    }

    @Override
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Luas Permukaan: " + hitungLuasPermukaan());
        System.out.println("Volume: " + hitungVolume());
        System.out.println("--------------------------");
    }
}
