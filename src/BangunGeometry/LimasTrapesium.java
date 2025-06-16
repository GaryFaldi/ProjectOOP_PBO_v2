package BangunGeometry;

import java.util.Scanner;

public class LimasTrapesium extends Trapesium {
    private final double tinggiLimas;
    public double volume;
    public double luasPermukaan;
    protected double newSisiAtas;
    protected double newSisiBawah;
    protected double newSisiMiringKiri;
    protected double newSisiMiringKanan;
    protected double newTinggi;
    char jawab = 'Y';

    public LimasTrapesium(double sisiAtas, double sisiBawah, double tinggiTrapesium,
                          double sisiMiringKiri, double sisiMiringKanan, double tinggiLimas) {
        super(sisiAtas, sisiBawah, tinggiTrapesium, sisiMiringKiri, sisiMiringKanan);
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

    public double hitungVolume(double newSisiAtas, double newSisiBawah, double newTinggi) {
        System.out.println("Apakah Anda akan mengedit value sisi atas, sisi bawah dan tinggi trapesium?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukkan nilai sisi atas baru:");
            newSisiAtas = inp.nextDouble();
            System.out.println("Masukkan nilai sisi bawah baru:");
            newSisiBawah = inp.nextDouble();
            System.out.println("Masukkan nilai tinggi trapesium baru:");
            newTinggi = inp.nextDouble();
            volume = (1.0 / 3.0) * super.hitungLuas(newSisiAtas, newSisiBawah, newTinggi) * tinggiLimas;
            return volume;
        } else {
            volume = (1.0 / 3.0) * super.luas * tinggiLimas;
            return volume;
        }
    }

    public double hitungLuasPermukaan() {
        // Hitung tinggi segitiga tegak menggunakan Pythagoras
        double setengahSisiAtas = super.sisiAtas / 2.0;
        double setengahSisiBawah = super.sisiBawah / 2.0;
        double setengahSisiKiri = super.sisiMiringKiri / 2.0;
        double setengahSisiKanan = super.sisiMiringKanan / 2.0;

        // Misalnya tinggi limas adalah panjang garis pelukis
        double tinggiSegitiga1 = Math.sqrt(tinggiLimas * tinggiLimas - setengahSisiAtas * setengahSisiAtas);
        double tinggiSegitiga2 = Math.sqrt(tinggiLimas * tinggiLimas - setengahSisiBawah * setengahSisiBawah);
        double tinggiSegitiga3 = Math.sqrt(tinggiLimas * tinggiLimas - setengahSisiKiri * setengahSisiKiri);
        double tinggiSegitiga4 = Math.sqrt(tinggiLimas * tinggiLimas - setengahSisiKanan * setengahSisiKanan);

        double luasTegak1 = 0.5 * super.sisiAtas * tinggiSegitiga1;
        double luasTegak2 = 0.5 * super.sisiBawah * tinggiSegitiga2;
        double luasTegak3 = 0.5 * super.sisiMiringKiri * tinggiSegitiga3;
        double luasTegak4 = 0.5 * super.sisiMiringKanan * tinggiSegitiga4;
        luasPermukaan = super.luas + luasTegak1 + luasTegak2 + luasTegak3 + luasTegak4;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newSisiAtas, double newSisiBawah, double newSisiMiringKiri, double newSisiMiringKanan, double newTinggi) {
        System.out.println("Apakah Anda akan mengedit value sisi atas, sisi bawah, sisi miring kiri, sisi miring kanan dan tinggi trapesium?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukkan nilai sisi atas baru:");
            newSisiAtas = inp.nextDouble();
            System.out.println("Masukkan nilai sisi bawah baru:");
            newSisiBawah = inp.nextDouble();
            System.out.println("Masukkan nilai sisi miring kiri baru:");
            newSisiMiringKiri = inp.nextDouble();
            System.out.println("Masukkan nilai sisi miring kanan baru:");
            newSisiMiringKanan = inp.nextDouble();
            System.out.println("Masukkan nilai tinggi trapesium baru:");
            newTinggi = inp.nextDouble();

            // Hitung tinggi segitiga tegak menggunakan Pythagoras
            double setengahSisiAtas = newSisiAtas / 2.0;
            double setengahSisiBawah = newSisiBawah / 2.0;
            double setengahSisiKiri = newSisiMiringKiri / 2.0;
            double setengahSisiKanan = newSisiMiringKanan / 2.0;

            // Misalnya tinggi limas adalah panjang garis pelukis
            double tinggiSegitiga1 = Math.sqrt(tinggiLimas * tinggiLimas - setengahSisiAtas * setengahSisiAtas);
            double tinggiSegitiga2 = Math.sqrt(tinggiLimas * tinggiLimas - setengahSisiBawah * setengahSisiBawah);
            double tinggiSegitiga3 = Math.sqrt(tinggiLimas * tinggiLimas - setengahSisiKiri * setengahSisiKiri);
            double tinggiSegitiga4 = Math.sqrt(tinggiLimas * tinggiLimas - setengahSisiKanan * setengahSisiKanan);

            double luasTegak1 = 0.5 * newSisiAtas * tinggiSegitiga1;
            double luasTegak2 = 0.5 * newSisiBawah * tinggiSegitiga2;
            double luasTegak3 = 0.5 * newSisiMiringKiri * tinggiSegitiga3;
            double luasTegak4 = 0.5 * newSisiMiringKanan * tinggiSegitiga4;
            luasPermukaan = super.hitungLuas(newSisiAtas, newSisiBawah, newTinggi) + luasTegak1 + luasTegak2 + luasTegak3 + luasTegak4;
            return luasPermukaan;
        } else {
            // Hitung tinggi segitiga tegak menggunakan Pythagoras
            double setengahSisiAtas = super.sisiAtas / 2.0;
            double setengahSisiBawah = super.sisiBawah / 2.0;
            double setengahSisiKiri = super.sisiMiringKiri / 2.0;
            double setengahSisiKanan = super.sisiMiringKanan / 2.0;

            // Misalnya tinggi limas adalah panjang garis pelukis
            double tinggiSegitiga1 = Math.sqrt(tinggiLimas * tinggiLimas - setengahSisiAtas * setengahSisiAtas);
            double tinggiSegitiga2 = Math.sqrt(tinggiLimas * tinggiLimas - setengahSisiBawah * setengahSisiBawah);
            double tinggiSegitiga3 = Math.sqrt(tinggiLimas * tinggiLimas - setengahSisiKiri * setengahSisiKiri);
            double tinggiSegitiga4 = Math.sqrt(tinggiLimas * tinggiLimas - setengahSisiKanan * setengahSisiKanan);

            double luasTegak1 = 0.5 * super.sisiAtas * tinggiSegitiga1;
            double luasTegak2 = 0.5 * super.sisiBawah * tinggiSegitiga2;
            double luasTegak3 = 0.5 * super.sisiMiringKiri * tinggiSegitiga3;
            double luasTegak4 = 0.5 * super.sisiMiringKanan * tinggiSegitiga4;
            luasPermukaan = super.luas + luasTegak1 + luasTegak2 + luasTegak3 + luasTegak4;
            return luasPermukaan;
        }
    }

    @Override
    public String getNama() {
        return "Limas Trapesium";
    }

    @Override
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Luas Permukaan: " + hitungLuasPermukaan());
        System.out.println("Volume: " + hitungVolume());
        System.out.println("--------------------------");
    }
}