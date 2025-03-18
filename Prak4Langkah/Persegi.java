package PBO.Prak4Langkah;

// Nama File: Persegi.java
// Deskripsi: Class Persegi yang mewarisi class bandunDatar.
// Pembuat: Daffa Pandora El-farisin / 24060123140185
// Tanggal: 16 Maret 2025

public class Persegi extends bandunDatar {
    private double sisi;

    // Konstruktor default
    public Persegi() {
        super(4, "Tidak Ada Warna", "Tidak Ada Border");
    }

    // Konstruktor berparameter
    public Persegi(double sisi, String warna, String border) {
        super(4, warna, border);
        this.sisi = sisi;
    }

    // Getter dan Setter
    public double getSisi() {
        return sisi;
    }

    public void setSisi(double sisi) {
        this.sisi = sisi;
    }

    // Method untuk menghitung luas
    public double getLuas() {
        return sisi * sisi;
    }

    // Method untuk menghitung keliling
    public double getKeliling() {
        return 4 * sisi;
    }

    // Method untuk menghitung diagonal
    public double getDiagonal() {
        return sisi * Math.sqrt(2);
    }

    // Override method printInfo
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Sisi: " + sisi);
        System.out.println("Luas: " + getLuas());
        System.out.println("Keliling: " + getKeliling());
        System.out.println("Diagonal: " + getDiagonal());
    }
}