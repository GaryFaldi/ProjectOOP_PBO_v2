package BangunRuang;

import BangunGeometry.JajarGenjang;

public class LimasJajarGenjang extends JajarGenjang {
    private final double tinggi; // tinggi dari alas ke puncak
    protected double volume;
    protected double luasPermukaan;

    public LimasJajarGenjang(double alas, double tinggiAlas, double sisiMiring, double tinggi) {
        super(alas, tinggiAlas, sisiMiring); // menghitung luas dan keliling di sini
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * luas * tinggi;
    }

    public double hitungLuasPermukaan() {
        double luasSisiTegak = 4 * (0.5 * tinggi * alas);
        return luas + luasSisiTegak;
    }

    @Override
    public String getNama() {
        return "Limas Jajar Genjang";
    }
}
