package BangunRuang;

import BangunGeometry.Trapesium;

public class LimasTrapesium extends Trapesium {
    private final double tinggiLimas;
    public double volume;
    public double luasPermukaan;

    public LimasTrapesium(double sisiAtas, double sisiBawah, double tinggiTrapesium,
                          double sisiMiringKiri, double sisiMiringKanan, double tinggiLimas) {
        super(sisiAtas, sisiBawah, tinggiTrapesium, sisiMiringKiri, sisiMiringKanan);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * luas * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        // Hitung tinggi segitiga tegak menggunakan Pythagoras
        double setengahSisiAtas = sisiAtas / 2.0;
        double setengahSisiBawah = sisiBawah / 2.0;
        double setengahSisiKiri = sisiMiringKiri / 2.0;
        double setengahSisiKanan = sisiMiringKanan / 2.0;

        // Misalnya tinggi limas adalah panjang garis pelukis
        double tinggiSegitiga1 = Math.sqrt(tinggiLimas * tinggiLimas - setengahSisiAtas * setengahSisiAtas);
        double tinggiSegitiga2 = Math.sqrt(tinggiLimas * tinggiLimas - setengahSisiBawah * setengahSisiBawah);
        double tinggiSegitiga3 = Math.sqrt(tinggiLimas * tinggiLimas - setengahSisiKiri * setengahSisiKiri);
        double tinggiSegitiga4 = Math.sqrt(tinggiLimas * tinggiLimas - setengahSisiKanan * setengahSisiKanan);

        double luasTegak1 = 0.5 * sisiAtas * tinggiSegitiga1;
        double luasTegak2 = 0.5 * sisiBawah * tinggiSegitiga2;
        double luasTegak3 = 0.5 * sisiMiringKiri * tinggiSegitiga3;
        double luasTegak4 = 0.5 * sisiMiringKanan * tinggiSegitiga4;

        return luas + luasTegak1 + luasTegak2 + luasTegak3 + luasTegak4;
    }


    public String getNama() {
        return "Limas Trapesium";
    }
}

