package BangunGeometry;

import java.util.Scanner;

public class LimasBelahKetupat extends BelahKetupat {
    private double tinggi;
    public double volume;
    public double luasPermukaan;
    char  jawab  = 'Y';
    protected double newD1;
    protected double newD2;
    protected double newS;

    public LimasBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggi) {
        super(diagonal1, diagonal2, sisi);
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggi;
        return volume;
    }

    public double hitungVolume(double newD1, double newD2) {
        System.out.println("apakah anda akan mengedit value Kedua diagonal??");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai Diagonal1 baru");
            newD1 = inp.nextDouble();
            System.out.println("Masukan nilai Diagonal2 baru");
            newD2 = inp.nextDouble();
            volume = (1.0 / 3.0) * super.hitungLuas(newD1, newD2) * tinggi;
            return volume;
        }else{
            volume = (1.0 / 3.0) * super.luas * tinggi;
            return volume;
        }
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = super.luas + 4 * (0.5 * (super.keliling / 4) * tinggi);
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newD1, double newD2, double newS) {
        System.out.println("apakah anda akan mengedit value sisi dan Kedua diagonal??");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai Diagonal1 baru");
            newD1 = inp.nextDouble();
            System.out.println("Masukan nilai Diagonal2 baru");
            newD2 = inp.nextDouble();
            System.out.println("Masukan nilai Sisi baru");
            newD2 = inp.nextDouble();
            luasPermukaan = super.hitungLuas(newD1, newD2) + 4 * (0.5 * (super.hitungKeliling(newS) / 4) * tinggi);
            return luasPermukaan;
        }else{
            luasPermukaan = super.luas + 4 * (0.5 * (super.keliling / 4) * tinggi);
            return luasPermukaan;
        }
    }

    @Override
    public String getNama() {
        return "Limas Belah Ketupat";
    }
}
