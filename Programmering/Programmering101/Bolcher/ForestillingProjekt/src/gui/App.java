package ForestillingProjekt.GUI;

import ForestillingProjekt.Controller.Controller;
import ForestillingProjekt.Model.Bestilling;
import ForestillingProjekt.Model.Forestilling;
import ForestillingProjekt.Model.Kunde;
import ForestillingProjekt.Model.Plads;
import ForestillingProjekt.Storage.Storage;
import javafx.application.Application;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(ForestillingGUI.class);
    }

    public static void initStorage() {
        Forestilling EvitaForestilling = Controller.createForestilling("Evita", LocalDate.of(2023,8,10), LocalDate.of(2023,8,20));
        Forestilling lykkePerForestilling = Controller.createForestilling("Lykke Per", LocalDate.of(2023,9,1), LocalDate.of(2023,9,10));
        Forestilling ChessForestilling = Controller.createForestilling("Chess", LocalDate.of(2023,8,21), LocalDate.of(2023,8,30));

        Kunde AndersHansenKunde = Controller.createKunde("Anders Hansen", "11223344");
        Kunde PeterJensenKunde = Controller.createKunde("Peter Jensen", "12345678");
        Kunde NielsMadsen = Controller.createKunde("Niels Madsen", "12341234");

        for (int række = 1; række <= 15; række++) {
            for (int nr = 1; nr <= 20; nr++) {
                // De gule pladser til 500kr
                if (række < 6 && nr > 2 && nr < 19) {
                    Plads plads = Controller.createPlads(række, nr, 500, Plads.PladsType.STANDARD);
                }
                // De grønne pladser til 450kr
                if ((række < 6 && (nr < 3 || nr > 18)) || (række > 5 && række < 11 && nr > 2 && nr < 19)) {
                    Plads plads = Controller.createPlads(række, nr, 450, Plads.PladsType.STANDARD);
                }
                // De blå rækker til 400kr
                if (række > 5 && række < 11 && (nr < 3 || nr > 18) || række > 10) {
                    Plads plads = Controller.createPlads(række, nr, 400, Plads.PladsType.STANDARD);
                }
            }
        }

        // Ændre pladstype til specielle pladser
        ArrayList<Plads> plads = Controller.getPladser();
        for (Plads p : plads) {
            if (p.getRække() == 10 && p.getNr() > 7 && p.getNr() < 13) {
                p.setPladsType(Plads.PladsType.KØRESTOl);
            }
            if (p.getRække() == 11 && p.getNr() > 7 && p.getNr() < 13) {
                p.setPladsType(Plads.PladsType.LANGEBEN);
            }
        }


        ArrayList<Plads> plads1 = new ArrayList<>();
        plads1.add(Controller.getPladser().get(3));
        plads1.add(Controller.getPladser().get(2));
        Bestilling b1 = Controller.opretBestillingMedPladser(EvitaForestilling, AndersHansenKunde, LocalDate.of(2023, 8, 11), plads1);

        System.out.println(b1.samletPris());
        System.out.println(EvitaForestilling.antalBestiltePladserPåDag(LocalDate.of(2023, 8, 11)));
        System.out.println(EvitaForestilling.succesDato().toString());
        System.out.println(AndersHansenKunde.bestiltePladserTilForestillingPåDag(EvitaForestilling, LocalDate.of(2023, 8, 11)).toString());

    }



    public static void testPrint() {
        System.out.println("Forestillinger");
        for (Forestilling x : Storage.getForestillinger()) {
            System.out.println(x.toString());
        }
        System.out.println("\nKunder");
        for (Kunde kunde : Storage.getKunder()) {
            System.out.print(kunde.toString());
        }
        System.out.println("\nPladser");
        for (Plads plads : Storage.getPladser()) {
            if (plads.getNr() == 20) {
                System.out.print(plads.toString() + " \n");
            } else {
                System.out.print(plads.toString() + " ");
            }
        }
        System.out.println();
        System.out.println(Storage.getPladser().size());
    }
}
