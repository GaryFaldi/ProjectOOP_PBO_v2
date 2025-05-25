package Main;

import BangunGeometry.*;
import BangunRuang.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("================ Bangun Datar ===================");

        // Memanggil class Segitiga
        Segitiga segitiga = new Segitiga(5, 8, 5, 5, 5);
        System.out.println("Nama Bangun: " + segitiga.getNama());
        System.out.println("Luas       : " + segitiga.luas);
        System.out.println("Keliling   : " + segitiga.keliling);

        // Memanggil class Persegi
        BangunGeometry Persegi = new Persegi(4);

        // Memanggil class PersegiPanjang
        BangunGeometry PersegiPanjang = new PersegiPanjang(4, 6);

        // Memanggil class JajaranGenjang
        BangunGeometry JajaranGenjang = new JajarGenjang(5, 7, 6);

        // Memanggil class Trapesium
        BangunGeometry Trapesium = new Trapesium(4, 6, 5, 6, 6);

        // Memanggil class BelahKetupat
        BangunGeometry BelahKetupat = new BelahKetupat(10, 8, 6);

        // Memanggil class LayangLayang
        BangunGeometry LayangLayang = new LayangLayang(3, 4, 5, 6);

        // Memanggil class Lingkaran
        BangunGeometry Lingkaran = new Lingkaran(7);

        // Memanggil class TemberengLingkaran
        BangunGeometry TemberengLingkaran = new TemberengLingkaran(7, 60);

        // Memanggil class JuringLingkaran
        BangunGeometry JuringLingkaran = new JuringLingkaran(7, 90);

        System.out.println("F");
        System.out.println("================ Bangun Ruang ===================");
        System.out.println("F");

        // Memanggil class PrismaSegitiga
        BangunGeometry PrismaSegitiga = new PrismaSegitiga(5, 8, 10, 10, 10, 9);

        // Memanggil class LimasSegitiga
        BangunGeometry LimasSegitiga = new LimasSegitiga(5, 8, 10, 10, 10, 9);

        // Memanggil class PrismaPersegi
        BangunGeometry PrismaPersegi = new PrismaPersegi(4, 10);

        // Memanggil class LimasPersegi
        BangunGeometry LimasPersegi = new LimasPersegi( 4,10);

        // Memanggil class PrismaPersegiPanjang
        BangunGeometry PrismaPersegiPanjang = new PrismaPersegiPanjang(4, 6, 10);

        // Memanggil class LimasPersegiPanjang
        BangunGeometry LimasPersegiPanjang = new LimasPersegiPanjang(4, 6, 10);

        // Memanggil class PrismaJajaranGenjang
        BangunGeometry PrismaJajaranGenjang = new PrismaJajarGenjang(5, 7, 6, 10);

        // Memanggil class LimasJajaranGenjang
        BangunGeometry LimasJajaranGenjang = new LimasJajarGenjang(5, 7, 6, 10);

        // Memanggil class PrismaTrapesium
        BangunGeometry PrismaTrapesium = new PrismaTrapesium(4, 6, 5, 10, 6, 6);

        // Memanggil class LimasTrapesium
        BangunGeometry LimasTrapesium = new LimasTrapesium(4, 6, 5, 10, 10, 11);

        // Memanggil class PrismaBelahKetupat
        BangunGeometry PrismaBelahKetupat = new PrismaBelahKetupat(4, 6, 10, 9);

        // Memanggil class LimasBelahKetupat
        BangunGeometry LimasBelahKetupat = new LimasBelahKetupat(4, 6, 10, 9);

        // Memanggil class PrismaLayangLayang
        BangunGeometry PrismaLayangLayang = new PrismaLayangLayang(3, 4, 5, 10, 4);

        // Memanggil class LimasLayangLayang
        BangunGeometry LimasLayangLayang = new LimasLayangLayang(3, 4, 5, 10, 4);

        // Memanggil class Tabung
        BangunGeometry Tabung = new Tabung(7, 10);

        // Memanggil class Kerucut
        BangunGeometry Kerucut = new Kerucut(7, 10);

        // Memanggil class KerucutTerpancung
        BangunGeometry KerucutTerpancung = new KerucutTerpancung(7, 10, 5);

        // Memanggil class Bola
        BangunGeometry Bola = new Bola(7);

        // Memanggil class TemberengBola
        BangunGeometry TemberengBola = new TemberengBola(7, 60);

        // Memanggil class JuringBola
        BangunGeometry JuringBola = new JuringBola(7, 90);

        // Memanggil class CincinBola
        BangunGeometry CincinBola = new CincinBola(7, 10);


    }
}