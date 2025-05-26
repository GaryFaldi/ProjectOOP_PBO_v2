package BangunGeometry;

import java.util.Scanner;

public class PrismaPersegi extends Persegi {
    private final double tinggiPrisma;
    public double volume;
    public double luasPermukaan;

    public PrismaPersegi(double sisiAlas, double tinggiPrisma) {
        super(sisiAlas);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        luas = super.luas * tinggiPrisma;
        return luas;
    }

    public double hitungVolume(newS) {
        luas = super.hitungLuas(newS) * tinggiPrisma;
        return luas;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * super.luas + super.keliling * tinggiPrisma;
        return luasPermukaan;
    }

    @Override
    public String getNama() {
        return "Prisma Persegi";
    }
}
