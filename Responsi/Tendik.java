package PBO.Responsi;

/**
 * Nama File   : Tendik.java
 * Deskripsi   : Kelas Tendik yang meng-extend karyawan.
 * Pembuat     : Daffa Pandora El-farisin / 24060123140185
 * Tanggal     : 25 Maret 2025
 */

public class Tendik extends Karyawan {
    private static int counterTendik = 0;
    private final double GAJI_POKOK = 4000000;

    // Konstruktor
    public Tendik(String nama, String email, int masaKerja) {
        super(nama, email, masaKerja);
        counterTendik++;
        // Generate NIP secara sederhana: "TND" + nomor urut
        setNIP("TND" + String.format("%03d", counterTendik));
    }

    // Selektor (getter)
    public static int getCounterTendik() {
        return counterTendik;
    }

    // Mutator tidak diperlukan untuk GAJI_POKOK karena nilainya tetap

    // Implementasi hitungGaji: gaji = 4.000.000 + (masa kerja × 1% × 4.000.000)
    @Override
    public double hitungGaji() {
        return GAJI_POKOK + (getMasaKerja() * 0.01 * GAJI_POKOK);
    }

    // Overriding method tampilkanInfo
    @Override
    public void tampilkanInfo() {
        System.out.println("=== Data Tendik ===");
        super.tampilkanInfo();
        System.out.println("Gaji     : Rp " + hitungGaji());
        System.out.println("-------------------");
    }
}

