package BangunGeometry;

public class PrismaLayangLayang extends LayangLayang {
    private final double tinggiPrisma;
    public double volume;
    public double luasPermukaan;

    public PrismaLayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang, double tinggiPrisma) {
        super(diagonal1, diagonal2, sisiPendek, sisiPanjang);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return super.luas * tinggiPrisma;
    }

    public double hitungLuasPermukaan() {
        return (2 * super.luas) + (super.keliling * tinggiPrisma);
    }

    @Override
    public String getNama() {
        return "Prisma Layang-Layang";
    }
}
