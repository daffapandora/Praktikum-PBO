import java.util.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Modality;

public class Pembayaran_View {
    // GUI input idTransaksi
    public void inputIdTransaksi(java.util.function.Consumer<String> listener) {
        new JFXPanel();
        Platform.runLater(() -> {
            Stage stage = new Stage();
            stage.setTitle("Input ID Transaksi");
            stage.initModality(Modality.APPLICATION_MODAL);

            Label label = new Label("Input ID Transaksi:");
            TextField tf = new TextField();
            Button submitBtn = new Button("Submit");

            submitBtn.setOnAction(e -> {
                String id = tf.getText();
                stage.close();
                if (listener != null) listener.accept(id);
            });

            VBox vbox = new VBox(10, label, tf, submitBtn);
            vbox.setPadding(new Insets(20));
            stage.setScene(new Scene(vbox, 300, 120));
            stage.show();
        });
    }

    // Tampilkan detail transaksi dan tombol lanjut ke metode pembayaran
    public void showDetailTransaksi(String idTransaksi, Runnable lanjutCallback) {
        showDetailTransaksi(idTransaksi, lanjutCallback, false);
    }

    // Tampilkan detail transaksi dan tombol lanjut ke metode pembayaran
    public void showDetailTransaksi(String idTransaksi, Runnable lanjutCallback, boolean isSelesai) {
        Pembayaran_Model pembayaranModel = new Pembayaran_Model();
        Transaksi_Model transaksi = pembayaranModel.getDataTransaksi(idTransaksi);

        new JFXPanel();
        Platform.runLater(() -> {
            Stage stage = new Stage();
            stage.setTitle("Detail Transaksi");
            stage.initModality(Modality.APPLICATION_MODAL);

            VBox vbox = new VBox(10);
            vbox.setPadding(new Insets(20));

            if (transaksi != null && transaksi.getId() != null) {
                vbox.getChildren().add(new Label("ID Transaksi: " + transaksi.getId()));
                vbox.getChildren().add(new Label("Status: " + transaksi.getStatus()));
                vbox.getChildren().add(new Label("Tanggal Awal: " + transaksi.getTglAwal()));
                vbox.getChildren().add(new Label("Tanggal Akhir: " + transaksi.getTglAkhir()));
                vbox.getChildren().add(new Label("Nominal Pembayaran: " + transaksi.getNominalPembayaran()));
                // Tanggal pembayaran
                if (transaksi.getPembayaran() != null && transaksi.getPembayaran().getTglPembayaran() != null) {
                    vbox.getChildren().add(new Label("Tanggal Pembayaran: " + transaksi.getPembayaran().getTglPembayaran()));
                }
                double total = pembayaranModel.hitungTotalBiaya(transaksi);
                vbox.getChildren().add(new Label("Total (termasuk denda): " + total));

                Button btn;
                if (isSelesai) {
                    btn = new Button("Selesai");
                    btn.setOnAction(e -> stage.close());
                } else {
                    btn = new Button("Lanjut ke Pembayaran");
                    btn.setOnAction(e -> {
                        stage.close();
                        if (lanjutCallback != null) lanjutCallback.run();
                    });
                }
                vbox.getChildren().add(btn);
            } else {
                vbox.getChildren().add(new Label("Transaksi tidak ditemukan."));
            }

            Scene scene = new Scene(vbox, 350, 320);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        });
    }

    // GUI pilih metode pembayaran
    public void pilihMetodePembayaran(java.util.function.Consumer<String> listener) {
        new JFXPanel();
        Platform.runLater(() -> {
            Stage stage = new Stage();
            stage.setTitle("Pilih Metode Pembayaran");
            stage.initModality(Modality.APPLICATION_MODAL);

            ToggleGroup group = new ToggleGroup();
            RadioButton tunai = new RadioButton("Tunai");
            RadioButton kredit = new RadioButton("Kredit");
            RadioButton mobile = new RadioButton("MobilePayment");
            tunai.setToggleGroup(group);
            kredit.setToggleGroup(group);
            mobile.setToggleGroup(group);

            Button submitBtn = new Button("Konfirmasi Pembayaran");

            submitBtn.setOnAction(e -> {
                RadioButton selected = (RadioButton) group.getSelectedToggle();
                if (selected != null) {
                    stage.close();
                    if (listener != null) listener.accept(selected.getText());
                }
            });

            VBox vbox = new VBox(10, new Label("Pilih Metode Pembayaran:"), tunai, kredit, mobile, submitBtn);
            vbox.setPadding(new Insets(20));
            stage.setScene(new Scene(vbox, 300, 200));
            stage.show();
        });
    }
}