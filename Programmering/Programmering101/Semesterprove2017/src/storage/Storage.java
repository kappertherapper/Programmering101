package storage;

import model.Patient;

import java.util.ArrayList;

public abstract class Storage {

    private static final ArrayList<Patient> patienter = new ArrayList<>();

    // -------------------------------------------------------------------------

    public static ArrayList<Patient> getPatienter() {
        return new ArrayList<Patient>(patienter);
    }

    public static void storePatient(Patient patient) {
        patienter.add(patient);
    }
}

    // -------------------------------------------------------------------------
