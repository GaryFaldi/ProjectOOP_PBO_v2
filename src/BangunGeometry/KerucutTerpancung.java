package BangunGeometry;

import java.util.Scanner;

public class KerucutTerpancung extends Kerucut {
    private double jariJariKecil;
    private double tinggi;
    public double volume;
    public double luasPermukaan;
    protected double newR;
    char  jawab  = 'Y';

    public KerucutTerpancung(double jariJari, double jariJariKecil, double tinggi) {
        super(jariJari, tinggi); // hanya untuk pewarisan atribut
        this.jariJariKecil = jariJariKecil;
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * Math.PI * tinggi * (super.jariJari * super.jariJari + super.jariJari * jariJariKecil + jariJariKecil * jariJariKecil);
        return volume;
    }

    public double hitungVolume(double newR) {
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            volume = (1.0 / 3.0) * Math.PI * tinggi * (newR * newR + newR * jariJariKecil + jariJariKecil * jariJariKecil);
            return volume;
        }else{
            volume = (1.0 / 3.0) * Math.PI * tinggi * (super.jariJari * super.jariJari + super.jariJari * jariJariKecil + jariJariKecil * jariJariKecil);
            return volume;
        }
    }

    public double hitungLuasPermukaan() {
        double s = Math.sqrt((super.jariJari - jariJariKecil) * (super.jariJari - jariJariKecil) + tinggi * tinggi); // garis pelukis
        luasPermukaan = Math.PI * (super.jariJari + jariJariKecil) * s + Math.PI * (super.jariJari * super.jariJari + jariJariKecil * jariJariKecil);
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newR) {
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            double s = Math.sqrt((newR - jariJariKecil) * (newR - jariJariKecil) + tinggi * tinggi); // garis pelukis
            luasPermukaan = Math.PI * (newR + jariJariKecil) * s + Math.PI * (newR * newR + jariJariKecil * jariJariKecil);
            return luasPermukaan;
        }else{
            double s = Math.sqrt((super.jariJari - jariJariKecil) * (super.jariJari - jariJariKecil) + tinggi * tinggi); // garis pelukis
            luasPermukaan = Math.PI * (super.jariJari + jariJariKecil) * s + Math.PI * (super.jariJari * super.jariJari + jariJariKecil * jariJariKecil);
            return luasPermukaan;
        }
    }

    @Override
    public String getNama() {
        return "Kerucut Terpancung";
    }

    @Override
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Jari-jari: " + jariJari);
        System.out.println("Jari-jari Kecil: " + jariJariKecil);
        System.out.println("Tinggi: " + tinggi);
        System.out.println("Luas Permukaan: " + hitungLuasPermukaan());
        System.out.println("Volume: " + hitungVolume());
        System.out.println("--------------------------");
    }
}
