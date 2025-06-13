package BangunGeometry;

public class BelahKetupat extends BangunDatar {
    private double diagonal1;
    private double diagonal2;
    private double sisi;
    public double luas;
    public double keliling;

    public BelahKetupat(double diagonal1, double diagonal2, double sisi) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisi = sisi;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
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
    public String getNama() {
        return "Belah Ketupat";
    }
}
