package PBO.PrakSesi2;

/**
 * File: Dosen.java
 * Description: Class representing a lecturer
 * Author: Daffa Pandora El-farisin
 * Date: February 25, 2025
 */

 public class Dosen {
    private String nip;
    private String nama;
    private String prodi;

    // Constructors
    public Dosen() {
        nip = "";
        nama = "";
        prodi = "";
    }

    public Dosen(String nip, String nama, String prodi) {
        this.nip = nip;
        this.nama = nama;
        this.prodi = prodi;
    }

    // Selectors (getters)
    public String getNip() {
        return nip;
    }

    public String getNama() {
        return nama;
    }

    public String getProdi() {
        return prodi;
    }

    // Mutators (setters)
    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }
}