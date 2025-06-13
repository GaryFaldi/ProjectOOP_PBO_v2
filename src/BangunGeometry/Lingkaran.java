package BangunGeometry;

public class Lingkaran extends BangunDatar{
    protected double jariJari;
    public double luas;
    public double keliling;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Lingkaran";
    }

    @Override
    public double hitungLuas() {
        luas = Math.PI * Math.pow(jariJari, 2);
        return luas;
    }

    public double hitungLuas(double newR) {
        return  Math.PI * Math.pow(newR, 2);
    }

    @Override
    public double hitungKeliling() {
        keliling = Math.PI * jariJari * 2;
        return keliling;
    }

    public double hitungKeliling(double newR) {
        keliling = Math.PI * newR * 2;
        return keliling;
    }
}