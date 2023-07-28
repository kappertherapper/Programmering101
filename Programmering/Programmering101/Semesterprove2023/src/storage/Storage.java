package storage;

import model.Bane;
import model.Booking;
import model.Kategori;
import model.Spiller;

import java.util.ArrayList;

public abstract class Storage {

    private static final ArrayList<Spiller> spillere = new ArrayList<>();
    private static final ArrayList<Bane> Baner = new ArrayList<>();
    private static final ArrayList<Kategori> kategorier = new ArrayList<>();
    private static final ArrayList<Booking> bookinger = new ArrayList<>();

    // -------------------------------------------------------------------------

    public static ArrayList<Spiller> getSpillere() {
        return new ArrayList<Spiller>(spillere);
    }

    public static void storeSpiller(Spiller spiller) {
        spillere.add(spiller);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Bane> getBaner() {
        return new ArrayList<>(Baner);
    }

    public static void storeBane(Bane bane) {
        Baner.add(bane);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Kategori> getKategorier() {
        return new ArrayList<>(kategorier);
    }

    public static void storeVagt(Kategori kategori) {
        kategorier.add(kategori);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Booking> getBookinger() {
        return new ArrayList<>(bookinger);
    }

    public static void storeBooking(Booking booking) {
        bookinger.add(booking);
    }

}



