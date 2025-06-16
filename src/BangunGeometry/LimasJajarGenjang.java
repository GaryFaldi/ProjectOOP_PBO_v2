package BangunGeometry;

import java.util.Scanner;

public class LimasJajarGenjang extends JajarGenjang {
    private final double tinggi; // tinggi dari alas ke puncak limas
    public double volume;
    public double luasPermukaan;
    char jawab = 'Y';
    protected double newTinggiAlas;
    protected double newAlas;

    public LimasJajarGenjang(double alas, double tinggiAlas, double sisiMiring, double tinggi) {
        super(alas, tinggiAlas, sisiMiring);
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public double getTinggi() {
        return tinggi;
    }

    @Override
    public String getNama() {
        return "Limas Jajar Genjang";
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggi;
        return volume;
    }

    public double hitungVolume(double newAlas, double newTinggiAlas) {
        System.out.println("Apakah Anda akan mengedit nilai alas Jajargenjang dan tinggi alas jajargenjang?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.print("Masukkan nilai alas baru: ");
            newAlas = inp.nextDouble();
            System.out.print("Masukkan nilai tinggi alas baru: ");
            newTinggiAlas = inp.nextDouble();
            volume = (1.0 / 3.0) * super.hitungLuas(newAlas, newTinggiAlas) * tinggi;
            return volume;
        } else {
            volume = (1.0 / 3.0) * super.luas * tinggi;
            return volume;
        }
    }

    public double hitungLuasPermukaan() {
        double luasSisiTegak = 4 * (0.5 * tinggi * super.alas); // Asumsi sisi tegak segitiga sama besar
        luasPermukaan = super.luas + luasSisiTegak;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newAlas) {
        System.out.println("Apakah Anda akan mengedit nilai alas?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.print("Masukkan nilai alas baru: ");
            newAlas = inp.nextDouble();
            double luasSisiTegak = 4 * (0.5 * tinggi * newAlas);
            luasPermukaan = super.hitungLuas(newAlas, tinggi) + luasSisiTegak;
            return luasPermukaan;
        } else {
            double luasSisiTegak = 4 * (0.5 * tinggi * super.alas);
            luasPermukaan = super.luas + luasSisiTegak;
            return luasPermukaan;
        }
    }

    @Override
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Luas Permukaan: " + hitungLuasPermukaan());
        System.out.println("Volume: " + hitungVolume());
        System.out.println("--------------------------");
    }
}
