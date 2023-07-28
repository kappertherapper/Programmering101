package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    LocalDate dato;
    LocalTime tid;
    boolean single;
    Spiller spiller;
    Bane bane;


    public Booking(Spiller spiller, Bane bane, LocalDate dato, LocalTime tid, boolean single) {
        this.spiller = spiller;
        this.bane = bane;
        this.dato = dato;
        this.tid = tid;
        this.single = single;
    }

    // -------------------------------------------------------------------------

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public boolean isSingle() {
        return single;
    }

    public Spiller getSpiller() {
        return spiller;
    }

    public Bane getBane() {
        return bane;
    }
    // -------------------------------------------------------------------------


    @Override
    public String toString() {
        return "Bane: " + bane.getNummer() +
                ", dag: " + dato +
                " kl. " + tid +
                ", single: " + single +
                ", spiller: " + spiller;
    }
}
