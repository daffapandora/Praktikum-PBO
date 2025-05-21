/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8lanjutan;

/**
 *
 * @author daffa pandora
 */
public class Koleksi<T> {
    private Object[] wadah;
    private int nbelm;

    public Koleksi(int kapasitas) {
        wadah = new Object[kapasitas];
        nbelm = 0;
    }

    public void add(T element) {
        if (nbelm < wadah.length) {
            wadah[nbelm++] = element;
        } else {
            System.out.println("Koleksi penuh!");
        }
    }

    public T getIsi(int index) {
        if (index < nbelm) {
            return (T) wadah[index];
        }
        return null;
    }

    public void setIsi(int index, T element) {
        if (index < nbelm) {
            wadah[index] = element;
        }
    }

    public int getSize() {
        return nbelm;
    }

    public void delete(int index) {
        if (index < nbelm) {
            for (int i = index; i < nbelm - 1; i++) {
                wadah[i] = wadah[i + 1];
            }
            nbelm--;
        }
    }

    public void showAll() {
        for (int i = 0; i < nbelm; i++) {
            System.out.println(wadah[i]);
        }
    }
}
