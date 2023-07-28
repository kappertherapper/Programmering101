package storage;

import model.Funktion;
import model.Medarbejder;
import model.Vagt;

import java.util.ArrayList;

public abstract class Storage {

    private static final ArrayList<Funktion> funktioner = new ArrayList<>();
    private static final ArrayList<Medarbejder> medarbejdere = new ArrayList<>();
    private static final ArrayList<Vagt> vagtere = new ArrayList<>();


    // -------------------------------------------------------------------------

    public static ArrayList<Funktion> getFunktioner() {
        return new ArrayList<Funktion>(funktioner);
    }

    public static void storeFunktion(Funktion funktion) {
        funktioner.add(funktion);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Medarbejder> getMedarbejdere() {
        return new ArrayList<>(medarbejdere);
    }

    public static void storeMedarbejder(Medarbejder medarbejder) {
        medarbejdere.add(medarbejder);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Vagt> getVagtere() {
        return new ArrayList<>(vagtere);
    }

    public static void storeVagt(Vagt vagt) {
        vagtere.add(vagt);
    }

    // -------------------------------------------------------------------------
}


