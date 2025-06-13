public class Pembayaran_Controller {
    private Pembayaran_View VP;
    private Pembayaran_Model MP;

    public Pembayaran_Controller() {
        VP = new Pembayaran_View();
        MP = new Pembayaran_Model();

        VP.inputIdTransaksi(idTransaksi -> {
            // Tampilkan detail transaksi
            VP.showDetailTransaksi(idTransaksi, () -> {
                // Pilih metode pembayaran
                VP.pilihMetodePembayaran(metode -> {
                    // Simpan pembayaran ke database
                    MP.simpanPembayaran(idTransaksi, metode);
                    // Update status transaksi
                    MP.konfirmasiPembayaran(idTransaksi);

                    // --- Tambahan: Update status mobil & sopir ke available ---
                    Transaksi_Model transaksi = MP.getDataTransaksi(idTransaksi);
                    if (transaksi != null) {
                        // Update mobil
                        Mobil_Model mobilModel = new Mobil_Model();
                        mobilModel.updateStatus(transaksi.getMobil().getNoPlat(), "available");
                        // Update sopir jika ada
                        if (transaksi.getSopir() != null && transaksi.getSopir().getIdSopir() != null && !transaksi.getSopir().getIdSopir().isEmpty()) {
                            Sopir_Model sopirModel = new Sopir_Model();
                            sopirModel.updateStatus(transaksi.getSopir().getIdSopir(), "available");
                        }
                    }
                    // --- End tambahan ---

                    // Tampilkan info selesai
                    VP.showDetailTransaksi(idTransaksi, null, true);
                });
            }, false);
        });
    }
}