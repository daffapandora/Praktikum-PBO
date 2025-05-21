/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8lanjutan;

/**
 *
 * @author daffa pandora
 */
public abstract class Anabul {
    protected String nama;
    protected int usia;
    protected String warna;
    
    public Anabul(String nama) {
        this.nama = nama;
        this.usia = 0;
        this.warna = "Tidak diketahui";
    }
    
    public Anabul(String nama, int usia, String warna) {
        this.nama = nama;
        this.usia = usia;
        this.warna = warna;
    }
    
    // Abstract methods to be implemented by child classes
    public abstract void bersuara();
    public abstract void bergerak();
    
    // Selector (getter) methods
    public String getNama() {
        return nama;
    }
    
    public int getUsia() {
        return usia;
    }
    
    public String getWarna() {
        return warna;
    }
    
    // Mutator (setter) methods
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setUsia(int usia) {
        this.usia = usia;
    }
    
    public void setWarna(String warna) {
        this.warna = warna;
    }
}
