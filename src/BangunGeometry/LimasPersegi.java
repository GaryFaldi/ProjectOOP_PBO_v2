package BangunGeometry;

public class LimasPersegi extends Persegi {
    private final double tinggiLimas;
    public double volume;
    public double luasPermukaan;

    public LimasPersegi(double sisi, double tinggiLimas) {
        super(sisi);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * super.luas * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        // Hitung luas segitiga pada sisi tegak (pakai pitagoras)
        double tinggiSegitiga = Math.sqrt(Math.pow((super.sisi / 2), 2) + Math.pow(tinggiLimas, 2));
        double luasSelimut = 4 * (0.5 *  super.sisi * tinggiSegitiga);

        return super.luas + luasSelimut;
    }

    @Override
    public String getNama() {
        return "Limas Persegi";
    }
}
