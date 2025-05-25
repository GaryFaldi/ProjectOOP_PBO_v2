package BangunRuang;

import BangunGeometry.Lingkaran;

public class Tabung extends Lingkaran {
    private final double tinggi;
    protected double volume;
    protected double luasPermukaan;

    public Tabung(double jariJari, double tinggi) {
        super((jariJari));
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return Math.PI * jariJari * jariJari * tinggi;
    }

    public double hitungLuasPermukaan() {
        return 2 * Math.PI * jariJari * (jariJari + tinggi);
    }

    public String getNama() {
        return "Tabung";
    }
}
