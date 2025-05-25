package BangunRuang;

import BangunGeometry.Lingkaran;

public class Kerucut extends Lingkaran {
    private double tinggi;
    protected double volume;
    protected double luasPermukaan;

    public Kerucut(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * luas * tinggi;
    }

    public double hitungLuasPermukaan() {
        double s = Math.sqrt(jariJari * jariJari + tinggi * tinggi);
        return Math.PI * jariJari * (jariJari + s);
    }

    @Override
    public String getNama() {
        return "Kerucut";
    }
}
