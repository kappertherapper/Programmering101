package gui;

import controller.Controller;
import model.Arrangement;
import model.Hold;
import model.Tutor;
import model.Uddannelse;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        initStorage();

        System.out.println("Tutor oversigt: " + Uddannelse.tutorOversigt() + "\n");
        System.out.println("Hold uden tutor: " + Controller.holdUdenTutorer().toString());
        Uddannelse.tutorOversigtTilFil("Semesterprove2018/src/model/oversigt.txt");

    }
    public static void initStorage() {

        //Uddannelser
        Uddannelse DMU = Controller.CreateUddannelse("DMU");
        Uddannelse FINØ = Controller.CreateUddannelse("FINØ");

        //Hold
        Hold et = Controller.createHold("1dmE17S", "Margrethe Dybdahl");
        Hold to = Controller.createHold("1dmE17T", "Kristian Dorland");
        Hold tre = Controller.createHold("1dmE17U", "Kell Ørhøj");
        Hold fire = Controller.createHold("1fiE17B", "Karen Jensen");

        //Hold til uddannelse
        DMU.addHold(et);
        DMU.addHold(to);
        DMU.addHold(tre);
        FINØ.addHold(fire);

        //Tutors
        Tutor anders = Controller.createTutor("Anders Hansen", "aaa@students.eaaa.dk");
        Tutor peter = Controller.createTutor("Peter Jensen", "ppp@students.eaaa.dk");
        Tutor niels = Controller.createTutor("Niels Madsen", "nnn@students.eaaa.dk");
        Tutor lone = Controller.createTutor("Lone Andersen", "lll@students.eaaa.dk");
        Tutor mads = Controller.createTutor("Mads Miller", "mmm@students.eaaa.dk");

        //Tutor på hold
        Controller.addTutorToHold(anders, et);
        Controller.addTutorToHold(lone, et);
        Controller.addTutorToHold(peter, tre);
        Controller.addTutorToHold(niels, tre);
        Controller.addTutorToHold(mads, fire);

        //Arrangementer
        Arrangement rusfest = Controller.createArragement("Rusfest", LocalDate.of(2017, 8, 31), LocalTime.parse("18:00"), LocalTime.parse("23:30"), 250.0);
        Arrangement fodbold = Controller.createArragement("Rusfest", LocalDate.of(2017, 8, 30), LocalTime.parse("14:00"), LocalTime.parse("17:30"), 100.0);
        Arrangement brætspil = Controller.createArragement("Rusfest", LocalDate.of(2017, 8, 29), LocalTime.parse("12:00"), LocalTime.parse("16:30"), 25.0);
        Arrangement mindeparken = Controller.createArragement("Rusfest", LocalDate.of(2017, 8, 30), LocalTime.parse("18:00"), LocalTime.parse("22:30"), 25.0);

        //Tutor til arrangement
        Controller.addTutorToArrangement(anders, rusfest);
        Controller.addTutorToArrangement(peter, rusfest);
        Controller.addTutorToArrangement(mads, rusfest);
        Controller.addTutorToArrangement(niels, fodbold);
        Controller.addTutorToArrangement(lone, brætspil);
        Controller.addTutorToArrangement(niels, brætspil);
        Controller.addTutorToArrangement(mads, mindeparken);
        Controller.addTutorToArrangement(anders, mindeparken);

    }


}
