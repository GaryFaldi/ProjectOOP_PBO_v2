package BangunGeometry;

import java.util.Scanner;

public class JuringBola extends Bola {
    private final double sudut;
    public double volume;
    public double luasPermukaan;
    protected double newR;
    char  jawab  = 'Y';

    public JuringBola(double jariJari, double sudut) {
        super(jariJari);
        this.sudut = sudut;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();// Has-a
    }

    @Override
    public double hitungVolume() {
        volume = (sudut / 360.0) * (4.0 / 3.0) * Math.PI * Math.pow(super.jariJari, 3);
        return volume;
    }

    @Override
    public double hitungVolume(double newR) {
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            volume = (sudut / 360.0) * (4.0 / 3.0) * Math.PI * Math.pow(newR, 3);
            return volume;
        }else{
            volume = (sudut / 360.0) * (4.0 / 3.0) * Math.PI * Math.pow(super.jariJari, 3);
            return volume;
        }
    }

    @Override
    public double hitungLuasPermukaan() {
        double A1 = (sudut / 360.0) * 4 * Math.PI * Math.pow(super.jariJari, 2); // permukaan lengkung
        double A2 = Math.PI * Math.pow(super.jariJari, 2); // alas
        luasPermukaan = A1 + A2;
        return luasPermukaan;
    }

    @Override
    public double hitungLuasPermukaan(double newR) {
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            double A1 = (sudut / 360.0) * 4 * Math.PI * Math.pow(newR, 2); // permukaan lengkung
            double A2 = Math.PI * Math.pow(newR, 2); // alas
            luasPermukaan = A1 + A2;
            return luasPermukaan;
        }else{
            double A1 = (sudut / 360.0) * 4 * Math.PI * Math.pow(super.jariJari, 2); // permukaan lengkung
            double A2 = Math.PI * Math.pow(super.jariJari, 2); // alas
            luasPermukaan = A1 + A2;
            return luasPermukaan;
        }
    }

    @Override
    public String getNama() {
        return "Juring Bola";
    }
}
