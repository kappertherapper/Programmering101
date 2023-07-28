package model;

import java.util.ArrayList;

public class Funktion {
    private String navn;
    private final ArrayList<Antal> antals = new ArrayList<>();

    public Funktion(String navn) {
        this.navn = navn;
    }

    // -------------------------------------------------------------------------

    public String getNavn() {
        return navn;
    }

    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return antals + navn;
    }

    public void addAntal(Antal antal) {
        antals.add(antal);
    }
}
