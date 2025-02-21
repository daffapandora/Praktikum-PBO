public class MGaris {
    public static void main(String[] args) {
        // Create points
        Titik t1 = new Titik(-2.0, 0.0);
        Titik t2 = new Titik(0.0, 4.0);
        Titik t3 = new Titik(0.0, 0.0);
        Titik t4 = new Titik(3.0, 3.0);

        // Create lines
        Garis g1 = new Garis(t1, t2);
        Garis g2 = new Garis(t3, t4);

        // Test functionality
        System.out.println("Garis 1:");
        g1.display();
        System.out.println("Persamaan garis: " + g1.getPersamaanGaris());
        System.out.println("Panjang: " + g1.getPanjang());
        System.out.println("Gradien: " + g1.getGradien());
        
        Titik tengah = g1.getTitikTengah();
        System.out.println("Titik tengah: (" + tengah.getAbsis() + "," + tengah.getOrdinat() + ")");

        System.out.println("\nGaris 2:");
        g2.display();
        System.out.println("Persamaan garis: " + g2.getPersamaanGaris());

        System.out.println("\nSejajar? " + g1.isSejajar(g2));
        System.out.println("Tegak lurus? " + g1.isTegakLurus(g2));
        
        System.out.println("\nJumlah garis yang dibuat: " + Garis.getCounterGaris());
    }
}