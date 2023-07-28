package storage;

import model.*;

import java.util.ArrayList;

import model.Conference;

public abstract class Storage {
    private static final ArrayList<Conference> conferences = new ArrayList<>();
    private static final ArrayList<Excursion> excursions = new ArrayList<>();
    private static final ArrayList<Hotel> hotels = new ArrayList<>();
    private static final ArrayList<Extra> extras = new ArrayList<>();
    private static final ArrayList<Registration> registrations = new ArrayList<>();

    // --------------------------------------------------------------------------

    public static ArrayList<Conference> getConferences() {
        return new ArrayList<>(conferences);
    }

    public static void storeConference(Conference conference) {
        conferences.add(conference);
    }

    public static void deleteConference(Conference conference) {
        conferences.remove(conference);
    }


    // -------------------------------------------------------------------------

    public static ArrayList<Excursion> getExcursions() {
        return new ArrayList<>(excursions);
    }

    public static void storeExcursion(Excursion excursion) {
        excursions.add(excursion);
    }

    public static void deleteExcursion(Excursion excursion) {
        excursions.remove(excursion);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Hotel> getHotels() {
        return new ArrayList<>(hotels);
    }

    public static void storeHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public static void deleteHotel(Hotel hotel) {
        hotels.remove(hotel);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Extra> getExtras() {
        return new ArrayList<>(extras);
    }

    public static void storeExtra(Extra extra) {
        extras.add(extra);
    }

    public static void deleteExtra(Extra extra) {
        extras.remove(extra);
    }
}
