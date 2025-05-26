package BangunGeometry;

public class Tabung extends Lingkaran {
    private final double tinggi;
    public double volume;
    public double luasPermukaan;

    public Tabung(double jariJari, double tinggi) {
        super((jariJari));
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return Math.PI * super.jariJari * super.jariJari * tinggi;
    }

    public double hitungLuasPermukaan() {
        return 2 * Math.PI * super.jariJari * (super.jariJari + tinggi);
    }

    @Override
    public String getNama() {
        return "Tabung";
    }
}
