package BangunGeometry;

public class Lingkaran extends BangunDatar implements Runnable {
    protected double jariJari;
    public double luas;
    public double keliling;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    public double getJariJari() {
        return jariJari;
    }

    @Override
    public String getNama() {
        return "Lingkaran";
    }

    @Override
    public double hitungLuas() {
        luas = Math.PI * Math.pow(jariJari, 2);
        return luas;
    }

    public double hitungLuas(double newR) {
        return  Math.PI * Math.pow(newR, 2);
    }

    @Override
    public double hitungKeliling() {
        keliling = Math.PI * jariJari * 2;
        return keliling;
    }

    public double hitungKeliling(double newR) {
        keliling = Math.PI * newR * 2;
        return keliling;
    }

    @Override
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Jari - jari: " + jariJari);
        System.out.println("Luas: " + hitungLuas());
        System.out.println("Keliling: " + hitungKeliling());
        System.out.println("--------------------------");
    }
}