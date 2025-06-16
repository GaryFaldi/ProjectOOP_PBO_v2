package BangunGeometry;

import java.util.Scanner;

public class TemberengBola extends Bola {
    private final double tinggi;
    public double volume;
    public double luasPermukaan;
    protected double newR;
    char  jawab  = 'Y';

    public TemberengBola(double jariJari, double tinggi) {
        super(jariJari); // Panggil konstruktor Bola (superclass)
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * Math.PI * tinggi * tinggi * (3 * super.jariJari - tinggi);
        return volume;
    }

    public double hitungVolume(double newR) {
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            volume = (1.0 / 3.0) * Math.PI * tinggi * tinggi * (3 * newR - tinggi);
            return volume;
        }else{
            volume = (1.0 / 3.0) * Math.PI * tinggi * tinggi * (3 * super.jariJari - tinggi);
            return volume;
        }
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * Math.PI * super.jariJari * tinggi + super.luas;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newR) {
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            luasPermukaan = 2 * Math.PI * newR * tinggi + super.hitungLuas(newR);
            return luasPermukaan;
        }else{
            luasPermukaan = 2 * Math.PI * super.jariJari * tinggi + super.luas;
            return luasPermukaan;
        }
    }

    @Override
    public String getNama() {
        return "Tembereng Bola";
    }

    @Override
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Luas Permukaan: " + hitungLuasPermukaan());
        System.out.println("Volume: " + hitungVolume());
        System.out.println("--------------------------");
    }
}
