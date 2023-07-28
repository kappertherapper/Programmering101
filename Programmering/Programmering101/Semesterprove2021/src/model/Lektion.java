package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Lektion {
    LocalDate dato;
    LocalTime startTid;
    String lokale;
    ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Lektion(LocalDate dato, LocalTime startTid, String lokale) {
        this.dato = dato;
        this.startTid = startTid;
        this.lokale = lokale;
    }

    // -------------------------------------------------------------------------

    public ArrayList<Deltagelse> getDeltagelser() {
        return deltagelser;
    }

    public void addDeltagelse(Deltagelse deltagelse) {
        deltagelser.add(deltagelse);
    }

    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return  dato + " " + startTid + " " + lokale;
    }
}
