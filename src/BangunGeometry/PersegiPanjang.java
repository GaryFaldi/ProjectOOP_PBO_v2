package BangunGeometry;

public class PersegiPanjang extends BangunDatar implements Runnable {
    protected double panjang;
    protected double lebar;
    public double luas;
    public double keliling;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    public double getLebar() {
        return lebar;
    }

    public double getPanjang() {
        return panjang;
    }

    @Override
    public double hitungLuas() {
        luas = panjang * lebar;
        return luas;
    }

    public double hitungLuas(double newP, double newL) {
        luas = newP * newL;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = 2 * (panjang + lebar);
        return keliling;
    }

    public double hitungKeliling(double newP, double newL) {
        keliling = 2 * (newP + newL);
        return keliling;
    }

    @Override
    public String getNama() {
        return "PersegiPanjang";
    }

    @Override
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Panjang: " + panjang);
        System.out.println("Lebar: " + lebar);
        System.out.println("Luas: " + hitungLuas());
        System.out.println("Keliling: " + hitungKeliling());
        System.out.println("--------------------------");
    }
}
