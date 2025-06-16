package BangunGeometry;

import java.util.Scanner;

public class TemberengLingkaran extends Lingkaran implements Runnable {
    private double tinggiTembereng;
    public double luasTemberengLingkaran;
    public double kelilingTemberengLingkaran;
    protected double newR;
    char  jawab  = 'Y';

    public TemberengLingkaran(double jariJari, double tinggiTembereng) {
        super(jariJari);
        this.tinggiTembereng = tinggiTembereng;
        this.luasTemberengLingkaran = hitungLuas();
        this.kelilingTemberengLingkaran = hitungKeliling();
    }


    public double getTinggiTembereng() {
        return tinggiTembereng;
    }

    @Override
    public double hitungLuas() {
        double sudut = 2 * Math.acos((jariJari - tinggiTembereng) / jariJari);
        double luasJuring = 0.5 * sudut * jariJari * jariJari;
        double luasSegitiga = 0.5 * jariJari * jariJari * Math.sin(sudut);
        luasTemberengLingkaran = luasJuring - luasSegitiga;
        return luasTemberengLingkaran;
    }

    public double hitungLuas(double newR){
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            double sudut = 2 * Math.acos((newR - tinggiTembereng) / newR);
            double luasJuring = 0.5 * sudut * newR * newR;
            double luasSegitiga = 0.5 * newR * newR * Math.sin(sudut);
            luasTemberengLingkaran = luasJuring - luasSegitiga;
            return luasTemberengLingkaran;
        }else{
            double sudut = 2 * Math.acos((jariJari - tinggiTembereng) / jariJari);
            double luasJuring = 0.5 * sudut * jariJari * jariJari;
            double luasSegitiga = 0.5 * jariJari * jariJari * Math.sin(sudut);
            luasTemberengLingkaran = luasJuring - luasSegitiga;
            return luasTemberengLingkaran;
        }
    }

    @Override
    public double hitungKeliling() {
        double sudut = 2 * Math.acos((jariJari - tinggiTembereng) / jariJari);
        double panjangBusur = sudut * jariJari;
        double panjangTaliBusur = 2 * Math.sqrt(tinggiTembereng * (2 * jariJari - tinggiTembereng));
        kelilingTemberengLingkaran = panjangBusur + panjangTaliBusur;
        return kelilingTemberengLingkaran;
    }

    public double hitungKeliling(double newR){
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            double sudut = 2 * Math.acos((newR - tinggiTembereng) / newR);
            double panjangBusur = sudut * newR;
            double panjangTaliBusur = 2 * Math.sqrt(tinggiTembereng * (2 * newR - tinggiTembereng));
            kelilingTemberengLingkaran = panjangBusur + panjangTaliBusur;
            return kelilingTemberengLingkaran;
        }else{
            double sudut = 2 * Math.acos((jariJari - tinggiTembereng) / jariJari);
            double panjangBusur = sudut * jariJari;
            double panjangTaliBusur = 2 * Math.sqrt(tinggiTembereng * (2 * jariJari - tinggiTembereng));
            kelilingTemberengLingkaran = panjangBusur + panjangTaliBusur;
            return kelilingTemberengLingkaran;
        }
    }

    @Override
    public String getNama(){
        return "TemberengLingkaran";
    }

    @Override
    public void run() {
        System.out.println("Thread " + getNama() + " sedang berjalan...");
        System.out.println("Tinggi Tembereng: " + tinggiTembereng);
        System.out.println("Jari-jari: " + jariJari);
        System.out.println("Luas: " + hitungLuas());
        System.out.println("Keliling: " + hitungKeliling());
        System.out.println("--------------------------");
    }
}
