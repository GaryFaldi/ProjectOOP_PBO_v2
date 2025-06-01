package BangunRuang;

import BangunGeometry.Lingkaran;

public class JuringBola extends Bola {
    private final double sudut;
    public double volume;
    public double luasPermukaan;

    public JuringBola(double jariJari, double sudut) {
        super(jariJari);
        this.sudut = sudut;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();// Has-a
    }

    public double hitungVolume() {
        return (sudut / 360.0) * (4.0 / 3.0) * Math.PI * Math.pow(jariJari, 3);
    }

    public double hitungLuasPermukaan() {
        double A1 = (sudut / 360.0) * 4 * Math.PI * Math.pow(jariJari, 2); // permukaan lengkung
        double A2 = Math.PI * Math.pow(jariJari, 2); // alas
        return A1 + A2;
    }

    @Override
    public String getNama() {
        return "Juring Bola";
    }
}
