package storage;

import model.Fag;
import model.Studerende;
import java.util.ArrayList;

public abstract class Storage {

    private static final ArrayList<Fag> fags = new ArrayList<>();
    private static final ArrayList<Studerende> studerendende = new ArrayList<>();


    // -------------------------------------------------------------------------

    public static ArrayList<Fag> getFag() {
        return new ArrayList<Fag>(fags);
    }

    public static void storeFag(Fag fag) {
        fags.add(fag);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Studerende> getStuderendende() {
        return new ArrayList<>(studerendende);
    }

    public static void storeStuderende(Studerende studerende) {
        studerendende.add(studerende);
    }
}

    // -------------------------------------------------------------------------


