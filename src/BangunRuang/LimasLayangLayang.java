package BangunRuang;

import BangunGeometry.LayangLayang;

public class LimasLayangLayang extends LayangLayang {
    private final double tinggiLimas;
    public double volume;
    public double luasPermukaan;

    public LimasLayangLayang(double diagonal1, double diagonal2,
                             double sisiPendek, double sisiPanjang,
                             double tinggiLimas) {
        super(diagonal1, diagonal2, sisiPendek, sisiPanjang);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * luas * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        // Gunakan Pythagoras untuk menghitung tinggi segitiga sisi tegak
        double tinggiSegitigaPendek  = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * diagonal1, 2));
        double tinggiSegitigaPanjang = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * diagonal2, 2));

        // Hitung luas sisi tegak
        double luasSisiPendek  = 2 * (0.5 * sisiPendek * tinggiSegitigaPendek);
        double luasSisiPanjang = 2 * (0.5 * sisiPanjang * tinggiSegitigaPanjang);

        return luas + luasSisiPendek + luasSisiPanjang;
    }

    @Override
    public String getNama() {
        return "Limas Layang-Layang";
    }
}
