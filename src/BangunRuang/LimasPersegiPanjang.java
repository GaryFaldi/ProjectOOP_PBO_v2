package BangunRuang;

import BangunGeometry.PersegiPanjang;

public class LimasPersegiPanjang extends PersegiPanjang{
    private final double tinggiLimas;
    protected double volume;
    protected double luasPermukaan;

    public LimasPersegiPanjang(double panjang, double lebar, double tinggiLimas) {
        super(panjang, lebar);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        // Volume = (1/3) * luas alas * tinggi limas
        return (1.0 / 3.0) * luas * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        double tinggiSegitigaPendek  = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * lebar, 2));
        double tinggiSegitigaPanjang = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * panjang, 2));

        // Hitung luas sisi tegak
        double luasSisiPendek  = 2 * (0.5 * lebar * tinggiSegitigaPendek);
        double luasSisiPanjang = 2 * (0.5 * panjang * tinggiSegitigaPanjang);

        return luas + luasSisiPendek + luasSisiPanjang;
    }

    public String getNama() {
        return "Limas Persegi Panjang";
    }
}
