package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Conference {
    private String name;
    private String place;
    private LocalDate startDate;
    private LocalDate endDate;
    private final int pricePrDay = 1500;

    //enkeltrettet komposition 1 --> 0..*
    private final ArrayList<Excursion> excursions = new ArrayList<>();
    //enkeltrettet associering 0..* --> 0..*
    private final ArrayList<Hotel> hotels = new ArrayList<>();
    //dobbeltrettet komposition 1 --> 0..*
    private static final ArrayList<Registration> registrations = new ArrayList<>();

    public Conference(String name, String place, LocalDate startDate, LocalDate endDate, int pricePrDay) {
        this.name = name;
        this.place = place;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getPricePrDay() {
        return pricePrDay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return name + " (" + startDate + " - " + endDate + ") " + "\n";
    }


// -----------------------------------------------------------------------------

    public ArrayList<Excursion> getExcursions() {
        return new ArrayList<>(excursions);
    }

    public void addExcursion(Excursion excursion) {
        excursions.add(excursion);
    }

    public void removeExcursion(Excursion excursion) {
        excursions.remove(excursion);
    }

    // -----------------------------------------------------------------------------

    public ArrayList<Hotel> getHotels() {
        return new ArrayList<>(hotels);
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public void removeHotel(Hotel hotel) {
        hotels.remove(hotel);
    }

    // -----------------------------------------------------------------------------

    public static ArrayList<Registration> getRegistrations() {
        return new ArrayList<>(registrations);
    }
    public void addRegistration(Registration registration) {
        registrations.add(registration);
    }
}
