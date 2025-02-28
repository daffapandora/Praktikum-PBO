package PBO.PrakSesi2;

/**
 * File: MataKuliah.java
 * Description: Class representing a course
 * Author: Daffa Pandora El-farisin
 * Date: February 25, 2025
 */

 public class MataKuliah {
    private String idMatKul;
    private String nama;
    private int sks;

    // Constructors
    public MataKuliah() {
        idMatKul = "";
        nama = "";
        sks = 0;
    }

    public MataKuliah(String idMatKul, String nama, int sks) {
        this.idMatKul = idMatKul;
        this.nama = nama;
        this.sks = sks;
    }

    // Selectors (getters)
    public String getIdMatKul() {
        return idMatKul;
    }

    public String getNama() {
        return nama;
    }

    public int getSks() {
        return sks;
    }

    // Mutators (setters)
    public void setIdMatKul(String idMatKul) {
        this.idMatKul = idMatKul;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }
}   