package PBO.Prak4Langkah;

// Nama File: Main.java
// Deskripsi: Class Main untuk menjalankan program.
// Pembuat: [Nama Anda]
// Tanggal: [Tanggal Pembuatan]

public class Main {
    public static void main(String[] args) {
        // Membuat objek Persegi
        Persegi persegi = new Persegi(5, "Merah", "Hitam");
        System.out.println("Informasi Persegi:");
        persegi.printInfo();
        System.out.println();

        // Membuat objek Lingkaran
        Lingkaran lingkaran = new Lingkaran(7, "Biru", "Putih");
        System.out.println("Informasi Lingkaran:");
        lingkaran.printInfo();
        System.out.println();

        // Menampilkan jumlah objek bandunDatar
        bandunDatar.printCounterbandunDatar();
    }
}
