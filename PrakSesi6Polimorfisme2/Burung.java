package PBO.PrakSesi6Polimorfisme2;

// Burung (Bird) class - child of Anabul
public class Burung extends Anabul {
    private String spesies;
    private boolean dapatBicara;
    private double panjangParuh;
    
    public Burung(String nama) {
        super(nama);
        this.spesies = "Tidak diketahui";
        this.dapatBicara = false;
        this.panjangParuh = 1.0;
    }
    
    public Burung(String nama, int usia, String warna) {
        super(nama, usia, warna);
        this.spesies = "Tidak diketahui";
        this.dapatBicara = false;
        this.panjangParuh = 1.0;
    }
    
    public Burung(String nama, int usia, String warna, String spesies, boolean dapatBicara, double panjangParuh) {
        super(nama, usia, warna);
        this.spesies = spesies;
        this.dapatBicara = dapatBicara;
        this.panjangParuh = panjangParuh;
    }
    
    @Override
    public void bersuara() {
        System.out.println(nama + " berbunyi: Cuit!");
    }
    
    @Override
    public void bergerak() {
        System.out.println(nama + " bergerak dengan terbang.");
    }
    
    // Method khusus untuk Burung
    public void terbang(String tujuan) {
        System.out.println(nama + " terbang ke arah " + tujuan + ".");
    }
    
    public void bernyanyi() {
        System.out.println(nama + " bernyanyi dengan merdu.");
    }
    
    // Selector (getter) methods
    public String getSpesies() {
        return spesies;
    }
    
    public boolean isDapatBicara() {
        return dapatBicara;
    }
    
    public double getPanjangParuh() {
        return panjangParuh;
    }
    
    // Mutator (setter) methods
    public void setSpesies(String spesies) {
        this.spesies = spesies;
    }
    
    public void setDapatBicara(boolean dapatBicara) {
        this.dapatBicara = dapatBicara;
    }
    
    public void setPanjangParuh(double panjangParuh) {
        this.panjangParuh = panjangParuh;
    }
    
    // Override parent's method to provide more specific information
    @Override
    public String toString() {
        return "Burung {" +
                "nama='" + nama + '\'' +
                ", usia=" + usia + 
                ", warna='" + warna + '\'' +
                ", spesies='" + spesies + '\'' +
                ", dapatBicara=" + dapatBicara +
                ", panjangParuh=" + panjangParuh +
                '}';
    }
}