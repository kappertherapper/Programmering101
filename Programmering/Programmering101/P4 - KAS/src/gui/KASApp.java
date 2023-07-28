package gg.gui;

import controller.Controller;
import gui.KASGui;
import javafx.application.Application;
import model.*;

import java.time.LocalDate;

public class KASApp {
    public static void main(String[] args) {
        initStorage();
        Application.launch(KASGui.class);
    }
    public static void initStorage() {
        //Conferences
        Conference himmeloghav = Controller.createConference("Himmel og hav", "Odense",
                LocalDate.of(2021,12,18),LocalDate.of(2021,12,20),
                1500);
        Conference fuglogfisk = Controller.createConference("Fugl og fisk", "Odense",
                LocalDate.of(2023,1,1), LocalDate.of(2023,1,5),
                100);

        //Excursions
        Excursion byrundtur = Controller.createExcursion("Byrundtur, Odense (inkl. frokost)",
                LocalDate.of(2021,12,18),125, himmeloghav);
        Excursion egeskov = Controller.createExcursion("Egeskov",
                LocalDate.of(2021, 12,19),75, himmeloghav);
        Excursion trapholt = Controller.createExcursion("Trapholt Museum, Kolding (inkl. frokost)",
                LocalDate.of(2021,12,20),200, himmeloghav);


        //Hotels
        Hotel denHvideSvane = Controller.createHotel("Den hvide svane", 1050,1250);
        Hotel hotelPhoenix = Controller.createHotel("Hotel Phønix",700,800);
        Hotel pensionTusindfryd = Controller.createHotel("Pension Tusindfryd",500,600);

        //Extras
        Extra wifiHvideSvane = Controller.createExtra("Wifi", 50,denHvideSvane);
        Extra bad = Controller.createExtra("Bad",200,hotelPhoenix);
        Extra wifiPhoenix = Controller.createExtra("Wifi",75,hotelPhoenix);
        Extra morgenmad = Controller.createExtra("Morgenmad", 100, pensionTusindfryd);

        //Registrations
        Registration finnMadsen = Controller.createRegistrationAndParticipant("Finn Madsen",
                "Vejnavn 123, 1234 By, Danmark","12345678",false,himmeloghav,
                LocalDate.of(2021,12,18),LocalDate.of(2021,12,20));

        Registration nielsPetersen = Controller.createRegistrationAndParticipant("Niels Petersen",
                "Gade Allé 9, 4600 Køge, Danmark","87654321",false,himmeloghav,
                LocalDate.of(2021,12,18),LocalDate.of(2021,12,20));
        Controller.addHotelToRegistration(denHvideSvane,nielsPetersen);

        Registration ullaHansen = Controller.createRegistrationAndParticipant("Ulla Hansen",
                "Bygade 48, 8000 Aarhus C, Danmark","12344321",false,himmeloghav,
                LocalDate.of(2021,12,18), LocalDate.of(2021,12,19));
        Controller.addCompanionToRegistration("Hans Hansen", ullaHansen);
        Controller.addExcursionsToRegistration(byrundtur, ullaHansen);

        Registration peterSommer = Controller.createRegistrationAndParticipant("Peter Sommer",
                "Strædet 45, 5000 Odense C, Danmark", "90909090", false, himmeloghav,
                LocalDate.of(2021,12,18),LocalDate.of(2021,12,20));
        Controller.addCompanionToRegistration("Mie Sommer", peterSommer);
        Controller.addExcursionsToRegistration(egeskov,peterSommer);
        Controller.addExcursionsToRegistration(trapholt,peterSommer);
        Controller.addHotelToRegistration(denHvideSvane,peterSommer);
        Controller.addExtraToRegistration(wifiHvideSvane,peterSommer);

        Registration loneJensen = Controller.createRegistrationAndParticipant("Lone Jensen",
                "Gadenavn 47, 4623 Lille Skensved, Danmark", "87654321",true,himmeloghav,
                LocalDate.of(2021,12,18),LocalDate.of(2021,12,20));
        Controller.addCompanionToRegistration("Jan Madsen", loneJensen);
        Controller.addExcursionsToRegistration(egeskov,loneJensen);
        Controller.addExcursionsToRegistration(byrundtur,loneJensen);
        Controller.addHotelToRegistration(denHvideSvane,loneJensen);
        Controller.addExtraToRegistration(wifiHvideSvane,loneJensen);

        System.out.println("Hotels");
        System.out.println(Controller.getHotels());
        System.out.println("Conferences:");
        System.out.println(Controller.getConferences());

        System.out.println(finnMadsen.calculatePrice());
        System.out.println(nielsPetersen.calculatePrice());
        System.out.println(ullaHansen.calculatePrice());
        System.out.println(peterSommer.calculatePrice());
        System.out.println(loneJensen.calculatePrice());

        for (Registration r : byrundtur.getRegistrations()){
            System.out.println(r.getCompanionName());
        }
    }
}
