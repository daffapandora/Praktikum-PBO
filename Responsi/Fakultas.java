package PBO.Responsi;

public class Fakultas {
    // Atribut
    private String namaFakultas;
    private double tarifUKT;
    private double gajiPokok;

    // Konstruktor
    public Fakultas(String namaFakultas, double tarifUKT, double gajiPokok) {
        this.namaFakultas = namaFakultas;
        this.tarifUKT = tarifUKT;
        this.gajiPokok = gajiPokok;
    }

    // Selektor (getter)
    public String getNamaFakultas() {
        return namaFakultas;
    }

    public double getTarifUKT() {
        return tarifUKT;
    }

    public double getGajiPokok() {
        return gajiPokok;
    }

    // Mutator (setter)
    public void setNamaFakultas(String namaFakultas) {
        this.namaFakultas = namaFakultas;
    }

    public void setTarifUKT(double tarifUKT) {
        this.tarifUKT = tarifUKT;
    }

    public void setGajiPokok(double gajiPokok) {
        this.gajiPokok = gajiPokok;
    }
}
