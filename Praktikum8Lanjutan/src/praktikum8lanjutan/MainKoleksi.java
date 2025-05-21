/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8lanjutan;

/**
 *
 * @author daffa pandora
 */
public class MainKoleksi {
    public static void main(String[] args) {
        Koleksi<Character> koleksi = new Koleksi<>(10);
        for (char c = 'A'; c <= 'J'; c++) {
            koleksi.add(c);
        }
        koleksi.showAll();
    }
}
