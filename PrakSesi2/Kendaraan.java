package PBO.PrakSesi2;

/**
 * File: Kendaraan.java
 * Description: Class representing a vehicle
 * Author: Daffa Pandora El-farisin
 * Date: February 25, 2025
 */

 public class Kendaraan {
    private String noPlat;
    private String jenis; // motor or mobil

    // Constructors
    public Kendaraan() {
        noPlat = "";
        jenis = "";
    }

    public Kendaraan(String noPlat, String jenis) {
        this.noPlat = noPlat;
        this.jenis = jenis;
    }

    // Selectors (getters)
    public String getNoPlat() {
        return noPlat;
    }

    public String getJenis() {
        return jenis;
    }

    // Mutators (setters)
    public void setNoPlat(String noPlat) {
        this.noPlat = noPlat;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}