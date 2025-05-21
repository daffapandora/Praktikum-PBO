/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8lanjutan;

/**
 *
 * @author daffa pandora
 */
public class MainKoleksiAnabul {
    public static void main(String[] args) {
        KoleksiAnabul<Anabul> koleksi = new KoleksiAnabul<>(10);
        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random() * 3);
            switch (random) {
                case 0:
                    koleksi.addAnabul(new Kucing("Kucing " + i));
                    break;
                case 1:
                    koleksi.addAnabul(new Anjing("Anjing " + i));
                    break;
                case 2:
                    koleksi.addAnabul(new Burung("Burung " + i));
                    break;
            }
        }
        koleksi.showAll();
    }
}
