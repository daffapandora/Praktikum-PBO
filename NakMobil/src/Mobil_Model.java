import java.sql.*;
import java.util.*;

public class Mobil_Model {
    // atribut
    private String noPlat;
    private String jenis;
    private String noRangka;
    private double biayaSewa;
    private String status;
    private String gambarPath;

    // konstruktor
    public Mobil_Model() {
        this.noPlat = "";
        this.jenis = "";
        this.noRangka = "";
        this.biayaSewa = 0.0;
        this.status = "";
        this.gambarPath = "";
    }

    public Mobil_Model(String noPlat, String jenis, String noRangka, double biayaSewa, String gambarPath, String status) {
        this.noPlat = noPlat;
        this.jenis = jenis;
        this.noRangka = noRangka;
        this.biayaSewa = biayaSewa;
        this.status = status;
        this.gambarPath = gambarPath;
    }


    // selektor
    public String getNoPlat() {
        return noPlat;
    }

    public String getJenis() {
        return jenis;
    }

    public String getNoRangka() {
        return noRangka;
    }

    public double getBiayaSewa() {
        return biayaSewa;
    }

    public String getStatus(){
        return status;
    }

    public String getGambarPath() {
        return gambarPath;
    }

    // mutator
    public void setNoPlat(String noPlat) {
        this.noPlat = noPlat;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    public void setNoRangka(String noRangka) {
        this.noRangka = noRangka;
    }
    
    public void setBiayaSewa(double biayaSewa) {
        this.biayaSewa = biayaSewa;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setGambarPath(String gambarPath) {
        this.gambarPath = gambarPath;
    }

    // method

    public ArrayList<Mobil_Model> getAvailableMobil(){
        ArrayList<Mobil_Model> dataMobil = new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost:3307/pbomobil";
            String user = "root";
            String pass = "Gegecp2005!123";
            Connection conn = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT noPlat, jenis, noRangka, biayaSewa, status, gambarPath FROM Mobil WHERE status = 'available'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String noPlat = rs.getString("noPlat");
                String jenis = rs.getString("jenis");
                String noRangka = rs.getString("noRangka");
                double biayaSewa = rs.getDouble("biayaSewa");
                String status = rs.getString("status");
                String gambarPath = rs.getString("gambarPath");

                Mobil_Model mobil = new Mobil_Model(noPlat, jenis, noRangka, biayaSewa, gambarPath, status);
                dataMobil.add(mobil);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Gagal mengambil data mobil: " + e.getMessage());
        }
        return dataMobil;
    }
    
    public void updateStatus(String platMobil, String status){
        try {
            String url = "jdbc:mysql://localhost:3307/pbomobil";
            String user = "root";
            String pass = "Gegecp2005!123";
            Connection conn = DriverManager.getConnection(url, user, pass);
            String sql = "UPDATE Mobil SET status = ? WHERE noPlat = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setString(2, platMobil);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Status mobil berhasil diupdate.");
            } else {
                System.out.println("Mobil dengan plat " + platMobil + " tidak ditemukan.");
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Gagal mengupdate status mobil: " + e.getMessage());
        }    
    }

    public void printInfo(){
        System.out.println("Nomor Plat : " + noPlat);
        System.out.println("Jenis : " + jenis);
        System.out.println("Nomor Rangka : " + noRangka);
        System.out.printf("Biaya Sewa : %.2f%n", biayaSewa);
        System.out.println("Status : " + status);
        System.out.println("Gambar (size): " + (gambarPath != null ? gambarPath.length() + " bytes" : "tidak ada"));
    }

}
