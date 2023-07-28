package model;

import controller.Controller;

import java.time.LocalTime;
import java.util.ArrayList;

public class Medarbejder {
    private String navn;
    private int antalTimerPrDag;
    private LocalTime typiskMødetid;
    private final ArrayList<Vagt> vagter = new ArrayList<>();
    private final ArrayList<Funktion> funktioner = new ArrayList<>();

    public Medarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        this.navn = navn;
        this.antalTimerPrDag = antalTimerPrDag;
        this.typiskMødetid = typiskMødetid;
    }

    // -------------------------------------------------------------------------

    public String getNavn() {
        return navn;
    }

    public int getAntalTimerPrDag() {
        return antalTimerPrDag;
    }

    public LocalTime getTypiskMødetid() {
        return typiskMødetid;
    }

    public ArrayList<Vagt> getVagter() {
        return vagter;
    }

    // -------------------------------------------------------------------------

    public void addFunktion (Funktion funktion) {
        funktioner.add(funktion);
    }

    // -------------------------------------------------------------------------

    public ArrayList<Funktion> getFunktioner() {
        return funktioner;
    }

    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return  "Navn: " + navn +
                ", Typisk mødetid: " + typiskMødetid;
    }

    // -------------------------------------------------------------------------



    public void TilføjMedarbejderTilVagt(Vagt vagt, Medarbejder medarbejder) {
        try {
            while (medarbejder.getTypiskMødetid().isBefore(LocalTime.from(vagt.getTidFra())) &&
                    medarbejder.getTypiskMødetid().isAfter(LocalTime.from(vagt.getTidTil()))) {
                Controller.addMedarbejderTilVagt(medarbejder, vagt);
            }
        } catch (RuntimeException ex) {
            System.out.println(medarbejder.getNavn() + "Har allerede en vagt samme dato som: ");
            System.out.println(vagt.getNavn());
        }
    }

}
