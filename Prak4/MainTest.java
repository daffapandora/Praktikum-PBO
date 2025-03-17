package PBO.Prak4;

/**
 * File: MainTest.java
 * Deskripsi: Class utama untuk testing semua class pegawai
 * Tanggal: 17 Maret 2025
 */

 import java.time.LocalDate;

 public class MainTest {
     public static void main(String[] args) {
         // Membuat objek DosenTetap
         DosenTetap dosenTetap = new DosenTetap(
             "9545647548", 
             "Andi", 
             LocalDate.of(1990, 5, 5), 
             LocalDate.of(2015, 1, 1), 
             5000000.0, 
             "Fakultas Sains dan Matematika", 
             "78647324"
         );
         
         // Membuat objek DosenTamu
         DosenTamu dosenTamu = new DosenTamu(
             "9545647549", 
             "Budi", 
             LocalDate.of(1985, 8, 15), 
             LocalDate.of(2020, 2, 1), 
             4500000.0, 
             "Fakultas Teknik", 
             "78647325", 
             LocalDate.of(2026, 5, 1)
         );
         
         // Membuat objek Tendik
         Tendik tendik = new Tendik(
             "9545647550", 
             "Cindy", 
             LocalDate.of(1988, 3, 20), 
             LocalDate.of(2018, 4, 1), 
             3500000.0, 
             "Akademik"
         );
         
         // Menampilkan informasi semua pegawai
         System.out.println("=========== INFORMASI DOSEN TETAP ===========");
         dosenTetap.printInfo();
         
         System.out.println("\n=========== INFORMASI DOSEN TAMU ===========");
         dosenTamu.printInfo();
         
         System.out.println("\n=========== INFORMASI TENDIK ===========");
         tendik.printInfo();
         
         // Menampilkan jumlah pegawai
         System.out.println("\n=========== JUMLAH PEGAWAI ===========");
         Pegawai.printCounterPegawai();
         Dosen.printCounterDosen();
         DosenTetap.printCounterDosenTetap();
         DosenTamu.printCounterDosenTamu();
         Tendik.printCounterTendik();
     }
 }