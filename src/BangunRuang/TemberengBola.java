package BangunRuang;

public class TemberengBola extends Bola {
    private final double tinggi;
    public double volume;
    public double luasPermukaan;

    public TemberengBola(double jariJari, double tinggi) {
        super(jariJari); // Panggil konstruktor Bola (superclass)
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * Math.PI * tinggi * tinggi * (3 * jariJari - tinggi);
    }

    public double hitungLuasPermukaan() {
        double alas = Math.PI * Math.pow(jariJari, 2);
        return 2 * Math.PI * jariJari * tinggi + alas;
    }

    @Override
    public String getNama() {
        return "Tembereng Bola";
    }
}
