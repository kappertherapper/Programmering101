package model;

import javax.swing.text.NumberFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Salgsannonce {
    private static int antalAnnoncer = 0;
    private int annonceNummer;
    private boolean aktiv;
    private LocalDate udløbsDato;
    private final ArrayList<Vare>varer = new ArrayList<>();
    private Sælger sælger;

    public Salgsannonce(Sælger sælger, LocalDate udløbsDato) {
        this.sælger = sælger;
        this.antalAnnoncer = antalAnnoncer+1;
        this.annonceNummer = antalAnnoncer;
        this.aktiv = true;
        this.udløbsDato = udløbsDato.plusDays(30);
    }
    public int getAntalAnnoncer() {
        return antalAnnoncer;
    }

    public int getAnnonceNummer() {
        return annonceNummer;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public LocalDate getUdløbsDato() {
        return udløbsDato;
    }

    public ArrayList<Vare> getVarer() {
        return varer;
    }

    public Sælger getSælger() {
        return sælger;
    }

    // -------------------------------------------------------------------------

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public void setSælger(Sælger sælger) {
        this.sælger = sælger;
    }

    // -------------------------------------------------------------------------

    public void addVare(Vare vare) {
        varer.add(vare);
    }

    // -------------------------------------------------------------------------


    @Override
    public String toString() {
        return  "Nr: " + annonceNummer +
                "  Sælger: " + sælger +
                "  udløbsDato: " + udløbsDato;

    }

    // -------------------------------------------------------------------------

    public int samletAnnonceUdbud() {
        int samletPris = 0;
        for (Vare v : varer) {
            samletPris += v.getUdbudspris();
        }
        return samletPris;
    }

    // -------------------------------------------------------------------------

    public Salgsannonce skalAnnonceVæreAktiv(Salgsannonce salgsannonce) {
        if (LocalDate.now().isAfter(salgsannonce.getUdløbsDato()) || salgsannonce.getVarer().equals(0)) {
            salgsannonce.setAktiv(false);
        }
        return salgsannonce;
    }
}
