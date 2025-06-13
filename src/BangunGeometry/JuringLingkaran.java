package BangunGeometry;

import java.util.Scanner;

public class JuringLingkaran extends Lingkaran {
    private double sudutDerajat;
    public double luasJuringLingkaran;
    public double kelilingJuringLingkaran;
    protected double newR;
    char  jawab  = 'Y';

    public JuringLingkaran(double jariJari, double sudutDerajat) {
        super(jariJari);
        this.sudutDerajat = sudutDerajat;
        this.luasJuringLingkaran = hitungLuas();
        this.kelilingJuringLingkaran = hitungKeliling();
    }

    @Override
    public double hitungLuas() {
        luasJuringLingkaran = (sudutDerajat / 360) * luas;
        return luasJuringLingkaran;
    }

    public double hitungLuas(double newR){
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            luasJuringLingkaran = (sudutDerajat / 360) * super.hitungLuas(newR) * newR;
            return luasJuringLingkaran;
        }else{
            luasJuringLingkaran = (sudutDerajat / 360) * luas;
            return luasJuringLingkaran;
        }
    }
    
    @Override
    public double hitungKeliling() {
        double panjangBusur = (sudutDerajat / 360) * keliling;
        kelilingJuringLingkaran = panjangBusur + 2 * jariJari;
        return kelilingJuringLingkaran;
    }

    public double hitungKeliling(double newR) {
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            double panjangBusur = (sudutDerajat / 360) * super.hitungKeliling(newR);
            kelilingJuringLingkaran = panjangBusur + 2 * newR;
            return kelilingJuringLingkaran;
        }else{
            double panjangBusur = (sudutDerajat / 360) * keliling;
            kelilingJuringLingkaran = panjangBusur + 2 * jariJari;
            return kelilingJuringLingkaran;
        }
    }

    @Override
    public String getNama() {
        return "Juring Lingkaran";
    }
}

