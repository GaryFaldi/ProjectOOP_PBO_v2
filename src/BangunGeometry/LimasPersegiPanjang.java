package BangunGeometry;

import java.util.Scanner;

public class LimasPersegiPanjang extends PersegiPanjang{
    private final double tinggiLimas;
    public double volume;
    public double luasPermukaan;
    protected double newP;
    protected double newS;
    char jawab = 'Y';

    public LimasPersegiPanjang(double panjang, double lebar, double tinggiLimas) {
        super(panjang, lebar);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    public double hitungVolume(double newP, double newL) {
        System.out.println("Apakah Anda akan mengedit value Panjang dan Lebar?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukkan nilai Panjang baru:");
            newP = inp.nextDouble();
            System.out.println("Masukkan nilai Lebar baru:");
            newL = inp.nextDouble();
            volume = (1.0 / 3.0) * super.hitungLuas(newP, newL) * tinggiLimas;
            return volume;
        } else {
            volume = (1.0 / 3.0) * super.luas * tinggiLimas;
            return volume;
        }
    }

    public double hitungLuasPermukaan() {
        double tinggiSegitigaPendek  = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * super.lebar, 2));
        double tinggiSegitigaPanjang = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * super.panjang, 2));
        // Hitung luas sisi tegak
        double luasSisiPendek  = 2 * (0.5 * super.lebar * tinggiSegitigaPendek);
        double luasSisiPanjang = 2 * (0.5 * super.panjang * tinggiSegitigaPanjang);
        luasPermukaan = super.luas + luasSisiPendek + luasSisiPanjang;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newP, double newL) {
        System.out.println("Apakah Anda akan mengedit value Panjang dan Lebar?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukkan nilai Panjang baru:");
            newP = inp.nextDouble();
            System.out.println("Masukkan nilai Lebar baru:");
            newL = inp.nextDouble();
            double tinggiSegitigaPendek  = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * super.lebar, 2));
            double tinggiSegitigaPanjang = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * super.panjang, 2));
            // Hitung luas sisi tegak
            double luasSisiPendek  = 2 * (0.5 * super.lebar * tinggiSegitigaPendek);
            double luasSisiPanjang = 2 * (0.5 * super.panjang * tinggiSegitigaPanjang);
            luasPermukaan = super.hitungLuas(newP, newL) + luasSisiPendek + luasSisiPanjang;
            return luasPermukaan;
        } else {
            double tinggiSegitigaPendek  = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * super.lebar, 2));
            double tinggiSegitigaPanjang = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * super.panjang, 2));
            // Hitung luas sisi tegak
            double luasSisiPendek  = 2 * (0.5 * super.lebar * tinggiSegitigaPendek);
            double luasSisiPanjang = 2 * (0.5 * super.panjang * tinggiSegitigaPanjang);
            luasPermukaan = super.luas + luasSisiPendek + luasSisiPanjang;
            return luasPermukaan;
        }
    }

    @Override
    public String getNama() {
        return "Limas Persegi Panjang";
    }
}
