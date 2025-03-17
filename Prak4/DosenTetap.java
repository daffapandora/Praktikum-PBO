package PBO.Prak4;

/**
 * File: DosenTetap.java
 * Deskripsi: Class DosenTetap sebagai subclass dari Dosen
 * Tanggal: 17 Maret 2025
 */

 import java.time.LocalDate;
 
 public class DosenTetap extends Dosen {
     // Atribut tambahan untuk class DosenTetap
     private String nidn;
     private static final int BUP_TAHUN = 65;
     
     // Static counter untuk menghitung jumlah objek DosenTetap
     private static int counterDosenTetap = 0;
     
     // Constructor default
     public DosenTetap() {
         super();
         counterDosenTetap++;
     }
     
     // Constructor dengan parameter
     public DosenTetap(String nip, String nama, LocalDate tanggalLahir, LocalDate tmt, double gajiPokok, 
                      String fakultas, String nidn) {
         super(nip, nama, tanggalLahir, tmt, gajiPokok, fakultas);
         this.nidn = nidn;
         counterDosenTetap++;
     }
     
     // Getter dan Setter (Selektor dan Mutator)
     public String getNidn() {
         return nidn;
     }
     
     public void setNidn(String nidn) {
         this.nidn = nidn;
     }
     
     // Method untuk menghitung BUP
     public LocalDate hitungBUP() {
         // BUP jatuh pada tanggal 1 bulan berikutnya dari tanggal lahir ditambah usia BUP
         return tanggalLahir.plusYears(BUP_TAHUN)
                           .withDayOfMonth(1)
                           .plusMonths(1);
     }
     
     // Override method hitungTunjangan
     @Override
     public double hitungTunjangan() {
         // Dosen tetap mendapat tunjangan 2% x masa kerja (dalam tahun) x gaji pokok
         return 0.02 * hitungMasaKerjaTahun() * gajiPokok;
     }
     
     // Override method printInfo
     @Override
     public void printInfo() {
         System.out.println("NIP : " + nip);
         System.out.println("NIDN : " + nidn);
         System.out.println("Nama : " + nama);
         System.out.println("Tanggal Lahir : " + formatTanggal(tanggalLahir));
         System.out.println("TMT : " + formatTanggal(tmt));
         System.out.println("Jabatan : Dosen Tetap");
         System.out.println("Fakultas : " + fakultas);
         System.out.println("Masa Kerja : " + formatMasaKerja());
         System.out.println("BUP : " + formatTanggal(hitungBUP()));
         System.out.println("Gaji Pokok : Rp " + String.format("%,.2f", gajiPokok));
         
         double tunjangan = hitungTunjangan();
         System.out.println("Tunjangan : 2% x " + hitungMasaKerjaTahun() + " x Rp " + 
                            String.format("%,.2f", gajiPokok) + " = Rp. " + 
                            String.format("%,.2f", tunjangan));
     }
     
     // Static method untuk menampilkan jumlah dosen tetap
     public static void printCounterDosenTetap() {
         System.out.println("Jumlah Dosen Tetap: " + counterDosenTetap);
     }
 }