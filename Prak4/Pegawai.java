package PBO.Prak4;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
 
public class Pegawai {
    // Atribut dengan access modifier protected
    protected String nip;
    protected String nama;
    protected LocalDate tanggalLahir;
    protected LocalDate tmt;
    protected double gajiPokok;
     
    // Static counter untuk menghitung jumlah objek Pegawai
    protected static int counterPegawai = 0;
     
    // Constructor default
    public Pegawai() {
        counterPegawai++;
    }
     
     // Constructor dengan parameter
     public Pegawai(String nip, String nama, LocalDate tanggalLahir, LocalDate tmt, double gajiPokok) {
         this.nip = nip;
         this.nama = nama;
         this.tanggalLahir = tanggalLahir;
         this.tmt = tmt;
         this.gajiPokok = gajiPokok;
         counterPegawai++;
     }
     
     // Getter dan Setter (Selektor dan Mutator)
     public String getNip() {
         return nip;
     }
     
     public void setNip(String nip) {
         this.nip = nip;
     }
     
     public String getNama() {
         return nama;
     }
     
     public void setNama(String nama) {
         this.nama = nama;
     }
     
     public LocalDate getTanggalLahir() {
         return tanggalLahir;
     }
     
     public void setTanggalLahir(LocalDate tanggalLahir) {
         this.tanggalLahir = tanggalLahir;
     }
     
     public LocalDate getTmt() {
         return tmt;
     }
     
     public void setTmt(LocalDate tmt) {
         this.tmt = tmt;
     }
     
     public double getGajiPokok() {
         return gajiPokok;
     }
     
     public void setGajiPokok(double gajiPokok) {
         this.gajiPokok = gajiPokok;
     }
     
     // Method untuk menghitung masa kerja
     public Period hitungMasaKerja() {
         return Period.between(tmt, LocalDate.now());
     }
     
     // Method untuk menghitung masa kerja dalam tahun (untuk perhitungan tunjangan)
     public int hitungMasaKerjaTahun() {
         return hitungMasaKerja().getYears();
     }
     
     // Method untuk format tanggal menjadi string (contoh: 5 Mei 1990)
     public String formatTanggal(LocalDate tanggal) {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
         return tanggal.format(formatter);
     }
     
     // Method untuk format masa kerja (contoh: 10 tahun 2 bulan)
     public String formatMasaKerja() {
         Period period = hitungMasaKerja();
         return period.getYears() + " tahun " + period.getMonths() + " bulan";
     }
     
     // Method untuk menghitung tunjangan (akan di-override oleh subclass)
     public double hitungTunjangan() {
         return 0.0;
     }
     
     // Method untuk menampilkan informasi pegawai
     public void printInfo() {
         System.out.println("NIP : " + nip);
         System.out.println("Nama : " + nama);
         System.out.println("Tanggal Lahir : " + formatTanggal(tanggalLahir));
         System.out.println("TMT : " + formatTanggal(tmt));
         System.out.println("Masa Kerja : " + formatMasaKerja());
         System.out.println("Gaji Pokok : Rp " + String.format("%,.2f", gajiPokok));
     }
     
     // Static method untuk menampilkan jumlah pegawai
     public static void printCounterPegawai() {
         System.out.println("Jumlah Pegawai: " + counterPegawai);
     }
 }