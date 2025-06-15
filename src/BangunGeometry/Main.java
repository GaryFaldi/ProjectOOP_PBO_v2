package BangunGeometry;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n================ Kalkulator Bangun Datar =================");
            System.out.println("Pilih bangun datar yang ingin dihitung:");
            System.out.println("1. Persegi");
            System.out.println("2. Persegi Panjang");
            System.out.println("3. Segitiga");
            System.out.println("4. Lingkaran");
            System.out.println("5. Jajar Genjang");
            System.out.println("6. Trapesium");
            System.out.println("7. Belah Ketupat");
            System.out.println("8. Layang-layang");
            System.out.println("9. Keluar");
            System.out.print("Masukkan pilihan (1-9): ");

            int pilihan = scanner.nextInt();

            switch(pilihan) {
                case 1:
                    hitungPersegi(scanner);
                    break;
                case 2:
                    hitungPersegiPanjang(scanner);
                    break;
                case 3:
                    hitungSegitiga(scanner);
                    break;
                case 4:
                    hitungLingkaran(scanner);
                    break;
                case 5:
                    hitungJajarGenjang(scanner);
                    break;
                case 6:
                    hitungTrapesium(scanner);
                    break;
                case 7:
                    hitungBelahKetupat(scanner);
                    break;
                case 8:
                    hitungLayangLayang(scanner);
                    break;
                case 9:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void hitungPersegi(Scanner scanner) {
        System.out.println("\n=== Menghitung Persegi ===");
        System.out.print("Masukkan panjang sisi: ");
        double sisi = scanner.nextDouble();

        Persegi persegi = new Persegi(sisi);

        // Loop untuk opsi utama persegi
        while (true) {
            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun: " + persegi.getNama());
            System.out.println("Sisi       : " + persegi.sisi);
            System.out.println("Luas       : " + persegi.luas);
            System.out.println("Keliling   : " + persegi.keliling);

            System.out.println("\nPilih opsi:");
            System.out.println("1. Edit panjang sisi");
            System.out.println("2. Hitung Limas Persegi");
            System.out.println("3. Hitung Prisma Persegi");
            System.out.println("4. Kembali ke menu utama");
            System.out.print("Masukkan pilihan (1-4): ");

            int pilihan = scanner.nextInt();

            switch(pilihan) {
                case 1:
                    System.out.print("Masukkan panjang sisi baru: ");
                    double newSisi = scanner.nextDouble();
                    // Gunakan method dengan parameter newSisi
                    persegi.luas = persegi.hitungLuas(newSisi);
                    persegi.keliling = persegi.hitungKeliling(newSisi);
                    persegi.sisi = newSisi; // Update sisi
                    System.out.println("Panjang sisi berhasil diubah!");
                    break;
                case 2:
                    hitungLimasPersegi(scanner, persegi.sisi);
                    break;
                case 3:
                    hitungPrismaPersegi(scanner, persegi.sisi);
                    break;
                case 4:
                    return; // Kembali ke menu utama
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void hitungPersegiPanjang(Scanner scanner) {
        System.out.println("\n=== Menghitung Persegi Panjang ===");
        System.out.print("Masukkan panjang: ");
        double panjang = scanner.nextDouble();
        System.out.print("Masukkan lebar: ");
        double lebar = scanner.nextDouble();

        PersegiPanjang persegiPanjang = new PersegiPanjang(panjang, lebar);

        // Loop untuk opsi utama persegi panjang
        while (true) {
            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun: " + persegiPanjang.getNama());
            System.out.println("Panjang    : " + persegiPanjang.panjang);
            System.out.println("Lebar      : " + persegiPanjang.lebar);
            System.out.println("Luas       : " + persegiPanjang.luas);
            System.out.println("Keliling   : " + persegiPanjang.keliling);

            System.out.println("\nPilih opsi:");
            System.out.println("1. Edit panjang dan lebar");
            System.out.println("2. Hitung Limas Persegi Panjang");
            System.out.println("3. Hitung Prisma Persegi Panjang");
            System.out.println("4. Kembali ke menu utama");
            System.out.print("Masukkan pilihan (1-4): ");

            int pilihan = scanner.nextInt();

            switch(pilihan) {
                case 1:
                    System.out.print("Masukkan panjang baru: ");
                    double newPanjang = scanner.nextDouble();
                    System.out.print("Masukkan lebar baru: ");
                    double newLebar = scanner.nextDouble();
                    // Gunakan method dengan parameter baru
                    persegiPanjang.luas = persegiPanjang.hitungLuas(newPanjang, newLebar);
                    persegiPanjang.keliling = persegiPanjang.hitungKeliling(newPanjang, newLebar);
                    persegiPanjang.panjang = newPanjang; // Update panjang
                    persegiPanjang.lebar = newLebar; // Update lebar
                    System.out.println("Panjang dan lebar berhasil diubah!");
                    break;
                case 2:
                    hitungLimasPersegiPanjang(scanner, persegiPanjang.panjang, persegiPanjang.lebar);
                    break;
                case 3:
                    hitungPrismaPersegiPanjang(scanner, persegiPanjang.panjang, persegiPanjang.lebar);
                    break;
                case 4:
                    return; // Kembali ke menu utama
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void hitungSegitiga(Scanner scanner) {
        System.out.println("\n=== Menghitung Segitiga ===");
        System.out.print("Masukkan alas: ");
        double alas = scanner.nextDouble();
        System.out.print("Masukkan tinggi: ");
        double tinggi = scanner.nextDouble();
        System.out.print("Masukkan sisi A: ");
        double sisiA = scanner.nextDouble();
        System.out.print("Masukkan sisi B: ");
        double sisiB = scanner.nextDouble();
        System.out.print("Masukkan sisi C: ");
        double sisiC = scanner.nextDouble();

        Segitiga segitiga = new Segitiga(alas, tinggi, sisiA, sisiB, sisiC);

        // Loop untuk opsi utama segitiga
        while (true) {
            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun: " + segitiga.getNama());
            System.out.println("Alas       : " + segitiga.sisiA);
            System.out.println("Tinggi     : " + segitiga.tinggi);
            System.out.println("Sisi A     : " + segitiga.sisiA);
            System.out.println("Sisi B     : " + segitiga.sisiB);
            System.out.println("Sisi C     : " + segitiga.sisiC);
            System.out.println("Luas       : " + segitiga.luas);
            System.out.println("Keliling   : " + segitiga.keliling);

            System.out.println("\nPilih opsi:");
            System.out.println("1. Edit alas dan tinggi");
            System.out.println("2. Edit semua sisi (A, B, C)");
            System.out.println("3. Hitung Limas Segitiga");
            System.out.println("4. Hitung Prisma Segitiga");
            System.out.println("5. Kembali ke menu utama");
            System.out.print("Masukkan pilihan (1-5): ");

            int pilihan = scanner.nextInt();

            switch(pilihan) {
                case 1:
                    System.out.print("Masukkan alas baru: ");
                    double newAlas = scanner.nextDouble();
                    System.out.print("Masukkan tinggi baru: ");
                    double newTinggi = scanner.nextDouble();
                    segitiga.luas = segitiga.hitungLuas(newAlas, newTinggi);
                    segitiga.sisiA = newAlas;
                    segitiga.tinggi = newTinggi;
                    System.out.println("Alas dan tinggi berhasil diubah!");
                    break;
                case 2:
                    System.out.print("Masukkan sisi A baru: ");
                    double newSisiA = scanner.nextDouble();
                    System.out.print("Masukkan sisi B baru: ");
                    double newSisiB = scanner.nextDouble();
                    System.out.print("Masukkan sisi C baru: ");
                    double newSisiC = scanner.nextDouble();
                    segitiga.keliling = segitiga.hitungKeliling(newSisiA, newSisiB, newSisiC);
                    segitiga.sisiA = newSisiA;
                    segitiga.sisiB = newSisiB;
                    segitiga.sisiC = newSisiC;
                    System.out.println("Sisi-sisi segitiga berhasil diubah!");
                    break;
                case 3:
                    hitungLimasSegitiga(scanner, segitiga.sisiA, segitiga.tinggi, segitiga.sisiA, segitiga.sisiB, segitiga.sisiC);
                    break;
                case 4:
                    hitungPrismaSegitiga(scanner, segitiga.sisiA, segitiga.tinggi, segitiga.sisiA, segitiga.sisiB, segitiga.sisiC);
                    break;
                case 5:
                    return; // Kembali ke menu utama
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void hitungLingkaran(Scanner scanner) {
        System.out.println("\n=== Menghitung Lingkaran ===");
        System.out.print("Masukkan jari-jari: ");
        double jariJari = scanner.nextDouble();

        Lingkaran lingkaran = new Lingkaran(jariJari);

        // Loop untuk opsi utama lingkaran
        while (true) {
            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun: " + lingkaran.getNama());
            System.out.println("Jari-jari  : " + lingkaran.jariJari);
            System.out.println("Luas       : " + lingkaran.luas);
            System.out.println("Keliling   : " + lingkaran.keliling);

            System.out.println("\nPilih opsi:");
            System.out.println("1. Edit jari-jari");
            System.out.println("2. Hitung Juring Lingkaran");
            System.out.println("3. Hitung Tembereng Lingkaran");
            System.out.println("4. Hitung Bangun Ruang (Bola/Tabung/Kerucut)");
            System.out.println("5. Kembali ke menu utama");
            System.out.print("Masukkan pilihan (1-5): ");

            int pilihan = scanner.nextInt();

            switch(pilihan) {
                case 1:
                    System.out.print("Masukkan jari-jari baru: ");
                    double newJariJari = scanner.nextDouble();
                    lingkaran = new Lingkaran(newJariJari); // Buat objek baru dengan jari-jari baru
                    System.out.println("Jari-jari berhasil diubah!");
                    // Hitung ulang dengan parameter newR
                    lingkaran.luas = lingkaran.hitungLuas(newJariJari);
                    lingkaran.keliling = lingkaran.hitungKeliling(newJariJari);
                    break;
                case 2:
                    hitungJuringLingkaran(scanner, lingkaran.jariJari);
                    break;
                case 3:
                    hitungTemberengLingkaran(scanner, lingkaran.jariJari);
                    break;
                case 4:
                    hitungBangunRuangLingkaran(scanner, lingkaran.jariJari);
                    break;
                case 5:
                    return; // Kembali ke menu utama
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void hitungJajarGenjang(Scanner scanner) {
        System.out.println("\n=== Menghitung Jajar Genjang ===");
        System.out.print("Masukkan alas: ");
        double alas = scanner.nextDouble();
        System.out.print("Masukkan tinggi: ");
        double tinggi = scanner.nextDouble();
        System.out.print("Masukkan sisi miring: ");
        double sisiMiring = scanner.nextDouble();

        JajarGenjang jajarGenjang = new JajarGenjang(alas, tinggi, sisiMiring);

        // Loop untuk opsi utama jajar genjang
        while (true) {
            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun : " + jajarGenjang.getNama());
            System.out.println("Alas        : " + jajarGenjang.alas);
            System.out.println("Tinggi      : " + jajarGenjang.tinggi);
            System.out.println("Sisi Miring : " + jajarGenjang.sisiMiring);
            System.out.println("Luas        : " + jajarGenjang.luas);
            System.out.println("Keliling    : " + jajarGenjang.keliling);

            System.out.println("\nPilih opsi:");
            System.out.println("1. Edit alas, tinggi, dan sisi miring");
            System.out.println("2. Edit alas dan tinggi saja");
            System.out.println("3. Edit sisi miring saja");
            System.out.println("4. Hitung Prisma Jajar Genjang");
            System.out.println("5. Hitung Limas Jajar Genjang");
            System.out.println("6. Kembali ke menu utama");
            System.out.print("Masukkan pilihan (1-6): ");

            int pilihan = scanner.nextInt();

            switch(pilihan) {
                case 1:
                    System.out.print("Masukkan alas baru: ");
                    double newAlas = scanner.nextDouble();
                    System.out.print("Masukkan tinggi baru: ");
                    double newTinggi = scanner.nextDouble();
                    System.out.print("Masukkan sisi miring baru: ");
                    double newSisiMiring = scanner.nextDouble();
                    jajarGenjang.luas = jajarGenjang.hitungLuas(newAlas, newTinggi);
                    jajarGenjang.keliling = jajarGenjang.hitungKeliling(newAlas, newSisiMiring);
                    jajarGenjang.alas = newAlas;
                    jajarGenjang.tinggi = newTinggi;
                    jajarGenjang.sisiMiring = newSisiMiring;
                    System.out.println("Semua atribut berhasil diubah!");
                    break;
                case 2:
                    System.out.print("Masukkan alas baru: ");
                    newAlas = scanner.nextDouble();
                    System.out.print("Masukkan tinggi baru: ");
                    newTinggi = scanner.nextDouble();
                    jajarGenjang.luas = jajarGenjang.hitungLuas(newAlas, newTinggi);
                    jajarGenjang.alas = newAlas;
                    jajarGenjang.tinggi = newTinggi;
                    System.out.println("Alas dan tinggi berhasil diubah!");
                    break;
                case 3:
                    System.out.print("Masukkan sisi miring baru: ");
                    newSisiMiring = scanner.nextDouble();
                    jajarGenjang.keliling = jajarGenjang.hitungKeliling(jajarGenjang.alas, newSisiMiring);
                    jajarGenjang.sisiMiring = newSisiMiring;
                    System.out.println("Sisi miring berhasil diubah!");
                    break;
                case 4:
                    hitungPrismaJajarGenjang(scanner, jajarGenjang.alas, jajarGenjang.tinggi, jajarGenjang.sisiMiring);
                    break;
                case 5:
                    hitungLimasJajarGenjang(scanner, jajarGenjang.alas, jajarGenjang.tinggi, jajarGenjang.sisiMiring);
                    break;
                case 6:
                    return; // Kembali ke menu utama
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void hitungTrapesium(Scanner scanner) {
        System.out.println("\n=== Menghitung Trapesium ===");
        System.out.print("Masukkan sisi atas: ");
        double sisiAtas = scanner.nextDouble();
        System.out.print("Masukkan sisi bawah: ");
        double sisiBawah = scanner.nextDouble();
        System.out.print("Masukkan tinggi: ");
        double tinggi = scanner.nextDouble();
        System.out.print("Masukkan sisi miring kiri: ");
        double sisiMiringKiri = scanner.nextDouble();
        System.out.print("Masukkan sisi miring kanan: ");
        double sisiMiringKanan = scanner.nextDouble();

        Trapesium trapesium = new Trapesium(sisiAtas, sisiBawah, tinggi, sisiMiringKiri, sisiMiringKanan);

        // Loop untuk opsi utama trapesium
        while (true) {
            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun     : " + trapesium.getNama());
            System.out.println("Sisi Atas       : " + trapesium.sisiAtas);
            System.out.println("Sisi Bawah      : " + trapesium.sisiBawah);
            System.out.println("Tinggi          : " + trapesium.tinggi);
            System.out.println("Sisi Miring Kiri: " + trapesium.sisiMiringKiri);
            System.out.println("Sisi Miring Kanan: " + trapesium.sisiMiringKanan);
            System.out.println("Luas            : " + trapesium.luas);
            System.out.println("Keliling        : " + trapesium.keliling);

            System.out.println("\nPilih opsi:");
            System.out.println("1. Edit semua atribut");
            System.out.println("2. Edit sisi sejajar (atas & bawah) dan tinggi");
            System.out.println("3. Edit sisi miring (kiri & kanan)");
            System.out.println("4. Edit tinggi saja");
            System.out.println("5. Hitung Prisma Trapesium");
            System.out.println("6. Hitung Limas Trapesium");
            System.out.println("7. Kembali ke menu utama");
            System.out.print("Masukkan pilihan (1-7): ");

            int pilihan = scanner.nextInt();

            switch(pilihan) {
                case 1:
                    System.out.print("Masukkan sisi atas baru: ");
                    double newSisiAtas = scanner.nextDouble();
                    System.out.print("Masukkan sisi bawah baru: ");
                    double newSisiBawah = scanner.nextDouble();
                    System.out.print("Masukkan tinggi baru: ");
                    double newTinggi = scanner.nextDouble();
                    System.out.print("Masukkan sisi miring kiri baru: ");
                    double newSisiMiringKiri = scanner.nextDouble();
                    System.out.print("Masukkan sisi miring kanan baru: ");
                    double newSisiMiringKanan = scanner.nextDouble();
                    trapesium.luas = trapesium.hitungLuas(newSisiAtas, newSisiBawah, newTinggi);
                    trapesium.keliling = trapesium.hitungKeliling(newSisiAtas, newSisiBawah, newSisiMiringKiri, newSisiMiringKanan);
                    trapesium.sisiAtas = newSisiAtas;
                    trapesium.sisiBawah = newSisiBawah;
                    trapesium.tinggi = newTinggi;
                    trapesium.sisiMiringKiri = newSisiMiringKiri;
                    trapesium.sisiMiringKanan = newSisiMiringKanan;
                    System.out.println("Semua atribut berhasil diubah!");
                    break;
                case 2:
                    System.out.print("Masukkan sisi atas baru: ");
                    newSisiAtas = scanner.nextDouble();
                    System.out.print("Masukkan sisi bawah baru: ");
                    newSisiBawah = scanner.nextDouble();
                    System.out.print("Masukkan tinggi baru: ");
                    newTinggi = scanner.nextDouble();
                    trapesium.luas = trapesium.hitungLuas(newSisiAtas, newSisiBawah, newTinggi);
                    trapesium.sisiAtas = newSisiAtas;
                    trapesium.sisiBawah = newSisiBawah;
                    trapesium.tinggi = newTinggi;
                    System.out.println("Sisi sejajar dan tinggi berhasil diubah!");
                    break;
                case 3:
                    System.out.print("Masukkan sisi miring kiri baru: ");
                    newSisiMiringKiri = scanner.nextDouble();
                    System.out.print("Masukkan sisi miring kanan baru: ");
                    newSisiMiringKanan = scanner.nextDouble();
                    trapesium.keliling = trapesium.hitungKeliling(trapesium.sisiAtas, trapesium.sisiBawah, newSisiMiringKiri, newSisiMiringKanan);
                    trapesium.sisiMiringKiri = newSisiMiringKiri;
                    trapesium.sisiMiringKanan = newSisiMiringKanan;
                    System.out.println("Sisi miring berhasil diubah!");
                    break;
                case 4:
                    System.out.print("Masukkan tinggi baru: ");
                    newTinggi = scanner.nextDouble();
                    trapesium.luas = trapesium.hitungLuas(trapesium.sisiAtas, trapesium.sisiBawah, newTinggi);
                    trapesium.tinggi = newTinggi;
                    System.out.println("Tinggi berhasil diubah!");
                    break;
                case 5:
                    hitungPrismaTrapesium(scanner, trapesium.sisiAtas, trapesium.sisiBawah, trapesium.tinggi, trapesium.sisiMiringKiri, trapesium.sisiMiringKanan);
                    break;
                case 6:
                    hitungLimasTrapesium(scanner, trapesium.sisiAtas, trapesium.sisiBawah, trapesium.tinggi, trapesium.sisiMiringKiri, trapesium.sisiMiringKanan);
                    break;
                case 7:
                    return; // Kembali ke menu utama
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void hitungBelahKetupat(Scanner scanner) {
        System.out.println("\n=== Menghitung Belah Ketupat ===");
        System.out.print("Masukkan diagonal 1: ");
        double d1 = scanner.nextDouble();
        System.out.print("Masukkan diagonal 2: ");
        double d2 = scanner.nextDouble();
        System.out.print("Masukkan panjang sisi: ");
        double sisi = scanner.nextDouble();

        BelahKetupat belahKetupat = new BelahKetupat(d1, d2, sisi);

        // Loop untuk opsi utama belah ketupat
        while (true) {
            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun : " + belahKetupat.getNama());
            System.out.println("Diagonal 1  : " + belahKetupat.diagonal1);
            System.out.println("Diagonal 2  : " + belahKetupat.diagonal2);
            System.out.println("Sisi        : " + belahKetupat.sisi);
            System.out.println("Luas        : " + belahKetupat.luas);
            System.out.println("Keliling    : " + belahKetupat.keliling);

            System.out.println("\nPilih opsi:");
            System.out.println("1. Edit semua atribut (diagonal 1, diagonal 2, sisi)");
            System.out.println("2. Edit diagonal saja (diagonal 1 & 2)");
            System.out.println("3. Edit panjang sisi saja");
            System.out.println("4. Hitung Prisma Belah Ketupat");
            System.out.println("5. Hitung Limas Belah Ketupat");
            System.out.println("6. Kembali ke menu utama");
            System.out.print("Masukkan pilihan (1-6): ");

            int pilihan = scanner.nextInt();

            switch(pilihan) {
                case 1:
                    System.out.print("Masukkan diagonal 1 baru: ");
                    double newD1 = scanner.nextDouble();
                    System.out.print("Masukkan diagonal 2 baru: ");
                    double newD2 = scanner.nextDouble();
                    System.out.print("Masukkan panjang sisi baru: ");
                    double newSisi = scanner.nextDouble();
                    belahKetupat.luas = belahKetupat.hitungLuas(newD1, newD2);
                    belahKetupat.keliling = belahKetupat.hitungKeliling(newSisi);
                    belahKetupat.diagonal1 = newD1;
                    belahKetupat.diagonal2 = newD2;
                    belahKetupat.sisi = newSisi;
                    System.out.println("Semua atribut berhasil diubah!");
                    break;
                case 2:
                    System.out.print("Masukkan diagonal 1 baru: ");
                    newD1 = scanner.nextDouble();
                    System.out.print("Masukkan diagonal 2 baru: ");
                    newD2 = scanner.nextDouble();
                    belahKetupat.luas = belahKetupat.hitungLuas(newD1, newD2);
                    belahKetupat.diagonal1 = newD1;
                    belahKetupat.diagonal2 = newD2;
                    System.out.println("Diagonal berhasil diubah!");
                    break;
                case 3:
                    System.out.print("Masukkan panjang sisi baru: ");
                    newSisi = scanner.nextDouble();
                    belahKetupat.keliling = belahKetupat.hitungKeliling(newSisi);
                    belahKetupat.sisi = newSisi;
                    System.out.println("Panjang sisi berhasil diubah!");
                    break;
                case 4:
                    hitungPrismaBelahKetupat(scanner, belahKetupat.diagonal1, belahKetupat.diagonal2, belahKetupat.sisi);
                    break;
                case 5:
                    hitungLimasBelahKetupat(scanner, belahKetupat.diagonal1, belahKetupat.diagonal2, belahKetupat.sisi);
                    break;
                case 6:
                    return; // Kembali ke menu utama
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void hitungLayangLayang(Scanner scanner) {
        System.out.println("\n=== Menghitung Layang-Layang ===");
        System.out.print("Masukkan diagonal 1 (d1): ");
        double d1 = scanner.nextDouble();
        System.out.print("Masukkan diagonal 2 (d2): ");
        double d2 = scanner.nextDouble();
        System.out.print("Masukkan sisi pendek (a): ");
        double sisiPendek = scanner.nextDouble();
        System.out.print("Masukkan sisi panjang (b): ");
        double sisiPanjang = scanner.nextDouble();

        LayangLayang layangLayang = new LayangLayang(d1, d2, sisiPendek, sisiPanjang);

        // Loop untuk opsi utama layang-layang
        while (true) {
            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun : " + layangLayang.getNama());
            System.out.println("Diagonal 1  : " + layangLayang.diagonal1);
            System.out.println("Diagonal 2  : " + layangLayang.diagonal2);
            System.out.println("Sisi Pendek : " + layangLayang.sisiPendek);
            System.out.println("Sisi Panjang: " + layangLayang.sisiPanjang);
            System.out.println("Luas        : " + layangLayang.luas);
            System.out.println("Keliling    : " + layangLayang.keliling);

            System.out.println("\nPilih opsi:");
            System.out.println("1. Edit semua atribut");
            System.out.println("2. Edit diagonal saja (d1 & d2)");
            System.out.println("3. Edit sisi saja (pendek & panjang)");
            System.out.println("4. Hitung Prisma Layang-Layang");
            System.out.println("5. Hitung Limas Layang-Layang");
            System.out.println("6. Kembali ke menu utama");
            System.out.print("Masukkan pilihan (1-6): ");

            int pilihan = scanner.nextInt();

            switch(pilihan) {
                case 1:
                    System.out.print("Masukkan diagonal 1 baru: ");
                    double newD1 = scanner.nextDouble();
                    System.out.print("Masukkan diagonal 2 baru: ");
                    double newD2 = scanner.nextDouble();
                    System.out.print("Masukkan sisi pendek baru: ");
                    double newSisiPendek = scanner.nextDouble();
                    System.out.print("Masukkan sisi panjang baru: ");
                    double newSisiPanjang = scanner.nextDouble();
                    layangLayang.luas = layangLayang.hitungLuas(newD1, newD2);
                    layangLayang.keliling = layangLayang.hitungKeliling(newSisiPendek, newSisiPanjang);
                    layangLayang.diagonal1 = newD1;
                    layangLayang.diagonal2 = newD2;
                    layangLayang.sisiPendek = newSisiPendek;
                    layangLayang.sisiPanjang = newSisiPanjang;
                    System.out.println("Semua atribut berhasil diubah!");
                    break;
                case 2:
                    System.out.print("Masukkan diagonal 1 baru: ");
                    newD1 = scanner.nextDouble();
                    System.out.print("Masukkan diagonal 2 baru: ");
                    newD2 = scanner.nextDouble();
                    layangLayang.luas = layangLayang.hitungLuas(newD1, newD2);
                    layangLayang.diagonal1 = newD1;
                    layangLayang.diagonal2 = newD2;
                    System.out.println("Diagonal berhasil diubah!");
                    break;
                case 3:
                    System.out.print("Masukkan sisi pendek baru: ");
                    newSisiPendek = scanner.nextDouble();
                    System.out.print("Masukkan sisi panjang baru: ");
                    newSisiPanjang = scanner.nextDouble();
                    layangLayang.keliling = layangLayang.hitungKeliling(newSisiPendek, newSisiPanjang);
                    layangLayang.sisiPendek = newSisiPendek;
                    layangLayang.sisiPanjang = newSisiPanjang;
                    System.out.println("Sisi-sisi berhasil diubah!");
                    break;
                case 4:
                    hitungPrismaLayangLayang(scanner, layangLayang.diagonal1, layangLayang.diagonal2,
                            layangLayang.sisiPendek, layangLayang.sisiPanjang);
                    break;
                case 5:
                    hitungLimasLayangLayang(scanner, layangLayang.diagonal1, layangLayang.diagonal2,
                            layangLayang.sisiPendek, layangLayang.sisiPanjang);
                    break;
                case 6:
                    return; // Kembali ke menu utama
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void hitungLimasPersegi(Scanner scanner, double sisi) {
        System.out.println("\n=== Menghitung Limas Persegi ===");
        System.out.print("Masukkan tinggi limas: ");
        double tinggiLimas = scanner.nextDouble();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            Future<Double> volumeFuture = executor.submit(() -> {
                return (1.0/3) * Math.pow(sisi, 2) * tinggiLimas;
            });

            Future<Double> luasPermukaanFuture = executor.submit(() -> {
                double luasAlas = Math.pow(sisi, 2);
                double tinggiSegitiga = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(sisi/2.0, 2));
                double luasSisiTegak = 4 * (0.5 * sisi * tinggiSegitiga);
                return luasAlas + luasSisiTegak;
            });

            Persegi limas = new LimasPersegi(sisi, tinggiLimas);
            LimasPersegi limasCast = (LimasPersegi) limas;

            limasCast.volume = volumeFuture.get();
            limasCast.luasPermukaan = luasPermukaanFuture.get();

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun   : " + limas.getNama());
            System.out.println("Sisi Alas     : " + sisi);
            System.out.println("Tinggi Limas  : " + tinggiLimas);
            System.out.println("Volume        : " + limasCast.volume);
            System.out.println("Luas Permukaan: " + limasCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }

    private static void hitungPrismaPersegi(Scanner scanner, double sisi) {
        System.out.println("\n=== Menghitung Prisma Persegi ===");
        System.out.print("Masukkan tinggi prisma: ");
        double tinggiPrisma = scanner.nextDouble();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            Future<Double> volumeFuture = executor.submit(() -> {
                return Math.pow(sisi, 2) * tinggiPrisma;
            });

            Future<Double> luasPermukaanFuture = executor.submit(() -> {
                double luasAlasDanTutup = 2 * Math.pow(sisi, 2);
                double luasSisiTegak = 4 * (sisi * tinggiPrisma);
                return luasAlasDanTutup + luasSisiTegak;
            });

            Persegi prisma = new PrismaPersegi(sisi, tinggiPrisma);
            PrismaPersegi pPersegiCast = (PrismaPersegi) prisma;

            pPersegiCast.volume = volumeFuture.get();
            pPersegiCast.luasPermukaan = luasPermukaanFuture.get();

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun   : " + prisma.getNama());
            System.out.println("Sisi Alas     : " + sisi);
            System.out.println("Tinggi Prisma : " + tinggiPrisma);
            System.out.println("Volume        : " + pPersegiCast.volume);
            System.out.println("Luas Permukaan: " + pPersegiCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }


    private static void hitungLimasPersegiPanjang(Scanner scanner, double panjang, double lebar) {
        System.out.println("\n=== Menghitung Limas Persegi Panjang ===");
        System.out.print("Masukkan tinggi limas: ");
        double tinggiLimas = scanner.nextDouble();

        ExecutorService executor = Executors.newFixedThreadPool(3); // 3 thread untuk perhitungan paralel

        try {
            // Hitung volume secara paralel
            Future<Double> volumeFuture = executor.submit(() -> {
                double luasAlas = panjang * lebar;
                return (1.0/3) * luasAlas * tinggiLimas;
            });

            // Hitung tinggi segitiga sisi panjang secara paralel
            Future<Double> tinggiSegitigaPanjangFuture = executor.submit(() -> {
                return Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(lebar/2.0, 2));
            });

            // Hitung tinggi segitiga sisi lebar secara paralel
            Future<Double> tinggiSegitigaLebarFuture = executor.submit(() -> {
                return Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(panjang/2.0, 2));
            });

            // Tunggu semua hasil perhitungan
            double volume = volumeFuture.get();
            double tinggiSegitigaPanjang = tinggiSegitigaPanjangFuture.get();
            double tinggiSegitigaLebar = tinggiSegitigaLebarFuture.get();

            // Hitung luas permukaan setelah mendapatkan semua komponen
            double luasAlas = panjang * lebar;
            double luasSisiPanjang = 2 * (0.5 * panjang * tinggiSegitigaPanjang);
            double luasSisiLebar = 2 * (0.5 * lebar * tinggiSegitigaLebar);
            double luasPermukaan = luasAlas + luasSisiPanjang + luasSisiLebar;

            // Buat objek limas
            PersegiPanjang limas = new LimasPersegiPanjang(panjang, lebar, tinggiLimas);
            LimasPersegiPanjang lPersegiPanjangCast = (LimasPersegiPanjang) limas;

            // Set nilai hasil perhitungan
            lPersegiPanjangCast.volume = volume;
            lPersegiPanjangCast.luasPermukaan = luasPermukaan;

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun   : " + limas.getNama());
            System.out.println("Panjang Alas  : " + panjang);
            System.out.println("Lebar Alas    : " + lebar);
            System.out.println("Tinggi Limas  : " + tinggiLimas);
            System.out.println("Volume        : " + lPersegiPanjangCast.volume);
            System.out.println("Luas Permukaan: " + lPersegiPanjangCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }


    private static void hitungPrismaPersegiPanjang(Scanner scanner, double panjang, double lebar) {
        System.out.println("\n=== Menghitung Prisma Persegi Panjang ===");
        System.out.print("Masukkan tinggi prisma: ");
        double tinggiPrisma = scanner.nextDouble();

        ExecutorService executor = Executors.newFixedThreadPool(2); // 2 thread untuk perhitungan paralel

        try {
            // Hitung volume dan luas permukaan secara paralel
            Future<Double> volumeFuture = executor.submit(() -> {
                return panjang * lebar * tinggiPrisma;
            });

            Future<Double> luasPermukaanFuture = executor.submit(() -> {
                double luasAlasDanTutup = 2 * (panjang * lebar);
                double luasSisiTegak = 2 * ((panjang * tinggiPrisma) + (lebar * tinggiPrisma));
                return luasAlasDanTutup + luasSisiTegak;
            });

            // Buat objek prisma
            PersegiPanjang prisma = new PrismaPersegiPanjang(panjang, lebar, tinggiPrisma);
            PrismaPersegiPanjang pPersegiCast = (PrismaPersegiPanjang) prisma;

            // Set nilai hasil perhitungan
            pPersegiCast.volume = volumeFuture.get();
            pPersegiCast.luasPermukaan = luasPermukaanFuture.get();

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun   : " + prisma.getNama());
            System.out.println("Panjang Alas  : " + panjang);
            System.out.println("Lebar Alas    : " + lebar);
            System.out.println("Tinggi Prisma : " + tinggiPrisma);
            System.out.println("Volume        : " + pPersegiCast.volume);
            System.out.println("Luas Permukaan: " + pPersegiCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }


    private static void hitungLimasSegitiga(Scanner scanner, double alas, double tinggi, double sisiA, double sisiB, double sisiC) {
        System.out.println("\n=== Menghitung Limas Segitiga ===");
        System.out.print("Masukkan tinggi limas: ");
        double tinggiLimas = scanner.nextDouble();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            Future<Double> volumeFuture = executor.submit(() -> {
                double luasAlas = 0.5 * alas * tinggi;
                return (1.0/3) * luasAlas * tinggiLimas;
            });

            Future<Double> luasPermukaanFuture = executor.submit(() -> {
                double luasAlas = 0.5 * alas * tinggi;

                // Hitung tinggi segitiga sisi tegak
                double tinggiSegitiga1 = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(tinggi/3.0, 2));
                double tinggiSegitiga2 = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(tinggi/3.0, 2));
                double tinggiSegitiga3 = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(tinggi/3.0, 2));

                double luasSisiTegak = 0.5 * (sisiA * tinggiSegitiga1 + sisiB * tinggiSegitiga2 + sisiC * tinggiSegitiga3);
                return luasAlas + luasSisiTegak;
            });

            Segitiga limas = new LimasSegitiga(alas, tinggi, sisiA, sisiB, sisiC, tinggiLimas);
            LimasSegitiga lSegitigaCast = (LimasSegitiga) limas;

            lSegitigaCast.volume = volumeFuture.get();
            lSegitigaCast.luasPermukaan = luasPermukaanFuture.get();

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun    : " + limas.getNama());
            System.out.println("Alas Segitiga  : " + alas);
            System.out.println("Tinggi Segitiga: " + tinggi);
            System.out.println("Sisi A         : " + sisiA);
            System.out.println("Sisi B         : " + sisiB);
            System.out.println("Sisi C         : " + sisiC);
            System.out.println("Tinggi Limas   : " + tinggiLimas);
            System.out.println("Volume         : " + lSegitigaCast.volume);
            System.out.println("Luas Permukaan : " + lSegitigaCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }


    private static void hitungPrismaSegitiga(Scanner scanner, double alas, double tinggi, double sisiA, double sisiB, double sisiC) {
        System.out.println("\n=== Menghitung Prisma Segitiga ===");
        System.out.print("Masukkan tinggi prisma: ");
        double tinggiPrisma = scanner.nextDouble();

        ExecutorService executor = Executors.newFixedThreadPool(3); // 3 thread untuk perhitungan paralel

        try {
            // Hitung volume secara paralel
            Future<Double> volumeFuture = executor.submit(() -> {
                double luasAlas = 0.5 * alas * tinggi;
                return luasAlas * tinggiPrisma;
            });

            // Hitung keliling alas secara paralel
            Future<Double> kelilingAlasFuture = executor.submit(() -> {
                return sisiA + sisiB + sisiC;
            });

            // Hitung luas sisi tegak secara paralel (tanpa menunggu keliling)
            Future<Double> luasSisiTegakFuture = executor.submit(() -> {
                return (sisiA + sisiB + sisiC) * tinggiPrisma;
            });

            // Tunggu semua hasil perhitungan
            double volume = volumeFuture.get();
            double kelilingAlas = kelilingAlasFuture.get();
            double luasSisiTegak = luasSisiTegakFuture.get();

            // Hitung luas permukaan
            double luasAlasDanTutup = 2 * (0.5 * alas * tinggi);
            double luasPermukaan = luasAlasDanTutup + luasSisiTegak;

            // Buat objek prisma
            Segitiga prisma = new PrismaSegitiga(alas, tinggi, sisiA, sisiB, sisiC, tinggiPrisma);
            PrismaSegitiga pSegitigaCast = (PrismaSegitiga) prisma;

            // Set nilai hasil perhitungan
            pSegitigaCast.volume = volume;
            pSegitigaCast.luasPermukaan = luasPermukaan;

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun    : " + prisma.getNama());
            System.out.println("Alas Segitiga  : " + alas);
            System.out.println("Tinggi Segitiga: " + tinggi);
            System.out.println("Sisi A         : " + sisiA);
            System.out.println("Sisi B         : " + sisiB);
            System.out.println("Sisi C         : " + sisiC);
            System.out.println("Tinggi Prisma  : " + tinggiPrisma);
            System.out.println("Volume         : " + pSegitigaCast.volume);
            System.out.println("Luas Permukaan : " + pSegitigaCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }


    private static void hitungPrismaJajarGenjang(Scanner scanner, double alas, double tinggi, double sisiMiring) {
        System.out.println("\n=== Menghitung Prisma Jajar Genjang ===");
        System.out.print("Masukkan tinggi prisma: ");
        double tinggiPrisma = scanner.nextDouble();

        ExecutorService executor = Executors.newFixedThreadPool(3); // 3 thread untuk perhitungan paralel

        try {
            // Hitung volume secara paralel
            Future<Double> volumeFuture = executor.submit(() -> {
                double luasAlas = alas * tinggi;
                return luasAlas * tinggiPrisma;
            });

            // Hitung keliling alas secara paralel
            Future<Double> kelilingAlasFuture = executor.submit(() -> {
                return 2 * (alas + sisiMiring);
            });

            // Hitung luas sisi tegak secara paralel
            Future<Double> luasSisiTegakFuture = executor.submit(() -> {
                return 2 * (alas + sisiMiring) * tinggiPrisma;
            });

            // Tunggu semua hasil perhitungan
            double volume = volumeFuture.get();
            double kelilingAlas = kelilingAlasFuture.get();
            double luasSisiTegak = luasSisiTegakFuture.get();

            // Hitung luas permukaan
            double luasAlasDanTutup = 2 * (alas * tinggi);
            double luasPermukaan = luasAlasDanTutup + luasSisiTegak;

            // Buat objek prisma
            JajarGenjang prisma = new PrismaJajarGenjang(alas, tinggi, sisiMiring, tinggiPrisma);
            PrismaJajarGenjang pJajarCast = (PrismaJajarGenjang) prisma;

            // Set nilai hasil perhitungan
            pJajarCast.volume = volume;
            pJajarCast.luasPermukaan = luasPermukaan;

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun   : " + prisma.getNama());
            System.out.println("Alas          : " + alas);
            System.out.println("Tinggi        : " + tinggi);
            System.out.println("Sisi Miring   : " + sisiMiring);
            System.out.println("Tinggi Prisma : " + tinggiPrisma);
            System.out.println("Volume        : " + pJajarCast.volume);
            System.out.println("Luas Permukaan: " + pJajarCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }


    private static void hitungLimasJajarGenjang(Scanner scanner, double alas, double tinggi, double sisiMiring) {
        System.out.println("\n=== Menghitung Limas Jajar Genjang ===");
        System.out.print("Masukkan tinggi limas: ");
        double tinggiLimas = scanner.nextDouble();

        ExecutorService executor = Executors.newFixedThreadPool(4); // 4 thread untuk perhitungan kompleks

        try {
            // Hitung volume secara paralel
            Future<Double> volumeFuture = executor.submit(() -> {
                double luasAlas = alas * tinggi;
                return (1.0/3) * luasAlas * tinggiLimas;
            });

            // Hitung tinggi segitiga sisi alas secara paralel
            Future<Double> tinggiSegitigaAlasFuture = executor.submit(() -> {
                return Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(tinggi/2.0, 2));
            });

            // Hitung tinggi segitiga sisi miring secara paralel
            Future<Double> tinggiSegitigaMiringFuture = executor.submit(() -> {
                return Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(tinggi/2.0, 2));
            });

            // Hitung luas alas secara paralel
            Future<Double> luasAlasFuture = executor.submit(() -> {
                return alas * tinggi;
            });

            // Tunggu semua hasil perhitungan
            double volume = volumeFuture.get();
            double tinggiSegitigaAlas = tinggiSegitigaAlasFuture.get();
            double tinggiSegitigaMiring = tinggiSegitigaMiringFuture.get();
            double luasAlas = luasAlasFuture.get();

            // Hitung luas permukaan
            double luasSegitigaAlas = 2 * (0.5 * alas * tinggiSegitigaAlas);
            double luasSegitigaMiring = 2 * (0.5 * sisiMiring * tinggiSegitigaMiring);
            double luasPermukaan = luasAlas + luasSegitigaAlas + luasSegitigaMiring;

            // Buat objek limas
            JajarGenjang limas = new LimasJajarGenjang(alas, tinggi, sisiMiring, tinggiLimas);
            LimasJajarGenjang lJajarCast = (LimasJajarGenjang) limas;

            // Set nilai hasil perhitungan
            lJajarCast.volume = volume;
            lJajarCast.luasPermukaan = luasPermukaan;

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun   : " + limas.getNama());
            System.out.println("Alas          : " + alas);
            System.out.println("Tinggi        : " + tinggi);
            System.out.println("Sisi Miring   : " + sisiMiring);
            System.out.println("Tinggi Limas  : " + tinggiLimas);
            System.out.println("Volume        : " + lJajarCast.volume);
            System.out.println("Luas Permukaan: " + lJajarCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }


    private static void hitungPrismaTrapesium(Scanner scanner, double sisiAtas, double sisiBawah, double tinggi, double sisiMiringKiri, double sisiMiringKanan) {
        System.out.println("\n=== Menghitung Prisma Trapesium ===");
        System.out.print("Masukkan tinggi prisma: ");
        double tinggiPrisma = scanner.nextDouble();

        ExecutorService executor = Executors.newFixedThreadPool(3); // 3 thread untuk perhitungan paralel

        try {
            // Hitung volume secara paralel
            Future<Double> volumeFuture = executor.submit(() -> {
                double luasAlas = 0.5 * (sisiAtas + sisiBawah) * tinggi;
                return luasAlas * tinggiPrisma;
            });

            // Hitung keliling alas secara paralel
            Future<Double> kelilingAlasFuture = executor.submit(() -> {
                return sisiAtas + sisiBawah + sisiMiringKiri + sisiMiringKanan;
            });

            // Hitung luas sisi tegak secara paralel
            Future<Double> luasSisiTegakFuture = executor.submit(() -> {
                return (sisiAtas + sisiBawah + sisiMiringKiri + sisiMiringKanan) * tinggiPrisma;
            });

            // Tunggu semua hasil perhitungan
            double volume = volumeFuture.get();
            double kelilingAlas = kelilingAlasFuture.get();
            double luasSisiTegak = luasSisiTegakFuture.get();

            // Hitung luas permukaan
            double luasAlasDanTutup = 2 * (0.5 * (sisiAtas + sisiBawah) * tinggi);
            double luasPermukaan = luasAlasDanTutup + luasSisiTegak;

            // Buat objek prisma
            Trapesium prisma = new PrismaTrapesium(sisiAtas, sisiBawah, tinggi, sisiMiringKiri, sisiMiringKanan, tinggiPrisma);
            PrismaTrapesium pTrapesiumCast = (PrismaTrapesium) prisma;

            // Set nilai hasil perhitungan
            pTrapesiumCast.volume = volume;
            pTrapesiumCast.luasPermukaan = luasPermukaan;

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun     : " + prisma.getNama());
            System.out.println("Sisi Atas       : " + sisiAtas);
            System.out.println("Sisi Bawah      : " + sisiBawah);
            System.out.println("Tinggi Trapesium: " + tinggi);
            System.out.println("Sisi Miring Kiri: " + sisiMiringKiri);
            System.out.println("Sisi Miring Kanan: " + sisiMiringKanan);
            System.out.println("Tinggi Prisma   : " + tinggiPrisma);
            System.out.println("Volume          : " + pTrapesiumCast.volume);
            System.out.println("Luas Permukaan  : " + pTrapesiumCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }


    private static void hitungLimasTrapesium(Scanner scanner, double sisiAtas, double sisiBawah, double tinggi, double sisiMiringKiri, double sisiMiringKanan) {
        System.out.println("\n=== Menghitung Limas Trapesium ===");
        System.out.print("Masukkan tinggi limas: ");
        double tinggiLimas = scanner.nextDouble();

        ExecutorService executor = Executors.newFixedThreadPool(4); // 4 thread untuk perhitungan kompleks

        try {
            // Hitung volume secara paralel
            Future<Double> volumeFuture = executor.submit(() -> {
                double luasAlas = 0.5 * (sisiAtas + sisiBawah) * tinggi;
                return (1.0/3) * luasAlas * tinggiLimas;
            });

            // Hitung tinggi segitiga sisi atas secara paralel
            Future<Double> tinggiSegitigaAtasFuture = executor.submit(() -> {
                return Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(tinggi/2.0, 2));
            });

            // Hitung tinggi segitiga sisi bawah secara paralel
            Future<Double> tinggiSegitigaBawahFuture = executor.submit(() -> {
                return Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(tinggi/2.0, 2));
            });

            // Hitung tinggi segitiga sisi miring secara paralel
            Future<Double> tinggiSegitigaMiringFuture = executor.submit(() -> {
                double x = (sisiBawah - sisiAtas) / 2;
                return Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(x, 2) + Math.pow(tinggi, 2));
            });

            // Tunggu semua hasil perhitungan
            double volume = volumeFuture.get();
            double tinggiSegitigaAtas = tinggiSegitigaAtasFuture.get();
            double tinggiSegitigaBawah = tinggiSegitigaBawahFuture.get();
            double tinggiSegitigaMiring = tinggiSegitigaMiringFuture.get();

            // Hitung luas permukaan
            double luasAlas = 0.5 * (sisiAtas + sisiBawah) * tinggi;
            double luasSegitigaAtas = 0.5 * sisiAtas * tinggiSegitigaAtas;
            double luasSegitigaBawah = 0.5 * sisiBawah * tinggiSegitigaBawah;
            double luasSegitigaMiringKiri = 0.5 * sisiMiringKiri * tinggiSegitigaMiring;
            double luasSegitigaMiringKanan = 0.5 * sisiMiringKanan * tinggiSegitigaMiring;
            double luasPermukaan = luasAlas + luasSegitigaAtas + luasSegitigaBawah +
                    luasSegitigaMiringKiri + luasSegitigaMiringKanan;

            // Buat objek limas
            Trapesium limas = new LimasTrapesium(sisiAtas, sisiBawah, tinggi, sisiMiringKiri, sisiMiringKanan, tinggiLimas);
            LimasTrapesium lTrapesiumCast = (LimasTrapesium) limas;

            // Set nilai hasil perhitungan
            lTrapesiumCast.volume = volume;
            lTrapesiumCast.luasPermukaan = luasPermukaan;

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun     : " + limas.getNama());
            System.out.println("Sisi Atas       : " + sisiAtas);
            System.out.println("Sisi Bawah      : " + sisiBawah);
            System.out.println("Tinggi Trapesium: " + tinggi);
            System.out.println("Sisi Miring Kiri: " + sisiMiringKiri);
            System.out.println("Sisi Miring Kanan: " + sisiMiringKanan);
            System.out.println("Tinggi Limas    : " + tinggiLimas);
            System.out.println("Volume          : " + lTrapesiumCast.volume);
            System.out.println("Luas Permukaan  : " + lTrapesiumCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }


    private static void hitungPrismaBelahKetupat(Scanner scanner, double d1, double d2, double sisi) {
        System.out.println("\n=== Menghitung Prisma Belah Ketupat ===");
        System.out.print("Masukkan tinggi prisma: ");
        double tinggiPrisma = scanner.nextDouble();

        ExecutorService executor = Executors.newFixedThreadPool(3); // 3 thread untuk perhitungan paralel

        try {
            // Hitung volume secara paralel
            Future<Double> volumeFuture = executor.submit(() -> {
                double luasAlas = 0.5 * d1 * d2;
                return luasAlas * tinggiPrisma;
            });

            // Hitung keliling alas secara paralel
            Future<Double> kelilingAlasFuture = executor.submit(() -> {
                return 4 * sisi;
            });

            // Hitung luas sisi tegak secara paralel
            Future<Double> luasSisiTegakFuture = executor.submit(() -> {
                return 4 * sisi * tinggiPrisma;
            });

            // Tunggu semua hasil perhitungan
            double volume = volumeFuture.get();
            double kelilingAlas = kelilingAlasFuture.get();
            double luasSisiTegak = luasSisiTegakFuture.get();

            // Hitung luas permukaan
            double luasAlasDanTutup = 2 * (0.5 * d1 * d2);
            double luasPermukaan = luasAlasDanTutup + luasSisiTegak;

            // Buat objek prisma
            BelahKetupat prisma = new PrismaBelahKetupat(d1, d2, sisi, tinggiPrisma);
            PrismaBelahKetupat pBelahKetupatCast = (PrismaBelahKetupat) prisma;

            // Set nilai hasil perhitungan
            pBelahKetupatCast.volume = volume;
            pBelahKetupatCast.luasPermukaan = luasPermukaan;

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun   : " + prisma.getNama());
            System.out.println("Diagonal 1    : " + d1);
            System.out.println("Diagonal 2    : " + d2);
            System.out.println("Sisi          : " + sisi);
            System.out.println("Tinggi Prisma : " + tinggiPrisma);
            System.out.println("Volume        : " + pBelahKetupatCast.volume);
            System.out.println("Luas Permukaan: " + pBelahKetupatCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }


    private static void hitungLimasBelahKetupat(Scanner scanner, double d1, double d2, double sisi) {
        System.out.println("\n=== Menghitung Limas Belah Ketupat ===");
        System.out.print("Masukkan tinggi limas: ");
        double tinggiLimas = scanner.nextDouble();

        ExecutorService executor = Executors.newFixedThreadPool(4); // 4 thread untuk perhitungan kompleks

        try {
            // Hitung volume secara paralel
            Future<Double> volumeFuture = executor.submit(() -> {
                double luasAlas = 0.5 * d1 * d2;
                return (1.0/3) * luasAlas * tinggiLimas;
            });

            // Hitung tinggi segitiga sisi 1 secara paralel
            Future<Double> tinggiSegitiga1Future = executor.submit(() -> {
                return Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(d1/2.0, 2));
            });

            // Hitung tinggi segitiga sisi 2 secara paralel
            Future<Double> tinggiSegitiga2Future = executor.submit(() -> {
                return Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(d2/2.0, 2));
            });

            // Hitung luas alas secara paralel
            Future<Double> luasAlasFuture = executor.submit(() -> {
                return 0.5 * d1 * d2;
            });

            // Tunggu semua hasil perhitungan
            double volume = volumeFuture.get();
            double tinggiSegitiga1 = tinggiSegitiga1Future.get();
            double tinggiSegitiga2 = tinggiSegitiga2Future.get();
            double luasAlas = luasAlasFuture.get();

            // Hitung luas permukaan
            double luasSegitiga1 = 2 * (0.5 * d1 * tinggiSegitiga2);
            double luasSegitiga2 = 2 * (0.5 * d2 * tinggiSegitiga1);
            double luasPermukaan = luasAlas + luasSegitiga1 + luasSegitiga2;

            // Buat objek limas
            BelahKetupat limas = new LimasBelahKetupat(d1, d2, sisi, tinggiLimas);
            LimasBelahKetupat lBelahKetupatCast = (LimasBelahKetupat) limas;

            // Set nilai hasil perhitungan
            lBelahKetupatCast.volume = volume;
            lBelahKetupatCast.luasPermukaan = luasPermukaan;

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun   : " + limas.getNama());
            System.out.println("Diagonal 1    : " + d1);
            System.out.println("Diagonal 2    : " + d2);
            System.out.println("Sisi          : " + sisi);
            System.out.println("Tinggi Limas  : " + tinggiLimas);
            System.out.println("Volume        : " + lBelahKetupatCast.volume);
            System.out.println("Luas Permukaan: " + lBelahKetupatCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }

    private static void hitungPrismaLayangLayang(Scanner scanner, double d1, double d2, double sisiPendek, double sisiPanjang) {
        System.out.println("\n=== Menghitung Prisma Layang-Layang ===");
        System.out.print("Masukkan tinggi prisma: ");
        double tinggiPrisma = scanner.nextDouble();

        ExecutorService executor = Executors.newFixedThreadPool(3); // 3 thread untuk perhitungan paralel

        try {
            // Hitung volume secara paralel
            Future<Double> volumeFuture = executor.submit(() -> {
                double luasAlas = 0.5 * d1 * d2;
                return luasAlas * tinggiPrisma;
            });

            // Hitung keliling alas secara paralel
            Future<Double> kelilingAlasFuture = executor.submit(() -> {
                return 2 * (sisiPendek + sisiPanjang);
            });

            // Hitung luas sisi tegak secara paralel
            Future<Double> luasSisiTegakFuture = executor.submit(() -> {
                return 2 * (sisiPendek + sisiPanjang) * tinggiPrisma;
            });

            // Tunggu semua hasil perhitungan
            double volume = volumeFuture.get();
            double kelilingAlas = kelilingAlasFuture.get();
            double luasSisiTegak = luasSisiTegakFuture.get();

            // Hitung luas permukaan
            double luasAlasDanTutup = 2 * (0.5 * d1 * d2);
            double luasPermukaan = luasAlasDanTutup + luasSisiTegak;

            // Buat objek prisma
            LayangLayang prisma = new PrismaLayangLayang(d1, d2, sisiPendek, sisiPanjang, tinggiPrisma);
            PrismaLayangLayang pLayangLayangCast = (PrismaLayangLayang) prisma;

            // Set nilai hasil perhitungan
            pLayangLayangCast.volume = volume;
            pLayangLayangCast.luasPermukaan = luasPermukaan;

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun   : " + prisma.getNama());
            System.out.println("Diagonal 1    : " + d1);
            System.out.println("Diagonal 2    : " + d2);
            System.out.println("Sisi Pendek   : " + sisiPendek);
            System.out.println("Sisi Panjang  : " + sisiPanjang);
            System.out.println("Tinggi Prisma : " + tinggiPrisma);
            System.out.println("Volume        : " + pLayangLayangCast.volume);
            System.out.println("Luas Permukaan: " + pLayangLayangCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }


    private static void hitungLimasLayangLayang(Scanner scanner, double d1, double d2, double sisiPendek, double sisiPanjang) {
        System.out.println("\n=== Menghitung Limas Layang-Layang ===");
        System.out.print("Masukkan tinggi limas: ");
        double tinggiLimas = scanner.nextDouble();

        ExecutorService executor = Executors.newFixedThreadPool(4); // 4 thread untuk perhitungan kompleks

        try {
            // Hitung volume secara paralel
            Future<Double> volumeFuture = executor.submit(() -> {
                double luasAlas = 0.5 * d1 * d2;
                return (1.0/3) * luasAlas * tinggiLimas;
            });

            // Hitung tinggi segitiga sisi pendek secara paralel
            Future<Double> tinggiSegitigaPendekFuture = executor.submit(() -> {
                return Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(d1/2.0, 2));
            });

            // Hitung tinggi segitiga sisi panjang secara paralel
            Future<Double> tinggiSegitigaPanjangFuture = executor.submit(() -> {
                return Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(d2/2.0, 2));
            });

            // Hitung luas alas secara paralel
            Future<Double> luasAlasFuture = executor.submit(() -> {
                return 0.5 * d1 * d2;
            });

            // Tunggu semua hasil perhitungan
            double volume = volumeFuture.get();
            double tinggiSegitigaPendek = tinggiSegitigaPendekFuture.get();
            double tinggiSegitigaPanjang = tinggiSegitigaPanjangFuture.get();
            double luasAlas = luasAlasFuture.get();

            // Hitung luas permukaan
            double luasSegitigaPendek = 2 * (0.5 * sisiPendek * tinggiSegitigaPendek);
            double luasSegitigaPanjang = 2 * (0.5 * sisiPanjang * tinggiSegitigaPanjang);
            double luasPermukaan = luasAlas + luasSegitigaPendek + luasSegitigaPanjang;

            // Buat objek limas
            LayangLayang limas = new LimasLayangLayang(d1, d2, sisiPendek, sisiPanjang, tinggiLimas);
            LimasLayangLayang lLayangLayangCast = (LimasLayangLayang) limas;

            // Set nilai hasil perhitungan
            lLayangLayangCast.volume = volume;
            lLayangLayangCast.luasPermukaan = luasPermukaan;

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun   : " + limas.getNama());
            System.out.println("Diagonal 1    : " + d1);
            System.out.println("Diagonal 2    : " + d2);
            System.out.println("Sisi Pendek   : " + sisiPendek);
            System.out.println("Sisi Panjang  : " + sisiPanjang);
            System.out.println("Tinggi Limas  : " + tinggiLimas);
            System.out.println("Volume        : " + lLayangLayangCast.volume);
            System.out.println("Luas Permukaan: " + lLayangLayangCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }

    private static void hitungJuringLingkaran(Scanner scanner, double jariJari) {
        System.out.println("\n=== Menghitung Juring Lingkaran ===");
        System.out.print("Masukkan sudut juring (derajat): ");
        double sudut = scanner.nextDouble();

        Lingkaran juringLingkaran = new JuringLingkaran(jariJari, sudut);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun: " + juringLingkaran.getNama());
        System.out.println("Jari-jari  : " + jariJari);
        System.out.println("Sudut      : " + sudut + "°");

        JuringLingkaran jlCast = (JuringLingkaran) juringLingkaran;
        System.out.println("Luas       : " + jlCast.luasJuringLingkaran);
        System.out.println("Keliling   : " + jlCast.kelilingJuringLingkaran);
    }

    private static void hitungTemberengLingkaran(Scanner scanner, double jariJari) {
        System.out.println("\n=== Menghitung Tembereng Lingkaran ===");
        System.out.print("Masukkan panjang tali busur: ");
        double taliBusur = scanner.nextDouble();

        Lingkaran temberengLingkaran = new TemberengLingkaran(jariJari, taliBusur);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun: " + temberengLingkaran.getNama());
        System.out.println("Jari-jari  : " + jariJari);
        System.out.println("Tali Busur : " + taliBusur);

        TemberengLingkaran tlCast = (TemberengLingkaran) temberengLingkaran;
        System.out.println("Luas       : " + tlCast.luasTemberengLingkaran);
        System.out.println("Keliling   : " + tlCast.kelilingTemberengLingkaran);
    }

    private static void hitungBangunRuangLingkaran(Scanner scanner, double jariJari) {
        while (true) {
            System.out.println("\n=== Pilih Bangun Ruang Lingkaran ===");
            System.out.println("1. Tabung");
            System.out.println("2. Kerucut");
            System.out.println("3. Bola");
            System.out.println("4. Kembali ke menu lingkaran");
            System.out.print("Masukkan pilihan (1-4): ");

            int pilihan = scanner.nextInt();

            switch(pilihan) {
                case 1:
                    hitungTabung(scanner, jariJari);
                    break;
                case 2:
                    hitungKerucut(scanner, jariJari);
                    break;
                case 3:
                    hitungBola(scanner, jariJari);
                    break;
                case 4:
                    return; // Kembali ke menu lingkaran
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void hitungTabung(Scanner scanner, double jariJari) {
        System.out.println("\n=== Menghitung Tabung ===");
        System.out.print("Masukkan tinggi tabung: ");
        double tinggi = scanner.nextDouble();

        // Membuat thread pool dengan 2 thread
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            // Submit tugas penghitungan volume dan luas permukaan secara paralel
            Future<Double> volumeFuture = executor.submit(() -> {
                return Math.PI * Math.pow(jariJari, 2) * tinggi;
            });

            Future<Double> luasPermukaanFuture = executor.submit(() -> {
                return 2 * Math.PI * jariJari * (jariJari + tinggi);
            });

            // Membuat objek Tabung dengan hasil perhitungan
            Lingkaran tabung = new Tabung(jariJari, tinggi);
            Tabung tabungCast = (Tabung) tabung;

            // Mengambil hasil dari Future
            tabungCast.volume = volumeFuture.get();
            tabungCast.luasPermukaan = luasPermukaanFuture.get();

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun   : " + tabung.getNama());
            System.out.println("Volume        : " + tabungCast.volume);
            System.out.println("Luas Permukaan: " + tabungCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }

    private static void hitungKerucut(Scanner scanner, double jariJari) {
        System.out.println("\n=== Menghitung Kerucut ===");
        System.out.print("Masukkan tinggi kerucut: ");
        double tinggi = scanner.nextDouble();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            // Menghitung garis pelukis secara paralel
            Future<Double> garisPelukisFuture = executor.submit(() -> {
                return Math.sqrt(Math.pow(jariJari, 2) + Math.pow(tinggi, 2));
            });

            // Menghitung volume dan luas permukaan secara paralel
            Future<Double> volumeFuture = executor.submit(() -> {
                return (1.0/3) * Math.PI * Math.pow(jariJari, 2) * tinggi;
            });

            double garisPelukis = garisPelukisFuture.get();

            Future<Double> luasPermukaanFuture = executor.submit(() -> {
                return Math.PI * jariJari * (jariJari + garisPelukis);
            });

            Lingkaran kerucut = new Kerucut(jariJari, tinggi);
            Kerucut kerucutCast = (Kerucut) kerucut;

            kerucutCast.volume = volumeFuture.get();
            kerucutCast.luasPermukaan = luasPermukaanFuture.get();

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun   : " + kerucut.getNama());
            System.out.println("Volume        : " + kerucutCast.volume);
            System.out.println("Luas Permukaan: " + kerucutCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }

    private static void hitungKerucutTerpancung(Scanner scanner, double jariBawah, double tinggi) {
        System.out.println("\n=== Menghitung Kerucut Terpancung ===");
        System.out.print("Masukkan jari-jari atas: ");
        double jariAtas = scanner.nextDouble();

        // Menggunakan polymorphism dengan Lingkaran sebagai parent
        Kerucut kerucutTerpancung = new KerucutTerpancung(jariBawah, jariAtas, tinggi);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + kerucutTerpancung.getNama());

        // Untuk mengakses properti khusus KerucutTerpancung, kita perlu casting
        KerucutTerpancung ktCast = (KerucutTerpancung) kerucutTerpancung;
        System.out.println("Volume        : " + ktCast.volume);
        System.out.println("Luas Permukaan: " + ktCast.luasPermukaan);

        // Opsi untuk kembali
        System.out.print("\nTekan enter untuk kembali...");
        scanner.nextLine(); // Clear buffer
        scanner.nextLine(); // Tunggu input enter
    }

    private static void hitungBola(Scanner scanner, double jariJari) {
        System.out.println("\n=== Menghitung Bola ===");

        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            Future<Double> volumeFuture = executor.submit(() -> {
                return (4.0/3) * Math.PI * Math.pow(jariJari, 3);
            });

            Future<Double> luasPermukaanFuture = executor.submit(() -> {
                return 4 * Math.PI * Math.pow(jariJari, 2);
            });

            Lingkaran bola = new Bola(jariJari);
            Bola bolaCast = (Bola) bola;

            bolaCast.volume = volumeFuture.get();
            bolaCast.luasPermukaan = luasPermukaanFuture.get();

            System.out.println("\nHasil Perhitungan:");
            System.out.println("Nama Bangun   : " + bola.getNama());
            System.out.println("Jari-jari     : " + jariJari);
            System.out.println("Volume        : " + bolaCast.volume);
            System.out.println("Luas Permukaan: " + bolaCast.luasPermukaan);

        } catch (Exception e) {
            System.out.println("Error dalam perhitungan: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }

    private static void hitungTemberengBola(Scanner scanner, double jariJari) {
        System.out.println("\n=== Menghitung Tembereng Bola ===");
        System.out.print("Masukkan tinggi tembereng: ");
        double tinggi = scanner.nextDouble();

        Bola temberengBola = new TemberengBola(jariJari, tinggi);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + temberengBola.getNama());
        System.out.println("Volume        : " + temberengBola.volume);
        System.out.println("Luas Permukaan: " + temberengBola.luasPermukaan);

        // Opsi untuk kembali
        System.out.print("\nTekan enter untuk kembali ke menu bola...");
        scanner.nextLine(); // Clear buffer
        scanner.nextLine(); // Tunggu input enter
    }

    private static void hitungJuringBola(Scanner scanner, double jariJari) {
        System.out.println("\n=== Menghitung Juring Bola ===");
        System.out.print("Masukkan sudut juring (derajat): ");
        double sudut = scanner.nextDouble();

        Bola juringBola = new JuringBola(jariJari, sudut);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + juringBola.getNama());
        System.out.println("Volume        : " + juringBola.volume);
        System.out.println("Luas Permukaan: " + juringBola.luasPermukaan);

        // Opsi untuk kembali
        System.out.print("\nTekan enter untuk kembali ke menu bola...");
        scanner.nextLine(); // Clear buffer
        scanner.nextLine(); // Tunggu input enter
    }

    private static void hitungCincinBola(Scanner scanner, double jariJari) {
        System.out.println("\n=== Menghitung Cincin Bola ===");
        System.out.print("Masukkan jari-jari bidang paralel: ");
        double jariParalel = scanner.nextDouble();

        Bola cincinBola = new CincinBola(jariJari, jariParalel);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + cincinBola.getNama());
        System.out.println("Volume        : " + cincinBola.volume);
        System.out.println("Luas Permukaan: " + cincinBola.luasPermukaan);
        // Opsi untuk kembali
        System.out.print("\nTekan enter untuk kembali ke menu bola...");
        scanner.nextLine(); // Clear buffer
        scanner.nextLine(); // Tunggu input enter
    }
}