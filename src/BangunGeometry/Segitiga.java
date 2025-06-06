package BangunGeometry;

public class Segitiga extends BangunDatar {
    protected double tinggi;
    protected double sisiA;
    protected double sisiB;
    protected double sisiC;
    public double luas;
    public double keliling;

    public Segitiga(double alas, double tinggi, double sisiA, double sisiB, double sisiC) {
        this.tinggi = tinggi;
        this.sisiA = sisiA;
        this.sisiB = sisiB;
        this.sisiC = sisiC;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public double hitungLuas() {
        return 0.5 * sisiA * tinggi;
    }

    @Override
    public double hitungKeliling() {
        return sisiA + sisiB + sisiC;
    }

    @Override
    public String getNama() { return "Segitiga"; }

}
