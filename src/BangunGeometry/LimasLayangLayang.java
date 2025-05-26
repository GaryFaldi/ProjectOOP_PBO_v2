package BangunGeometry;

public class LimasLayangLayang extends LayangLayang {
    private final double tinggiLimas;
    public double volume;
    public double luasPermukaan;

    public LimasLayangLayang(double diagonal1, double diagonal2,
                             double sisiPendek, double sisiPanjang,
                             double tinggiLimas) {
        super(diagonal1, diagonal2, sisiPendek, sisiPanjang);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * super.luas * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        // Gunakan Pythagoras untuk menghitung tinggi segitiga sisi tegak
        double tinggiSegitigaPendek  = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * super.diagonal1, 2));
        double tinggiSegitigaPanjang = Math.sqrt((tinggiLimas * tinggiLimas) + Math.pow(0.5 * super.diagonal2, 2));

        // Hitung luas sisi tegak
        double luasSisiPendek  = 2 * (0.5 * super.sisiPendek * tinggiSegitigaPendek);
        double luasSisiPanjang = 2 * (0.5 * super.sisiPanjang * tinggiSegitigaPanjang);

        return super.luas + luasSisiPendek + luasSisiPanjang;
    }

    @Override
    public String getNama() {
        return "Limas Layang-Layang";
    }
}
