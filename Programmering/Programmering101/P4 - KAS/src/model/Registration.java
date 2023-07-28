package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Registration {

    boolean lecturer;
    String businessName;
    String businessPhone;
    String companionName;
    Conference conference;
    Hotel hotel;
    LocalDate arrivalDate;
    LocalDate departDate;
    Participant participant;
    Excursion excursion;
    private static final ArrayList<Excursion> excursions = new ArrayList<>();
    private static final ArrayList<Extra> extras = new ArrayList<>();
    private final ArrayList<Excursion> businessExcursions = new ArrayList<>();

    public Registration(boolean lecturer, Conference conference, Participant participant, LocalDate arrivalDate, LocalDate departDate) {
        this.lecturer = lecturer;
        this.conference = conference;
        this.participant = participant;
        this.arrivalDate = arrivalDate;
        this.departDate = departDate;
    }

    //--------------------------------------------------------------------------------------------
    public String getCompanionName() {
        return companionName;
    }

    public void setCompanionName(String companionName) {
        this.companionName = companionName;
    }

    //--------------------------------------------------------------------------------------------
    public String getBusinessName() {
        return businessName;
    }
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    //--------------------------------------------------------------------------------------------
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public ArrayList<Extra> getChosenExtras() {
        return extras;
    }

    public void addExtra(Extra extra) {
        extras.add(extra);
    }

    //--------------------------------------------------------------------------------------------

    public ArrayList<Excursion> getBusinessExcursions() {
        return new ArrayList<>(businessExcursions);
    }
    public void addExcursion(Excursion excursion) {
        businessExcursions.add(excursion);
    }

    //--------------------------------------------------------------------------------------------
    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    //--------------------------------------------------------------------------------------------
    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    //--------------------------------------------------------------------------------------------
    public double calculatePrice() {
        //hvis der er firma, betaler dette for selve konferencen
        //hvis deltager er foredragsholder, betaler man ikke for selve konferencen

        double price = 0;
        int noOfDays = (int) arrivalDate.until(departDate, ChronoUnit.DAYS);

        //conference
        if (!lecturer) {
            price += conference.getPricePrDay() * (noOfDays + 1);
        }

        //hotel
        if (hotel != null) {
            if (companionName == null) {
                price += hotel.getPriceSingleRoom() * noOfDays;
            } else {
                price += hotel.getPriceDoubleroom() * noOfDays;
            }
        }

        //extras
        if (!extras.isEmpty()) {
            for (Extra e : extras) {
                price += e.getPrice() * noOfDays;
            }
        }

        //excursions
        if (companionName != null && !companionName.isEmpty()) {
            for (Excursion e : businessExcursions) {
                price += e.getPrice();
            }
        }

        return price;
    }

    //--------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Registration: " +  "\n" +
                "Name: " + participant.getName() + "\n" +
                "Lecturer? " + lecturer + "\n" +
                "Friend: " + companionName + "\n" +
                "Hotel: " + hotel.getName() + "\n" +
                "Stay: (" + arrivalDate + " - " + departDate + ") " + "\n" + "\n";
    }
}
