/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LatihanTutorial;

/**
 *
 * @author daffa pandora
 */
public class testSenjata {
    public static void main(String[] args) {
        Senjata ak47 = new Senjata("TAR");
        Senjata m16 = new Senjata("DOR"); // Nama variabel diperbaiki

        System.out.print("AK47 Menembak 3x: ");
        ak47.menembak(3); // Method diperbaiki
        System.out.print("M16 Menembak 1x: ");
        m16.menembak(1); // Method dan variabel diperbaiki

        System.out.println("AK47 menusuk: " + ak47.menusuk());
        ak47.pasangBayonet();
        System.out.println("AK47 menusuk: " + ak47.menusuk());
    }
}
