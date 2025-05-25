package BangunRuang;

import BangunGeometry.BelahKetupat;

public class LimasBelahKetupat extends BelahKetupat {
    private double tinggi;
    protected double volume;
    protected double luasPermukaan;

    public LimasBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggi) {
        super(diagonal1, diagonal2, sisi);
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * luas * tinggi;
    }

    public double hitungLuasPermukaan() {
        return luas + 4 * (0.5 * (keliling / 4) * tinggi);
    }

    @Override
    public String getNama() {
        return "Limas Belah Ketupat";
    }
}
