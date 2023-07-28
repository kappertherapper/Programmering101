package model;

import java.util.ArrayList;

public class Spiller {
    String navn;
    String uddannelse;
    ArrayList<Booking> bookinger = new ArrayList<>();

    public Spiller(String navn, String uddannelse) {
        this.navn = navn;
        this.uddannelse = uddannelse;
    }

    // -------------------------------------------------------------------------

    public String getNavn() {
        return navn;
    }
    public String getUddannelse() {
        return uddannelse;
    }

    public ArrayList<Booking> getBookinger() {
        return bookinger;
    }
    // -------------------------------------------------------------------------

    public void addBooking(Booking booking) {
        bookinger.add(booking);
    }

    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return navn + "(" + uddannelse + ")";
    }

    // -------------------------------------------------------------------------

    public int samletPris(Kategori kategori) {
        int samletPris = 0;
        String s = "single";
        String d = "double";
        for (Booking booking : bookinger) {
            if (booking.getBane().getKategori() == kategori) {
                if (kategori.getNavn() == s ) {
                    samletPris += kategori.getPrisKrSingle();
                } else if (kategori.getNavn() == d) {
                    samletPris += kategori.getPrisKrDouble();
                }
            }
        }
        return samletPris;
    }
}
