package BangunGeometry;

import java.util.Scanner;

public class PrismaLayangLayang extends LayangLayang {
    private final double tinggiPrisma;
    public double volume;
    public double luasPermukaan;
    char jawab = 'Y';
    protected double newD1;
    protected double newD2;
    protected double newPendek;
    protected double newPanjang;

    public PrismaLayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang, double tinggiPrisma) {
        super(diagonal1, diagonal2, sisiPendek, sisiPanjang);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
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
            volume = super.hitungLuas(newD1, newD2) * tinggiPrisma;
            return volume;
        } else {
            volume = super.luas * tinggiPrisma;
            return volume;
        }
    }


    public double hitungLuasPermukaan() {
        luasPermukaan = (2 * super.luas) + (super.keliling * tinggiPrisma);
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
            luasPermukaan = (2 * super.hitungLuas(newD1, newD2)) + (super.hitungKeliling(newPendek, newPanjang) * tinggiPrisma);
            return luasPermukaan;
        } else {
            luasPermukaan = (2 * super.luas) + (super.keliling * tinggiPrisma);
            return luasPermukaan;
        }
    }


    @Override
    public String getNama() {
        return "Prisma Layang-Layang";
    }
}
