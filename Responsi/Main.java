package PBO.Responsi;

/**
 * Nama File   : Main.java
 * Deskripsi   : Main class untuk menguji.
 * Pembuat     : Daffa Pandora El-farisin / 24060123140185
 * Tanggal     : 25 Maret 2025
 */

public class Main {
    public static void main(String[] args) {
        // Membuat objek Fakultas
        Fakultas teknik = new Fakultas("Teknik", 5000000, 6000000);
        Fakultas ekonomi = new Fakultas("Informatika", 4000000, 5000000);

        // Membuat objek Mahasiswa
        Mahasiswa mhs1 = new Mahasiswa("Budi", "budi@mail.com", 1, teknik);
        Mahasiswa mhs2 = new Mahasiswa("Siti", "siti@mail.com", 3, ekonomi);

        // Membuat objek Dosen
        Dosen dsn1 = new Dosen("Dr. Surya", "surya@mail.com", 10, teknik);
        Dosen dsn2 = new Dosen("Dr. Rina", "rina@mail.com", 5, ekonomi);

        // Membuat objek Tendik
        Tendik tnd1 = new Tendik("Andi", "andi@mail.com", 7);
        Tendik tnd2 = new Tendik("Rina", "tendik@mail.com", 3);

        // Menampilkan informasi masing-masing objek
        mhs1.tampilkanInfo();
        mhs2.tampilkanInfo();
        dsn1.tampilkanInfo();
        dsn2.tampilkanInfo();
        tnd1.tampilkanInfo();
        tnd2.tampilkanInfo();

        // Menampilkan jumlah instance dari tiap kategori
        System.out.println("Total Mahasiswa: " + Mahasiswa.getCounterMahasiswa());
        System.out.println("Total Dosen    : " + Dosen.getCounterDosen());
        System.out.println("Total Tendik   : " + Tendik.getCounterTendik());
    }
}
