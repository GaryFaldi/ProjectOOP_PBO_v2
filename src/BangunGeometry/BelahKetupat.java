package BangunGeometry;

public class BelahKetupat implements BangunGeometry {
    private double diagonal1;
    private double diagonal2;
    private double sisi;
    protected double luas;
    protected double keliling;

    public BelahKetupat(double diagonal1, double diagonal2, double sisi) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisi = sisi;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    public double hitungLuas() {
        return 0.5 * diagonal1 * diagonal2;
    }

    public double hitungKeliling() {
        return 4 * sisi;
    }

    @Override
    public String getNama() {
        return "Belah Ketupat";
    }
}
