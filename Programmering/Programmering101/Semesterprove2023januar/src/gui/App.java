package gui;

import controller.Controller;
import model.*;
import storage.Storage;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
    initStorage();
    Gui.launch(Gui.class);

    }
    public static void initStorage() {
        //Sælgere:
        Sælger viktor = Controller.createSælger("Viktor", 23, "45344247");
        Sælger gustav = Controller.createSælger("Gustav", 35, "56124522");

        //Varer
        Vare samsung = Controller.createVare(Varekategori.MOBILTELEFON, "Samsung Mobil", 1200);
        Vare iphone = Controller.createVare(Varekategori.MOBILTELEFON, "iPhone", 2000);
        Vare java = Controller.createVare(Varekategori.STUDIEBOG, "Java", 400);
        Vare android = Controller.createVare(Varekategori.STUDIEBOG, "Android", 300);
        Vare python = Controller.createVare(Varekategori.STUDIEBOG, "Python", 200);
        Vare regnjakke = Controller.createVare(Varekategori.TØJ, "Regnjakke", 100);
        Vare regnbukser = Controller.createVare(Varekategori.TØJ, "Regnbukser", 80);

        //Salgsannoncer
        Salgsannonce viktor1 = Controller.createSalgsannonce(viktor, LocalDate.now());
        viktor1.addVare(samsung);


        Salgsannonce viktor2 = Controller.createSalgsannonce(viktor, LocalDate.now());
        viktor2.addVare(java);
        viktor2.addVare(android);
        viktor2.addVare(python);

        viktor.addSalgsannonce(viktor1);
        viktor.addSalgsannonce(viktor2);

        Salgsannonce gustav1 = Controller.createSalgsannonce(gustav, LocalDate.now());
        gustav1.addVare(iphone);

        Salgsannonce gustav2 = Controller.createSalgsannonce(gustav, LocalDate.now());
        gustav2.addVare(regnjakke);
        gustav2.addVare(regnbukser);

        gustav.addSalgsannonce(gustav1);
        gustav.addSalgsannonce(gustav2);

        //Salg
        Salg stine = Controller.createSalg("Stine", 450);
        stine.addVare(android);
        stine.addVare(python);

        Salg laura = Controller.createSalg("Laura", 120);
        laura.addVare(regnbukser);
        laura.addVare(regnjakke);

        Salg viktorkøb = Controller.createSalg("Viktor", 80);

        String fil = "Semesterprove2023januar/src/controller/salg.txt";
        Controller.salgTilFil(fil);

    }
}
