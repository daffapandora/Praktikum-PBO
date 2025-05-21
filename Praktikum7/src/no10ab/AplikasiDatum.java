/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package no10ab;

/**
 *
 * @author daffa pandora
 */
public class AplikasiDatum {
    public static void main(String[] args) {
        // Membuat objek Datum untuk masing-masing hewan
        Datum<Anjing> datumAnjing = new Datum<>(new Anjing("Buddy", 3, "Cokelat", "Golden Retriever", true));
        Datum<Burung> datumBurung = new Datum<>(new Burung("Polly", 2, "Hijau", "Kakatua", true, 2.5));
        Datum<Kucing> datumKucing = new Datum<>(new Kucing("Milo", 2, "Putih", "Persia", true));

        // Simulasi perilaku hewan dari Datum
        simulasiPerilaku(datumAnjing);
        simulasiPerilaku(datumBurung);
        simulasiPerilaku(datumKucing);
    }

    public static <T extends Anabul> void simulasiPerilaku(Datum<T> datum) {
        T hewan = datum.getIsi();
        hewan.bersuara();
        hewan.bergerak();
        System.out.println(hewan); 
        System.out.println("-------------------");
    }
}