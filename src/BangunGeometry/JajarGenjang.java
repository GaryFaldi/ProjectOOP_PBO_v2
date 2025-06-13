package BangunGeometry;

public class JajarGenjang extends BangunDatar {
    protected double alas;
    protected double tinggi;
    protected double sisiMiring;
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
        luas = alas * tinggi;
        return luas;
    }
    
    public double hitungLuas(double newAlas, double newTinggi) {
        luas = newAlas * newTinggi;
        return luas;
    }
    
    @Override
    public double hitungKeliling() {
        keliling = 2 * (alas + sisiMiring);
        return keliling;
    }
    
    public double hitungKeliling(double newAlas, double newSM) {
        keliling = 2 * (newAlas + newSM);
        return keliling;
    }

    @Override
    public String getNama() {
        return "JajarGenjang";
    }
}
