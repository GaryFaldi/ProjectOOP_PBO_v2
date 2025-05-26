package BangunGeometry;

public class JuringLingkaran extends Lingkaran {
    private double sudutDerajat;
    public double luasJuringLingkaran;
    public double kelilingJuringLingkaran;

    public JuringLingkaran(double jariJari, double sudutDerajat) {
        super(jariJari);
        this.sudutDerajat = sudutDerajat;
        this.luasJuringLingkaran = hitungLuasJuringLingkaran();
        this.kelilingJuringLingkaran = hitungKeliling();
    }

    public double hitungLuasJuringLingkaran() {
        return (sudutDerajat / 360) * luas;
    }
    
    @Override
    public double hitungKeliling() {
        double panjangBusur = (sudutDerajat / 360) * keliling;
        return panjangBusur + 2 * jariJari;
    }

    @Override
    public String getNama() {
        return "Juring Lingkaran";
    }
}

