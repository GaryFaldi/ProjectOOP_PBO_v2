package BangunGeometry;

public class Segitiga extends BangunDatar implements Runnable {
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

    public double getTinggi() {
        return tinggi;
    }

    public double getSisiA() {
        return sisiA;
    }

    public double getSisiB() {
        return sisiB;
    }

    public double getSisiC() {
        return sisiC;
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

    @Override
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Tinggi: " + tinggi);
        System.out.println("sisi A: " + sisiA);
        System.out.println("sisi B: " + sisiB);
        System.out.println("sisi C: " + sisiC);
        System.out.println("Luas: " + hitungLuas());
        System.out.println("Keliling: " + hitungKeliling());
        System.out.println("--------------------------");
    }

}
