package PBO.PrakSesi5;

/**
 * Nama File   : Petani.java
 * Deskripsi   : Kelas Petani yang meng-extend Manusia.
 * Pembuat     : Daffa Pandora El-farisin / 24060123140185
 * Tanggal     : 23 Maret 2025
 */

 public class Petani extends Manusia {
    private String daerah;
    private static int counterPetani = 0;
    
    public Petani(String nama, String tglMulaiKerja, String alamat, double pendapatan, String daerah) {
        super(nama, tglMulaiKerja, alamat, pendapatan);
        this.daerah = daerah;
        counterPetani++;
    }
    
    // Selektor dan Mutator
    public String getDaerah() {
        return daerah;
    }
    
    public void setDaerah(String daerah) {
        this.daerah = daerah;
    }
    
    public static int getCounterPetani() {
        return counterPetani;
    }
    
    // Untuk petani, pajak dianggap 0
    @Override
    public double hitungPajak() {
        return 0;
    }
    
    @Override
    public void cetakInfo() {
        System.out.println("=== Data Petani ===");
        super.cetakInfo();
        System.out.println("Daerah             : " + daerah);
        System.out.println("Pajak              : Rp " + hitungPajak());
        System.out.println("----------------------------");
    }
}
