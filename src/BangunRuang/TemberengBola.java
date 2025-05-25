package BangunRuang;

public class TemberengBola extends Bola {
    private final double tinggi;
    protected double volume;
    protected double luasPermukaan;

    public TemberengBola(double jariJari, double tinggi) {
        super(jariJari); // Panggil konstruktor Bola (superclass)
        this.tinggi = tinggi;
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
