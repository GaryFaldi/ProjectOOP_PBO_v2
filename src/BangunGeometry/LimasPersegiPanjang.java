package BangunGeometry;


public class LimasPersegiPanjang extends PersegiPanjang{
    private final double tinggiLimas;
    public double volume;
    public double luasPermukaan;

    public LimasPersegiPanjang(double panjang, double lebar, double tinggiLimas) {
        super(panjang, lebar);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        // Volume = (1/3) * luas alas * tinggi limas
        return (1.0 / 3.0) * super.luas * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        double tinggiSegitigaPendek  = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * super.lebar, 2));
        double tinggiSegitigaPanjang = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * super.panjang, 2));

        // Hitung luas sisi tegak
        double luasSisiPendek  = 2 * (0.5 * super.lebar * tinggiSegitigaPendek);
        double luasSisiPanjang = 2 * (0.5 * super.panjang * tinggiSegitigaPanjang);

        return super.luas + luasSisiPendek + luasSisiPanjang;
    }

    @Override
    public String getNama() {
        return "Limas Persegi Panjang";
    }
}
