package BangunGeometry;

import java.util.Scanner;

public class PrismaTrapesium extends Trapesium {
    private final double tinggiPrisma;
    public double volume;
    public double luasPermukaan;
    protected double newSisiAtas;
    protected double newSisiBawah;
    protected double newSisiMiringKiri;
    protected double newSisiMiringKanan;
    protected double newTinggi;
    char jawab = 'Y';

    public PrismaTrapesium(double sisiAtas, double sisiBawah, double tinggiTrapesium,
                           double sisiMiring1, double sisiMiring2, double tinggiPrisma) {
        super(sisiAtas, sisiBawah, tinggiTrapesium, sisiMiring1, sisiMiring2);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
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
            volume = super.hitungLuas(newSisiAtas, newSisiBawah, newTinggi) * tinggiPrisma;
            return volume;
        } else {
            volume = super.luas * tinggiPrisma;
            return volume;
        }
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * super.luas + super.keliling * tinggiPrisma;
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
            luasPermukaan = 2 * super.hitungLuas(newSisiAtas, newSisiBawah, newTinggi) + super.hitungKeliling(newSisiAtas, newSisiBawah, newSisiMiringKiri, newSisiMiringKanan) * tinggiPrisma;
            return luasPermukaan;
        } else {
            luasPermukaan = 2 * super.luas + super.keliling * tinggiPrisma;
            return luasPermukaan;
        }
    }

    @Override
    public String getNama() {
        return "Prisma Trapesium";
    }

    @Override
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Luas Permukaan: " + hitungLuasPermukaan());
        System.out.println("Volume: " + hitungVolume());
        System.out.println("--------------------------");
    }
}
