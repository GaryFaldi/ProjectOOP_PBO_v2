package BangunGeometry;

public class Persegi implements BangunGeometry {
    protected double sisi;
    protected double luas;
    protected double keliling;

    public Persegi(double sisi) {
        this.sisi = sisi;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    public double hitungLuas() {
        return sisi * sisi;
    }

    public double hitungKeliling() {
        return 4 * sisi;
    }

    @Override
    public String getNama() {
        return "Persegi";
    }
}
