package BangunGeometry;

public class Trapesium extends BangunDatar {
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
        return "Traoesium";
    }
}
