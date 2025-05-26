package BangunGeometry;

public class Kerucut extends Lingkaran {
    private double tinggi;
    public double volume;
    public double luasPermukaan;

    public Kerucut(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * super.luas * tinggi;
    }

    public double hitungLuasPermukaan() {
        double s = Math.sqrt(super.jariJari * super.jariJari + tinggi * tinggi);
        return Math.PI * super.jariJari * (super.jariJari + s);
    }

    @Override
    public String getNama() {
        return "Kerucut";
    }
}
