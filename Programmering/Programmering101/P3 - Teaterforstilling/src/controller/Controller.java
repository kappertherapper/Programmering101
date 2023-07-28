package controller;

import Model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {

    /**
     * Laver ny forstilling
     */
    public static Forestilling createForstilling(String name, LocalDate startDato, LocalDate slutDato) {
        Forestilling forestilling = new Forestilling(name, startDato, slutDato);
        Storage.storeForstilling(forestilling);
        return forestilling;
    }

    /**
     * Laver ny kunde
     */
    public static Kunde createKunde(String navn, String mobil) {
        Kunde kunde = new Kunde(navn, mobil);
        Storage.storeKunde(kunde);
        return kunde;
    }

    /**
     * Laver ny plads
     */
    public static Plads createPlads(int række, int nr, int pris, PladsType PladsType) {
        Plads plads = new Plads(række, nr, pris, PladsType);
        Storage.storePladser(plads);
        return plads;
    }

    /**
     * Laver en ny bestilling med en eller flere pladser
     */
    public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde, LocalDate dato, ArrayList<Plads> pladser) {
        Bestilling bestilling = null;
        boolean keepGoing = true;

        if (dato.isBefore(forestilling.getStartDato()) || dato.isAfter(forestilling.getSlutDato())) {
            keepGoing = false;
        }

        if (keepGoing)
            for (Plads plads : pladser) {
                if (!forestilling.erPladsLedig(plads.getRække(), plads.getNr(), dato)) {
                    keepGoing = false;
                }
            }

        if (keepGoing) {
            bestilling = new Bestilling(dato, forestilling, kunde, pladser);
            kunde.addKunde(bestilling);
            forestilling.addForestilling(bestilling);
        }
        return bestilling;
    }
}










        //Bestilling bestilling = null;
       // if ((!dato.isBefore(forestilling.getStartDato()) || !dato.isAfter(forestilling.getSlutDato()))) {
         //   for (Plads p : pladser) {
           //     if (forestilling.erPladsLedig(p.getRække(), p.getNr(), dato)) {
             //       bestilling = new Bestilling(dato, forestilling, kunde, pladser);
               //     kunde.addKunde(bestilling);
                 //   forestilling.addForestilling(bestilling);
            //    }
         //   }
      //  }
     //   return bestilling;
   // }




