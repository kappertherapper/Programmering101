package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    private LocalDate dato;
    private Kunde kunde;
    private final Forestilling forestilling;
    private ArrayList<Plads> pladser;

    public Bestilling(LocalDate dato, Forestilling forestilling, Kunde kunde, ArrayList<Plads> pladser) {
        this.forestilling = forestilling;
        this.kunde = kunde;
        this.pladser = pladser;
        this.dato = dato;
    }

    public LocalDate getDato() {
        return dato;
    }

    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public int samletpris(Bestilling bestilling) {
        int pris = 0;
        for (Plads p : pladser) {
            pris += p.getPris(); {

            }
        }

        return pris;
    }
}