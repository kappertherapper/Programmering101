package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Vagt {
    private String navn;
    private LocalDateTime tidFra;
    private LocalDateTime tidTil;
    private final ArrayList<Medarbejder> medarbejdere = new ArrayList<>();
    private final ArrayList<Antal> antals = new ArrayList<>();
    private final ArrayList<Funktion> funktioner = new ArrayList<>();

    public Vagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil) {
        this.navn = navn;
        this.tidFra = tidFra;
        this.tidTil = tidTil;
    }

    // -------------------------------------------------------------------------

    public String getNavn() {
        return navn;
    }

    public LocalDateTime getTidFra() {
        return tidFra;
    }

    public LocalDateTime getTidTil() {
        return tidTil;
    }

    // -------------------------------------------------------------------------

    public ArrayList<Medarbejder> getMedarbejdere() {
        return medarbejdere;
    }

    public void addMedarbejder(Medarbejder medarbejder) {
        medarbejdere.add(medarbejder);
    }


    // -------------------------------------------------------------------------
    public ArrayList<Funktion> getFunktioner() {
        return funktioner;
    }

    public void addFunktionMedAntal (Funktion funktion, int antalValue) {
        Antal antal = new Antal(antalValue);
        funktioner.add(funktion);
        antals.add(antal);
    }

    // -------------------------------------------------------------------------

    public long elapsedTime() {
        return Duration.between(tidFra,tidTil).toMinutes();
    }

    // -------------------------------------------------------------------------

    /**
     * Returnere medarbejder der møder på angivne tidspunkt
     * og arbejder mindst det angivne antal timer
     */
    public String findMedarbejder(LocalTime tidspunkt, int antalTimer) {
        for (Medarbejder medarbejder : medarbejdere) {
            if (medarbejder.getTypiskMødetid() == tidspunkt && medarbejder.getAntalTimerPrDag() > antalTimer) {
                return medarbejder.getNavn();
            }
        }
        return null;
    }

    // -------------------------------------------------------------------------


    @Override
    public String toString() {
        return navn;
    }

    /**
     * returnerer vagtens samlede timeforbrug
     */
    public int beregnTimeforbrug() {
        int forbrug = 0;
        for (Medarbejder medarbejder : medarbejdere) {
            for (Vagt vagt : medarbejder.getVagter()) {
                forbrug = vagt.getTidFra().getHour() - vagt.getTidTil().getHour();
            }
        }
        return forbrug;
    }

    // -------------------------------------------------------------------------

    /**
     * returnere antal medarbejdere tilknyttet vagten med den angivne funktion
     */
    public ArrayList<Medarbejder> antalMedarbejdereMedFunktion(Funktion funktion) {
        ArrayList<Medarbejder> medarbejderMedFunktion = new ArrayList<>();
        for (Medarbejder medarbejder : medarbejdere) {
            for (Vagt vagt : medarbejder.getVagter()) {
                if (medarbejder.getFunktioner().equals(funktion)) {
                    medarbejderMedFunktion.add(medarbejder);
                }
            }
        }
        return medarbejderMedFunktion;
    }

    // -------------------------------------------------------------------------

    /**
     * returnerer et array med de medarbejdere på vagten,
     * som har typisk mødetid senere end vagtens start tid.
     */
    public Medarbejder[] skalAdviseresOmMødetid() {
        Medarbejder[] medarbejdere = new Medarbejder[100];
        int index = 0;
        for (Medarbejder medarbejder : medarbejdere) {
            for (Vagt vagt : medarbejder.getVagter()) {
                if (medarbejder.getTypiskMødetid().isAfter(LocalTime.from(vagt.getTidFra()))) {
                    medarbejdere[index] = medarbejder;
                    index++;
                }
            }
        }
        return medarbejdere;
    }

    // -------------------------------------------------------------------------

    public ArrayList<String> status(ArrayList<String> arr) {
        // arr has an unsorted part followed by a sorted part,
        // i is the index of the last number in the unsorted part
        for (int i = arr.size() - 1; i > 0; i--) {
            // bubble the biggest number in the unsorted part up to index i
            for (int j = 0; j < i; j++) {
                if (arr.get(j).length() > arr.get(j + 1).length()) {
                    String temp = (arr.get(j));
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
        return arr;
    }
}
