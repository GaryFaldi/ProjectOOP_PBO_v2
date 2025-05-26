package BangunGeometry;


public class LimasSegitiga extends Segitiga {
    private final double tinggiLimas; // tinggi dari puncak ke alas segitiga
    public double volume;
    public double luasPermukaan;

    public LimasSegitiga(double alasSegitiga, double tinggiSegitiga,
                         double sisiA, double sisiB, double sisiC,
                         double tinggiLimas) {
        super(alasSegitiga, tinggiSegitiga, sisiA, sisiB, sisiC);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * super.luas * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        // Asumsikan semua sisi tegak berbentuk segitiga dengan tinggi = tinggiLimas
        double luasSisiTegak1 = 0.5 * super.sisiA * tinggiLimas;
        double luasSisiTegak2 = 0.5 * super.sisiB * tinggiLimas;
        double luasSisiTegak3 = 0.5 * super.sisiC * tinggiLimas;

        return super.luas + luasSisiTegak1 + luasSisiTegak2 + luasSisiTegak3;
    }

    @Override
    public String getNama() {
        return "Limas Segitiga";
    }
}
