package storage;

import Model.Bestilling;
import Model.Forestilling;
import Model.Kunde;
import Model.Plads;
import java.util.AbstractList;
import java.util.ArrayList;

public abstract class Storage {

    private static final ArrayList<Forestilling> forestillinger = new ArrayList<>();
    private static final ArrayList<Kunde> kunder = new ArrayList<>();
    private static final ArrayList<Plads> pladser = new ArrayList<>();
    private static final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    // -------------------------------------------------------------------------

    public static ArrayList<Forestilling> getForestillinger() {
        return new ArrayList<Forestilling>(forestillinger);
    }

    public static void storeForstilling(Forestilling forestilling) {
        forestillinger.add(forestilling);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Kunde> getKunder() {
        return new ArrayList<>(kunder);
    }

    public static void storeKunde(Kunde kunde) {
        kunder.add(kunde);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public static void storePladser(Plads plads) {
        pladser.add(plads);
    }

    public static ArrayList<Bestilling> getBestilling() {

        return bestillinger;
    }
}
