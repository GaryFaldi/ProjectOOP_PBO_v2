package BangunRuang;

import BangunGeometry.PersegiPanjang;

public class PrismaPersegiPanjang extends PersegiPanjang {
    private final double tinggiPrisma;
    public double volume;
    public double luasPermukaan;

    public PrismaPersegiPanjang(double panjang, double lebar, double tinggiPrisma) {
        super(panjang, lebar);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return luas * tinggiPrisma;
    }

    public double hitungLuasPermukaan() {
        // Rumus: 2 * luas alas + keliling alas * tinggi
        double luasAlas = panjang * lebar;
        double kelilingAlas = 2 * (panjang + lebar);
        return 2 * luasAlas + kelilingAlas * tinggiPrisma;
    }
}
