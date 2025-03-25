package PBO.PrakSesi5;

/**
 * Nama File   : PNS.java
 * Deskripsi   : Kelas PNS (pegawai negeri sipil) yang meng-extend Manusia.
 * Pembuat     : Daffa Pandora El-farisin / 24060123140185
 * Tanggal     : 23 Maret 2025
 */

 public class PNS extends Manusia {
    private String noId; // nomor identitas PNS
    private static int counterPNS = 0;
    
    // Constructor dengan 5 parameter
    public PNS(String nama, String tglMulaiKerja, String alamat, double pendapatan, String noId) {
        super(nama, tglMulaiKerja, alamat, pendapatan);
        this.noId = noId;
        counterPNS++;
    }
    
    // Constructor dengan 4 parameter (tanpa alamat)
    public PNS(String nama, String tglMulaiKerja, double pendapatan, String noId) {
        super(nama, tglMulaiKerja, pendapatan);
        this.noId = noId;
        counterPNS++;
    }
    
    // Selektor dan Mutator untuk noId
    public String getNoId() {
        return noId;
    }
    
    public void setNoId(String noId) {
        this.noId = noId;
    }
    
    public static int getCounterPNS() {
        return counterPNS;
    }
    
    // Implementasi hitungPajak: 10% dari pendapatan
    @Override
    public double hitungPajak() {
        return 0.10 * getPendapatan();
    }
    
    // Override cetakInfo untuk menampilkan info PNS
    @Override
    public void cetakInfo() {
        System.out.println("=== Data PNS ===");
        super.cetakInfo();
        System.out.println("No. ID         : " + noId);
        System.out.println("Pajak          : Rp " + hitungPajak());
        System.out.println("----------------------------");
    }
}
