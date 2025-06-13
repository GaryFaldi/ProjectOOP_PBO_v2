package BangunGeometry;

import java.util.Scanner;

public class LimasSegitiga extends Segitiga {
    private final double tinggiLimas; // tinggi dari puncak ke alas segitiga
    public double volume;
    public double luasPermukaan;
    protected double newSisiA;
    protected double newSisiB;
    protected double newSisiC;
    protected double newTinggi;
    char jawab = 'Y';

    public LimasSegitiga(double alasSegitiga, double tinggiSegitiga,
                         double sisiA, double sisiB, double sisiC,
                         double tinggiLimas) {
        super(alasSegitiga, tinggiSegitiga, sisiA, sisiB, sisiC);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    public double hitungVolume(double newSisiA, double newTinggi) {
        System.out.println("Apakah Anda akan mengedit value sisi A dan tinggi segitiga?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukkan nilai sisi A baru:");
            newSisiA = inp.nextDouble();
            System.out.println("Masukkan nilai tinggi segitiga baru:");
            newTinggi = inp.nextDouble();
            volume = (1.0 / 3.0) * super.hitungLuas(newSisiA, newTinggi) * tinggiLimas;
            return volume;
        } else {
            volume = (1.0 / 3.0) * super.luas * tinggiLimas;
            return volume;
        }
    }

    public double hitungLuasPermukaan() {
        // Asumsikan semua sisi tegak berbentuk segitiga dengan tinggi = tinggiLimas
        double luasSisiTegak1 = 0.5 * super.sisiA * tinggiLimas;
        double luasSisiTegak2 = 0.5 * super.sisiB * tinggiLimas;
        double luasSisiTegak3 = 0.5 * super.sisiC * tinggiLimas;
        luasPermukaan = super.luas + luasSisiTegak1 + luasSisiTegak2 + luasSisiTegak3;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newSisiA, double newSisiB, double newSisiC,double newTinggi) {
        System.out.println("Apakah Anda akan mengedit value sisi A, sisi B, sisi C dan tinggi segitiga?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukkan nilai sisi A baru:");
            newSisiA = inp.nextDouble();
            System.out.println("Masukkan nilai sisi B baru:");
            newSisiB = inp.nextDouble();
            System.out.println("Masukkan nilai sisi C baru:");
            newSisiC = inp.nextDouble();
            System.out.println("Masukkan nilai tinggi segitiga baru:");
            newTinggi = inp.nextDouble();
            double luasSisiTegak1 = 0.5 * newSisiA * tinggiLimas;
            double luasSisiTegak2 = 0.5 * newSisiB * tinggiLimas;
            double luasSisiTegak3 = 0.5 * newSisiC * tinggiLimas;
            luasPermukaan = super.hitungLuas(newSisiA, newTinggi) + luasSisiTegak1 + luasSisiTegak2 + luasSisiTegak3;
            return luasPermukaan;
        } else {
            double luasSisiTegak1 = 0.5 * super.sisiA * tinggiLimas;
            double luasSisiTegak2 = 0.5 * super.sisiB * tinggiLimas;
            double luasSisiTegak3 = 0.5 * super.sisiC * tinggiLimas;
            luasPermukaan = super.luas + luasSisiTegak1 + luasSisiTegak2 + luasSisiTegak3;
            return luasPermukaan;
        }
    }

    @Override
    public String getNama() {
        return "Limas Segitiga";
    }
}
