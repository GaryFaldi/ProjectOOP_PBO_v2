package BangunGeometry;

import java.util.Scanner;

public class Tabung extends Lingkaran {
    private final double tinggi;
    public double volume;
    public double luasPermukaan;
    protected double newR;
    char  jawab  = 'Y';

    public Tabung(double jariJari, double tinggi) {
        super((jariJari));
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume = super.luas * tinggi;
        return volume;
    }

    public double hitungVolume(double newR) {
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            volume = super.hitungLuas(newR) * tinggi;
            return volume;
        }else{
            volume = super.luas * tinggi;
            return volume;
        }
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * Math.PI * super.jariJari * (super.jariJari + tinggi);
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newR) {
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            luasPermukaan = 2 * Math.PI * newR * (newR + tinggi);
            return luasPermukaan;
        }else{
            luasPermukaan = 2 * Math.PI * super.jariJari * (super.jariJari + tinggi);
            return luasPermukaan;
        }
    }

    @Override
    public String getNama() {
        return "Tabung";
    }
}
