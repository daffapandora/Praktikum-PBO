package PBO.PrakSesi2;

/**
 * File: MMahasiswa.java
 * Description: Test class for Mahasiswa and its relationships
 * Author: Daffa Pandora El-farisin
 * Date: February 25, 2025
 */

 public class MMahasiswa {
    public static void main(String[] args) {
        // Create courses
        MataKuliah mk1 = new MataKuliah("PBO", "Pemrograman Berorientasi Objek", 3);
        MataKuliah mk2 = new MataKuliah("MBD", "Manjemen Basis Data", 4);
        MataKuliah mk3 = new MataKuliah("ASA", "Analisis Strategi Algoritma", 4);
        MataKuliah mk4 = new MataKuliah("GKV", "Grafik Kreatif Visual", 3);
        
        // Create advisors
        Dosen dosen1 = new Dosen("001", "Dr. Budi Santoso", "Informatika");
        Dosen dosen2 = new Dosen("002", "Prof. Siti Rahayu", "Sistem Informasi");
        
        // Create vehicles
        Kendaraan kendaraan1 = new Kendaraan("B1234CD", "motor");
        Kendaraan kendaraan2 = new Kendaraan("B5678EF", "mobil");
        
        // Create students
        Mahasiswa mhs1 = new Mahasiswa("234", "Ahmad Fauzi", "Informatika");
        Mahasiswa mhs2 = new Mahasiswa("344", "Ratna Sari", "Sistem Informasi");
        Mahasiswa mhs3 = new Mahasiswa("423", "Deni Wijaya", "Informatika");
        
        // Set relationships for mhs1 - has advisor and vehicle, takes 3 courses
        mhs1.setDosenWali(dosen1);
        mhs1.setKendaraan(kendaraan1);
        mhs1.addMatKul(mk1);
        mhs1.addMatKul(mk2);
        mhs1.addMatKul(mk3);
        
        // Set relationships for mhs2 - has advisor but no vehicle, takes 2 courses
        mhs2.setDosenWali(dosen2);
        mhs2.addMatKul(mk2);
        mhs2.addMatKul(mk4);
        
        // Set relationships for mhs3 - has advisor, has different vehicle, takes 1 course
        mhs3.setDosenWali(dosen1);
        mhs3.setKendaraan(kendaraan2);
        mhs3.addMatKul(mk1);
        
        // Print information
        System.out.println("========== MAHASISWA 1 ==========");
        System.out.println("Jumlah SKS: " + mhs1.getJumlahSKS());
        System.out.println("Jumlah Mata Kuliah: " + mhs1.getJumlahMatKul());
        System.out.println("\nDetail Mahasiswa:");
        mhs1.printDetailMhs();
        
        System.out.println("\n========== MAHASISWA 2 ==========");
        System.out.println("Jumlah SKS: " + mhs2.getJumlahSKS());
        System.out.println("Jumlah Mata Kuliah: " + mhs2.getJumlahMatKul());
        System.out.println("\nDetail Mahasiswa:");
        mhs2.printDetailMhs();
        
        System.out.println("\n========== MAHASISWA 3 ==========");
        System.out.println("Jumlah SKS: " + mhs3.getJumlahSKS());
        System.out.println("Jumlah Mata Kuliah: " + mhs3.getJumlahMatKul());
        System.out.println("\nDetail Mahasiswa:");
        mhs3.printDetailMhs();
    }
}