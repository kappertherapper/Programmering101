package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {
    private String navn;
    private String mobil;
    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Kunde (String navn, String mobil){
        this.navn = navn;
        this.mobil = mobil;

    }

    public void addKunde(Bestilling bestilling) {
        bestillinger.add(bestilling);
    }

    /**
     * Returnere en liste med alle pladser, kunden har bestilt til forestillingen på datoen
     */
    public ArrayList<Plads> bestiltePladserTilForestillingPådag(Forestilling forestilling, LocalDate dato) {
        ArrayList<Plads> bestiltePladser = new ArrayList<>();
        for (Bestilling b : bestillinger) {
            if (b.getDato().isEqual(dato)) {
                for (Plads p : b.getPladser()) {
                    bestiltePladser.add(p);
                }
            }
        }
        return bestiltePladser;
    }


    @Override
    public String toString() {
        return  "Navn: " + navn + " " +
                "(" + mobil + ")";
    }
}
