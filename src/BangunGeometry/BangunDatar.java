package BangunGeometry;

public abstract class BangunDatar implements BangunGeometry {

    public BangunDatar() {
    }

    @Override
    public String getNama() {
        return "BangunDatar";
    }

    public abstract double hitungLuas();
    public abstract double hitungKeliling();
}