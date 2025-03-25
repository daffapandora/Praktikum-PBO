package PBO.PrakSesi5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Nama File   : Manusia.java
 * Deskripsi   : Abstract class untuk pelaporan pajak tahunan.
 * Pembuat     : Daffa Pandora El-farisin / 24060123140185
 * Tanggal     : 23 Maret 2025
 */

public abstract class Manusia {
    // Atribut umum
    private String nama;
    private LocalDate tglMulaiKerja;
    private String alamat;
    private double pendapatan;
    
    // Counter statis untuk semua manusia
    private static int counterMns = 0;
    
    // DateTimeFormatter untuk parsing tanggal dengan format "dd-MM-yyyy"
    protected static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
    // Constructor
    public Manusia(String nama, String tglMulaiKerja, String alamat, double pendapatan) {
        this.nama = nama;
        this.tglMulaiKerja = LocalDate.parse(tglMulaiKerja, formatter);
        this.alamat = alamat;
        this.pendapatan = pendapatan;
        counterMns++;
    }
    
    // Constructor tanpa alamat (bisa di-set kemudian via setter)
    public Manusia(String nama, String tglMulaiKerja, double pendapatan) {
        this(nama, tglMulaiKerja, "", pendapatan);
    }
    
    // Selektor dan Mutator
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public LocalDate getTglMulaiKerja() {
        return tglMulaiKerja;
    }
    
    public void setTglMulaiKerja(String tglMulaiKerja) {
        this.tglMulaiKerja = LocalDate.parse(tglMulaiKerja, formatter);
    }
    
    public String getAlamat() {
        return alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public double getPendapatan() {
        return pendapatan;
    }
    
    public void setPendapatan(double pendapatan) {
        this.pendapatan = pendapatan;
    }
    
    public static int getCounterMns() {
        return counterMns;
    }
    
    // Menghitung masa kerja dalam tahun dari tglMulaiKerja hingga hari ini
    public long hitungMasaKerja() {
        LocalDate sekarang = LocalDate.now();
        return ChronoUnit.YEARS.between(this.tglMulaiKerja, sekarang);
    }
    
    // Method abstrak untuk menghitung pajak
    public abstract double hitungPajak();
    
    // Mencetak informasi lengkap tentang objek
    public void cetakInfo() {
        System.out.println("Nama           : " + nama);
        System.out.println("Tanggal Mulai  : " + tglMulaiKerja.format(formatter));
        System.out.println("Alamat         : " + alamat);
        System.out.println("Pendapatan     : Rp " + pendapatan);
        System.out.println("Masa Kerja     : " + hitungMasaKerja() + " tahun");
    }
}
