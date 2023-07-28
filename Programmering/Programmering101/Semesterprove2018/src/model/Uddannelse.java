package model;

import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Uddannelse {
    private String navn;
    private static final ArrayList<Hold> holds = new ArrayList<>();

    public Uddannelse(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public static ArrayList<Hold> getHolds() {
        return holds;
    }

    public void addHold(Hold hold) {
        holds.add(hold);
    }

    /**
     * Returnere liste over alle tutore
     * Uddannelse driller (null)w
     */
    public static ArrayList<String> tutorOversigt() {
        ArrayList<String> tutorOversigt = new ArrayList<>();
        for (Hold h : holds) {
            if (h.getTutor() != null) {
            tutorOversigt.add(h.getTutor().toString());
            //tutorOversigt.add(h.getUddannelse().toString());
            tutorOversigt.add(h.getBetegnelse().toString());
            tutorOversigt.add(h.getTutor().getEmail());
            tutorOversigt.add(h.getHoldleder());
            }
        }
        return tutorOversigt;
    }

    /**
     * opretter ny fil
     * Virker ikke
     * @throws FileNotFoundException
     */
    public static void tutorOversigtTilFil(String filnavn) {
        File in = new File(filnavn);
        for (Uddannelse u : Storage.getUddannelser()) {
            filnavn += u.tutorOversigt().toString();
        }
    }
}

