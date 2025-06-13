import java.time.*;
import java.time.temporal.ChronoUnit;
import java.sql.*;
import java.util.*;

public class Transaksi_Model {
    //attribut
    private String id;
    private LocalDate tglAwal;
    private LocalDate tglAkhir;
    private String status;
    private Pelanggan_Model pelanggan;
    private Mobil_Model mobil;
    private Pembayaran_Model pembayaran;
    private Sopir_Model sopir;
    private double nominalPembayaran;

    //konstruktor
    public Transaksi_Model() {
        this.id = "";
        this.tglAwal = LocalDate.now();
        this.tglAkhir = LocalDate.now();
        this.status = "";
        this.pelanggan = new Pelanggan_Model();
        this.mobil = new Mobil_Model();
        this.pembayaran = new Pembayaran_Model();
        this.sopir = new Sopir_Model();
    }

    //method
    public Transaksi_Model(String id, LocalDate tglAwal, LocalDate tglAkhir, String status,
    Pelanggan_Model pelanggan, Mobil_Model mobil, Pembayaran_Model pembayaran, Sopir_Model sopir) {
        this.id = id;
        this.tglAwal = tglAwal;
        this.tglAkhir = tglAkhir;
        this.status = status;
        this.pelanggan = pelanggan;
        this.mobil = mobil;
        this.pembayaran = pembayaran;
        this.sopir = sopir;

        try {
            String url = "jdbc:mysql://localhost:3307/pbomobil";
            String user = "root";
            String pass = "Gegecp2005!123";
            Connection conn = DriverManager.getConnection(url, user, pass);
            
            // Tambahkan nominalPembayaran ke query
            String sql = "INSERT INTO transaksi (id, tglAwal, tglAkhir, nikPelanggan, platMobil, idSopir, idPembayaran, status, nominalPembayaran) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, this.id);
            ps.setDate(2, java.sql.Date.valueOf(this.tglAwal));
            ps.setDate(3, java.sql.Date.valueOf(this.tglAkhir));
            ps.setString(4, this.pelanggan.getNIK());
            ps.setString(5, this.mobil.getNoPlat());
            if (this.sopir != null && this.sopir.getIdSopir() != null && !this.sopir.getIdSopir().isEmpty()) {
                ps.setString(6, this.sopir.getIdSopir());
            } else {
                ps.setNull(6, java.sql.Types.VARCHAR);
            }
            ps.setString(7, this.pembayaran.getIdPembayaran());
            ps.setString(8, this.status);
            // Set nominalPembayaran dari hasil hitungBiaya
            ps.setDouble(9, this.pembayaran.getNominalPembayaran());
            
            ps.executeUpdate();
            System.out.println("Data transaksi berhasil disimpan.");
            
            ps.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("Gagal menyimpan data transaksi: " + e.getMessage());
        }
    }

    //selektor
    public String getId() {
        return id;
    }

    public LocalDate getTglAwal() {
        return tglAwal;
    }

    public LocalDate getTglAkhir() {
        return tglAkhir;
    }

    public String getStatus(){
        return status;
    }

    public Pelanggan_Model getPelanggan() {
        return pelanggan;
    }

    public Mobil_Model getMobil() {
        return mobil;
    }

    public Pembayaran_Model getPembayaran() {
        return pembayaran;
    }

    public Sopir_Model getSopir() {
        return sopir;
    }

    public double getNominalPembayaran() {
        return nominalPembayaran;
    }

    //mutator

    public void setId(String id) {
        this.id = id;
    }

    public void setTglAwal(LocalDate tglAwal) {
        this.tglAwal = tglAwal;
    }

    public void setTglAkhir(LocalDate tglAkhir){
        this.tglAkhir = tglAkhir;
    }

    public void setStatus(String status){
        this.status = status;
    }
     
    public void setPelanggan(Pelanggan_Model pelanggan) {
        this.pelanggan = pelanggan;
    }

