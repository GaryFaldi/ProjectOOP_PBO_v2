package BangunRuang;

import BangunGeometry.JajarGenjang;

public class PrismaJajarGenjang extends JajarGenjang {
    private final double tinggiPrisma;
    protected double volume;
    protected double luasPermukaan;

    public PrismaJajarGenjang(double alas, double tinggi, double sisiMiring, double tinggiPrisma) {
        super(alas, tinggi, sisiMiring); // mewarisi dan menghitung luas & keliling
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return luas * tinggiPrisma;
    }

    public double hitungLuasPermukaan() {
        return (2 * luas) + (keliling * tinggiPrisma);
    }

    @Override
    public String getNama() {
        return "Prisma Jajar Genjang";
    }
}
