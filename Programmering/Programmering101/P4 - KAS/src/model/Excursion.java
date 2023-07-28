package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Excursion {
    private String name;
    private String place;
    private LocalDate date;
    private double price;
    private Conference conference;
    //dobbeltrettet associering 0..* --> 0..*
    private final ArrayList<Registration> registrations = new ArrayList<>();

    public Excursion(String name, LocalDate date, double price) {
        this.name = name;
        this.date = date;
        this.price = price;
    }

    //linkmetoder registration
    public ArrayList<Registration> getRegistrations() {
        return new ArrayList<>(registrations);
    }
    public void addRegistration(Registration registration) {
        registrations.add(registration);
    }

    @Override
    public String toString() {
        return "Name: " + name + " (" + date + ") ";
    }


    // -----------------------------------------------------------------------------

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public double getPrice() {
        return price;
    }

    // -----------------------------------------------------------------------------
}
