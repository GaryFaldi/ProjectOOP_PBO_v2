package BangunGeometry;

public class JajarGenjang extends BangunDatar implements Runnable {
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

    public double getAlas() {
        return alas;
    }

    public double getTinggi() {
        return tinggi;
    }

    public double getSisiMiring() {
        return sisiMiring;
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
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Alas: " + alas);
        System.out.println("Tinggi: " + tinggi);
        System.out.println("Sisi Miring: " + sisiMiring);
        System.out.println("Luas: " + hitungLuas());
        System.out.println("Keliling: " + hitungKeliling());
        System.out.println("--------------------------");
    }

    @Override
    public String getNama() {
        return "JajarGenjang";
    }
}
