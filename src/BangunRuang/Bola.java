package BangunRuang;

import BangunGeometry.Lingkaran;

public class Bola extends Lingkaran {
    public double volume;
    public double luasPermukaan;

    public Bola(double jariJariBola) {
        super(jariJariBola);
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
