package BangunGeometry;

import java.util.Scanner;

public class PrismaJajarGenjang extends JajarGenjang {
    private final double tinggiPrisma;
    public double volume;
    public double luasPermukaan;
    char jawab = 'Y';
    protected double newAlas;
    protected double newTinggiAlas;

    public PrismaJajarGenjang(double alas, double tinggi, double sisiMiring, double tinggiPrisma) {
        super(alas, tinggi, sisiMiring);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Prisma Jajar Genjang";
    }

    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
        return volume;
    }

    public double hitungVolume(double newAlas, double newTinggiAlas) {
        System.out.println("Apakah Anda ingin mengganti nilai alas dan tinggi alas?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.print("Masukkan nilai alas baru: ");
            newAlas = inp.nextDouble();
            System.out.print("Masukkan nilai tinggi alas baru: ");
            newTinggiAlas = inp.nextDouble();
            volume = super.hitungLuas(newAlas, newTinggiAlas) * tinggiPrisma;
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

    public double hitungLuasPermukaan(double newAlas, double newTinggiAlas, double newSisiMiring) {
        System.out.println("Apakah Anda ingin mengganti nilai alas, tinggi alas dan sisi miring?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.print("Masukkan nilai alas baru: ");
            newAlas = inp.nextDouble();
            System.out.print("Masukkan nilai tinggi alas baru: ");
            newTinggiAlas = inp.nextDouble();
            System.out.print("Masukkan nilai sisi miring baru: ");
            newSisiMiring = inp.nextDouble();
            double luasAlasBaru = super.hitungLuas(newAlas, newTinggiAlas);
            double kelilingBaru = super.hitungKeliling(newAlas, newSisiMiring);
            luasPermukaan = (2 * luasAlasBaru) + (kelilingBaru * tinggiPrisma);
            return luasPermukaan;
        } else {
            luasPermukaan = (2 * super.luas) + (super.keliling * tinggiPrisma);
            return luasPermukaan;
        }
    }
}
