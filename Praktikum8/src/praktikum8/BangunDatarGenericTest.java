/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author daffa pandora
 */
public class BangunDatarGenericTest {
    public static void main(String[] args) {
        BangunDatarGeneric<Persegi> persegi = new BangunDatarGeneric<>();
        persegi.set(new Persegi(5));
        System.out.println("Luas Persegi: " + persegi.hitungLuas());

        BangunDatarGeneric<PersegiPanjang> persegiPanjang = new BangunDatarGeneric<>();
        persegiPanjang.set(new PersegiPanjang(4, 6));
        System.out.println("Keliling Persegi Panjang: " + persegiPanjang.hitungKeliling());

        BangunDatarGeneric<Segitiga> segitiga = new BangunDatarGeneric<>();
        segitiga.set(new Segitiga(3, 4));
        System.out.println("Luas Segitiga: " + segitiga.hitungLuas());
    }
}