package PBO.Responsi;

public abstract class CivitasAkademika {
    // Atribut
    private String nama;
    private String email;

    // Konstruktor
    public CivitasAkademika(String nama, String email) {
        this.nama = nama;
        this.email = email;
    }

    // Selektor (getter)
    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    // Mutator (setter)
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Method untuk menampilkan informasi seluruh atribut (akan di-override di subclass)
    public void tampilkanInfo() {
        System.out.println("Nama  : " + nama);
        System.out.println("Email : " + email);
    }
}
