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
        luas = 0.5 * sisiA * tinggi;
        return luas;
    }

    public double hitungLuas(double newSisiA, double newTinggi) {
        luas = 0.5 * newSisiA * newTinggi;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = sisiA + sisiB + sisiC;
        return keliling;
    }

    public double hitungKeliling(double newSisiA, double newSisiB, double newSisiC) {
        keliling = newSisiA + newSisiB + newSisiC;
        return keliling;
    }

    @Override
    public String getNama() { return "Segitiga"; }

}
