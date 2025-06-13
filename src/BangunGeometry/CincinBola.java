package BangunGeometry;

import java.util.Scanner;

public class CincinBola extends Bola {
    private final double jariJariDalam;
    public double volume;
    public double luasPermukaan;
    protected double newR;
    char  jawab  = 'Y';

    public CincinBola(double jariJari, double jariJariDalam) {
        super(jariJari);
        this.jariJariDalam = jariJariDalam;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public double hitungVolume() {
        // Volume cincin bola = volume bola luar - volume bola dalam
        double volumeLuar = (4.0 / 3.0) * super.luas * super.jariJari;
        double volumeDalam = (4.0 / 3.0) * Math.PI * Math.pow(jariJariDalam, 3);
        volume = volumeLuar - volumeDalam;
        return volume;
    }

    @Override
    public double hitungVolume(double newR) {
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            double volumeLuar = (4.0 / 3.0) * super.hitungLuas(newR) * newR;
            double volumeDalam = (4.0 / 3.0) * Math.PI * Math.pow(jariJariDalam, 3);
            volume = volumeLuar - volumeDalam;
            return volume;
        }else{
            double volumeLuar = (4.0 / 3.0) * super.luas * super.jariJari;
            double volumeDalam = (4.0 / 3.0) * Math.PI * Math.pow(jariJariDalam, 3);
            volume = volumeLuar - volumeDalam;
            return volume;
        }

    }

    @Override
    public double hitungLuasPermukaan() {
        // Misal kita anggap luas permukaan cincin bola adalah selisih permukaan 2 bola
        double luasLuar = 4 * Math.PI * Math.pow(super.jariJari, 2);
        double luasDalam = 4 * Math.PI * Math.pow(jariJariDalam, 2);
        return luasLuar - luasDalam;
    }

    @Override
    public double hitungLuasPermukaan(double newR) {
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            double luasLuar = 4 * Math.PI * Math.pow(newR, 2);
            double luasDalam = 4 * Math.PI * Math.pow(jariJariDalam, 2);
            luasPermukaan = luasLuar - luasDalam;
            return luasPermukaan;
        }else{
            double luasLuar = 4 * Math.PI * Math.pow(super.jariJari, 2);
            double luasDalam = 4 * Math.PI * Math.pow(jariJariDalam, 2);
            return luasLuar - luasDalam;
        }

    }

    @Override
    public String getNama() {
        return "Cincin Bola";
    }
}
