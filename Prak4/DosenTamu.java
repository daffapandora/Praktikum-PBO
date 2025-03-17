package PBO.Prak4;

/**
 * File: DosenTamu.java
 * Deskripsi: Class DosenTamu sebagai subclass dari Dosen
 * Tanggal: 17 Maret 2025
 */

 import java.time.LocalDate;
 import java.time.Period;
 
 public class DosenTamu extends Dosen {
     // Atribut tambahan untuk class DosenTamu
     private String nidk;
     private LocalDate tanggalBerakhirKontrak;
     
     // Static counter untuk menghitung jumlah objek DosenTamu
     private static int counterDosenTamu = 0;
     
     // Constructor default
     public DosenTamu() {
         super();
         counterDosenTamu++;
     }
     
     // Constructor dengan parameter
     public DosenTamu(String nip, String nama, LocalDate tanggalLahir, LocalDate tmt, double gajiPokok, 
                      String fakultas, String nidk, LocalDate tanggalBerakhirKontrak) {
         super(nip, nama, tanggalLahir, tmt, gajiPokok, fakultas);
         this.nidk = nidk;
         this.tanggalBerakhirKontrak = tanggalBerakhirKontrak;
         counterDosenTamu++;
     }
     
     // Getter dan Setter (Selektor dan Mutator)
     public String getNidk() {
         return nidk;
     }
     
     public void setNidk(String nidk) {
         this.nidk = nidk;
     }
     
     public LocalDate getTanggalBerakhirKontrak() {
         return tanggalBerakhirKontrak;
     }
     
     public void setTanggalBerakhirKontrak(LocalDate tanggalBerakhirKontrak) {
         this.tanggalBerakhirKontrak = tanggalBerakhirKontrak;
     }
     
     // Method untuk menghitung sisa masa kontrak
     public Period hitungSisaMasaKontrak() {
         return Period.between(LocalDate.now(), tanggalBerakhirKontrak);
     }
     
     // Method untuk format sisa masa kontrak
     public String formatSisaMasaKontrak() {
         Period period = hitungSisaMasaKontrak();
         return period.getYears() + " tahun " + period.getMonths() + " bulan";
     }
     
     // Override method hitungTunjangan
     @Override
     public double hitungTunjangan() {
         // Dosen tamu mendapat tunjangan 2,5% x gaji pokok
         return 0.025 * gajiPokok;
     }
     
     // Override method printInfo
     @Override
     public void printInfo() {
         System.out.println("NIP : " + nip);
         System.out.println("NIDK : " + nidk);
         System.out.println("Nama : " + nama);
         System.out.println("Tanggal Lahir : " + formatTanggal(tanggalLahir));
         System.out.println("TMT : " + formatTanggal(tmt));
         System.out.println("Jabatan : Dosen Tamu");
         System.out.println("Fakultas : " + fakultas);
         System.out.println("Masa Kerja : " + formatMasaKerja());
         System.out.println("Masa Kontrak Berakhir : " + formatSisaMasaKontrak());
         System.out.println("Gaji Pokok : Rp " + String.format("%,.2f", gajiPokok));
         
         double tunjangan = hitungTunjangan();
         System.out.println("Tunjangan : 2,5% x Rp " + String.format("%,.2f", gajiPokok) + 
                            " = Rp. " + String.format("%,.2f", tunjangan));
     }
     
     // Static method untuk menampilkan jumlah dosen tamu
     public static void printCounterDosenTamu() {
         System.out.println("Jumlah Dosen Tamu: " + counterDosenTamu);
     }
 }