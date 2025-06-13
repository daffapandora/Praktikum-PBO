import java.util.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Mobil_View {

    // Callback interface untuk mengirim plat mobil terpilih ke controller
    public interface MobilSelectedListener {
        void onMobilSelected(String platMobil);
    }

    // show versi GUI scrollable & pilih mobil
    public void show(ArrayList<Mobil_Model> dataMobil, MobilSelectedListener listener){
        new JFXPanel(); // Inisialisasi JavaFX jika belum jalan

        Platform.runLater(() -> {
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Daftar Mobil Tersedia");

            VBox content = new VBox(15);
            content.setPadding(new Insets(20));

            ToggleGroup group = new ToggleGroup();

            if (dataMobil != null && !dataMobil.isEmpty()) {
                for (Mobil_Model mobil : dataMobil) {
                    HBox hbox = new HBox(15);
                    hbox.setPadding(new Insets(10));
                    hbox.setStyle("-fx-border-color:rgb(33, 31, 129); -fx-border-radius: 5;");

                    // Gambar
                    ImageView imageView;
                    try {
                        Image img = new Image("file:" + mobil.getGambarPath(), 120, 80, true, true);
                        imageView = new ImageView(img);
                    } catch (Exception e) {
                        imageView = new ImageView();
                    }

                    // Info
                    VBox info = new VBox(5);
                    info.getChildren().addAll(
                        new Label("Nomor Plat: " + mobil.getNoPlat()),
                        new Label("Jenis: " + mobil.getJenis()),
                        new Label("Nomor Rangka: " + mobil.getNoRangka()),
                        new Label(String.format("Biaya Sewa: %.2f", mobil.getBiayaSewa()))
                    );

                    // RadioButton untuk memilih mobil
                    RadioButton selectBtn = new RadioButton("Pilih");
                    selectBtn.setToggleGroup(group);
                    selectBtn.setUserData(mobil.getNoPlat());

                    hbox.getChildren().addAll(imageView, info, selectBtn);
                    content.getChildren().add(hbox);
                }
            } else {
                content.getChildren().add(new Label("Tidak ada mobil tersedia."));
            }

            // Tombol konfirmasi pilihan
            Button confirmBtn = new Button("Konfirmasi Pilihan");
            confirmBtn.setOnAction(e -> {
                RadioButton selected = (RadioButton) group.getSelectedToggle();
                if (selected != null) {
                    String platMobil = (String) selected.getUserData();
                    if (listener != null) {
                        listener.onMobilSelected(platMobil);
                    }
                    primaryStage.close();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Pilih salah satu mobil terlebih dahulu!");
                    alert.showAndWait();
                }
            });

            VBox root = new VBox(15, new ScrollPane(content), confirmBtn);
            root.setPadding(new Insets(10));

            Scene scene = new Scene(root, 500, 400);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        });
    }
}