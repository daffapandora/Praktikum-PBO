/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author daffa pandora
 */
public class BangunDatarGeneric<T extends BangunDatar> {
    private T bangunDatar;

    public void set(T bangunDatar) {
        this.bangunDatar = bangunDatar;
    }

    public T get() {
        return bangunDatar;
    }

    public double hitungLuas() {
        return bangunDatar.hitungLuas();
    }

    public double hitungKeliling() {
        return bangunDatar.hitungKeliling();
    }
}