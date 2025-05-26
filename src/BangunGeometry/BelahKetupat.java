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
        return 0.5 * diagonal1 * diagonal2;
    }
    
    @Override
    public double hitungKeliling() {
        return 4 * sisi;
    }

    @Override
    public String getNama() {
        return "Belah Ketupat";
    }
}
