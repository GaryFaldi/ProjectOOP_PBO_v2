package BangunRuang;

public class CincinBola extends Bola {
    private final double jariJariDalam;
    protected double volume;
    protected double luasPermukaan;

    public CincinBola(double jariJari, double jariJariDalam) {
        super(jariJari);
        this.jariJariDalam = jariJariDalam;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungLuasCincin() {
        double luasLuar = Math.PI * jariJari * jariJari;
        double luasDalam = Math.PI * jariJariDalam * jariJariDalam;
        return luasLuar - luasDalam;
    }


    public double hitungLuasPermukaan() {
        // Misal kita anggap luas permukaan cincin bola adalah selisih permukaan 2 bola
        double luasLuar = 4 * Math.PI * Math.pow(jariJari, 2);
        double luasDalam = 4 * Math.PI * Math.pow(jariJariDalam, 2);
        return luasLuar - luasDalam;
    }

    public double hitungVolume() {
        // Volume cincin bola = volume bola luar - volume bola dalam
        double volumeLuar = (4.0 / 3.0) * luas * jariJari;
        double volumeDalam = (4.0 / 3.0) * Math.PI * Math.pow(jariJariDalam, 3);
        return volumeLuar - volumeDalam;
    }

    @Override
    public String getNama() {
        return "Cincin Bola";
    }
}
