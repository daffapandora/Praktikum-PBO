/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8lanjutan;

/**
 *
 * @author daffa pandora
 */
public class KoleksiAnabul<T extends Anabul> {
    private Koleksi<T> koleksi;

    public KoleksiAnabul(int kapasitas) {
        koleksi = new Koleksi<>(kapasitas);
    }

    public void addAnabul(T anabul) {
        koleksi.add(anabul);
    }

    public void showAll() {
        for (int i = 0; i < koleksi.getSize(); i++) {
            T anabul = koleksi.getIsi(i);
            System.out.println("Nama: " + anabul.getNama());
            anabul.bersuara();
            anabul.bergerak();
            System.out.println("-------------------");
        }
    }
}