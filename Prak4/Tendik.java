package PBO.Prak4;

/**
 * File: Tendik.java
 * Deskripsi: Class Tendik sebagai subclass dari Pegawai
 * Tanggal: 17 Maret 2025
 */

 import java.time.LocalDate;

 public class Tendik extends Pegawai {
     // Atribut tambahan untuk class Tendik
     private String bidang; // Akademik, Kemahasiswaan, atau Sumber Daya
     private static final int BUP_TAHUN = 55;
     
     // Static counter untuk menghitung jumlah objek Tendik
     private static int counterTendik = 0;
     
     // Constructor default
     public Tendik() {
         super();
         counterTendik++;
     }
     
     // Constructor dengan parameter
     public Tendik(String nip, String nama, LocalDate tanggalLahir, LocalDate tmt, double gajiPokok, String bidang) {
         super(nip, nama, tanggalLahir, tmt, gajiPokok);
         this.bidang = bidang;
         counterTendik++;
     }
     
     // Getter dan Setter (Selektor dan Mutator)
     public String getBidang() {
         return bidang;
     }
     
     public void setBidang(String bidang) {
         this.bidang = bidang;
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
         // Tendik mendapat tunjangan 1% x masa kerja (dalam tahun) x gaji pokok
         return 0.01 * hitungMasaKerjaTahun() * gajiPokok;
     }
     
     // Override method printInfo
     @Override
     public void printInfo() {
         System.out.println("NIP : " + nip);
         System.out.println("Nama : " + nama);
         System.out.println("Tanggal Lahir : " + formatTanggal(tanggalLahir));
         System.out.println("TMT : " + formatTanggal(tmt));
         System.out.println("Jabatan : Tenaga Kependidikan");
         System.out.println("Bidang : " + bidang);
         System.out.println("Masa Kerja : " + formatMasaKerja());
         System.out.println("BUP : " + formatTanggal(hitungBUP()));
         System.out.println("Gaji Pokok : Rp " + String.format("%,.2f", gajiPokok));
         
         double tunjangan = hitungTunjangan();
         System.out.println("Tunjangan : 1% x " + hitungMasaKerjaTahun() + " x Rp " + 
                           String.format("%,.2f", gajiPokok) + " = Rp. " + 
                           String.format("%,.2f", tunjangan));
     }
     
     // Static method untuk menampilkan jumlah tendik
     public static void printCounterTendik() {
         System.out.println("Jumlah Tenaga Kependidikan: " + counterTendik);
     }
 }