package PBO.Responsi;

/**
 * Nama File   : Karyawan.java
 * Deskripsi   : Kelas Karyawan yang meng-extend CivitasAkademika.
 * Pembuat     : Daffa Pandora El-farisin / 24060123140185
 * Tanggal     : 25 Maret 2025
 */


public abstract class Karyawan extends CivitasAkademika {
    // Atribut khusus
    private String NIP;
    private int masaKerja; // dalam tahun

    // Konstruktor
    public Karyawan(String nama, String email, int masaKerja) {
        super(nama, email);
        this.masaKerja = masaKerja;
        // Penomoran NIP akan di-handle di subclass masing-masing
    }

    // Selektor (getter)
    public String getNIP() {
        return NIP;
    }

    public int getMasaKerja() {
        return masaKerja;
    }

    // Mutator (setter)
    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public void setMasaKerja(int masaKerja) {
        this.masaKerja = masaKerja;
    }

    // Method abstrak untuk menghitung gaji
    public abstract double hitungGaji();

    // Overriding method tampilkanInfo agar bisa di-extend di subclass
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("NIP      : " + NIP);
        System.out.println("Masa Kerja: " + masaKerja + " tahun");
    }
}
