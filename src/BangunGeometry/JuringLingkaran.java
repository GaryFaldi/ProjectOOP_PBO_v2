package BangunGeometry;

public class JuringLingkaran extends Lingkaran {
    private double sudutDerajat;
    public double luasJuringLingkaran;
    public double kelilingJuringLingkaran;

    public JuringLingkaran(double jariJari, double sudutDerajat) {
        super(jariJari);
        this.sudutDerajat = sudutDerajat;
        this.luasJuringLingkaran = hitungLuas();
        this.kelilingJuringLingkaran = hitungKeliling();
    }

    public double hitungLuas() {
        return (sudutDerajat / 360) * luas;
    }

    public double hitungKeliling() {
        double panjangBusur = (sudutDerajat / 360) * keliling;
        return panjangBusur + 2 * jariJari;
    }

    @Override
    public String getNama() {
        return "Juring Lingkaran";
    }
}