    public void setMobil(Mobil_Model mobil) {
        this.mobil = mobil;
    }

    public void setPembayaran(Pembayaran_Model pembayaran) {
        this.pembayaran = pembayaran;
    }

    public void setSopir(Sopir_Model sopir) {
        this.sopir = sopir;
    }

    public void setNominalPembayaran(double nominalPembayaran) {
        this.nominalPembayaran = nominalPembayaran;
    }

    //method

    public Pelanggan_Model getDataPelanggan(String NIK){
        Pelanggan_Model dataPelanggan = new Pelanggan_Model();
        try {
            String url = "jdbc:mysql://localhost:3307/pbomobil";
            String user = "root";
            String pass = "Gegecp2005!123";
            Connection conn = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT NIK, nama, alamat, noTelp FROM Pelanggan WHERE NIK = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, NIK);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nik = rs.getString("nik");
                String nama = rs.getString("nama");
                String alamat = rs.getString("alamat");
                String noTelp = rs.getString("noTelp");

                dataPelanggan.setNIK(nik);
                dataPelanggan.setNama(nama);
                dataPelanggan.setAlamat(alamat);
                dataPelanggan.setNoTelp(noTelp);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Gagal mengambil data pelanggan: " + e.getMessage());
        }
        return dataPelanggan;
    }

    public Mobil_Model getDataMobil(String platMobil){
        Mobil_Model dataMobil = new Mobil_Model();
        try {
            String url = "jdbc:mysql://localhost:3307/pbomobil";
            String user = "root";
            String pass = "Gegecp2005!123";
            Connection conn = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT noPlat, jenis, noRangka, biayaSewa, status, gambarPath FROM Mobil WHERE noPlat = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, platMobil);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String noPlat = rs.getString("noPlat");
                String jenis = rs.getString("jenis");
                String noRangka = rs.getString("noRangka");
                Double biayaSewa = rs.getDouble("biayaSewa");
                String status = rs.getString("status");
                String gambarPath = rs.getString("gambarPath");

                dataMobil.setNoPlat(noPlat);
                dataMobil.setJenis(jenis);
                dataMobil.setNoRangka(noRangka);
                dataMobil.setBiayaSewa(biayaSewa);
                dataMobil.setStatus(status);
                dataMobil.setGambarPath(gambarPath);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Gagal mengambil data pelanggan: " + e.getMessage());
        }
        return dataMobil;
    }

    public Sopir_Model getDataSopir(String idSopir){
        Sopir_Model dataSopir = new Sopir_Model();
        try {
            String url = "jdbc:mysql://localhost:3307/pbomobil";
            String user = "root";
            String pass = "Gegecp2005!123";
            Connection conn = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT idSopir, nama, biaya, status, gambarPath FROM Sopir WHERE idSopir = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idSopir);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // String idSopir = rs.getString("idSopir");
                String nama = rs.getString("nama");
                Double biaya = rs.getDouble("biaya");
                String status = rs.getString("status");
                String gambarPath = rs.getString("gambarPath");

                dataSopir.setIdSopir(idSopir);
                dataSopir.setNama(nama);
                dataSopir.setBiaya(biaya);
                dataSopir.setStatus(status);
                dataSopir.setGambarPath(gambarPath);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Gagal mengambil data pelanggan: " + e.getMessage());
        }
        return dataSopir;
    }

    public double hitungBiaya(LocalDate tglAwal, LocalDate tglAkhir, Mobil_Model mobil, Sopir_Model sopir) {
        long hariSewa = ChronoUnit.DAYS.between(tglAwal, tglAkhir);
        double biayaMobil = hariSewa * mobil.getBiayaSewa();
        double biayaSopir = (sopir.getIdSopir() != null && !sopir.getIdSopir().isEmpty()) ? 
                        hariSewa * sopir.getBiaya() : 0;
        return biayaMobil + biayaSopir;
    }
}