package BangunGeometry;

public class BelahKetupat extends BangunDatar implements Runnable {
    protected double diagonal1;
    protected double diagonal2;
    protected double sisi;
    public double luas;
    public double keliling;

    public BelahKetupat(double diagonal1, double diagonal2, double sisi) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisi = sisi;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    public double getSisi() {
        return sisi;
    }

    public double getDiagonal1() {
        return diagonal1;
    }

    public double getDiagonal2() {
        return diagonal2;
    }

    @Override
    public double hitungLuas() {
        luas = 0.5 * diagonal1 * diagonal2;
        return luas;
    }
    
    public double hitungLuas(double newD1, double newD2) {
        luas = 0.5 * newD1 * newD2;
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
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Sisi: " + sisi);
        System.out.println("Diagonal 1: " + diagonal1);
        System.out.println("Diagonal 2: " + diagonal2);
        System.out.println("Luas: " + hitungLuas());
        System.out.println("Keliling: " + hitungKeliling());
        System.out.println("--------------------------");
    }

    @Override
    public String getNama() {
        return "Belah Ketupat";
    }
}
