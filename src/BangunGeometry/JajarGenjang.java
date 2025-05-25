package BangunGeometry;

public class JajarGenjang implements BangunGeometry {
    protected double alas;
    private double tinggi;
    private double sisiMiring;
    protected double luas;
    protected double keliling;

    public JajarGenjang(double alas, double tinggi, double sisiMiring) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiMiring = sisiMiring;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    public double hitungLuas() {
        return alas * tinggi;
    }

    public double hitungKeliling() {
        return 2 * (alas + sisiMiring);
    }

    @Override
    public String getNama() {
        return "JajarGenjang";
    }
}
