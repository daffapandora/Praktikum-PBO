import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu_View {
    public interface MenuListener {
        void onBuatTransaksi();
        void onPembayaran();
    }

    public void show(MenuListener listener) {
        new JFXPanel(); 

        Platform.runLater(() -> {
            Stage stage = new Stage();
            stage.setTitle("Menu Utama NakMobil");

            Label title = new Label("Rental Mobil Nak Mobil");
            title.getStyleClass().add("title-label");

            Button btnTransaksi = new Button("Buat Transaksi");
            Button btnPembayaran = new Button("Pembayaran");

            btnTransaksi.setOnAction(e -> {
                stage.close();
                if (listener != null) listener.onBuatTransaksi();
            });

            btnPembayaran.setOnAction(e -> {
                stage.close();
                if (listener != null) listener.onPembayaran();
            });

            VBox vbox = new VBox(30, title, btnTransaksi, btnPembayaran);
            vbox.setPadding(new Insets(50));
            vbox.setPrefWidth(400);
            vbox.setPrefHeight(350);
            vbox.setAlignment(Pos.CENTER);

            Scene scene = new Scene(vbox, 400, 350);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        });
    }
}