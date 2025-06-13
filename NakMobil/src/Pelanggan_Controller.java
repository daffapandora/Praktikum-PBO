import java.util.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Pelanggan_Controller {
    // attribut
    Pelanggan_Model MPL;
    Pelanggan_View VPL;
    ArrayList<String> dataPelanggan;

    // method
    Pelanggan_Controller(){
        MPL = new Pelanggan_Model();
        VPL = new Pelanggan_View();
    }

    public void start() {
        VPL.showGUI(dataPelanggan -> {
            if (dataPelanggan != null && dataPelanggan.size() == 4) {
                MPL = new Pelanggan_Model(
                    dataPelanggan.get(0),
                    dataPelanggan.get(1),
                    dataPelanggan.get(2),
                    dataPelanggan.get(3)
                );
                String nikPelanggan = dataPelanggan.get(0);
                // Lanjut ke mobil
                new Mobil_Controller().start(nikPelanggan);
            } else {
                System.out.println("Data pelanggan tidak ditemukan atau tidak lengkap.");
            }
        });
    }
}