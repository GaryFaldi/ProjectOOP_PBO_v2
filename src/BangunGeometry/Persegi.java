package BangunGeometry;

public class Persegi extends BangunDatar {
    protected double sisi;
    public double luas;
    public double keliling;

    public Persegi(double sisi) {
        this.sisi = sisi;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public double hitungLuas() {
        luas = sisi * sisi;
        return luas;
    }

    public double hitungLuas(double newS) {
        luas = newS * newS;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = 4 * sisi;
        return keliling;
    }

    public double hitungKeliling(double newS) {
        keliling = 4 * newS;
        return keliling;
    }

    @Override
    public String getNama() {
        return "Persegi";
    }
}
