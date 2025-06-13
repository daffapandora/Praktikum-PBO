import java.time.LocalDate;
import java.util.*;

public class Transaksi_Controller {
    private Transaksi_View VT;
    private Transaksi_Model MT;
    private String idPelanggan; 
    private String platMobil;
    private String idSopir;
    private ArrayList<LocalDate> Periode;
    double nominalBiaya;

    public Transaksi_Controller(String idPelanggan, String platMobil, String idSopir) {
        VT = new Transaksi_View();
        MT = new Transaksi_Model();

        // Ambil data dari database sesuai pilihan user
        Pelanggan_Model pelanggan = MT.getDataPelanggan(idPelanggan);
        Mobil_Model mobil = MT.getDataMobil(platMobil);
        Sopir_Model sopir = (idSopir != null && !idSopir.isEmpty()) ? MT.getDataSopir(idSopir) : new Sopir_Model();

        // Ambil periode sewa dari view
        VT.getPeriodeSewa(periode -> {
            LocalDate tglAwal = periode.get(0);
            LocalDate tglAkhir = periode.get(1);

            // Hitung biaya
            nominalBiaya = MT.hitungBiaya(tglAwal, tglAkhir, mobil, sopir);

            Pembayaran_Model pembayaran = new Pembayaran_Model();
            pembayaran.setIdPembayaran(UUID.randomUUID().toString());
            pembayaran.setNominalPembayaran(nominalBiaya);

            String idTransaksi = UUID.randomUUID().toString();

            String status = "unpaid";

            VT.showAll(
                idTransaksi,
                pelanggan,
                mobil,
                sopir,
                tglAwal,
                tglAkhir,
                nominalBiaya,
                () -> {
                    // Callback ini dipanggil saat user klik tombol konfirmasi
                    new Transaksi_Model(idTransaksi, tglAwal, tglAkhir, status, pelanggan, mobil, pembayaran, sopir);
                    System.out.println("Transaksi berhasil dibuat dan disimpan ke database!");
                }
            );
        });
    }
}