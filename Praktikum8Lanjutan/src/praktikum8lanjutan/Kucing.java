/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8lanjutan;

/**
 *
 * @author daffa pandora
 */
public class Kucing extends Anabul {
    private String ras;
    private boolean longHair;
    
    public Kucing(String nama) {
        super(nama);
        this.ras = "Domestik";
        this.longHair = false;
    }
    
    public Kucing(String nama, int usia, String warna) {
        super(nama, usia, warna);
        this.ras = "Domestik";
        this.longHair = false;
    }
    
    public Kucing(String nama, int usia, String warna, String ras, boolean longHair) {
        super(nama, usia, warna);
        this.ras = ras;
        this.longHair = longHair;
    }
    
    @Override
    public void bersuara() {
        System.out.println(nama + " berbunyi: Meong!");
    }
    
    @Override
    public void bergerak() {
        System.out.println(nama + " bergerak dengan melata.");
    }
    
    // Method khusus untuk Kucing
    public void mencakar() {
        System.out.println(nama + " sedang mencakar-cakar.");
    }
    
    // Selector (getter) methods
    public String getRas() {
        return ras;
    }
    
    public boolean isLongHair() {
        return longHair;
    }
    
    // Mutator (setter) methods
    public void setRas(String ras) {
        this.ras = ras;
    }
    
    public void setLongHair(boolean longHair) {
        this.longHair = longHair;
    }
    
    // Override parent's method to provide more specific information
    @Override
    public String toString() {
        return "Kucing {" +
                "nama='" + nama + '\'' +
                ", usia=" + usia + 
                ", warna='" + warna + '\'' +
                ", ras='" + ras + '\'' +
                ", longHair=" + longHair +
                '}';
    }
}