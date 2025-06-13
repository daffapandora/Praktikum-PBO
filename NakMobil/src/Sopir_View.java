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

public class Sopir_View {
    private Stage sopirStage; 

    // method CLI tetap
    public String getSopir(){
        String idSopir;
        System.out.println("Input IdSopir : ");
        Scanner s = new Scanner(System.in);
        idSopir = s.nextLine();
        return idSopir;
    }

    public void show(ArrayList<Sopir_Model> dataSopir){
        System.out.println("Daftar Sopir Tersedia:");
        if (dataSopir != null && !dataSopir.isEmpty()) {
            for (Sopir_Model sopir : dataSopir) {
                System.out.println("Nomor Plat: " + sopir.getIdSopir());
                System.out.println("Nama: " + sopir.getNama());
                System.out.printf("Biaya Sewa: %.2f%n", sopir.getBiaya());
                System.out.println("Status : " + sopir.getStatus());
                System.out.println("Path Gambar: " + sopir.getGambarPath());
                System.out.println("-----------------------------");
            }  
        }
        else {
            System.out.println("Tidak ada sopir tersedia.");
        }
    }

    // Tambahan: GUI scrollable & pilih sopir (opsional)
    public void showGUI(ArrayList<Sopir_Model> dataSopir, SopirSelectedListener listener){
        new JFXPanel(); // Inisialisasi JavaFX jika belum jalan

        Platform.runLater(() -> {
            sopirStage = new Stage(); 
            sopirStage.setTitle("Pilih Sopir");

            VBox content = new VBox(15);
            content.setPadding(new Insets(20));

            ToggleGroup group = new ToggleGroup();

            // Opsi tanpa sopir
            RadioButton tanpaSopirBtn = new RadioButton("Tanpa Sopir");
            tanpaSopirBtn.setToggleGroup(group);
            tanpaSopirBtn.setUserData(null);
            content.getChildren().add(tanpaSopirBtn);

            if (dataSopir != null && !dataSopir.isEmpty()) {
                for (Sopir_Model sopir : dataSopir) {
                    HBox hbox = new HBox(15);
                    hbox.setPadding(new Insets(10));
                    hbox.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5;");

                    // Gambar
                    ImageView imageView;
                    try {
                        Image img = new Image("file:" + sopir.getGambarPath(), 120, 80, true, true);
                        imageView = new ImageView(img);
                    } catch (Exception e) {
                        imageView = new ImageView();
                    }

                    // Info
                    VBox info = new VBox(5);
                    info.getChildren().addAll(
                        new Label("ID Sopir: " + sopir.getIdSopir()),
                        new Label("Nama: " + sopir.getNama()),
                        new Label(String.format("Biaya Sewa: %.2f", sopir.getBiaya())),
                        new Label("Status: " + sopir.getStatus())
                    );

                    // RadioButton untuk memilih sopir
                    RadioButton selectBtn = new RadioButton("Pilih");
                    selectBtn.setToggleGroup(group);
                    selectBtn.setUserData(sopir.getIdSopir());

                    hbox.getChildren().addAll(imageView, info, selectBtn);
                    content.getChildren().add(hbox);
                }
            } else {
                content.getChildren().add(new Label("Tidak ada sopir tersedia."));
            }

            // Tombol konfirmasi pilihan
            Button confirmBtn = new Button("Konfirmasi Pilihan");
            confirmBtn.setOnAction(e -> {
                RadioButton selected = (RadioButton) group.getSelectedToggle();
                if (selected != null) {
                    String idSopir = (String) selected.getUserData();
                    if (listener != null) {
                        listener.onSopirSelected(idSopir);
                    }
                    sopirStage.close(); 
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Pilih salah satu sopir atau tanpa sopir terlebih dahulu!");
                    alert.showAndWait();
                }
            });

            VBox root = new VBox(15, new ScrollPane(content), confirmBtn);
            root.setPadding(new Insets(10));

            Scene scene = new Scene(root, 500, 400);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); // Tambahkan baris ini
            sopirStage.setScene(scene);
            sopirStage.show();
        });
    }

    // Method untuk menutup window dari luar (controller)
    public void closeWindow() {
        Platform.runLater(() -> {
            if (sopirStage != null && sopirStage.isShowing()) {
                sopirStage.close();
            }
        });
    }

    // Callback interface untuk controller
    public interface SopirSelectedListener {
        void onSopirSelected(String idSopir); // null jika tanpa sopir
    }
}
