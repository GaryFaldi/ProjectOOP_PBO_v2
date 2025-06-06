package BangunGeometry;

public class JajarGenjang extends BangunDatar {
    protected double alas;
    private double tinggi;
    private double sisiMiring;
    public double luas;
    public double keliling;

    public JajarGenjang(double alas, double tinggi, double sisiMiring) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiMiring = sisiMiring;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }
    
    @Override
    public double hitungLuas() {
        return alas * tinggi;
    }
    
    @Override
    public double hitungKeliling() {
        return 2 * (alas + sisiMiring);
    }

    @Override
    public String getNama() {
        return "JajarGenjang";
    }
}
