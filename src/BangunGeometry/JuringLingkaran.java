package BangunGeometry;

public class JuringLingkaran extends Lingkaran {
    private double sudutDerajat;
    protected double luasJuringLingkaran;
    protected double kelilingJuringLingkaran;

    public JuringLingkaran(double jariJari, double sudutDerajat) {
        super(jariJari);
        this.sudutDerajat = sudutDerajat;
        this.luasJuringLingkaran = hitungLuas();
        this.kelilingJuringLingkaran = hitungKeliling();
    }

    public double hitungLuas() {
        return (sudutDerajat / 360.0) * luas;
    }

    public double hitungKeliling() {
        double panjangBusur = (sudutDerajat / 360.0) * keliling;
        return panjangBusur + 2 * jariJari;
    }

    @Override
    public String getNama() {
        return "Juring Lingkaran";
    }
}

