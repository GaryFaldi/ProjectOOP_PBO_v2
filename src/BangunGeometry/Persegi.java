package BangunGeometry;

public class Persegi extends BangunDatar {
    protected double sisi;
    public double luas;
    public double keliling;
    public double newS;

    public Persegi(double sisi) {
        this.sisi = sisi;
        this.newS = newS;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public double hitungLuas() {
        luas = sisi * sisi;
        return luas;
    }

    public double hitungLuas(newS) {
        luas = newS * newS;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = 4 * sisi;
        return keliling;
    }

    public double hitungKeliling(newS) {
        keliling = 4 * newS;
        return keliling;
    }

    @Override
    public String getNama() {
        return "Persegi";
    }
}
