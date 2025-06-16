package BangunGeometry;

import java.util.Scanner;

public class PrismaPersegi extends Persegi {
    private final double tinggiPrisma;
    public double volume;
    public double luasPermukaan;
    char jawab = 'Y';

    public PrismaPersegi(double sisiAlas, double tinggiPrisma) {
        super(sisiAlas);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    @Override
    public String getNama() {
        return "Prisma Persegi";
    }

    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
        return volume;
    }

    public double hitungVolume(double newS) {
        System.out.println("Apakah Anda akan mengedit value sisi?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukkan nilai sisi baru:");
            newS = inp.nextDouble();
            volume = super.hitungLuas(newS) * tinggiPrisma;
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

    public double hitungLuasPermukaan(double newS) {
        System.out.println("Apakah Anda akan mengedit value sisi?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukkan nilai sisi baru:");
            newS = inp.nextDouble();
            luasPermukaan = 2 * super.hitungLuas(newS) + super.hitungKeliling(newS) * tinggiPrisma;
            return luasPermukaan;
        } else {
            luasPermukaan = 2 * super.luas + super.keliling * tinggiPrisma;
            return luasPermukaan;
        }
    }

    @Override
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Luas Permukaan: " + hitungLuasPermukaan());
        System.out.println("Volume: " + hitungVolume());
        System.out.println("--------------------------");
    }
}
