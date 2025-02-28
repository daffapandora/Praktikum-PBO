package PBO.PrakSesi2;

/**
 * File: Mahasiswa.java
 * Description: Class representing a student with relationships to other classes
 * Author: Daffa Pandora El-farisin
 * Date: February 25, 2025
 */

 public class Mahasiswa {
    // Attributes
    private String nim;
    private String nama;
    private String prodi;
    
    private MataKuliah[] listMatKul;
    private int jumlahMatKul;
    private Dosen dosenWali;
    private Kendaraan kendaraan;

    // Konstruktor
    public Mahasiswa() {
        nim = "";
        nama = "";
        prodi = "";
        listMatKul = new MataKuliah[50];
        jumlahMatKul = 0;
        dosenWali = null;
        kendaraan = null;
    }

    public Mahasiswa(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        listMatKul = new MataKuliah[50];
        jumlahMatKul = 0;
        dosenWali = null;
        kendaraan = null;
    }

    // Selectors
    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getProdi() {
        return prodi;
    }

    public Dosen getDosenWali() {
        return dosenWali;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    // Mutators
    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public void setDosenWali(Dosen dosenWali) {
        this.dosenWali = dosenWali;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    // Method to add a course
    public void addMatKul(MataKuliah matkul) {
        if (jumlahMatKul < 50) {
            listMatKul[jumlahMatKul] = matkul;
            jumlahMatKul++;
        } else {
            System.out.println("Batas maksimum mata kuliah telah tercapai!");
        }
    }

    // Method to get total credits
    public int getJumlahSKS() {
        int totalSKS = 0;
        for (int i = 0; i < jumlahMatKul; i++) {
            totalSKS += listMatKul[i].getSks();
        }
        return totalSKS;
    }

    // Method to get number of courses
    public int getJumlahMatKul() {
        return jumlahMatKul;
    }

    // Method to print basic student info
    public void printMhs() {
        System.out.println("NIM: " + nim);
        System.out.println("Nama: " + nama);
        System.out.println("Program Studi: " + prodi);
    }

    public void printDetailMhs() {
        printMhs();
        System.out.println("\nDaftar Mata Kuliah:");
        if (jumlahMatKul == 0) {
            System.out.println("Belum mengambil mata kuliah");
        } else {
            for (int i = 0; i < jumlahMatKul; i++) {
                System.out.println((i+1) + ". " + listMatKul[i].getNama() + " (" + listMatKul[i].getIdMatKul() + ") - " + listMatKul[i].getSks() + " SKS");
            }
            System.out.println("Total SKS: " + getJumlahSKS());
        }
        System.out.println("\nDosen Wali:");
        if (dosenWali == null) {
            System.out.println("Belum memiliki dosen wali");
        } else {
            System.out.println("Nama: " + dosenWali.getNama());
            System.out.println("NIP: " + dosenWali.getNip());
            System.out.println("Program Studi: " + dosenWali.getProdi());
        }
        System.out.println("\nKendaraan:");
        if (kendaraan == null) {
            System.out.println("Tidak memiliki kendaraan");
        } else {
            System.out.println("Jenis: " + kendaraan.getJenis());
            System.out.println("No. Plat: " + kendaraan.getNoPlat());
        }
        // System.out.println("Nim: " + nim);
        // System.out.println("Nama: " + nama);
        // System.out.println("Prodi: " + prodi);
        // System.out.println("Prodi: " + prodi);
        // int i;
        // for(i=0;i<listMatKul.size();i++){
        //     System.out.println(listMatKul.get(i).getNama());
        // }
    }
}