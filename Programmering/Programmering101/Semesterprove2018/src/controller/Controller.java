package controller;

import model.Arrangement;
import model.Hold;
import model.Tutor;
import model.Uddannelse;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Controller {

    /**
     * Create a new Uddannelse.
     * Pre: -
     */
    public static Uddannelse CreateUddannelse(String name) {
        Uddannelse uddannelse = new Uddannelse(name);
        Storage.storeUddannelse(uddannelse);
        return uddannelse;
    }

    /**
     * Update the conference.
     * Pre: Name, place, start and end date
     */
//    public static void updateConference(Conference conference, String name, String place, LocalDate startDate, LocalDate endDate) {
//        Uddannelse.set(name);
//    }
    public static ArrayList<Uddannelse> getUddannelser() {
        return Storage.getUddannelser();
    }

    // -------------------------------------------------------------------------

    /**
     * Create a new Tutor.
     * Pre: -
     */
    public static Tutor createTutor(String name, String email) {
        Tutor tutor = new Tutor(name, email);
        Storage.storeTutor(tutor);
        return tutor;
    }

    /**
     * Delete the excursion.
     * Pre: Conference associated with a excursion
     */
//    public static void deleteExcursion(Excursion excursion) {
//        Conference conference = excursion.getConference();
//        if (conference != null) {
//            conference.removeExcursion(excursion);
//        }
//        Storage.deleteExcursion(excursion);
//    }

    /**
     * Update the excursion.
     * Pre: name and place
     */
//    public static void updateExcursion(Excursion excursion, String name, String place) {
//        excursion.set(name);
//        excursion.setPlace(place);
//    }
    public static ArrayList<Tutor> getTutore() {
        return Storage.getTutore();

    }

    // -------------------------------------------------------------------------

    /**
     * Create a new Arrangement.
     * Pre: -
     */
    public static Arrangement createArragement(String titel, LocalDate date, LocalTime startTid, LocalTime slutTid, Double pris) {
        Arrangement arrangement = new Arrangement(titel, date, startTid, slutTid, pris);
        Storage.StoreArrangement(arrangement);
        return arrangement;
    }

    /**
     * Add tutor to arrangement
     */
    public static void addTutorToArrangement(Tutor tutor, Arrangement arrangement){
        try {
            arrangement.addTutor(tutor);
        } catch (RuntimeException ex) {

        }
    }

    public static ArrayList<Arrangement> getArrangementer() {
        return Storage.getArrangementer();

    }

    /**
     * Create a new Hold.
     * Pre: -
     */
    public static Hold createHold(String betegnelse, String holdleder) {
        Hold hold = new Hold(betegnelse, holdleder);
        Storage.storeHold(hold);
        return hold;
    }

    public static void addTutorToHold(Tutor tutor, Hold hold) {
        hold.setTutor(tutor);
    }

    /**
     * Returnere hold uden tutor
     */
    public static ArrayList<Hold> holdUdenTutorer() {
    ArrayList<Hold> tutorløs = new ArrayList<>();
    for (Hold h : Uddannelse.getHolds()) {
        if (h.getTutor() == null) {
            tutorløs.add(h);
        }
    }
        return tutorløs;
    }
    // -------------------------------------------------------------------------
}