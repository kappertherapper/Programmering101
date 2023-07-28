package storage;

import model.Salg;
import model.Sælger;
import model.Vare;

import java.util.ArrayList;

public abstract class Storage {

    private static final ArrayList<Sælger> sælgere = new ArrayList<>();
    private static final ArrayList<Vare> varer = new ArrayList<>();
    private static final ArrayList<Salg> salgs = new ArrayList<>();


    // -------------------------------------------------------------------------

    public static ArrayList<Sælger> getSælgere() {
        return new ArrayList<Sælger>(sælgere);
    }

    public static void storeSælger(Sælger sælger) {
        sælgere.add(sælger);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public static void storeVare(Vare vare) {
        varer.add(vare);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Salg> getSalgs() {
        return new ArrayList<>(salgs);
    }

    public static void storeSalg(Salg salg) {
        salgs.add(salg);
    }

    // -------------------------------------------------------------------------

}



