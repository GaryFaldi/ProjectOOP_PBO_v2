package BangunGeometry;

import java.util.Scanner;

public class PrismaBelahKetupat extends BelahKetupat {
    private final double tinggi;
    public double volume;
    public double luasPermukaan;
    char  jawab  = 'Y';
    protected double newD1;
    protected double newD2;

    public PrismaBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggiPrisma) {
        super(diagonal1, diagonal2, sisi); // pewarisan atribut dari BelahKetupat
        this.tinggi = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double getTinggi() {
        return tinggi;
    }

    public double hitungVolume() {
        volume = super.luas * tinggi;
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
            volume = hitungLuas(newD1, newD2) * tinggi;
            return volume;
        }else{
            volume = super.luas * tinggi;
            return volume;
        }
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = (2 * super.luas) + (super.luas * tinggi);
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newD1, double newD2) {
        System.out.println("apakah anda akan mengedit value Kedua diagonal??");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai Diagonal1 baru");
            newD1 = inp.nextDouble();
            System.out.println("Masukan nilai Diagonal2 baru");
            newD2 = inp.nextDouble();
            luasPermukaan = (2 * hitungLuas(newD1, newD2)) + (hitungLuas(newD1, newD2) * tinggi);
            return luasPermukaan;
        }else{
            luasPermukaan = (2 * super.luas) + (super.luas * tinggi);
            return luasPermukaan;
        }
    }

    @Override
    public String getNama() {
        return "Prisma Belah Ketupat";
    }

    @Override
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Luas Permukaan: " + hitungLuasPermukaan());
        System.out.println("Volume: " + hitungVolume());
        System.out.println("--------------------------");
    }
}
