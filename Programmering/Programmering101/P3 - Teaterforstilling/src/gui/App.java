package gui;

import controller.Controller;
import Model.*;
import storage.Storage;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        initStorage();
        //testPrint();
        gui.launch(gui.class);

    }
    public static void initStorage() {
        // Forstillinger
        Controller.createForstilling("Evita", LocalDate.of(2023, 8, 10), LocalDate.of(2023, 8, 20));
        Controller.createForstilling("Lykke Per", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 10));
        Controller.createForstilling("Chess", LocalDate.of(2023, 8, 21), LocalDate.of(2023, 8, 30));

        // Kunder
        Controller.createKunde("Anders Hansen", "11223344");
        Controller.createKunde("Peter Jensen", "12345678");
        Controller.createKunde("Niels Madsen", "12341234");

        // Pladser
        ArrayList<Plads> PladsList = new ArrayList<>();
        PladsList.add(new Plads(1,1,450,PladsType.STANDARD));
        PladsList.add(new Plads(1,2,450,PladsType.STANDARD));
        PladsList.add(new Plads(1,3,450,PladsType.STANDARD));

        ArrayList<Plads> PladsList2 = new ArrayList<>();
        PladsList2.add(new Plads(2,1,450,PladsType.STANDARD));

        // Oprettet bestillinger
        ArrayList<Bestilling> ben = Storage.getBestilling();

        Forestilling f = Storage.getForestillinger().get(2);
        Kunde g = Storage.getKunder().get(2);
        Kunde b = Storage.getKunder().get(2);

        //Bestillinger
        Controller.opretBestillingMedPladser(f ,g , LocalDate.of(2023,8,21), PladsList);
        Controller.opretBestillingMedPladser(f ,b , LocalDate.of(2023,8,25), PladsList2);


        //Test af antal bestilte pladser på pågælende dag
        //System.out.println(f.antalBestiltePladserPåDag(LocalDate.of(2023,8,21)));

        //Test af samlet pris
        // System.out.println(b.samletpris(b));

        //Test af dato med flest booket pladser
        //System.out.println(f.succesDato());

        //Test af hvad kunden har bestilt til en forestilling
        //System.out.println(g.bestiltePladserTilForestillingPådag(f, LocalDate.of(2023,8,21)));

        //Pladser
        for (int row = 1; row <= 15; row++) {
            for (int col = 1; col <= 20; col++) {

                // Gule pladser
                if (row >= 1 && row <= 5 && col >= 3 && col <= 18) {
                    Controller.createPlads(row, col, 500, PladsType.STANDARD);
                }

                // Grønne pladser
                else if (row >= 1 && row <= 5 && col >= 1 && col < 3 || col > 18) {
                    Controller.createPlads(row, col, 450, PladsType.STANDARD);
                }
                else if (row >= 6 && row <= 9 && col >= 3 && col < 18) {
                    Controller.createPlads(row, col, 450, PladsType.STANDARD);
                }
                else if (row == 10 && col > 7 && col < 13) {
                    Controller.createPlads(row, col, 450, PladsType.KØRESTOL);
                }
                else if (row == 10 && col >= 3 && col < 19) {
                    Controller.createPlads(row, col, 450, PladsType.STANDARD);
                }

                // Blå pladser
                else if (row >= 6 && row < 11 || row >= 13 && col >= 1 && col < 3) {
                    Controller.createPlads(row, col, 400, PladsType.STANDARD);
                }
                else if (row >= 6 && row < 11 || row >= 13 && col <= 18 && col < 20) {
                    Controller.createPlads(row, col, 400, PladsType.STANDARD);
                }
                else if (row == 11 && col > 7 && col < 13) {
                    Controller.createPlads(row, col, 400, PladsType.LANGEBEN);

                } else {
                    Controller.createPlads(row, col, 400, PladsType.STANDARD);
                }
            }
        }
    }

    public static void testPrint() {
        System.out.println("Kunder: ");
        for (Kunde kunde : Storage.getKunder()) {
            System.out.println(kunde.toString());
        }

        System.out.println();

        System.out.println("Forstillinger: ");
        for (Forestilling forestilling : Storage.getForestillinger()) {
            System.out.println(forestilling.toString());
        }

        System.out.println();

        System.out.println("Pladser: ");
        for (Plads plads : Storage.getPladser()) {
            System.out.print(plads.toString());
            if (plads.getNr() == 20) {
                System.out.println();
            }
        }
    }
}
