package BangunGeometry;

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
        return super.luas * tinggiPrisma;
    }

    public double hitungLuasPermukaan() {
        // Rumus: 2 * luas alas + keliling alas * tinggi
        double luasAlas = super.panjang * super.lebar;
        double kelilingAlas = 2 * (super.panjang + super.lebar);
        return 2 * luasAlas + kelilingAlas * tinggiPrisma;
    }
    @Override
    public String getNama() {
        return "Prisma Persegi Panjang";
    }
}
