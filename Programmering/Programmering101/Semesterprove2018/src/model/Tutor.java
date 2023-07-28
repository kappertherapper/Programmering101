package model;

import java.util.ArrayList;

public class Tutor {
    private String navn;
    private String email;
    private final ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public Tutor(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Arrangement> getArrangementer() {
        return arrangementer;
    }

    @Override
    public String toString() {
        return "Navn = " + navn;
    }

    public double arrangementsPris() {
        double pris = 0;
        for (Arrangement arrangement : arrangementer) {
            pris += arrangement.getPris();
        }
        return pris;
    }
}
