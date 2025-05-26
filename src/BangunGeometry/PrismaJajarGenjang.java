package BangunGeometry;

public class PrismaJajarGenjang extends JajarGenjang {
    private final double tinggiPrisma;
    public double volume;
    public double luasPermukaan;

    public PrismaJajarGenjang(double alas, double tinggi, double sisiMiring, double tinggiPrisma) {
        super(alas, tinggi, sisiMiring); // mewarisi dan menghitung luas & keliling
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
        return "Prisma Jajar Genjang";
    }
}
