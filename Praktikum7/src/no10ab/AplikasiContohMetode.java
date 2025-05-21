/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package no10ab;

/**
 *
 * @author daffa pandora
 */
public class AplikasiContohMetode {
    public static void main(String[] args) {
        // Inisialisasi objek Datum
        Datum<Anabul> datum1 = new Datum<>(new Anjing("Rex", 4, "Hitam"));
        Datum<Anabul> datum2 = new Datum<>(new Burung("Tweety", 1, "Kuning"));
        Datum<Anabul> datum3 = new Datum<>(new Kucing("Whiskers", 2, "Abu-abu"));

        // Menggunakan metode generik untuk mengendalikan Datum
        ContohMetodeGenerik.kendalikanDatum(datum1);
        ContohMetodeGenerik.kendalikanDatum(datum2);
        ContohMetodeGenerik.kendalikanDatum(datum3);

        // Mengubah isi Datum dan menampilkan kembali
        ContohMetodeGenerik.ubahIsiDatum(datum1, new Burung("Pip", 2, "Biru"));
        ContohMetodeGenerik.kendalikanDatum(datum1);
    }
}
