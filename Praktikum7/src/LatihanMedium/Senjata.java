/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LatihanMedium;

/**
 *
 * @author daffa pandora
 */
public class Senjata {
    private String bunyi;
    private int peluru;
    private boolean menusuk;

    public Senjata(String bunyi) {
        this.bunyi = bunyi;
        this.peluru = 0;
        this.menusuk = false;
    }

    public String getBunyi() {
        return bunyi;
    }

    public int getPeluru() {
        return peluru;
    }

    public boolean isMenusuk() {
        return menusuk;
    }

    public void setBunyi(String bunyi) {
        this.bunyi = bunyi;
    }

    public void setPeluru(int peluru) {
        this.peluru = peluru;
    }

    public void setMenusuk(boolean menusuk) {
        this.menusuk = menusuk;
    }

    public void pasangBayonet() {
        this.menusuk = true;
    }

    public String menusuk() {
        if (menusuk) {
            return "Jleb!";
        } else {
            return "Gagal, belum pasang bayonet";
        }
    }

    public void menembak(int jumlah) {
        if (peluru >= jumlah) {
            for (int i = 0; i < jumlah; i++) {
                System.out.println(bunyi);
            }
            peluru -= jumlah;
        } else {
            System.out.println("Gagal tembak, Peluru Habis");
        }
    }
}
