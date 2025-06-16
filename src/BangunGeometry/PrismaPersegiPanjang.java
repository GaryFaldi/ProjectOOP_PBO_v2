package BangunGeometry;

import java.util.Scanner;

public class PrismaPersegiPanjang extends PersegiPanjang {
    private final double tinggiPrisma;
    public double volume;
    public double luasPermukaan;
    protected double newP;
    protected double newS;
    char jawab = 'Y';

    public PrismaPersegiPanjang(double panjang, double lebar, double tinggiPrisma) {
        super(panjang, lebar);
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

    public double hitungVolume(double newP, double newL) {
        System.out.println("Apakah Anda akan mengedit value Panjang dan Lebar?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukkan nilai Panjang baru:");
            newP = inp.nextDouble();
            System.out.println("Masukkan nilai Lebar baru:");
            newL = inp.nextDouble();
            volume = super.hitungLuas(newP, newL) * tinggiPrisma;
            return volume;
        } else {
            volume = super.luas * tinggiPrisma;
            return volume;
        }
    }

    public double hitungLuasPermukaan() {
       double luasAlas = super.panjang * super.lebar;
        double kelilingAlas = 2 * (super.panjang + super.lebar);
        luasPermukaan = 2 * luasAlas + kelilingAlas * tinggiPrisma;
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
            double luasAlas = newP * newS;
            double kelilingAlas = 2 * (newP + newS);
            luasPermukaan = 2 * luasAlas + kelilingAlas * tinggiPrisma;
            return luasPermukaan;
        } else {
            // Rumus: 2 * luas alas + keliling alas * tinggi
            double luasAlas = super.panjang * super.lebar;
            double kelilingAlas = 2 * (super.panjang + super.lebar);
            luasPermukaan = 2 * luasAlas + kelilingAlas * tinggiPrisma;
            return luasPermukaan;
        }
    }

    @Override
    public String getNama() {
        return "Prisma Persegi Panjang";
    }

    @Override
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Luas Permukaan: " + hitungLuasPermukaan());
        System.out.println("Volume: " + hitungVolume());
        System.out.println("--------------------------");
    }
}
