/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package no10ab;

/**
 *
 * @author daffa pandora
 */
public class ContohMetodeGenerik {
    // Metode generik untuk menampilkan informasi dan perilaku hewan
    public static <T extends Anabul> void kendalikanDatum(Datum<T> datum) {
        T hewan = datum.getIsi();
        System.out.println("Mengendalikan hewan: " + hewan.getNama());
        hewan.bersuara();
        hewan.bergerak();
        System.out.println("-------------------");
    }

    // Metode generik untuk mengubah isi Datum
    public static <T extends Anabul> void ubahIsiDatum(Datum<T> datum, T isiBaru) {
        datum.setIsi(isiBaru);
        System.out.println("Isi Datum berhasil diubah ke: " + isiBaru.getNama());
    }
}