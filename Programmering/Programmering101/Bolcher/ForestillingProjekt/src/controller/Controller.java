package ForestillingProjekt.Controller;

import ForestillingProjekt.Model.Bestilling;
import ForestillingProjekt.Model.Forestilling;
import ForestillingProjekt.Model.Kunde;
import ForestillingProjekt.Model.Plads;
import ForestillingProjekt.Storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {
    public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
        Storage.storeForestilling(forestilling);
        return forestilling;
    }

    public static Kunde createKunde(String navn, String mobil) {
        Kunde kunde = new Kunde(navn, mobil);
        Storage.StoreKunde(kunde);
        return kunde;
    }

    public static Plads createPlads(int række, int nr, int pris, Plads.PladsType pladsType) {
        Plads plads = new Plads(række, nr, pris, pladsType);
        Storage.storePladser(plads);
        return plads;
    }

    public static ArrayList<Plads> getPladser() {
        return Storage.getPladser();
    }





    // --------------------------------------------------------------------------------

    public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde, LocalDate dato, ArrayList<Plads> pladser) {
        Bestilling bestilling = null;
        boolean keepGoing = true;

        if (dato.isBefore(forestilling.getStartDato()) || dato.isAfter(forestilling.getSlutDato())) {
            keepGoing = false;
        }

        if (keepGoing)
        for (Plads plads : pladser) {
            if (!forestilling.erPladsenLedig(plads.getRække(), plads.getNr(), dato)) {
                keepGoing = false;
            }
        }

        if (keepGoing) {
            bestilling = new Bestilling(dato, kunde, forestilling, pladser);
            kunde.addKunde(bestilling);
            forestilling.addBestilling(bestilling);
        }
        return bestilling;
    }
}
