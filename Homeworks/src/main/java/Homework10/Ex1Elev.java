package Homework10;

public class Ex1Elev {
    private String nume;
    private double nota;

    public Ex1Elev(String nume, double nota) {
        this.nume = nume;
        this.nota = nota;
    }

    public String getNume() {
        return nume;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
