package BangunRuang;

import BangunGeometry.Persegi;

public class PrismaPersegi extends Persegi {
    private final double tinggiPrisma;
    protected double volume;
    protected double luasPermukaan;

    public PrismaPersegi(double sisiAlas, double tinggiPrisma) {
        super(sisiAlas);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return luas * tinggiPrisma;
    }

    public double hitungLuasPermukaan() {
        return 2 * luas + keliling * tinggiPrisma;
    }

    public String getNama() {
        return "Prisma Persegi";
    }
}
