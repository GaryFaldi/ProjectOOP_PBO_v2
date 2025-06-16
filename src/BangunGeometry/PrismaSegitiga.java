package BangunGeometry;

import java.util.Scanner;

public class PrismaSegitiga extends Segitiga {
    private final double tinggiPrisma;
    public double volume;
    public double luasPermukaan;
    protected double newSisiA;
    protected double newSisiB;
    protected double newSisiC;
    protected double newTinggi;
    char jawab = 'Y';

    public PrismaSegitiga(double alasSegitiga, double tinggiSegitiga,
                          double sisiA, double sisiB, double sisiC,
                          double tinggiPrisma) {
        super(alasSegitiga, tinggiSegitiga, sisiA, sisiB, sisiC);
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

    public double hitungVolume(double newSisiA, double newTinggi) {
        System.out.println("Apakah Anda akan mengedit value sisi A dan tinggi segitiga?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukkan nilai sisi A baru:");
            newSisiA = inp.nextDouble();
            System.out.println("Masukkan nilai tinggi segitiga baru:");
            newTinggi = inp.nextDouble();
            volume = super.hitungLuas(newSisiA, newTinggi) * tinggiPrisma;
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

    public double hitungLuasPermukaan(double newSisiA, double newSisiB, double newSisiC, double newTinggi) {
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
            luasPermukaan = 2 * super.hitungLuas(newSisiA, newTinggi) + super.hitungKeliling(newSisiA, newSisiB, newSisiC) * tinggiPrisma;
            return luasPermukaan;
        } else {
            luasPermukaan = 2 * super.luas + super.keliling * tinggiPrisma;
            return luasPermukaan;
        }
    }

    @Override
    public String getNama() {
        return "Prisma Segitiga";
    }

    @Override
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Luas Permukaan: " + hitungLuasPermukaan());
        System.out.println("Volume: " + hitungVolume());
        System.out.println("--------------------------");
    }
}

