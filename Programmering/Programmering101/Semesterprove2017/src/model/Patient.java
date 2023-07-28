package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Patient {
    private String navn;
    private double vægt;
    private int vægtFaktor;
    private final ArrayList<PersonligtMåltid> personligeMåltider = new ArrayList<>();

    public Patient(String navn, double vægt, int vægtFaktor) {
        this.navn = navn;
        this.vægt = vægt;
        this.vægtFaktor = vægtFaktor;
    }

    // -------------------------------------------------------------------------

    public String getNavn() {
        return navn;
    }

    public double getVægt() {
        return vægt;
    }

    public int getVægtFaktor() {
        return vægtFaktor;
    }

    public ArrayList<PersonligtMåltid> getPersonligeMåltider() {
        return personligeMåltider;
    }

    // -------------------------------------------------------------------------

    public void addPersonligtMåltid(PersonligtMåltid personligtMåltid) {
        personligeMåltider.add(personligtMåltid);
    }

    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return navn + "  " +  vægtFaktor + "  " +  vægt;
    }

    // -------------------------------------------------------------------------

    public double beregnAnbefaletKalorierPerDag() {
        double anbefaletKalorier;
        anbefaletKalorier = vægtFaktor * vægt;

        return anbefaletKalorier;
    }

    // -------------------------------------------------------------------------

    public double beregnDagensAntalKalorier() {
        double spist = 0;
        for (PersonligtMåltid p : personligeMåltider) {
            for (Indtag i : p.getIndtags()) {
                double forskel = i.getVejetFørIndtagelse() - i.getVejetEfterIndtagelse();
                double procent = forskel / i.getVejetFørIndtagelse();
                spist += i.getAnslåetAntalKalorier() * procent;
            }
        }
        return spist;
    }

    // -------------------------------------------------------------------------

    public double beregnProcentDagligAnbefalet() {
        double procent = 0;
        procent = beregnDagensAntalKalorier() / beregnAnbefaletKalorierPerDag() * 100;

        return procent;
    }

    // -------------------------------------------------------------------------

    public List<String> sortMåltider() {
        List<String> navn = new ArrayList<>();
        List<String> anrette = new ArrayList<>();
        for (PersonligtMåltid p : personligeMåltider) {
            navn.add(p.getNavn());
            anrette.add(p.getAnretterNavn());
            Collections.sort(anrette);
            Collections.sort(navn);

        }
        List<String> sorteret = new ArrayList<>();
        sorteret.addAll(anrette);
        sorteret.addAll(navn);

        return sorteret;
    }
}
