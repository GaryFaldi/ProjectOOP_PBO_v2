package BangunGeometry;

public class KerucutTerpancung extends Kerucut {
    private double jariJariKecil;
    private double tinggi;
    public double volume;
    public double luasPermukaan;

    public KerucutTerpancung(double jariJari, double jariJariKecil, double tinggi) {
        super(jariJari, tinggi); // hanya untuk pewarisan atribut
        this.jariJariKecil = jariJariKecil;
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * Math.PI * tinggi * (super.jariJari * super.jariJari + super.jariJari * jariJariKecil + jariJariKecil * jariJariKecil);
    }

    public double hitungLuasPermukaan() {
        double s = Math.sqrt((super.jariJari - jariJariKecil) * (super.jariJari - jariJariKecil) + tinggi * tinggi); // garis pelukis
        return Math.PI * (super.jariJari + jariJariKecil) * s + Math.PI * (super.jariJari * super.jariJari + jariJariKecil * jariJariKecil);
    }

    @Override
    public String getNama() {
        return "Kerucut Terpancung";
    }
}
