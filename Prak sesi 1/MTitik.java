public class MTitik {
    public static void main(String[] args) {
        // Create objects
        Titik t1 = new Titik();
        t1.setAbsis(1.0);
        t1.setOrdinat(2.0);
        
        Titik t2 = new Titik(3.0, 4.0);
        
        // Part 2 - Object Reference
        Titik t3 = t1;
        t3.setAbsis(5.0);
        t3.setOrdinat(6.0);
        
        // Print results
        System.out.println("T1: (" + t1.getAbsis() + ", " + t1.getOrdinat() + ")");
        System.out.println("T2: (" + t2.getAbsis() + ", " + t2.getOrdinat() + ")");
        System.out.println("T3: (" + t3.getAbsis() + ", " + t3.getOrdinat() + ")");
        
        // Print counter
        System.out.println("Jumlah objek titik: " + Titik.getCounterTitik());
        
        // Test reflection methods
        System.out.println("\nTesting reflection methods:");
        System.out.println("Original T2: (" + t2.getAbsis() + ", " + t2.getOrdinat() + ")");
        t2.refleksiX();
        System.out.println("After refleksiX: (" + t2.getAbsis() + ", " + t2.getOrdinat() + ")");
        
        Titik t2ReflectedY = t2.getRefleksiY();
        System.out.println("New point from getRefleksiY: (" + t2ReflectedY.getAbsis() + ", " + t2ReflectedY.getOrdinat() + ")");
    }
}