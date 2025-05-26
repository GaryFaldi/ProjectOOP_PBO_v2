package BangunGeometry;

public class LimasBelahKetupat extends BelahKetupat {
    private double tinggi;
    public double volume;
    public double luasPermukaan;

    public LimasBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggi) {
        super(diagonal1, diagonal2, sisi);
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * super.luas * tinggi;
    }

    public double hitungLuasPermukaan() {
        return super.luas + 4 * (0.5 * (super.keliling / 4) * tinggi);
    }

    @Override
    public String getNama() {
        return "Limas Belah Ketupat";
    }
}
