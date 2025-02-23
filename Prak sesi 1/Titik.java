/*Nama File : Titik.java
 *Deskripsi : berisi berisi program Titik
 *Pembuat   : Daffa Pandora El-farisin/24060123140185
 *Tanggal   : 20 Februari 2025
*/

public class Titik {
    /* States/Atribut */
    double absis;
    double ordinat;
    static int CounterTitik = 0;
    /* Behavior/Method */

    // Konstruktor
    Titik() {
        absis = 0;
        ordinat = 0;
        CounterTitik++;
    }
    
    Titik(double x, double y) {
        absis = x;
        ordinat = y;
        CounterTitik++;
    }

    // Mengembalikan nilai absis
    double getAbsis() {
        return absis;
    }

    // Mengembalikan nilai ordinat
    double getOrdinat() {
        return ordinat;
    }

    // Mengubah nilai absis
    void setAbsis(double x) {
        this.absis = x;
    }

    // Mengubah nilai ordinat
    void setOrdinat(double y) {
        this.ordinat = y;
    }

    // Menggeser nilai absis dan ordinat masing-masing sejauh x dan y
    void geser(double x, double y) {
        absis += x;
        ordinat += y;
    }

    // Mengembalikan nilai kuadran
    int getKuadran() {
        if(absis > 0 && ordinat > 0){
            return 1;
        }
        else if(absis < 0 && ordinat > 0){
            return 2;
        }
        else if(absis < 0 && ordinat < 0){
            return 3;
        }
        else if(absis > 0 && ordinat < 0){
            return 4;
        }
        else{
            return 0;
        }
    }

    // Mengembalikan nilai jarak pusat
    double getJarakPusat() {
        return Math.sqrt(Math.pow(absis, 2) + Math.pow(ordinat, 2));
    }
    
    // Mengembalikan nilai jarak
    double getJarak(Titik T){
        return Math.sqrt(Math.pow(this.getAbsis() - T.getAbsis(), 2) + Math.pow(this.getOrdinat() - T.getOrdinat(), 2));
    }

    // Mengubah nilai refleksi X
    void refleksiX() {
        this.ordinat = this.getOrdinat() * (-1);
    }

    // Mengubah nilai refleksi Y
    void refleksiY() {
        this.absis = -this.absis;
    }

    // Mengembalikan nilai refleksi 
    public Titik getRefleksiX() {
        return new Titik(this.absis, -this.ordinat);
    }

    // Mengembalikan nilai refleksi Y
    public Titik getRefleksiY() {
        return new Titik(-this.absis, this.ordinat);
    }

    // Mengembalikan nilai CounterTitik
    static int getCounterTitik(){
        return CounterTitik;
    }

    // Mencetak koordinat titik
    void printTitik() {
        System.out.println("Titik (" + absis + ", " + ordinat + ")");
    }
}
