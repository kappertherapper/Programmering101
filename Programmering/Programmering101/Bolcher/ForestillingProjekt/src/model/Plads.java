package ForestillingProjekt.Model;

import java.util.ArrayList;

public class Plads {
    private int række;
    private int nr;
    private int pris;
    private PladsType pladsType;

    public Plads(int række, int nr, int pris, PladsType pladsType) {
        this.række = række;
        this.nr = nr;
        this.pris = pris;
        this.pladsType = pladsType;
    }

    public enum PladsType {
        STANDARD,
        LANGEBEN,
        KØRESTOl
    }

    public void setPladsType(PladsType pladsType) {
        this.pladsType = pladsType;
    }

    public int getRække() {
        return række;
    }

    public int getNr() {
        return nr;
    }

    public int getPris() {
        return pris;
    }


    @Override
    public String toString() {
        return String.format("Rk: %2d nr: %d (kr. %2d %s) \n", række, nr, pris, pladsType);
    }
}



