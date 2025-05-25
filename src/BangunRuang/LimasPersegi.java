package BangunRuang;

import BangunGeometry.Persegi;

public class LimasPersegi extends Persegi {
    private final double tinggiLimas;
    protected double volume;
    protected double luasPermukaan;

    public LimasPersegi(double sisiAlas, double tinggiLimas) {
        super(sisiAlas);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * luas * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        // Hitung luas segitiga pada sisi tegak (pakai pitagoras)
        double tinggiSegitiga = Math.sqrt(Math.pow((sisi / 2), 2) + Math.pow(tinggiLimas, 2));
        double luasSelimut = 4 * (0.5 *  sisi * tinggiSegitiga);

        return luas + luasSelimut;
    }

    @Override
    public String getNama() {
        return "Limas Persegi";
    }
}
