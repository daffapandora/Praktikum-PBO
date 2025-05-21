/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LatihanMedium;

/**
 *
 * @author daffa pandora
 */
public class KontrolSenjata {
    private Senjata senjata;

    public KontrolSenjata(Senjata senjata) {
        this.senjata = senjata;
    }

    public boolean isAdaPeluru() {
        return senjata.getPeluru() > 0;
    }

    public void isiPeluru(int jumlah) {
        senjata.setPeluru(senjata.getPeluru() + jumlah);
        System.out.println(">> Peluru berhasil ditambahkan: " + jumlah);
    }

    public void menembak(int jumlah) {
        System.out.println(">> Slap menembak " + jumlah + " kali");
        if (isAdaPeluru()) {
            senjata.menembak(jumlah);
            System.out.println(">> Peluru sisa: " + senjata.getPeluru());
        } else {
            System.out.println("Peluru Habis");
        }
    }
}