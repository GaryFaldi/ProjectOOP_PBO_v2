package BangunGeometry;

public class PrismaBelahKetupat extends BelahKetupat {
    private final double tinggi;
    public double volume;
    public double luasPermukaan;

    public PrismaBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggiPrisma) {
        super(diagonal1, diagonal2, sisi); // pewarisan atribut dari BelahKetupat
        this.tinggi = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return super.luas * tinggi;
    }

    public double hitungLuasPermukaan() {
        return (2 * super.luas) + (super.luas * tinggi);
    }

    @Override
    public String getNama() {
        return "Prisma Belah Ketupat";
    }
}
