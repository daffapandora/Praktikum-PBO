package PBO.PrakSesi5;

/**
 * Nama File   : Pengusaha.java
 * Deskripsi   : Kelas Pengusaha yang meng-extend Manusia.
 * Pembuat     : Daffa Pandora El-farisin / 24060123140185
 * Tanggal     : 23 Maret 2025
 */

 public class Pengusaha extends Manusia {
    private String noId; // nomor identitas pengusaha
    private static int counterPengusaha = 0;
    
    public Pengusaha(String nama, String tglMulaiKerja, String alamat, double pendapatan, String noId) {
        super(nama, tglMulaiKerja, alamat, pendapatan);
        this.noId = noId;
        counterPengusaha++;
    }
    
    // Selektor dan Mutator
    public String getNoId() {
        return noId;
    }
    
    public void setNoId(String noId) {
        this.noId = noId;
    }
    
    public static int getCounterPengusaha() {
        return counterPengusaha;
    }
    
    // Implementasi hitungPajak: 15% dari pendapatan
    @Override
    public double hitungPajak() {
        return 0.15 * getPendapatan();
    }
    
    @Override
    public void cetakInfo() {
        System.out.println("=== Data Pengusaha ===");
        super.cetakInfo();
        System.out.println("No. ID             : " + noId);
        System.out.println("Pajak              : Rp " + hitungPajak());
        System.out.println("----------------------------");
    }
}

