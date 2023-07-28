package model;

import java.util.ArrayList;

public class Salg {
    private String købersNavn;
    private int aftaltSamletPris;
    private final ArrayList<Vare>varer = new ArrayList<>();

    public Salg(String købersNavn, int aftaltSamletPris) {
        this.købersNavn = købersNavn;
        this.aftaltSamletPris = aftaltSamletPris;
    }

    public String getKøbersNavn() {
        return købersNavn;
    }

    public int getAftaltSamletPris() {
        return aftaltSamletPris;
    }

    public ArrayList<Vare> getVarer() {
        return varer;
    }

    // -------------------------------------------------------------------------

    public void addVare(Vare vare) {
        varer.add(vare);
    }

    // -------------------------------------------------------------------------

    public int samletPris() {
        int samletPris = 0;
        for (Vare vare : varer) {
            samletPris += vare.getUdbudspris();
        }
        return samletPris;
    }
}
