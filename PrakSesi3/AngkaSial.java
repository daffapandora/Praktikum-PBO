package PBO.PrakSesi3;

public class AngkaSial {
    public void cobaAngka(int angka) throws AngkaSialException {
        System.out.println("Mencoba angka " + angka);
        if (angka == 13) {
            throw new AngkaSialException("Angka sial terdeteksi!");
        }
        System.out.println(angka + " bukan angka sial.");
    }

    public static void main(String[] args) {
        AngkaSial angkaSial = new AngkaSial();
        try {
            angkaSial.cobaAngka(10);
            angkaSial.cobaAngka(13);
            angkaSial.cobaAngka(5);
        } catch (AngkaSialException e) {
            System.out.println("Exception ditangkap: " + e.getMessage());
            System.out.println("hati-hati memasukkan angka!!!");
        }
    }
}