package BangunGeometry;

public class PrismaTrapesium extends Trapesium {
    private final double tinggiPrisma;
    public double volume;
    public double luasPermukaan;

    public PrismaTrapesium(double sisiAtas, double sisiBawah, double tinggiTrapesium,
                           double sisiMiring1, double sisiMiring2, double tinggiPrisma) {
        super(sisiAtas, sisiBawah, tinggiTrapesium, sisiMiring1, sisiMiring2);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return super.luas * tinggiPrisma;
    }

    public double hitungLuasPermukaan() {
        return 2 * super.luas + super.keliling * tinggiPrisma;
    }

    @Override
    public String getNama() {
        return "Prisma Trapesium";
    }
}
