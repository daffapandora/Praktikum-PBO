public class Main {
    public static void main(String[] args) {
        MainMenu_View menu = new MainMenu_View();
        menu.show(new MainMenu_View.MenuListener() {
            @Override
            public void onBuatTransaksi() {
                // Mulai proses transaksi dari pelanggan
                new Pelanggan_Controller().start();
            }

            @Override
            public void onPembayaran() {
                // Mulai proses pembayaran
                new Pembayaran_Controller();
            }
        });
    }
}