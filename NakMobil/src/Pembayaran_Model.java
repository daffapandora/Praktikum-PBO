import java.time.*;
import java.time.temporal.ChronoUnit;
import java.sql.*;

public class Pembayaran_Model {
    // atribut
    private String idPembayaran;
    private LocalDate tglPembayaran;
    private double nominalPembayaran;

    // konstruktor
    public Pembayaran_Model(){
        this.idPembayaran = "";
        this.tglPembayaran = LocalDate.now();
        this.nominalPembayaran = 0.0;
    }

    public Pembayaran_Model(String idPembayaran, LocalDate tglPembayaran, double nominalPembayaran){
        this.idPembayaran = idPembayaran;
        this.tglPembayaran = tglPembayaran;
        this.nominalPembayaran = nominalPembayaran;
    }

    // selektor
    public String getIdPembayaran(){ return idPembayaran; }
    public LocalDate getTglPembayaran(){ return tglPembayaran; }
    public double getNominalPembayaran(){ return nominalPembayaran; }

    // mutator
    public void setIdPembayaran(String idPembayaran){ this.idPembayaran = idPembayaran; }
    public void setTglPembayaran(LocalDate tglPembayaran){ this.tglPembayaran = tglPembayaran; }
    public void setNominalPembayaran(double nominalPembayaran){ this.nominalPembayaran = nominalPembayaran; }

    // Denda otomatis dihitung dari tglAkhir ke hari ini
    public double denda(Transaksi_Model transaksi){
        LocalDate tglAkhir = transaksi.getTglAkhir();
        LocalDate today = LocalDate.now();
        long hariTerlambat = ChronoUnit.DAYS.between(tglAkhir, today);
        if (hariTerlambat > 0) {
            return hariTerlambat * (2 * transaksi.getMobil().getBiayaSewa());
        } else {
            return 0;
        }
    }

    public double hitungTotalBiaya(Transaksi_Model transaksi){
        double nominal = 0.0;
        double denda = denda(transaksi);
        if (transaksi.getPembayaran() != null) {
            nominal = transaksi.getPembayaran().getNominalPembayaran();
        }
        return nominal + denda;
    }

    public Transaksi_Model getDataTransaksi(String idTransaksi){
        Transaksi_Model dataTransaksi = new Transaksi_Model();
        try {
            String url = "jdbc:mysql://localhost:3307/pbomobil";
            String user = "root";
            String pass = "Gegecp2005!123";
            Connection conn = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT * FROM Transaksi WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idTransaksi);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String id = rs.getString("id");
                LocalDate tglAwal = rs.getDate("tglAwal").toLocalDate();
                LocalDate tglAkhir = rs.getDate("tglAkhir").toLocalDate();
                String status = rs.getString("status");
                String nik = rs.getString("nikPelanggan");
                String plat = rs.getString("platMobil");
                String idPembayaran = rs.getString("idPembayaran");
                String idSopir = rs.getString("idSopir");
                double nominalPembayaranTransaksi = rs.getDouble("nominalPembayaran");

                Pelanggan_Model pelanggan = new Transaksi_Model().getDataPelanggan(nik);
                Mobil_Model mobil = new Transaksi_Model().getDataMobil(plat);
                Pembayaran_Model pembayaran = null;
                try {
                    String sqlPembayaran = "SELECT * FROM pembayaran WHERE idTransaksi = ?";
                    PreparedStatement psPembayaran = conn.prepareStatement(sqlPembayaran);
                    psPembayaran.setString(1, idTransaksi);
                    ResultSet rsPembayaran = psPembayaran.executeQuery();
                    if (rsPembayaran.next()) {
                        String idPembayaranDb = rsPembayaran.getString("idPembayaran");
                        LocalDate tglPembayaranDb = rsPembayaran.getDate("tglPembayaran").toLocalDate();
                        double nominalPembayaranDb = rsPembayaran.getDouble("nominalPembayaran");
                        pembayaran = new Pembayaran_Model(idPembayaranDb, tglPembayaranDb, nominalPembayaranDb);
                    } else {
                        pembayaran = new Pembayaran_Model();
                        pembayaran.setNominalPembayaran(nominalPembayaranTransaksi);
                    }
                    rsPembayaran.close();
                    psPembayaran.close();
                } catch (SQLException e) {
                    pembayaran = new Pembayaran_Model();
                    pembayaran.setNominalPembayaran(nominalPembayaranTransaksi);
                }
                Sopir_Model sopir = new Transaksi_Model().getDataSopir(idSopir);

                dataTransaksi.setId(id);
                dataTransaksi.setTglAwal(tglAwal);
                dataTransaksi.setTglAkhir(tglAkhir);
                dataTransaksi.setStatus(status);
                dataTransaksi.setPelanggan(pelanggan);
                dataTransaksi.setMobil(mobil);
                dataTransaksi.setSopir(sopir);
                dataTransaksi.setNominalPembayaran(nominalPembayaranTransaksi);
                dataTransaksi.setPembayaran(pembayaran);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Gagal mengambil data transaksi: " + e.getMessage());
        }
        return dataTransaksi;
    }

    public void konfirmasiPembayaran(String idTransaksi) {
        try {
            String url = "jdbc:mysql://localhost:3307/pbomobil";
            String user = "root";
            String pass = "Gegecp2005!123";
            Connection conn = DriverManager.getConnection(url, user, pass);

            String sql = "UPDATE Transaksi SET status = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "paid");
            ps.setString(2, idTransaksi);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Status transaksi berhasil diubah menjadi 'paid'.");
            } else {
                System.out.println("Transaksi tidak ditemukan.");
            }

            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Gagal mengubah status transaksi: " + e.getMessage());
        }
    }

    public void simpanPembayaran(String idTransaksi, String metode) {
        try {
            String url = "jdbc:mysql://localhost:3307/pbomobil";
            String user = "root";
            String pass = "Gegecp2005!123";
            Connection conn = DriverManager.getConnection(url, user, pass);

            // Ambil nominal pembayaran dari transaksi
            Transaksi_Model transaksi = getDataTransaksi(idTransaksi);
            double nominal = 0.0;
            if (transaksi.getPembayaran() != null) {
                nominal = transaksi.getPembayaran().getNominalPembayaran();
            }

            String idPembayaran = java.util.UUID.randomUUID().toString();
            LocalDate tgl = LocalDate.now();

            String sql = "INSERT INTO pembayaran (idPembayaran, idTransaksi, metode, nominalPembayaran, tglPembayaran, status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idPembayaran);
            ps.setString(2, idTransaksi);
            ps.setString(3, metode);
            ps.setDouble(4, nominal);
            ps.setDate(5, java.sql.Date.valueOf(tgl));
            ps.setString(6, "paid");

            ps.executeUpdate();
            ps.close();
            conn.close();
            System.out.println("Pembayaran berhasil disimpan.");
        } catch (SQLException e) {
            System.out.println("Gagal menyimpan pembayaran: " + e.getMessage());
        }
    }
}