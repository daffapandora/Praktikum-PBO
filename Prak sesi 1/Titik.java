public class Titik {
    private double absis;
    private double ordinat;
    private static int counterTitik = 0;

    // Constructor without parameters
    public Titik() {
        absis = 0.0;
        ordinat = 0.0;
        counterTitik++;
    }

    // Constructor with parameters (overloading)
    public Titik(double x, double y) {
        this.absis = x;
        this.ordinat = y;
        counterTitik++;
    }

    public void setAbsis(double x) {
        this.absis = x;
    }

    public void setOrdinat(double y) {
        this.ordinat = y;
    }

    public double getAbsis() {
        return this.absis;
    }

    public double getOrdinat() {
        return this.ordinat;
    }

    public static int getCounterTitik() {
        return counterTitik;
    }

    // Additional methods based on the class diagram
    public double getJarakPusat() {
        return Math.sqrt(Math.pow(absis, 2) + Math.pow(ordinat, 2));
    }

    public void refleksiX() {
        this.ordinat = -this.ordinat;
    }

    public void refleksiY() {
        this.absis = -this.absis;
    }

    public Titik getRefleksiX() {
        return new Titik(this.absis, -this.ordinat);
    }

    public Titik getRefleksiY() {
        return new Titik(-this.absis, this.ordinat);
    }
}