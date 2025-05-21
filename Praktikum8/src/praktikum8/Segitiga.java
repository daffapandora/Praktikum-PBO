/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author daffa pandora
 */
public class Segitiga extends BangunDatar {
    private double alas;
    private double tinggi;
    private double sisiMiring;

    public Segitiga(double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiMiring = Math.sqrt(alas * alas + tinggi * tinggi);
    }

    @Override
    public double hitungLuas() {
        return (alas * tinggi) / 2;
    }

    @Override
    public double hitungKeliling() {
        return alas + tinggi + sisiMiring;
    }
}
