import java.sql.*;
import java.util.*;

public class Sopir_Model {
    // atribut
    private String idSopir;
    private String nama;
    private double biaya;
    private String status;
    private String gambarPath;

    // method

    //konstruktor 
    public Sopir_Model(){
        this.idSopir = "";
        this.nama = "";
        this.biaya = 0.0;
        this.status = "";
        this.gambarPath = "";
    }

    public Sopir_Model(String idSopir, String nama, double biaya, String status, String gambarPath){
        this.idSopir = idSopir;
        this.nama = nama;
        this.biaya = biaya;
        this.status = status;
        this.gambarPath = gambarPath;
    }

    //selektor
    public String getIdSopir(){
        return idSopir;
    }

    public String getNama(){
        return nama;
    }

    public double getBiaya(){
        return biaya;
    }
    
    public String getStatus(){
        return status;
    }

    public String getGambarPath(){
        return gambarPath;
    }

    public void setIdSopir(String idSopir){
        this.idSopir = idSopir;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setBiaya(double biaya){
        this.biaya = biaya;
    }

    public void setStatus(String status){
        this.status = status;
    }
    
    public void setGambarPath(String gambarPath) {
        this.gambarPath = gambarPath;
    }

    public void printInfo() {
    System.out.println("ID Sopir: " + idSopir);
    System.out.println("Nama: " + nama);
    System.out.printf("Biaya: %.2f%n", biaya);
    System.out.println("Status: " + status);
    }

    public ArrayList<Sopir_Model> getAvailableSopir() {
        ArrayList<Sopir_Model> dataSopir = new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost:3307/pbomobil";
            String user = "root";
            String pass = "Gegecp2005!123";
            Connection conn = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT idSopir, nama, biaya, status, gambarPath FROM SOPIR WHERE status = 'available'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String idSopir = rs.getString("idSopir");
                String nama = rs.getString("nama");
                double biaya = rs.getDouble("biaya");
                String status = rs.getString("status");
                String gambarPath = rs.getString("gambarPath");

                Sopir_Model sopir = new Sopir_Model(idSopir, nama, biaya, status, gambarPath);
                dataSopir.add(sopir);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Gagal mengambil data sopir: " + e.getMessage());
        }
        return dataSopir;

    }

    public void updateStatus(String idSopir, String status) {
        try {
            String url = "jdbc:mysql://localhost:3307/pbomobil";
            String user = "root";
            String pass = "Gegecp2005!123";
            Connection conn = DriverManager.getConnection(url, user, pass);
            String sql = "UPDATE Sopir SET status = ? WHERE idSopir = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setString(2, idSopir);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Status sopir berhasil diupdate.");
            } else {
                System.out.println("Sopir dengan idSopir :  " + idSopir + " tidak ditemukan.");
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Gagal mengupdate status mobil: " + e.getMessage());
        } 
    }
}
