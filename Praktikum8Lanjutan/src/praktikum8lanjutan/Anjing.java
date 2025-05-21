/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8lanjutan;

/**
 *
 * @author daffa pandora
 */
public class Anjing extends Anabul {
    private String ras;
    private boolean terlatih;
    
    public Anjing(String nama) {
        super(nama);
        this.ras = "Kampung";
        this.terlatih = false;
    }
    
    public Anjing(String nama, int usia, String warna) {
        super(nama, usia, warna);
        this.ras = "Kampung";
        this.terlatih = false;
    }
    
    public Anjing(String nama, int usia, String warna, String ras, boolean terlatih) {
        super(nama, usia, warna);
        this.ras = ras;
        this.terlatih = terlatih;
    }
    
    @Override
    public void bersuara() {
        System.out.println(nama + " berbunyi: Guk-guk!");
    }
    
    @Override
    public void bergerak() {
        System.out.println(nama + " bergerak dengan melata.");
    }
    
    // Method khusus untuk Anjing
    public void mengonggong(String target) {
        System.out.println(nama + " mengonggong keras ke arah " + target + "!");
    }
    
    // Selector (getter) methods
    public String getRas() {
        return ras;
    }
    
    public boolean isTerlatih() {
        return terlatih;
    }
    
    // Mutator (setter) methods
    public void setRas(String ras) {
        this.ras = ras;
    }
    
    public void setTerlatih(boolean terlatih) {
        this.terlatih = terlatih;
    }
    
    // Override parent's method to provide more specific information
    @Override
    public String toString() {
        return "Anjing {" +
                "nama='" + nama + '\'' +
                ", usia=" + usia + 
                ", warna='" + warna + '\'' +
                ", ras='" + ras + '\'' +
                ", terlatih=" + terlatih +
                '}';
    }
}