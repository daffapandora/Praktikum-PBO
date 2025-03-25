package PBO.Responsi;

/**
 * Nama File   : Dosen.java
 * Deskripsi   : Kelas Dosen yang meng-extend karyawan.
 * Pembuat     : Daffa Pandora El-farisin / 24060123140185
 * Tanggal     : 25 Maret 2025
 */


public class Dosen extends Karyawan {
    private Fakultas fakultas;
    private static int counterDosen = 0;

    // Konstruktor
    public Dosen(String nama, String email, int masaKerja, Fakultas fakultas) {
        super(nama, email, masaKerja);
        counterDosen++;
        // Generate NIP secara sederhana: "DSN" + nomor urut
        setNIP("DSN" + String.format("%03d", counterDosen));
        this.fakultas = fakultas;
    }

    // Selektor (getter)
    public Fakultas getFakultas() {
        return fakultas;
    }

    public static int getCounterDosen() {
        return counterDosen;
    }

    // Mutator (setter)
    public void setFakultas(Fakultas fakultas) {
        this.fakultas = fakultas;
    }

    // Implementasi hitungGaji: gaji = gajiPokok fakultas + (masaKerja × 1% × gajiPokok fakultas)
    @Override
    public double hitungGaji() {
        double gajiPokok = fakultas.getGajiPokok();
        return gajiPokok + (getMasaKerja() * 0.01 * gajiPokok);
    }

    // Overriding method tampilkanInfo
    @Override
    public void tampilkanInfo() {
        System.out.println("=== Data Dosen ===");
        super.tampilkanInfo();
        System.out.println("Fakultas : " + fakultas.getNamaFakultas());
        System.out.println("Gaji     : Rp " + hitungGaji());
        System.out.println("------------------");
    }
}
