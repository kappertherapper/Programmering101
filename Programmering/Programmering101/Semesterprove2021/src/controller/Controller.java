package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Controller {
    /**
     * Laver ny studerende
     */
    public static Studerende createStuderende(String navn, String email) {
        Studerende studerende = new Studerende(navn, email);
        Storage.storeStuderende(studerende);
        return studerende;
    }

    /**
     * Laver ny et nyt fag
     */
    public static Fag createFag(String navn, String klasse) {
        Fag fag = new Fag(navn, klasse);
        Storage.storeFag(fag);
        return fag;
    }

    /**
     * Laver ny Lektion
     */
    public static Lektion createLektion(LocalDate dato, LocalTime startTid, String lokale) {
        Lektion lektion = new Lektion(dato, startTid, lokale);
        return lektion;
    }


    public static void opretDeltagelser(Fag fag, Studerende studerende) {
        ArrayList<Deltagelse> deltagelser = new ArrayList<>();
        for (Lektion lek : fag.getLektioner()) {
            Deltagelse deltagelse = new Deltagelse(false, DeltagerStatus.TILSTEDE, lek, studerende);
            deltagelser.add(deltagelse);
            lek.addDeltagelse(deltagelse);

        }

        studerende.setDeltagelser(deltagelser);
    }

//        for (Deltagelse deltagelse : studerende.getDeltagelser()) {
//            if (studerende.equals(DeltagerStatus.TILSTEDE) && studerende.equals(deltagelse.isRegistreret() == false)) {
//                deltagelse.setFag(fag);
//                deltagelse.setStuderende(studerende);
//                deltagelse.setLektion(lektion);
//            }


    public static ArrayList<Studerende> studerendeTilObservation(int grænse) {
        ArrayList<Studerende> slemmeBorn = new ArrayList<>();
        Studerende studerende = null;
        for (Deltagelse deltagelse : studerende.getDeltagelser())
            if (deltagelse.getStuderende().antalFraværsLektioner() > grænse)
                slemmeBorn.add(deltagelse.getStuderende());

        for (int i = 0; i < slemmeBorn.size() - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < slemmeBorn.size(); j++) {
                if (slemmeBorn.get(j).compareTo(slemmeBorn.get(indexOfMin)) < 0) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                Studerende temp = slemmeBorn.get(i);
                slemmeBorn.set(i, slemmeBorn.get(indexOfMin));
                slemmeBorn.set(indexOfMin, temp);
            }
        }
        return slemmeBorn;
    }
}
