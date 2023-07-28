package gui;

import model.Fag;
import model.Lektion;
import model.Studerende;
import controller.Controller;

import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        initStorage();
        Gui.launch(Gui.class);

    }
    public static void initStorage() {
        //Studerende
        Studerende peter = Controller.createStuderende("Peter Hansen", "ph@stud.dk");
        Studerende tina = Controller.createStuderende("Tina Jensen", "tj@stud.dk");
        Studerende sascha = Controller.createStuderende("Sascha Petersen", "sp@stud.dk");

        //Fag
        Fag fag1 = Controller.createFag("PRO1", "20S");
        Fag fag2 = Controller.createFag("PRO1", "20T");
        Fag fag3 = Controller.createFag("SU1", "20S");

        //Lektioner
        Lektion et = Controller.createLektion(LocalDate.of(2021,2,1), LocalTime.of(8, 30), "A1.32");
        Lektion to = Controller.createLektion(LocalDate.of(2021,2,1), LocalTime.of(10, 30), "A1.32");
        Lektion tre = Controller.createLektion(LocalDate.of(2021,2,3), LocalTime.of(8, 30), "A1.32");
        Lektion fire = Controller.createLektion(LocalDate.of(2021,2,3), LocalTime.of(10, 30), "A1.32");

        fag1.addLektion(et);
        fag1.addLektion(to);
        fag1.addLektion(tre);
        fag1.addLektion(fire);

        Controller.opretDeltagelser(fag1, peter);
        Controller.opretDeltagelser(fag1, tina);
        Controller.opretDeltagelser(fag1, sascha);


    }
}
