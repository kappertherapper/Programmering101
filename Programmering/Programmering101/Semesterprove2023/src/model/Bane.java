package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {
    int nummer;
    boolean inde;
    LocalTime førsteTid;
    LocalTime sidsteTid;
    ArrayList<Booking> bookinger = new ArrayList<>();
    Kategori kategori;

    public Bane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori) {
        this.nummer = nummer;
        this.inde = inde;
        this.førsteTid = førsteTid;
        this.sidsteTid = sidsteTid;
        this.kategori = kategori;

    }

    // -------------------------------------------------------------------------

    public int getNummer() {
        return nummer;
    }

    public boolean isInde() {
        return inde;
    }

    public LocalTime getFørsteTid() {
        return førsteTid;
    }

    public LocalTime getSidsteTid() {
        return sidsteTid;
    }

    public ArrayList<Booking> getBookinger() {
        return bookinger;
    }

    public Kategori getKategori() {
        return kategori;
    }

    // -------------------------------------------------------------------------
    public void addBooking(Booking booking) {
        bookinger.add(booking);
    }

    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Nr. "+ nummer + " inde: " + inde +
                " ("+ førsteTid + "->" + sidsteTid + ")" +
                ", " + kategori;
    }


    // -------------------------------------------------------------------------

    /**
     * Returnere samlet antal bookede timer på dato som parameter.
     */
    public int bookedeTimerPåDato(LocalDate dato) {
        int samletTid = 0;
        for (Booking booking : bookinger) {
            if (booking.getDato() == dato) {
                samletTid += booking.getTid().getHour();
            }
        }
        return samletTid;
    }

    public Booking[] antalBookningerPrTime() {
        Booking[] antalBookinger = new Booking[0];
        int count = 0;
            for (Booking booking : bookinger) {
                booking.getBane();
                if (booking.getTid().equals(0)) {
                    count++;
                }
            }
        return antalBookinger;
    }

    /**
     * Metoden tager en dato og en tid som parametre
     * og returnere true for ledig, false for opdaget
     */
    public boolean tidLedig(ArrayList<Booking> list, LocalDate dato, LocalTime tid) {
        boolean found = false;
        int i = 0;
        while (!found && i < list.size()) {
            Booking b = list.get(i);
            if (b.getDato() == dato && b.getTid() == tid) {
                found = true;
            } else {
                i++;
            }
        }
        return found;
    }
}
