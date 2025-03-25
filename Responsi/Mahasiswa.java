package PBO.Responsi;

/**
 * Nama File   : Mahasiswa.java
 * Deskripsi   : Kelas Mahasiswa yang meng-extend CivitasAkademika.
 * Pembuat     : Daffa Pandora El-farisin / 24060123140185
 * Tanggal     : 25 Maret 2025
 */

public class Mahasiswa extends CivitasAkademika {
    // Atribut khusus
    private String NIM;
    private int semester;
    private Fakultas fakultas;

    // Counter jumlah mahasiswa
    private static int counterMahasiswa = 0;

    // Konstruktor (overloading: dengan parameter lengkap)
    public Mahasiswa(String nama, String email, int semester, Fakultas fakultas) {
        super(nama, email);
        counterMahasiswa++;
        this.NIM = "MHS" + String.format("%03d", counterMahasiswa);
        this.semester = semester;
        this.fakultas = fakultas;
    }

    // Selektor (getter)
    public String getNIM() {
        return NIM;
    }

    public int getSemester() {
        return semester;
    }

    public Fakultas getFakultas() {
        return fakultas;
    }

    public static int getCounterMahasiswa() {
        return counterMahasiswa;
    }

    // Mutator (setter)
    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setFakultas(Fakultas fakultas) {
        this.fakultas = fakultas;
    }

    // Method untuk menghitung biaya UKT mahasiswa
    // Biaya UKT = tarifUKT × (1 - 0.05*(semester-1))
    public double hitungBiayaUKT() {
        double tarifDasar = fakultas.getTarifUKT();
        double diskon = 0.05 * (semester - 1);
        double biaya = tarifDasar * (1 - diskon);
        return biaya;
    }

    // Overriding method tampilkanInfo
    @Override
    public void tampilkanInfo() {
        System.out.println("=== Data Mahasiswa ===");
        super.tampilkanInfo();
        System.out.println("NIM      : " + NIM);
        System.out.println("Semester : " + semester);
        System.out.println("Fakultas : " + fakultas.getNamaFakultas());
        System.out.println("Biaya UKT: Rp " + hitungBiayaUKT());
        System.out.println("----------------------");
    }
}
