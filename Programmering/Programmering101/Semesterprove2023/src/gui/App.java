package gui;

import controller.Controller;
import model.Bane;
import model.Booking;
import model.Kategori;
import model.Spiller;

import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        initStorage();
        Gui.launch(Gui.class);

    }
    public static void initStorage() {

        //Kategori
        Kategori luksus = Controller.createKategori("Luksus", 100, 200);
        Kategori mellem = Controller.createKategori("Mellem", 50, 100);
        Kategori begynder = Controller.createKategori("Begynder", 25, 50);


        //Baner
        //Indendørs
        Bane et = Controller.createBane(1, true, LocalTime.of(9,00), LocalTime.of(17,00), luksus);
        Bane to = Controller.createBane(2, true, LocalTime.of(9,00), LocalTime.of(17,00), luksus);
        Bane tre = Controller.createBane(3, true, LocalTime.of(9,00), LocalTime.of(17,00), mellem);
        //Udendørs
        Bane fire = Controller.createBane(4, false, LocalTime.of(9,00), LocalTime.of(17,00), mellem);
        Bane fem = Controller.createBane(5, false, LocalTime.of(9,00), LocalTime.of(17,00), begynder);
        Bane seks = Controller.createBane(6, false, LocalTime.of(9,00), LocalTime.of(17,00), begynder);


        //Spillere
        Spiller andreas = Controller.createSpiller("Andreas", "DMU");
        Spiller petra = Controller.createSpiller("Petra", "DMU");
        Spiller henrik = Controller.createSpiller("Henrik", "ITA");
        Spiller ulla = Controller.createSpiller("Ulla", "ITA");


        //Bookinger
        Booking and = Controller.createBooking(andreas, tre, LocalDate.of(2023, 6, 20), LocalTime.of(10, 00), true);
        Booking and2 = Controller.createBooking(andreas, to, LocalDate.of(2023, 6, 22), LocalTime.of(10, 00), false);
        Booking hen = Controller.createBooking(henrik, tre, LocalDate.of(2023, 6, 20), LocalTime.of(11, 00), false);
        Booking ull = Controller.createBooking(ulla, tre, LocalDate.of(2023, 6, 20), LocalTime.of(16, 00), false);
        Booking ull2 = Controller.createBooking(ulla, fem, LocalDate.of(2023, 6, 23), LocalTime.of(17, 00), true);


        Controller.addBookingtilSpiller(andreas, and);
        Controller.addBookingtilSpiller(andreas, and2);
        Controller.addBookingtilSpiller(henrik, hen);
        Controller.addBookingtilSpiller(ulla, ull);
        Controller.addBookingtilSpiller(ulla, ull2);

        Controller.addBookingtilBane(tre, and);
        Controller.addBookingtilBane(to, and2);
        Controller.addBookingtilBane(tre, hen);
        Controller.addBookingtilBane(tre, ull);
        Controller.addBookingtilBane(fem, ull2);


        String fil = "Semesterprove2023/src/controller/bookinger.txt";
        Controller.udskrivBookinger(fil);

    }
}
