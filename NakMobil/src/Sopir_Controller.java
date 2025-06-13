import java.util.*;

public class Sopir_Controller {
    // atribut
    Sopir_View VS;
    Sopir_Model MS;
    String idSopir;
    String status;

    // method
    Sopir_Controller(){
        VS = new Sopir_View();
        MS = new Sopir_Model();

        VS.showGUI(MS.getAvailableSopir(), idSopir -> {
            if (idSopir != null) {
            MS.updateStatus(idSopir, "unavailable");
            }
        });
    }

    public void start(String nikPelanggan, String platMobil) {
        VS.showGUI(MS.getAvailableSopir(), idSopir -> {
            // Update status sopir jika ada yang dipilih
            if (idSopir != null) {
                MS.updateStatus(idSopir, "unavailable");
            }
            // Lanjut ke transaksi
            new Transaksi_Controller(nikPelanggan, platMobil, idSopir);
            VS.closeWindow();
        });
    }
}