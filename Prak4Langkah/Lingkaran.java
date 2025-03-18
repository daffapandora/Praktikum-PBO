package PBO.Prak4Langkah;

// Nama File: Lingkaran.java
// Deskripsi: Class Lingkaran yang mewarisi class bandunDatar.
// Pembuat: [Nama Anda]
// Tanggal: [Tanggal Pembuatan]

public class Lingkaran extends bandunDatar {
    private double jari;

    // Konstruktor default
    public Lingkaran() {
        super(0, "Tidak Ada Warna", "Tidak Ada Border");
    }

    // Konstruktor berparameter
    public Lingkaran(double jari, String warna, String border) {
        super(0, warna, border);
        this.jari = jari;
    }

    // Getter dan Setter
    public double getJari() {
        return jari;
    }

    public void setJari(double jari) {
        this.jari = jari;
    }

    // Method untuk menghitung luas
    public double getLuas() {
        return Math.PI * jari * jari;
    }

    // Method untuk menghitung keliling
    public double getKeliling() {
        return 2 * Math.PI * jari;
    }

    // Override method printInfo
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Jari-jari: " + jari);
        System.out.println("Luas: " + getLuas());
        System.out.println("Keliling: " + getKeliling());
    }
}