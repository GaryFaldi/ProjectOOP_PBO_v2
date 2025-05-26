package BangunGeometry;

public class PrismaSegitiga extends Segitiga {
    private final double tinggiPrisma;
    public double volume;
    public double luasPermukaan;

    public PrismaSegitiga(double alasSegitiga, double tinggiSegitiga,
                          double sisiA, double sisiB, double sisiC,
                          double tinggiPrisma) {
        super(alasSegitiga, tinggiSegitiga, sisiA, sisiB, sisiC);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return super.luas * tinggiPrisma;
    }

    public double hitungLuasPermukaan() {
        // Luas permukaan = 2 * luas alas + keliling alas * tinggi
        return 2 * super.luas + super.keliling * tinggiPrisma;
    }

    @Override
    public String getNama() {
        return "Prisma Segitiga";
    }
}

