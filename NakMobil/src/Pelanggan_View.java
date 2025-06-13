import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Modality;

public class Pelanggan_View {
    public ArrayList<String> getDataPelanggan() {
        // kamus lokal
        ArrayList<String> dataPelanggan = new ArrayList<>();

        // Inisialisasi JavaFX jika belum jalan
        new JFXPanel();

        final Object lock = new Object();

        Platform.runLater(() -> {
            Stage stage = new Stage();
            stage.setTitle("Input Data Pelanggan");
            stage.initModality(Modality.APPLICATION_MODAL);

            Label nikLabel = new Label("NIK:");
            TextField nikField = new TextField();

            Label namaLabel = new Label("Nama:");
            TextField namaField = new TextField();

            Label alamatLabel = new Label("Alamat:");
            TextField alamatField = new TextField();

            Label telpLabel = new Label("Nomor Telepon:");
            TextField telpField = new TextField();

            Button submitBtn = new Button("Submit");
            Label infoLabel = new Label();

            submitBtn.setOnAction(e -> {
                dataPelanggan.clear();
                dataPelanggan.add(nikField.getText());
                dataPelanggan.add(namaField.getText());
                dataPelanggan.add(alamatField.getText());
                dataPelanggan.add(telpField.getText());
                stage.close();
                synchronized (lock) {
                    lock.notify();
                }
            });

            VBox vbox = new VBox(10, nikLabel, nikField, namaLabel, namaField, alamatLabel, alamatField, telpLabel, telpField, submitBtn, infoLabel);
            vbox.setPadding(new javafx.geometry.Insets(20));

            Scene scene = new Scene(vbox, 350, 350);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        });

        // Tunggu sampai submit ditekan
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        return dataPelanggan;
    }

    public void showGUI(java.util.function.Consumer<ArrayList<String>> listener) {
        new JFXPanel();
        Platform.runLater(() -> {
            Stage stage = new Stage();
            stage.setTitle("Input Data Pelanggan");
            stage.initModality(Modality.APPLICATION_MODAL);

            Label nikLabel = new Label("NIK:");
            TextField nikField = new TextField();
            Label namaLabel = new Label("Nama:");
            TextField namaField = new TextField();
            Label alamatLabel = new Label("Alamat:");
            TextField alamatField = new TextField();
            Label telpLabel = new Label("Nomor Telepon:");
            TextField telpField = new TextField();
            Button submitBtn = new Button("Submit");

            submitBtn.setOnAction(e -> {
                ArrayList<String> dataPelanggan = new ArrayList<>();
                dataPelanggan.add(nikField.getText());
                dataPelanggan.add(namaField.getText());
                dataPelanggan.add(alamatField.getText());
                dataPelanggan.add(telpField.getText());
                stage.close();
                if (listener != null) listener.accept(dataPelanggan);
            });

            VBox vbox = new VBox(10, nikLabel, nikField, namaLabel, namaField, alamatLabel, alamatField, telpLabel, telpField, submitBtn);
            vbox.setPadding(new Insets(20));
            Scene scene = new Scene(vbox, 350, 350);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        });
    }
    
}