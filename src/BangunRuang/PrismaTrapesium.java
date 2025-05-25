package BangunRuang;

import BangunGeometry.Trapesium;

public class PrismaTrapesium extends Trapesium {
    private final double tinggiPrisma;
    protected double volume;
    protected double luasPermukaan;

    public PrismaTrapesium(double sisiAtas, double sisiBawah, double tinggiTrapesium,
                           double sisiMiring1, double sisiMiring2, double tinggiPrisma) {
        super(sisiAtas, sisiBawah, tinggiTrapesium, sisiMiring1, sisiMiring2);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return hitungLuas() * tinggiPrisma;
    }

    public double hitungLuasPermukaan() {
        return 2 * hitungLuas() + hitungKeliling() * tinggiPrisma;
    }

    public String getNama() {
        return "Prisma Trapesium";
    }
}
