package gui;

import controller.Controller;
import model.Antal;
import model.Funktion;
import model.Medarbejder;
import model.Vagt;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        initStorage();
        Gui.launch(Gui.class);


    }
    public static void initStorage() {
        // Funktioner
        Funktion filetering = Controller.createFunktion("Filetering");
        Funktion grønsager = Controller.createFunktion("Grøntsager");
        Funktion sovs = Controller.createFunktion("Sovs og tilbehør");
        Funktion buffet = Controller.createFunktion("Buffetopfyldning");

        // Medarbejdere
        Medarbejder peter = Controller.createMedarbejder("Peter", 6, LocalTime.of(8,00) );
        Medarbejder anne = Controller.createMedarbejder("Anne", 8, LocalTime.of(8,00) );
        Medarbejder marie = Controller.createMedarbejder("Marie", 6, LocalTime.of(10,00) );
        Medarbejder torben = Controller.createMedarbejder("Torben", 8, LocalTime.of(7,00) );

        // Medarbejder til funktioner
        peter.addFunktion(grønsager);
        peter.addFunktion(sovs);
        peter.addFunktion(buffet);

        marie.addFunktion(filetering);
        marie.addFunktion(grønsager);
        marie.addFunktion(buffet);

        torben.addFunktion(filetering);
        torben.addFunktion(sovs);

        //Vagter
        Vagt ål = Controller.createVagt("Røgede ål til medarbejderne",
                LocalDateTime.of(2022, 6, 24, 8,00),
                LocalDateTime.of(2022, 6, 24, 12,30) );

        ål.addFunktionMedAntal(filetering, 2);
        ål.addFunktionMedAntal(grønsager, 1);
        ål.addFunktionMedAntal(sovs, 1);
        ål.addFunktionMedAntal(buffet, 1);

        //Medarbejder på vagten
        ål.addMedarbejder(peter);
        ål.addMedarbejder(anne);
        ål.addMedarbejder(marie);

        //String fil = "Semesterprove2022/src/controller/duty.txt";
        //Controller.udskrivVagtplan(ål,fil);

    }
}
