import java.sql.*;

public class Pelanggan_Model {
    // atribut
    private String NIK;
    private String nama;
    private String alamat;
    private String noTelp;

    // konstruktor
    public Pelanggan_Model(){
        this.NIK = "";
        this.nama = "";
        this.alamat = "";
        this.noTelp = "";
    }
    
    public Pelanggan_Model(String NIK, String nama, String alamat, String noTelp) {
        if (NIK == null || NIK.length() != 16 || !NIK.matches("\\d+")) {
            throw new IllegalArgumentException("NIK harus 16 digit angka!");
        }
        if (noTelp == null || !noTelp.matches("^08\\d{9,11}$")) {
            throw new IllegalArgumentException("Nomor telepon tidak valid!");
        }
        this.NIK = NIK;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;

        // simpan database
        try {
            String url = "jdbc:mysql://localhost:3307/pbomobil";
            String user = "root";
            String pass = "Gegecp2005!123";

            Connection conn = DriverManager.getConnection(url, user, pass);
            String sql = "INSERT INTO pelanggan (NIK, nama, alamat, noTelp) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, NIK);
            stmt.setString(2, nama);
            stmt.setString(3, alamat);
            stmt.setString(4, noTelp);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Gagal menyimpan ke database: " + e.getMessage());
        }
    }
    
    //selektor
    public String getNIK() {
        return NIK;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }


    public String getNoTelp() {
        return noTelp;
    }

    //mutator
    public void setNIK(String NIK) {
        this.NIK = NIK;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    // method
    public void printInfo(){
        System.out.println("NIK : " + NIK);
        System.out.println("Nama : " + nama);
        System.out.println("Alamat : " + alamat);
        System.out.println("Nomor Telepon : " + noTelp);
    }
}