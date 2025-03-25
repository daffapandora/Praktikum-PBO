package PBO.PrakSesi5;

/**
 * Nama File   : MManusia.java
 * Deskripsi   : Main class untuk menguji pelaporan pajak tahunan.
 * Pembuat     : Daffa Pandora El-farisin / 24060123140185
 * Tanggal     : 23 Maret 2025
 */

 public class MManusia {
    public static void main(String[] args) {
        // Membuat objek-objek berdasarkan contoh di soal
        PNS p1 = new PNS("Satriyo", "01-04-2006", "Jl. Seroja", 15000000, "198302032006041002");
        Pengusaha pe1 = new Pengusaha("Adhy", "01-01-2000", "Jl.Air", 55000000, "000-556-773-212-000-5");
        Petani pt1 = new Petani("Nugraha", "09-01-1977", "Jl. Bunga 9 Tembalang", 5000000, "wonogiri");
        PNS p2 = new PNS("Panji", "01-04-2010", 10000000, "198004212010041002");
        
        // Update alamat p2 menggunakan setter
        p2.setAlamat("Jl. Panorama 111 Tembalang");
        
        // Menampilkan jumlah objek
        System.out.println("Jumlah Manusia    = " + Manusia.getCounterMns());
        System.out.println("Jumlah PNS        = " + PNS.getCounterPNS());
        System.out.println("Jumlah Pengusaha  = " + Pengusaha.getCounterPengusaha());
        System.out.println("Jumlah Petani     = " + Petani.getCounterPetani());
        System.out.println();
        
        // Menampilkan perhitungan pajak dan masa kerja
        System.out.println("Pajak PNS p1       = Rp " + p1.hitungPajak());
        System.out.println("Pajak Pengusaha pe1= Rp " + pe1.hitungPajak());
        System.out.println("Pajak Petani pt1   = Rp " + pt1.hitungPajak());
        System.out.println();
        
        System.out.println("Masa Kerja p1      = " + p1.hitungMasaKerja() + " tahun");
        System.out.println("Masa Kerja pe1     = " + pe1.hitungMasaKerja() + " tahun");
        System.out.println("Masa Kerja pt1     = " + pt1.hitungMasaKerja() + " tahun");
        System.out.println();
        
        // Mencetak info lengkap tiap objek
        p1.cetakInfo();
        pe1.cetakInfo();
        pt1.cetakInfo();
        p2.cetakInfo();
    }
}
