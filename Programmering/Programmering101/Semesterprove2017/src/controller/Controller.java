package controller;

import model.Indtag;
import model.Patient;
import model.PersonligtMåltid;
import storage.Storage;

import java.util.ArrayList;

public abstract class Controller {

    /**
     * Create a new Patient.
     * Pre: -
     */
    public static Patient createPatient(String navn, double vægt, int vægtFaktor) {
        Patient patient = new Patient(navn, vægt, vægtFaktor);
        Storage.storePatient(patient);
        return patient;
    }

    public static ArrayList<Patient> getPatienter() {
        return Storage.getPatienter();
    }

    // -------------------------------------------------------------------------

    /**
     * Create a new PersonligtMåltid.
     * Pre: -
     */
    public static PersonligtMåltid createPersonligtMåltid(String navn, String anretterNavn) {
        PersonligtMåltid personligtMåltid = new PersonligtMåltid(navn, anretterNavn);
        return personligtMåltid;
    }

    public static void addMåltidToPatient(PersonligtMåltid personligtMåltid, Patient patient) {
        personligtMåltid.setPatient(patient);
        patient.addPersonligtMåltid(personligtMåltid);
    }

    // -------------------------------------------------------------------------

    public static void addIndtagToMåltid(Indtag indtag, PersonligtMåltid personligtMåltid) {
        indtag.setPersonligtMåltid(personligtMåltid);
        personligtMåltid.addIntagTilPersonligtmåltid(indtag);

    }

    // -------------------------------------------------------------------------

    public ArrayList<Integer> findIndtagMedKalorier() {
        ArrayList<Integer> mål = new ArrayList<>();
        for (Patient p : Storage.getPatienter()) {
            for (PersonligtMåltid m : p.getPersonligeMåltider()) {
                for (Indtag i : m.getIndtags()) {
                    if (i.getAnslåetAntalKalorier() >= 0) {
                        mål.add(i.getAnslåetAntalKalorier());
                    }
                }
            }
        }
        return mål;
    }
}

    // -------------------------------------------------------------------------
