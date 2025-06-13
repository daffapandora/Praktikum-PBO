import java.util.*;

public class Mobil_Controller {
    // atribut
    Mobil_View VM;
    Mobil_Model MM;
    String platMobil;
    String status;

    // method
    Mobil_Controller(){
        VM = new Mobil_View();
        MM = new Mobil_Model();
        // Di Mobil_Controller
        VM.show(MM.getAvailableMobil(), plat -> {
            // plat adalah plat mobil yang dipilih user di GUI
            MM.updateStatus(plat, "unavailable");
            // Lanjutkan proses lain sesuai kebutuhan
        });
    }

    public void start(String nikPelanggan) {
        VM.show(MM.getAvailableMobil(), platMobil -> {
            // Lanjut ke sopir
            new Sopir_Controller().start(nikPelanggan, platMobil);
        });
    }
}
