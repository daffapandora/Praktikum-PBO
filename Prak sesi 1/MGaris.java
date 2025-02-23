/* Nama File : MGaris.java
 * Deskripsi : Main class untuk menguji class Garis
 * Pembuat : Daffa Pandora El-farisin / 24060123140185
 * Tanggal : 20 Februari 2025
 */

 public class MGaris {
    public static void main(String[] args) {
        // Membuat titik T1 dan T2
        Titik T1 = new Titik(3, 4);
        Titik T2 = new Titik(-10, 10);

        // Membuat garis dengan konstruktor default
        System.out.println("==========Membuat Garis Default==========");
        Garis G1 = new Garis();
        System.out.println("Garis G1 (default):");
        G1.printT1T2();
        G1.printRumus();
        System.out.println("Panjang garis: " + G1.getPanjang());
        System.out.println("Gradien: " + G1.getGradien());

        // Membuat garis dengan T1 dan T2
        System.out.println("\n==========Membuat Garis dengan T1 dan T2==========");
        Garis G2 = new Garis(T1, T2);
        System.out.println("Garis G2 (dari T1 ke T2):");
        G2.printT1T2();
        G2.printRumus();
        System.out.println("Panjang garis: " + G2.getPanjang());
        System.out.println("Gradien: " + G2.getGradien());

        // Menguji titik tengah
        System.out.println("\n==========Titik Tengah==========");
        Titik tengah = G2.getTitikTengah();
        System.out.println("Titik tengah G2: (" + tengah.getAbsis() + "," + tengah.getOrdinat() + ")");

        // Menguji kesejajaran dan ketegaklurusan
        System.out.println("\n==========Pengujian Sejajar dan Tegak Lurus==========");
        System.out.println("G1 sejajar dengan G2? " + G1.isSejajar(G2));
        System.out.println("G1 tegak lurus dengan G2? " + G1.isTegakLurus(G2));

        // Menampilkan jumlah objek garis yang dibuat
        System.out.println("\nJumlah objek Garis yang dibuat: " + Garis.getCounterGaris());
    }
}
