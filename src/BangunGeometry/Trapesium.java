package BangunGeometry;

public class Trapesium extends BangunDatar implements Runnable {
    protected double sisiAtas;
    protected double sisiBawah;
    protected double tinggi;
    protected double sisiMiringKiri;
    protected double sisiMiringKanan;
    public double luas;
    public double keliling;

    public Trapesium(double sisiAtas, double sisiBawah, double tinggi, double sisiMiringKiri, double sisiMiringKanan) {
        this.sisiAtas = sisiAtas;
        this.sisiBawah = sisiBawah;
        this.tinggi = tinggi;
        this.sisiMiringKiri = sisiMiringKiri;
        this.sisiMiringKanan = sisiMiringKanan;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    public double getTinggi() {
        return tinggi;
    }

    public double getSisiAtas() {
        return sisiAtas;
    }

    public double getSisiBawah() {
        return sisiBawah;
    }

    public double getSisiMiringKanan() {
        return sisiMiringKanan;
    }

    public double getSisiMiringKiri() {
        return sisiMiringKiri;
    }

    @Override
    public double hitungLuas() {
        luas = 0.5 * (sisiAtas + sisiBawah) * tinggi;
        return luas;
    }

    public double hitungLuas(double newSisiAtas, double newSisiBawah, double newTinggi) {
        luas = 0.5 * (newSisiAtas + newSisiBawah) * newTinggi;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = sisiAtas + sisiBawah + sisiMiringKiri + sisiMiringKanan;
        return keliling;
    }

    public double hitungKeliling(double newSisiAtas, double newSisiBawah, double newSisiMiringKiri, double newSisiMiringKanan) {
        keliling = newSisiAtas + newSisiBawah + newSisiMiringKiri + newSisiMiringKanan;
        return keliling;
    }

    @Override
    public String getNama() {
        return "Trapesium";
    }

    @Override
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("sisi Atas: " + sisiAtas);
        System.out.println("sisi Bawah: " + sisiBawah);
        System.out.println("Tinggi: " + tinggi);
        System.out.println("sisi Miring Kiri: " + sisiMiringKiri);
        System.out.println("sisi Miring Kanan: " + sisiMiringKanan);
        System.out.println("Luas: " + hitungLuas());
        System.out.println("Keliling: " + hitungKeliling());
        System.out.println("--------------------------");
    }
}
