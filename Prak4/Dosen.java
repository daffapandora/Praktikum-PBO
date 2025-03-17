package PBO.Prak4;

/**
 * File: Dosen.java
 * Deskripsi: Class Dosen sebagai subclass dari Pegawai dan superclass untuk DosenTetap dan DosenTamu
 * Tanggal: 17 Maret 2025
 */

 import java.time.LocalDate;

 public class Dosen extends Pegawai {
     // Atribut tambahan untuk class Dosen
     protected String fakultas;
     
     // Static counter untuk menghitung jumlah objek Dosen
     protected static int counterDosen = 0;
     
     // Constructor default
     public Dosen() {
         super();
         counterDosen++;
     }
     
     // Constructor dengan parameter
     public Dosen(String nip, String nama, LocalDate tanggalLahir, LocalDate tmt, double gajiPokok, String fakultas) {
         super(nip, nama, tanggalLahir, tmt, gajiPokok);
         this.fakultas = fakultas;
         counterDosen++;
     }
     
     // Getter dan Setter (Selektor dan Mutator)
     public String getFakultas() {
         return fakultas;
     }
     
     public void setFakultas(String fakultas) {
         this.fakultas = fakultas;
     }
     
     // Override method printInfo
     @Override
     public void printInfo() {
         super.printInfo();
         System.out.println("Fakultas : " + fakultas);
     }
     
     // Static method untuk menampilkan jumlah dosen
     public static void printCounterDosen() {
         System.out.println("Jumlah Dosen: " + counterDosen);
     }
 }