package BangunGeometry;

public class LayangLayang implements BangunGeometry {
    protected double diagonal1;
    protected double diagonal2;
    protected double sisiPendek;
    protected double sisiPanjang;
    public double luas;
    public double keliling;

    public LayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisiPendek = sisiPendek;
        this.sisiPanjang = sisiPanjang;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    public double hitungLuas() {
        return 0.5 * diagonal1 * diagonal2;
    }

    public double hitungKeliling() {
        return 2 * (sisiPendek + sisiPanjang);
    }

    @Override
    public String getNama() {
        return "Layang Layang";
    }
}
