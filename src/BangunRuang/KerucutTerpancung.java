package BangunRuang;

public class KerucutTerpancung extends Kerucut {
    private double jariJariKecil;
    private double tinggi;
    public double volume;
    public double luasPermukaan;

    public KerucutTerpancung(double jariJariBesar, double jariJariKecil, double tinggi) {
        super(jariJariBesar, tinggi); // hanya untuk pewarisan atribut
        this.jariJariKecil = jariJariKecil;
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * Math.PI * tinggi * (jariJari * jariJari + jariJari * jariJariKecil + jariJariKecil * jariJariKecil);
    }

    public double hitungLuasPermukaan() {
        double s = Math.sqrt((jariJari - jariJariKecil) * (jariJari - jariJariKecil) + tinggi * tinggi); // garis pelukis
        return Math.PI * (jariJari + jariJariKecil) * s + Math.PI * (jariJari * jariJari + jariJariKecil * jariJariKecil);
    }

    @Override
    public String getNama() {
        return "Kerucut Terpancung";
    }
}
