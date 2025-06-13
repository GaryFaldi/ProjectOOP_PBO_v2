package BangunGeometry;

public class LayangLayang extends BangunDatar {
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
        keliling = 2 * (sisiPendek + sisiPanjang);
        return keliling;
    }

    public double hitungKeliling(double newPendek, double newPanjang) {
        keliling = 2 * (newPendek + newPanjang);
        return keliling;
    }

    @Override
    public String getNama() {
        return "Layang Layang";
    }
}
