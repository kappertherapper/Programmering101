package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fag {
    private final String navn;
    private final String klasse;
    private final ArrayList<Lektion> lektioner = new ArrayList<>();

    public Fag(String navn, String klasse) {
        this.navn = navn;
        this.klasse = klasse;
    }

    public ArrayList<Lektion> getLektioner() {
        return lektioner;
    }

    public void addLektion (Lektion lektion) {
        lektioner.add(lektion);
    }

    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return navn + " " +  klasse;
    }

    // -------------------------------------------------------------------------

    public ArrayList<Studerende> sygdomPåDato(LocalDate dato) {
        ArrayList<Studerende> sygdom = new ArrayList<>();
        for (Lektion lektion : lektioner) {
            for (Deltagelse deltagelse : lektion.getDeltagelser()) {
                if (lektion.equals(dato) && deltagelse.equals(DeltagerStatus.SYG)) {
                    sygdom.add(deltagelse.getStuderende());
            }
            }
        }
        return sygdom;
    }

    // -------------------------------------------------------------------------

    public int lektionMestFravær() {
        int max = 0;
        for (Lektion lektion : lektioner) {
            int fravær = 0;
            for (Deltagelse deltagelse : lektion.getDeltagelser()) {
                if (deltagelse.equals(DeltagerStatus.FRAVÆR)) {
                    fravær++;
                    if (fravær > max) {
                        max = fravær;
                    }
                    if (fravær == max) {
                        max = Integer.parseInt(null);
                    }
                }
            }
        }
        return max;
    }
}
