package BangunGeometry;

public class Lingkaran implements BangunGeometry {
    protected double jariJari;
    protected double luas;
    protected double keliling;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    public double hitungLuas() {
        return Math.PI * jariJari * jariJari;
    }

    public double hitungKeliling() {
        return 2 * Math.PI * jariJari;
    }

    @Override
    public String getNama() {
        return "Lingkaran";
    }
}
