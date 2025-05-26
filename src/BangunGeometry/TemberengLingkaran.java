package BangunGeometry;

public class TemberengLingkaran extends Lingkaran {
    private double tinggiTembereng;
    public double luasTemberengLingkaran;
    public double kelilingTemberengLingkaran;

    public TemberengLingkaran(double jariJari, double tinggiTembereng) {
        super(jariJari);
        this.tinggiTembereng = tinggiTembereng;
        this.luasTemberengLingkaran = hitungLuas();
        this.kelilingTemberengLingkaran = hitungKeliling();
    }

    @Override
    public double hitungLuas() {
        double sudut = 2 * Math.acos((jariJari - tinggiTembereng) / jariJari);
        double luasJuring = 0.5 * sudut * jariJari * jariJari;
        double luasSegitiga = 0.5 * jariJari * jariJari * Math.sin(sudut);
        return luasJuring - luasSegitiga;
    }

    @Override
    public double hitungKeliling() {
        double sudut = 2 * Math.acos((jariJari - tinggiTembereng) / jariJari);
        double panjangBusur = sudut * jariJari;
        double panjangTaliBusur = 2 * Math.sqrt(tinggiTembereng * (2 * jariJari - tinggiTembereng));
        return panjangBusur + panjangTaliBusur;
    }

    @Override
    public String getNama(){
        return "TemberengLingkaran";
    }
}
