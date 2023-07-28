package controller;

import model.*;
import storage.Storage;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {

    /**
     * Create a new conference.
     * Pre: -
     */
    public static Conference createConference(String name, String place, LocalDate startDate, LocalDate endDate, int pricePrDay) {
        Conference conference = new Conference(name, place, startDate, endDate, pricePrDay);
        //conference.addHotel(hotel);
        Storage.storeConference(conference);
        return conference;
    }

    /**
     * Update the conference.
     * Pre: Name, place, start and end date
     */
    public static void updateConference(Conference conference, String name, String place, LocalDate startDate, LocalDate endDate) {
        conference.setName(name);
        conference.setPlace(place);
        conference.setStartDate(startDate);
        conference.setEndDate(endDate);
    }

    public static ArrayList<Conference> getConferences() {
        return Storage.getConferences();
    }

    // -------------------------------------------------------------------------

    /**
     * Create a new excursion.
     * Pre: -
     */
    public static Excursion createExcursion(String name, LocalDate date, double price, Conference conference){
        Excursion excursion = new Excursion(name, date, price);
        conference.addExcursion(excursion);
        return excursion;
    }

    /**
     * Delete the excursion.
     * Pre: Conference associated with a excursion
     */
    public static void deleteExcursion(Excursion excursion) {
        Conference conference = excursion.getConference();
        if (conference != null) {
            conference.removeExcursion(excursion);
        }
        Storage.deleteExcursion(excursion);
    }

    /**
     * Update the excursion.
     * Pre: name and place
     */
//    public static void updateExcursion(Excursion excursion, String name, String place) {
//        excursion.set(name);
//        excursion.setPlace(place);
//    }

    public static ArrayList<Excursion> getExcursions() {
        return Storage.getExcursions();

    }

    // -------------------------------------------------------------------------

    /**
     * Create a new hotel.
     * Pre: -
     */
    public static Hotel createHotel(String name, double priceSingleRoom, double priceDoubleroom) {
        Hotel hotel = new Hotel(name, priceSingleRoom, priceDoubleroom);
        Storage.storeHotel(hotel);
        return hotel;
    }

    /**
     * Update the hotel.
     * Pre: name, price on single and double room
     */
    public static void updateHotel(Hotel hotel, String name, double priceSingleRoom, double priceDoubleroom) {
        hotel.setName(name);
        hotel.setPriceSingleRoom(priceSingleRoom);
        hotel.setPriceDoubleroom(priceDoubleroom);
    }

    public static ArrayList<Hotel> getHotels() {
        return Storage.getHotels();

    }

    // -------------------------------------------------------------------------

    /**
     * Create a new extra.
     * Pre: hotel created
     */
    public static Extra createExtra (String name, double price, Hotel hotel) {
        Extra extra = new Extra(name, price);
        hotel.addExtras(extra);
        Storage.storeExtra(extra);
        return extra;
    }

    public static ArrayList<Extra> getExtras() {
        return Storage.getExtras();
    }

    // -------------------------------------------------------------------------

    /**
     * Removes a excursion from a conference
     * Pre: excursion and conference
     */
    public static void removeExcursionFromConference(Excursion excursion, Conference conference) {
            conference.removeExcursion(excursion);
            excursion.setConference(null);


    }

    // -------------------------------------------------------------------------

    /**
     * Create a new registration .
     * Pre: hotel created
     */
    public static Registration createRegistrationAndParticipant(String Name, String Adress, String Phone, boolean lecturer, Conference conference, LocalDate arrivalDate, LocalDate departDate) {
        Participant participant = new Participant(Name, Adress, Phone);
        Registration registration = new Registration(lecturer, conference, participant, arrivalDate, departDate);
        return registration;
    }

    //---------------------------------------------------------------------------

    public static void addCompanyToRegistration(String BusinessName, String BusinessPhone, Registration registration){
        registration.setBusinessPhone(BusinessPhone);
        registration.setBusinessName(BusinessName);
    }

    public static void addCompanionToRegistration(String companionName, Registration registration){
        registration.setCompanionName(companionName);
    }

    /**
     * Pre: companionName is non-empty
     */
    public static void addExcursionsToRegistration(Excursion excursion, Registration registration){
        registration.addExcursion(excursion);
        excursion.addRegistration(registration);
    }

    //add hotel
    public static void addHotelToRegistration(Hotel hotel, Registration registration){
        registration.setHotel(hotel);
        hotel.addRegistration(registration);
    }
    //add extras
    public static void addExtraToRegistration(Extra extra, Registration registration){
        registration.addExtra(extra);
    }

    public static void addExtraToHotel(Extra extra, Hotel hotel){
        hotel.addExtras(extra);
    }
}
