package model;

import java.util.ArrayList;

public class Vare {
    private Varekategori kategori;
    private String navn;
    private int udbudspris;
    private boolean solgt;
    private Salgsannonce salgsannonce;

    public Vare(Varekategori kategori, String navn, int udbudspris) {
        this.kategori = kategori;
        this.navn = navn;
        this.udbudspris = udbudspris;
        this.solgt = solgt;
    }

    public Varekategori getKategori() {
        return kategori;
    }

    public String getNavn() {
        return navn;
    }

    public int getUdbudspris() {
        return udbudspris;
    }

    // -------------------------------------------------------------------------

    public boolean isSolgt() {
        return solgt;
    }

    public void setSalgsannonce(Salgsannonce salgsannonce) {
        this.salgsannonce = salgsannonce;
    }

    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return  "Navn: " + navn +
                ", Udbudspris: " + udbudspris +
                " solgt?: " + solgt;
    }
}
