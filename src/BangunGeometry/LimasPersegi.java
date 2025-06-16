package BangunGeometry;

import java.util.Scanner;

public class LimasPersegi extends Persegi {
    private final double tinggiLimas;
    public double volume;
    public double luasPermukaan;
    char jawab = 'Y';

    public LimasPersegi(double sisi, double tinggiLimas) {
        super(sisi);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    @Override
    public String getNama() {
        return "Limas Persegi";
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    public double hitungVolume(double newS) {
        System.out.println("Apakah Anda akan mengedit nilai sisi?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.print("Masukkan nilai sisi baru: ");
            newS = inp.nextDouble();
            volume = (1.0 / 3.0) * super.hitungLuas(newS) * tinggiLimas;
            return volume;
        } else {
            volume = (1.0 / 3.0) * super.luas * tinggiLimas;
            return volume;
        }
    }

    public double hitungLuasPermukaan() {
        double tinggiSegitiga = Math.sqrt(Math.pow((super.sisi / 2), 2) + Math.pow(tinggiLimas, 2));
        double luasSelimut = 4 * (0.5 * super.sisi * tinggiSegitiga);
        luasPermukaan = super.luas + luasSelimut;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newS) {
        System.out.println("Apakah Anda akan mengedit nilai sisi?");
        if (jawab == 'Y' || jawab == 'y') {
            Scanner inp = new Scanner(System.in);
            System.out.print("Masukkan nilai sisi baru: ");
            newS = inp.nextDouble();
            double tinggiSegitiga = Math.sqrt(Math.pow((newS / 2), 2) + Math.pow(tinggiLimas, 2));
            double luasSelimut = 4 * (0.5 * newS * tinggiSegitiga);
            luasPermukaan = super.hitungLuas(newS) + luasSelimut;
            return luasPermukaan;
        } else {
            double tinggiSegitiga = Math.sqrt(Math.pow((super.sisi / 2), 2) + Math.pow(tinggiLimas, 2));
            double luasSelimut = 4 * (0.5 * super.sisi * tinggiSegitiga);
            luasPermukaan = super.luas + luasSelimut;
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
