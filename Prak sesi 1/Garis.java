public class Garis {
    private Titik titikAwal;
    private Titik titikAkhir;
    private static int counterGaris = 0;

    // Constructor without parameters
    public Garis() {
        titikAwal = new Titik(0.0, 0.0);
        titikAkhir = new Titik(1.0, 1.0);
        counterGaris++;
    }

    // Constructor with parameters
    public Garis(Titik awal, Titik akhir) {
        titikAwal = awal;
        titikAkhir = akhir;
        counterGaris++;
    }

    // Getters and setters
    public Titik getTitikAwal() {
        return titikAwal;
    }

    public Titik getTitikAkhir() {
        return titikAkhir;
    }

    public void setTitikAwal(Titik titik) {
        titikAwal = titik;
    }

    public void setTitikAkhir(Titik titik) {
        titikAkhir = titik;
    }

    public static int getCounterGaris() {
        return counterGaris;
    }

    // Get length of the line
    public double getPanjang() {
        double dx = titikAkhir.getAbsis() - titikAwal.getAbsis();
        double dy = titikAkhir.getOrdinat() - titikAwal.getOrdinat();
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Get gradient of the line
    public double getGradien() {
        double dx = titikAkhir.getAbsis() - titikAwal.getAbsis();
        double dy = titikAkhir.getOrdinat() - titikAwal.getOrdinat();
        return dy / dx;
    }

    // Get middle point
    public Titik getTitikTengah() {
        double midX = (titikAwal.getAbsis() + titikAkhir.getAbsis()) / 2;
        double midY = (titikAwal.getOrdinat() + titikAkhir.getOrdinat()) / 2;
        return new Titik(midX, midY);
    }

    // Check if parallel with another line
    public boolean isSejajar(Garis g) {
        return Math.abs(this.getGradien() - g.getGradien()) < 0.001;
    }

    // Check if perpendicular with another line
    public boolean isTegakLurus(Garis g) {
        return Math.abs(this.getGradien() * g.getGradien() + 1) < 0.001;
    }

    // Display endpoints
    public void display() {
        System.out.println("Garis dari titik (" + titikAwal.getAbsis() + "," + 
                          titikAwal.getOrdinat() + ") ke (" + titikAkhir.getAbsis() + 
                          "," + titikAkhir.getOrdinat() + ")");
    }

    // Get line equation as string (y = mx + c)
    public String getPersamaanGaris() {
        double m = getGradien();
        double c = titikAwal.getOrdinat() - (m * titikAwal.getAbsis());
        return String.format("y = %.2fx + %.2f", m, c);
    }
}
