package model;

import java.util.ArrayList;

public class Antal {
    private int antal;
    private Funktion funktion;

    public Antal(int antal) {
        this.antal = antal;
    }

    // -------------------------------------------------------------------------

    public int getAntal() {
        return antal;
    }

    // -------------------------------------------------------------------------

    public Funktion getFunktion() {
        return funktion;
    }
    public void setFunktion(Funktion funktion) {
        this.funktion = funktion;
    }
}
