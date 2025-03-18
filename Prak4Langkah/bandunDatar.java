package PBO.Prak4Langkah;

// Nama File: bandunDatar.java
// Deskripsi: Class bandunDatar sebagai superclass untuk Persegi dan Lingkaran.
// Pembuat: Daffa Pandora El-farisin / 24060123140185
// Tanggal: 16 Maret 2025

public class bandunDatar {
    protected int jmlSisi;
    protected String warna;
    protected String border;
    private static int counterbandunDatar = 0;

    // Konstruktor default
    public bandunDatar() {
        counterbandunDatar++;
    }

    // Konstruktor berparameter
    public bandunDatar(int jmlSisi, String warna, String border) {
        this.jmlSisi = jmlSisi;
        this.warna = warna;
        this.border = border;
        counterbandunDatar++;
    }

    // Getter dan Setter
    public int getJmlSisi() {
        return jmlSisi;
    }

    public void setJmlSisi(int jmlSisi) {
        this.jmlSisi = jmlSisi;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    // Method untuk menampilkan informasi
    public void printInfo() {
        System.out.println("Jumlah sisi: " + jmlSisi);
        System.out.println("Warna: " + warna);
        System.out.println("Border: " + border);
    }

    // Method static untuk menampilkan counter
    public static void printCounterbandunDatar() {
        System.out.println("Jumlah Objek Bangun Datar: " + counterbandunDatar);
    }
}