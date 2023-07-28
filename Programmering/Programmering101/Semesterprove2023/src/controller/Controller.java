package controller;

import model.Bane;
import model.Booking;
import model.Kategori;
import model.Spiller;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Controller {
    /**
     * Opretter ny Spiller
     * Pre: navn empty, Uddannelse empty
     */
    public static Spiller createSpiller(String navn, String uddannelse) {
        Spiller spiller = new Spiller(navn, uddannelse);
        Storage.storeSpiller(spiller);
        return spiller;
    }

    // -------------------------------------------------------------------------

    /**
     * Opretter ny Bane
     * Pre: nummer null, inde false, førsteTid null, sidsteTid null
     */
    public static Bane createBane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori) {
        Bane bane = new Bane(nummer, inde, førsteTid, sidsteTid, kategori);
        Storage.storeBane(bane);
        return bane;
    }

    // -------------------------------------------------------------------------

    /**
     * Opretter ny Kategori
     * Pre: navn empty, prisKrSingle null, PriskrDouble null
     */
    public static Kategori createKategori(String navn, int prisKrSingle, int prisKrDouble) {
        Kategori kategori = new Kategori(navn, prisKrSingle, prisKrDouble);
        Storage.storeVagt(kategori);
        return kategori;
    }

    // -------------------------------------------------------------------------

    /**
     * Opretter ny Booking
     * Pre: navn empty, prisKrSingle null, PriskrDouble null
     */
    public static Booking createBooking(Spiller spiller, Bane bane, LocalDate dato, LocalTime tid, boolean single) {
        Booking booking = new Booking(spiller, bane, dato, tid, single);
        Storage.storeBooking(booking);
        return booking;
    }

    // -------------------------------------------------------------------------

    public static void addBookingtilSpiller(Spiller spiller, Booking booking) {
        spiller.addBooking(booking);
    }

    public static void addBookingtilBane(Bane bane, Booking booking) {
        bane.addBooking(booking);
    }

    // -------------------------------------------------------------------------

    /**
     * Returnere den samlede tid for bookinger til double spil
     * foretaget af spillere på den givne uddannelse på baner af den givne kategori
     */
    public int samletBooketDoubleTid(String uddannelse, Kategori kategori) {
        int samletTid = 0;
        for (Booking booking : Storage.getBookinger())
            if (booking.getSpiller().getUddannelse() == uddannelse && booking.getBane().getKategori() == kategori
                    && booking.isSingle() == false) {
                samletTid += booking.getTid().getHour();

            }
        return samletTid;
    }

    // -------------------------------------------------------------------------

    /**
     *
     *  Metoden tager en dato, en tid og en kategori som parametre
     *  og søge efter en ledig bane med den givne kategori på det angivne tidspunkt.
     *  Returnere den ledige bane, hvis en den findes, ellers returneres null
     */
    public Bane findLedigBane(ArrayList<Bane> list, LocalDate dato, LocalTime tid, Kategori kategori) {
        boolean found = false;
        int i = 0;
        while (!found && i < list.size()) {
            Bane b = list.get(i);
            for (Booking booking : Storage.getBookinger()) {
                if (b.getKategori() == kategori && booking.getDato() == dato && booking.getTid() == tid){
                    found = true;
                    return b;
                } else {
                    i++;
                }
            }
        }
        return null;
    }

    // -------------------------------------------------------------------------

    public static void udskrivBookinger(String filNavn) {
        File in = new File(filNavn);
        try (PrintWriter b = new PrintWriter(in)) {
            for (Booking bookinger : Storage.getBookinger()) {
                b.println(bookinger);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Sorry! An unexpected error has occurred.");
            System.err.println("Technical message: " + ex.getMessage());
        }
    }
}