import java.util.*;
import java.time.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Transaksi_View {
    // method GUI, gunakan callback
    public void getPeriodeSewa(java.util.function.Consumer<ArrayList<LocalDate>> listener) {
        new JFXPanel(); // Inisialisasi JavaFX jika belum jalan

        Platform.runLater(() -> {
            Stage stage = new Stage();
            stage.setTitle("Input Periode Sewa");
            stage.initModality(Modality.APPLICATION_MODAL);

            Label lblMulai = new Label("Tanggal Mulai:");
            DatePicker dpMulai = new DatePicker();

            Label lblAkhir = new Label("Tanggal Akhir:");
            DatePicker dpAkhir = new DatePicker();

            Button submitBtn = new Button("Submit");
            Label infoLabel = new Label();

            submitBtn.setOnAction(e -> {
                ArrayList<LocalDate> dataPeriodeSewa = new ArrayList<>();
                LocalDate tglMulai = dpMulai.getValue();
                LocalDate tglAkhir = dpAkhir.getValue();
                if (tglMulai == null || tglAkhir == null) {
                    infoLabel.setText("Tanggal tidak boleh kosong!");
                    return;
                }
                dataPeriodeSewa.add(tglMulai);
                dataPeriodeSewa.add(tglAkhir);
                stage.close();
                if (listener != null) listener.accept(dataPeriodeSewa);
            });

            VBox vbox = new VBox(10, lblMulai, dpMulai, lblAkhir, dpAkhir, submitBtn, infoLabel);
            vbox.setPadding(new Insets(20));
            stage.setScene(new Scene(vbox, 300, 250));
            stage.show();
        });
    }

    // Tampilkan info transaksi, biaya, dan tombol konfirmasi
    public void showAll(
        String idTransaksi,
        Pelanggan_Model pelanggan,
        Mobil_Model mobil,
        Sopir_Model sopir,
        LocalDate tglAwal,
        LocalDate tglAkhir,
        double nominalBiaya,
        Runnable konfirmasiCallback 
    ) {
        new JFXPanel();
        Platform.runLater(() -> {
            Stage stage = new Stage();
            stage.setTitle("Konfirmasi Transaksi");
            stage.initModality(Modality.APPLICATION_MODAL);

            VBox vbox = new VBox(10);
            vbox.setPadding(new Insets(20));

            // Info Transaksi
            vbox.getChildren().add(new Label("ID Transaksi: " + idTransaksi));
            vbox.getChildren().add(new Label("Tanggal Awal: " + tglAwal));
            vbox.getChildren().add(new Label("Tanggal Akhir: " + tglAkhir));

            // Info Pelanggan
            vbox.getChildren().add(new Label("Pelanggan: " + pelanggan.getNama() + " (" + pelanggan.getNIK() + ")"));

            // Info Mobil
            vbox.getChildren().add(new Label("Mobil: " + mobil.getNoPlat() + " - " + mobil.getJenis()));

            // Info Sopir (opsional)
            if (sopir != null && sopir.getIdSopir() != null && !sopir.getIdSopir().isEmpty()) {
                vbox.getChildren().add(new Label("Sopir: " + sopir.getNama() + " (" + sopir.getIdSopir() + ")"));
            } else {
                vbox.getChildren().add(new Label("Sopir: (Tanpa Sopir)"));
            }

            // Info Biaya
            vbox.getChildren().add(new Label("Total Biaya: Rp " + String.format("%.2f", nominalBiaya)));

            // Tombol konfirmasi
            Button btnKonfirmasi = new Button("Konfirmasi Transaksi");
            btnKonfirmasi.setOnAction(e -> {
                stage.close();
                if (konfirmasiCallback != null) konfirmasiCallback.run();
            });

            vbox.getChildren().add(btnKonfirmasi);

            Scene scene = new Scene(vbox, 350, 350);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        });
    }
}