package model;

import java.util.ArrayList;
import java.util.Collections;

public class PersonligtMåltid implements Comparable<PersonligtMåltid> {
    private String navn;
    private String anretterNavn;
    private Patient patient;
    private final ArrayList<Indtag> indtags = new ArrayList<>();

    public PersonligtMåltid(String navn, String anretterNavn) {
        this.navn = navn;
        this.anretterNavn = anretterNavn;
    }

    // -------------------------------------------------------------------------

    public String getNavn() {
        return navn;
    }

    public String getAnretterNavn() {
        return anretterNavn;
    }

    public Patient getPatient() {
        return patient;
    }

    public ArrayList<Indtag> getIndtags() {
        return indtags;
    }

    // -------------------------------------------------------------------------

    public void addIntagTilPersonligtmåltid(Indtag indtag) {
        indtags.add(indtag);
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // -------------------------------------------------------------------------

    public static Indtag createIndtag(int vejetFørIndtagelse, int vejetEfterIndtagelse, String beskrivelse, int anslåetAntalKalorier) {
        Indtag indtag = new Indtag(vejetFørIndtagelse, vejetEfterIndtagelse, beskrivelse, anslåetAntalKalorier);
        return indtag;

    }

    // -------------------------------------------------------------------------

    public int beregnAntalKalorier() {
        int antalKalorier = 0;
        int spist = 0;
        for (Indtag i : indtags) {
            i.getAnslåetAntalKalorier();
            spist = i.getVejetFørIndtagelse() - i.getVejetEfterIndtagelse();
            antalKalorier = i.getAnslåetAntalKalorier() - spist;

        }
        return antalKalorier;
    }

    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return navn + "  " +  anretterNavn;
    }

    // -------------------------------------------------------------------------

    @Override
    public int compareTo(PersonligtMåltid other) {
        int compare = (this.anretterNavn.compareTo(other.anretterNavn));
        if (compare == 0) {
            compare = this.navn.compareTo(other.navn);
        }
        return compare;
    }
}
