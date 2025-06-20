package BangunGeometry;

import java.util.Scanner;

public class Bola extends Lingkaran {
    public double volume;
    public double luasPermukaan;
    protected double newR;
    char  jawab  = 'Y';

    public Bola(double jariJari) {
        super(jariJari);
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Bola";
    }

    public double hitungVolume() {
        volume = (4.0 / 3.0) * super.jariJari * super.luas;
        return volume;
    }

    public double hitungVolume(double newR){
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            volume = (4.0 / 3.0) * Math.PI * super.hitungLuas(newR) * newR;
            return volume;
        }else{
            volume = (4.0 / 3.0) * super.jariJari * super.luas;
            return volume;
        }
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 4 * super.luas;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newR) {
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();

            luasPermukaan = 4 * super.hitungLuas(newR);
            return luasPermukaan;
        }else{
            luasPermukaan = 4 * super.luas;
            return luasPermukaan;
        }
    }

    @Override
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Jari-jari: " + jariJari);
        System.out.println("Luas Permukaan: " + hitungLuasPermukaan());
        System.out.println("Volume: " + hitungVolume());
        System.out.println("--------------------------");
    }
}