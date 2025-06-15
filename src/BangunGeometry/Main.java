package BangunGeometry;

import java.util.Scanner;

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

        Persegi limas = new LimasPersegi(sisi, tinggiLimas);  // Polymorphism

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + limas.getNama());
        System.out.println("Sisi Alas     : " + sisi);
        System.out.println("Tinggi Limas  : " + tinggiLimas);

        // Downcasting untuk akses atribut khusus
        LimasPersegi limasCast = (LimasPersegi) limas;
        System.out.println("Volume        : " + limasCast.volume);
        System.out.println("Luas Permukaan: " + limasCast.luasPermukaan);
    }

    private static void hitungPrismaPersegi(Scanner scanner, double sisi) {
        System.out.println("\n=== Menghitung Prisma Persegi ===");
        System.out.print("Masukkan tinggi prisma: ");
        double tinggiPrisma = scanner.nextDouble();

        Persegi prisma = new PrismaPersegi(sisi, tinggiPrisma);  // Polymorphism

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + prisma.getNama());
        System.out.println("Sisi Alas     : " + sisi);
        System.out.println("Tinggi Prisma : " + tinggiPrisma);

        // Downcasting untuk mengakses atribut khusus child
        PrismaPersegi pPersegiCast = (PrismaPersegi) prisma;
        System.out.println("Volume        : " + pPersegiCast.volume);
        System.out.println("Luas Permukaan: " + pPersegiCast.luasPermukaan);
    }


    private static void hitungLimasPersegiPanjang(Scanner scanner, double panjang, double lebar) {
        System.out.println("\n=== Menghitung Limas Persegi Panjang ===");
        System.out.print("Masukkan tinggi limas: ");
        double tinggiLimas = scanner.nextDouble();

        PersegiPanjang limas = new LimasPersegiPanjang(panjang, lebar, tinggiLimas);  // Polymorphism

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + limas.getNama());
        System.out.println("Panjang Alas  : " + panjang);
        System.out.println("Lebar Alas    : " + lebar);
        System.out.println("Tinggi Limas  : " + tinggiLimas);

        // Downcasting
        LimasPersegiPanjang lPersegiPanjangCast = (LimasPersegiPanjang) limas;
        System.out.println("Volume        : " + lPersegiPanjangCast.volume);
        System.out.println("Luas Permukaan: " + lPersegiPanjangCast.luasPermukaan);
    }


    private static void hitungPrismaPersegiPanjang(Scanner scanner, double panjang, double lebar) {
        System.out.println("\n=== Menghitung Prisma Persegi Panjang ===");
        System.out.print("Masukkan tinggi prisma: ");
        double tinggiPrisma = scanner.nextDouble();

        // Polymorphism
        PersegiPanjang prisma = new PrismaPersegiPanjang(panjang, lebar, tinggiPrisma);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + prisma.getNama());
        System.out.println("Panjang Alas  : " + panjang);
        System.out.println("Lebar Alas    : " + lebar);
        System.out.println("Tinggi Prisma : " + tinggiPrisma);

        // Downcasting
        PrismaPersegiPanjang pPersegiCast = (PrismaPersegiPanjang) prisma;
        System.out.println("Volume        : " + pPersegiCast.volume);
        System.out.println("Luas Permukaan: " + pPersegiCast.luasPermukaan);
    }


    private static void hitungLimasSegitiga(Scanner scanner, double alas, double tinggi, double sisiA, double sisiB, double sisiC) {
        System.out.println("\n=== Menghitung Limas Segitiga ===");
        System.out.print("Masukkan tinggi limas: ");
        double tinggiLimas = scanner.nextDouble();

        // Polymorphism
        Segitiga limas = new LimasSegitiga(alas, tinggi, sisiA, sisiB, sisiC, tinggiLimas);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun    : " + limas.getNama());
        System.out.println("Alas Segitiga  : " + alas);
        System.out.println("Tinggi Segitiga: " + tinggi);
        System.out.println("Sisi A         : " + sisiA);
        System.out.println("Sisi B         : " + sisiB);
        System.out.println("Sisi C         : " + sisiC);
        System.out.println("Tinggi Limas   : " + tinggiLimas);

        // Downcasting
        LimasSegitiga lSegitigaCast = (LimasSegitiga) limas;
        System.out.println("Volume         : " + lSegitigaCast.volume);
        System.out.println("Luas Permukaan : " + lSegitigaCast.luasPermukaan);
    }


    private static void hitungPrismaSegitiga(Scanner scanner, double alas, double tinggi, double sisiA, double sisiB, double sisiC) {
        System.out.println("\n=== Menghitung Prisma Segitiga ===");
        System.out.print("Masukkan tinggi prisma: ");
        double tinggiPrisma = scanner.nextDouble();

        Segitiga prisma = new PrismaSegitiga(alas, tinggi, sisiA, sisiB, sisiC, tinggiPrisma);  // Polymorphism

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun    : " + prisma.getNama());
        System.out.println("Alas Segitiga  : " + alas);
        System.out.println("Tinggi Segitiga: " + tinggi);
        System.out.println("Sisi A         : " + sisiA);
        System.out.println("Sisi B         : " + sisiB);
        System.out.println("Sisi C         : " + sisiC);
        System.out.println("Tinggi Prisma  : " + tinggiPrisma);

        // Downcasting
        PrismaSegitiga pSegitigaCast = (PrismaSegitiga) prisma;
        System.out.println("Volume         : " + pSegitigaCast.volume);
        System.out.println("Luas Permukaan : " + pSegitigaCast.luasPermukaan);
    }


    private static void hitungPrismaJajarGenjang(Scanner scanner, double alas, double tinggi, double sisiMiring) {
        System.out.println("\n=== Menghitung Prisma Jajar Genjang ===");
        System.out.print("Masukkan tinggi prisma: ");
        double tinggiPrisma = scanner.nextDouble();

        // Polymorphism: menggunakan referensi superclass JajarGenjang
        JajarGenjang prisma = new PrismaJajarGenjang(alas, tinggi, sisiMiring, tinggiPrisma);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + prisma.getNama());
        System.out.println("Alas          : " + alas);
        System.out.println("Tinggi        : " + tinggi);
        System.out.println("Sisi Miring   : " + sisiMiring);
        System.out.println("Tinggi Prisma : " + tinggiPrisma);

        // Downcasting agar bisa akses volume & luasPermukaan
        PrismaJajarGenjang pJajarCast = (PrismaJajarGenjang) prisma;
        System.out.println("Volume        : " + pJajarCast.volume);
        System.out.println("Luas Permukaan: " + pJajarCast.luasPermukaan);
    }


    private static void hitungLimasJajarGenjang(Scanner scanner, double alas, double tinggi, double sisiMiring) {
        System.out.println("\n=== Menghitung Limas Jajar Genjang ===");
        System.out.print("Masukkan tinggi limas: ");
        double tinggiLimas = scanner.nextDouble();

        // Polymorphism
        JajarGenjang limas = new LimasJajarGenjang(alas, tinggi, sisiMiring, tinggiLimas);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + limas.getNama());
        System.out.println("Alas          : " + alas);
        System.out.println("Tinggi        : " + tinggi);
        System.out.println("Sisi Miring   : " + sisiMiring);
        System.out.println("Tinggi Limas  : " + tinggiLimas);

        // Downcasting
        LimasJajarGenjang lJajarCast = (LimasJajarGenjang) limas;
        System.out.println("Volume        : " + lJajarCast.volume);
        System.out.println("Luas Permukaan: " + lJajarCast.luasPermukaan);
    }


    private static void hitungPrismaTrapesium(Scanner scanner, double sisiA, double sisiB, double tinggi, double sisiC, double sisiD) {
        System.out.println("\n=== Menghitung Prisma Trapesium ===");
        System.out.print("Masukkan tinggi prisma: ");
        double tinggiPrisma = scanner.nextDouble();

        // Polymorphism: menggunakan superclass Trapesium sebagai tipe referensi
        Trapesium prisma = new PrismaTrapesium(sisiA, sisiB, tinggi, sisiC, sisiD, tinggiPrisma);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun    : " + prisma.getNama());
        System.out.println("Sisi Sejajar A : " + sisiA);
        System.out.println("Sisi Sejajar B : " + sisiB);
        System.out.println("Tinggi Trapesium: " + tinggi);
        System.out.println("Sisi C         : " + sisiC);
        System.out.println("Sisi D         : " + sisiD);
        System.out.println("Tinggi Prisma  : " + tinggiPrisma);

        // Downcasting ke PrismaTrapesium untuk akses atribut volume dan luasPermukaan
        PrismaTrapesium pTrapesiumCast = (PrismaTrapesium) prisma;
        System.out.println("Volume         : " + pTrapesiumCast.volume);
        System.out.println("Luas Permukaan : " + pTrapesiumCast.luasPermukaan);
    }


    private static void hitungLimasTrapesium(Scanner scanner, double sisiA, double sisiB, double tinggi, double sisiC, double sisiD) {
        System.out.println("\n=== Menghitung Limas Trapesium ===");
        System.out.print("Masukkan tinggi limas: ");
        double tinggiLimas = scanner.nextDouble();

        // Polymorphism
        Trapesium limas = new LimasTrapesium(sisiA, sisiB, tinggi, sisiC, sisiD, tinggiLimas);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun    : " + limas.getNama());
        System.out.println("Sisi Sejajar A : " + sisiA);
        System.out.println("Sisi Sejajar B : " + sisiB);
        System.out.println("Tinggi Trapesium: " + tinggi);
        System.out.println("Sisi C         : " + sisiC);
        System.out.println("Sisi D         : " + sisiD);
        System.out.println("Tinggi Limas   : " + tinggiLimas);

        // Downcasting
        LimasTrapesium lTrapesiumCast = (LimasTrapesium) limas;
        System.out.println("Volume         : " + lTrapesiumCast.volume);
        System.out.println("Luas Permukaan : " + lTrapesiumCast.luasPermukaan);
    }


    private static void hitungPrismaBelahKetupat(Scanner scanner, double d1, double d2, double sisi) {
        System.out.println("\n=== Menghitung Prisma Belah Ketupat ===");
        System.out.print("Masukkan tinggi prisma: ");
        double tinggiPrisma = scanner.nextDouble();

        // Polymorphism: deklarasi pakai superclass
        BelahKetupat prisma = new PrismaBelahKetupat(d1, d2, sisi, tinggiPrisma);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + prisma.getNama());
        System.out.println("Diagonal 1    : " + d1);
        System.out.println("Diagonal 2    : " + d2);
        System.out.println("Sisi          : " + sisi);
        System.out.println("Tinggi Prisma : " + tinggiPrisma);

        // Downcasting agar bisa akses atribut spesifik dari PrismaBelahKetupat
        PrismaBelahKetupat pBelahKetupatCast = (PrismaBelahKetupat) prisma;
        System.out.println("Volume        : " + pBelahKetupatCast.volume);
        System.out.println("Luas Permukaan: " + pBelahKetupatCast.luasPermukaan);
    }


    private static void hitungLimasBelahKetupat(Scanner scanner, double d1, double d2, double sisi) {
        System.out.println("\n=== Menghitung Limas Belah Ketupat ===");
        System.out.print("Masukkan tinggi limas: ");
        double tinggiLimas = scanner.nextDouble();

        // Polymorphism
        BelahKetupat limas = new LimasBelahKetupat(d1, d2, sisi, tinggiLimas);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + limas.getNama());
        System.out.println("Diagonal 1    : " + d1);
        System.out.println("Diagonal 2    : " + d2);
        System.out.println("Sisi          : " + sisi);
        System.out.println("Tinggi Limas  : " + tinggiLimas);

        // Downcasting
        LimasBelahKetupat lBelahKetupatCast = (LimasBelahKetupat) limas;
        System.out.println("Volume        : " + lBelahKetupatCast.volume);
        System.out.println("Luas Permukaan: " + lBelahKetupatCast.luasPermukaan);
    }


    private static void hitungPrismaLayangLayang(Scanner scanner, double d1, double d2, double sisiA, double sisiB) {
        System.out.println("\n=== Menghitung Prisma Layang-Layang ===");
        System.out.print("Masukkan tinggi prisma: ");
        double tinggiPrisma = scanner.nextDouble();

        // Gunakan polymorphism: deklarasikan dengan tipe superclass
        LayangLayang prisma = new PrismaLayangLayang(d1, d2, sisiA, sisiB, tinggiPrisma);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + prisma.getNama());
        System.out.println("Diagonal 1    : " + d1);
        System.out.println("Diagonal 2    : " + d2);
        System.out.println("Sisi Pendek   : " + sisiA);
        System.out.println("Sisi Panjang  : " + sisiB);
        System.out.println("Tinggi Prisma : " + tinggiPrisma);

        // Lakukan downcasting untuk mengakses atribut spesifik subclass
        PrismaLayangLayang pLayangLayangCast = (PrismaLayangLayang) prisma;
        System.out.println("Volume        : " + pLayangLayangCast.volume);
        System.out.println("Luas Permukaan: " + pLayangLayangCast.luasPermukaan);
    }


    private static void hitungLimasLayangLayang(Scanner scanner, double d1, double d2, double sisiA, double sisiB) {
        System.out.println("\n=== Menghitung Limas Layang-Layang ===");
        System.out.print("Masukkan tinggi limas: ");
        double tinggiLimas = scanner.nextDouble();

        LayangLayang limas = new LimasLayangLayang(d1, d2, sisiA, sisiB, tinggiLimas);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + limas.getNama());
        System.out.println("Diagonal 1    : " + d1);
        System.out.println("Diagonal 2    : " + d2);
        System.out.println("Sisi Pendek   : " + sisiA);
        System.out.println("Sisi Panjang  : " + sisiB);
        System.out.println("Tinggi Limas  : " + tinggiLimas);

        LimasLayangLayang lLayangLayangCast = (LimasLayangLayang) limas;
        System.out.println("Volume        : " + lLayangLayangCast.volume);
        System.out.println("Luas Permukaan: " + lLayangLayangCast.luasPermukaan);
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

        // Menggunakan polymorphism dengan Lingkaran sebagai parent
        Lingkaran tabung = new Tabung(jariJari, tinggi);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + tabung.getNama());

        // Untuk mengakses properti khusus Tabung, kita perlu casting
        Tabung tabungCast = (Tabung) tabung;
        System.out.println("Volume        : " + tabungCast.volume);
        System.out.println("Luas Permukaan: " + tabungCast.luasPermukaan);
    }

    private static void hitungKerucut(Scanner scanner, double jariJari) {
        System.out.println("\n=== Menghitung Kerucut ===");
        System.out.print("Masukkan tinggi kerucut: ");
        double tinggi = scanner.nextDouble();

        // Menggunakan polymorphism dengan Lingkaran sebagai parent
        Lingkaran kerucut = new Kerucut(jariJari, tinggi);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + kerucut.getNama());

        // Untuk mengakses properti khusus Kerucut, kita perlu casting
        Kerucut kerucutCast = (Kerucut) kerucut;
        System.out.println("Volume        : " + kerucutCast.volume);
        System.out.println("Luas Permukaan: " + kerucutCast.luasPermukaan);

        // Opsi lanjutan untuk kerucut terpancung dengan pilihan lebih jelas
        while (true) {
            System.out.println("\nPilih opsi lanjutan:");
            System.out.println("1. Hitung Kerucut Terpancung");
            System.out.println("2. Kembali ke menu bangun ruang");
            System.out.print("Masukkan pilihan (1-2): ");

            int pilihan = scanner.nextInt();

            switch(pilihan) {
                case 1:
                    hitungKerucutTerpancung(scanner, jariJari, tinggi);
                    break;
                case 2:
                    return; // Kembali ke menu bangun ruang
                default:
                    System.out.println("Pilihan tidak valid.");
            }
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

        Lingkaran bola = new Bola(jariJari);

        System.out.println("\nHasil Perhitungan:");
        System.out.println("Nama Bangun   : " + bola.getNama());
        System.out.println("Jari-jari     : " + jariJari);

        Bola ktCast = (Bola) bola;
        System.out.println("Volume        : " + ktCast.volume);
        System.out.println("Luas Permukaan: " + ktCast.luasPermukaan);

        // Opsi lanjutan untuk bagian bola
        while (true) {
            System.out.println("\nPilih opsi lanjutan:");
            System.out.println("1. Hitung Tembereng Bola");
            System.out.println("2. Hitung Juring Bola");
            System.out.println("3. Hitung Cincin Bola");
            System.out.println("4. Kembali ke menu bangun ruang");
            System.out.print("Masukkan pilihan (1-4): ");

            int pilihan = scanner.nextInt();

            switch(pilihan) {
                case 1:
                    hitungTemberengBola(scanner, jariJari);
                    break;
                case 2:
                    hitungJuringBola(scanner, jariJari);
                    break;
                case 3:
                    hitungCincinBola(scanner, jariJari);
                    break;
                case 4:
                    return; // Kembali ke menu bangun ruang
                default:
                    System.out.println("Pilihan tidak valid.");
            }
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