package BangunGeometry;

import java.util.Scanner;

public class Kerucut extends Lingkaran {
    private double tinggi;
    public double volume;
    public double luasPermukaan;
    protected double newR;
    char  jawab  = 'Y';

    public Kerucut(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggi;
        return volume;
    }

    public double hitungVolume(double newR) {
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            volume = (1.0 / 3.0) * super.hitungLuas(newR) * tinggi;
            return volume;
        }else{
            volume = (1.0 / 3.0) * super.luas * tinggi;
            return volume;
        }
    }

    public double hitungLuasPermukaan() {
        double s = Math.sqrt(super.jariJari * super.jariJari + tinggi * tinggi);
        luasPermukaan = Math.PI * super.jariJari * (super.jariJari + s);
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newR) {
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            double s = Math.sqrt(newR * newR + tinggi * tinggi);
            luasPermukaan = Math.PI * newR * (newR + s);
            return luasPermukaan;
        }else{
            double s = Math.sqrt(super.jariJari * super.jariJari + tinggi * tinggi);
            luasPermukaan = Math.PI * super.jariJari * (super.jariJari + s);
            return luasPermukaan;
        }
    }

    @Override
    public String getNama() {
        return "Kerucut";
    }
}
