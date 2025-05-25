package BangunRuang;

import BangunGeometry.Lingkaran;

public class Bola extends Lingkaran {
    protected double volume;
    protected double luasPermukaan;

    public Bola(double jariJari) {
        super(jariJari);
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return (4.0 / 3.0) * luas * jariJari;
    }

    public double hitungLuasPermukaan() {
        return 4 * luas;
    }

    @Override
    public String getNama() {
        return "Bola";
    }
}
