package Main;

import BangunGeometry.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("================ Bangun Datar ===================");

        // Memanggil class Segitiga
        Segitiga segitiga = new Segitiga(5, 8, 5, 5, 5);
        System.out.println("Nama Bangun: " + segitiga.getNama());
        System.out.println("Luas       : " + segitiga.luas);
        System.out.println("Keliling   : " + segitiga.keliling);

        // Memanggil class Persegi
        Persegi persegi = new Persegi(4);
        System.out.println("Nama Bangun: " + persegi.getNama());
        System.out.println("Luas       : " + persegi.luas);
        System.out.println("Keliling   : " + persegi.keliling);

        // Memanggil class PersegiPanjang
        PersegiPanjang persegiPanjang = new PersegiPanjang(4, 6);
        System.out.println("Nama Bangun: " + persegiPanjang.getNama());
        System.out.println("Luas       : " + persegiPanjang.luas);
        System.out.println("Keliling   : " + persegiPanjang.keliling);

        // Memanggil class JajarGenjang
        JajarGenjang jajarGenjang = new JajarGenjang(5, 7, 6);
        System.out.println("Nama Bangun: " + jajarGenjang.getNama());
        System.out.println("Luas       : " + jajarGenjang.luas);
        System.out.println("Keliling   : " + jajarGenjang.keliling);

        // Memanggil class Trapesium
        Trapesium trapesium = new Trapesium(4, 6, 5, 6, 6);
        System.out.println("Nama Bangun: " + trapesium.getNama());
        System.out.println("Luas       : " + trapesium.luas);
        System.out.println("Keliling   : " + trapesium.keliling);

        // Memanggil class BelahKetupat
        BelahKetupat belahKetupat = new BelahKetupat(10, 8, 6);
        System.out.println("Nama Bangun: " + belahKetupat.getNama());
        System.out.println("Luas       : " + belahKetupat.luas);
        System.out.println("Keliling   : " + belahKetupat.keliling);

        // Memanggil class LayangLayang
        LayangLayang layangLayang = new LayangLayang(5, 8, 5, 6);
        System.out.println("Nama Bangun: " + layangLayang.getNama());
        System.out.println("Luas       : " + layangLayang.luas);
        System.out.println("Keliling   : " + layangLayang.keliling);

        // Memanggil class Lingkaran
        Lingkaran lingkaran = new Lingkaran(4);
        System.out.println("Nama Bangun: " + lingkaran.getNama());
        System.out.println("Luas       : " + lingkaran.luas);
        System.out.println("Keliling   : " + lingkaran.keliling);

        // Memanggil class TemberengLingkaran
        TemberengLingkaran temberengLingkaran = new TemberengLingkaran(7, 9);
        System.out.println("Nama Bangun: " + temberengLingkaran.getNama());
        System.out.println("Luas       : " + temberengLingkaran.luasTemberengLingkaran);
        System.out.println("Keliling   : " + temberengLingkaran.kelilingTemberengLingkaran);

        // Memanggil class JuringLingkaran
        JuringLingkaran juringLingkaran = new JuringLingkaran(7, 45);
        System.out.println("Nama Bangun: " + juringLingkaran.getNama());
        System.out.println("Luas       : " + juringLingkaran.luasJuringLingkaran);
        System.out.println("Keliling   : " + juringLingkaran.kelilingJuringLingkaran);

        System.out.println("F");
        System.out.println("================ Bangun Ruang ===================");
        System.out.println("F");

        // Memanggil class PrismaSegitiga
        PrismaSegitiga prismaSegitiga = new PrismaSegitiga(5, 8, 10, 10, 10, 9);
        System.out.println("Nama Bangun   : " + prismaSegitiga.getNama());
        System.out.println("Volume        : " + prismaSegitiga.volume);
        System.out.println("Luas Permukaan: " + prismaSegitiga.luasPermukaan);

        // Memanggil class LimasSegitiga
        LimasSegitiga limasSegitiga = new LimasSegitiga(5, 8, 10, 10, 10, 9);
        System.out.println("Nama Bangun   : " + limasSegitiga.getNama());
        System.out.println("Volume        : " + limasSegitiga.volume);
        System.out.println("Luas Permukaan: " + limasSegitiga.luasPermukaan);

        // Memanggil class PrismaPersegi
        PrismaPersegi prismaPersegi = new PrismaPersegi(4, 10);
        System.out.println("Nama Bangun   : " + prismaPersegi.getNama());
        System.out.println("Volume        : " + prismaPersegi.volume);
        System.out.println("Luas Permukaan: " + prismaPersegi.luasPermukaan);

        // Memanggil class LimasPersegi
        LimasPersegi limasPersegi = new LimasPersegi( 4,10);
        System.out.println("Nama Bangun   : " + limasPersegi.getNama());
        System.out.println("Volume        : " + limasPersegi.volume);
        System.out.println("Luas Permukaan: " + limasPersegi.luasPermukaan);

        // Memanggil class PrismaPersegiPanjang
        PrismaPersegiPanjang prismaPersegiPanjang = new PrismaPersegiPanjang(4, 6, 10);
        System.out.println("Nama Bangun   : " + prismaPersegiPanjang.getNama());
        System.out.println("Volume        : " + prismaPersegiPanjang.volume);
        System.out.println("Luas Permukaan: " + prismaPersegiPanjang.luasPermukaan);

        // Memanggil class LimasPersegiPanjang
        LimasPersegiPanjang limasPersegiPanjang = new LimasPersegiPanjang(4, 6, 10);
        System.out.println("Nama Bangun   : " + limasPersegiPanjang.getNama());
        System.out.println("Volume        : " + limasPersegiPanjang.volume);
        System.out.println("Luas Permukaan: " + limasPersegiPanjang.luasPermukaan);

        // Memanggil class PrismaJajarGenjang
        PrismaJajarGenjang prismaJajarGenjang = new PrismaJajarGenjang(5, 7, 6, 10);
        System.out.println("Nama Bangun   : " + prismaJajarGenjang.getNama());
        System.out.println("Volume        : " + prismaJajarGenjang.volume);
        System.out.println("Luas Permukaan: " + prismaJajarGenjang.luasPermukaan);

        // Memanggil class LimasJajarGenjang
        LimasJajarGenjang limasJajarGenjang = new LimasJajarGenjang(5, 7, 6, 10);
        System.out.println("Nama Bangun   : " + limasJajarGenjang.getNama());
        System.out.println("Volume        : " + limasJajarGenjang.volume);
        System.out.println("Luas Permukaan: " + limasJajarGenjang.luasPermukaan);

        // Memanggil class PrismaTrapesium
        PrismaTrapesium prismaTrapesium = new PrismaTrapesium(4, 6, 5, 10, 6, 6);
        System.out.println("Nama Bangun   : " + prismaTrapesium.getNama());
        System.out.println("Volume        : " + prismaTrapesium.volume);
        System.out.println("Luas Permukaan: " + prismaTrapesium.luasPermukaan);

        // Memanggil class LimasTrapesium
        LimasTrapesium limasTrapesium = new LimasTrapesium(4, 6, 5, 10, 10, 11);
        System.out.println("Nama Bangun   : " + limasTrapesium.getNama());
        System.out.println("Volume        : " + limasTrapesium.volume);
        System.out.println("Luas Permukaan: " + limasTrapesium.luasPermukaan);

        // Memanggil class PrismaBelahKetupat
        PrismaBelahKetupat prismaBelahKetupat = new PrismaBelahKetupat(4, 6, 10, 9);
        System.out.println("Nama Bangun   : " + prismaBelahKetupat.getNama());
        System.out.println("Volume        : " + prismaBelahKetupat.volume);
        System.out.println("Luas Permukaan: " + prismaBelahKetupat.luasPermukaan);

        // Memanggil class LimasBelahKetupat
        LimasBelahKetupat limasBelahKetupat = new LimasBelahKetupat(4, 6, 10, 9);
        System.out.println("Nama Bangun   : " + limasBelahKetupat.getNama());
        System.out.println("Volume        : " + limasBelahKetupat.volume);
        System.out.println("Luas Permukaan: " + limasBelahKetupat.luasPermukaan);

        // Memanggil class PrismaLayangLayang
        PrismaLayangLayang prismaLayangLayang = new PrismaLayangLayang(3, 4, 5, 10, 4);
        System.out.println("Nama Bangun   : " + prismaLayangLayang.getNama());
        System.out.println("Volume        : " + prismaLayangLayang.volume);
        System.out.println("Luas Permukaan: " + prismaLayangLayang.luasPermukaan);

        // Memanggil class LimasLayangLayang
        LimasLayangLayang limasLayangLayang = new LimasLayangLayang(3, 4, 5, 10, 4);
        System.out.println("Nama Bangun   : " + limasLayangLayang.getNama());
        System.out.println("Volume        : " + limasLayangLayang.volume);
        System.out.println("Luas Permukaan: " + limasLayangLayang.luasPermukaan);

        // Memanggil class Tabung
        Tabung tabung = new Tabung(1, 10);
        System.out.println("Nama Bangun   : " + tabung.getNama());
        System.out.println("Volume        : " + tabung.volume);
        System.out.println("Luas Permukaan: " + tabung.luasPermukaan);

        // Memanggil class Kerucut
        Kerucut kerucut = new Kerucut(1, 10);
        System.out.println("Nama Bangun   : " + kerucut.getNama());
        System.out.println("Volume        : " + kerucut.volume);
        System.out.println("Luas Permukaan: " + kerucut.luasPermukaan);

        // Memanggil class KerucutTerpancung
        KerucutTerpancung kerucutTerpancung = new KerucutTerpancung(4, 2, 5);
        System.out.println("Nama Bangun   : " + kerucutTerpancung.getNama());
        System.out.println("Volume        : " + kerucutTerpancung.volume);
        System.out.println("Luas Permukaan: " + kerucutTerpancung.luasPermukaan);

        // Memanggil class Bola
        Bola bola = new Bola(1);
        System.out.println("Nama Bangun   : " + bola.getNama());
        double volumeBaru = bola.hitungVolume(0);
        System.out.println("Volume        : " + volumeBaru);
        double luasBaru = bola.hitungLuasPermukaan(0);
        System.out.println("Luas Permukaan: " + luasBaru);

        // Memanggil class TemberengBola
        TemberengBola temberengBola = new TemberengBola(3, 5);
        System.out.println("Nama Bangun   : " + temberengBola.getNama());
        System.out.println("Volume        : " + temberengBola.volume);
        System.out.println("Luas Permukaan: " + temberengBola.luasPermukaan);

        // Memanggil class JuringBola
        JuringBola juringBola = new JuringBola(3, 180);
        System.out.println("Nama Bangun   : " + juringBola.getNama());
        System.out.println("Volume        : " + juringBola.volume);
        System.out.println("Luas Permukaan: " + juringBola.luasPermukaan);

        // Memanggil class CincinBola
        CincinBola cincinBola = new CincinBola(3, 2);
        System.out.println("Nama Bangun   : " + cincinBola.getNama());
        System.out.println("Volume        : " + cincinBola.volume);
        System.out.println("Luas Permukaan: " + cincinBola.luasPermukaan);

    }
}