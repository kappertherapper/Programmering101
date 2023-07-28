package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Forestilling {

    private String name;
    private static LocalDate startDato;
    private static  LocalDate slutDato;
    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Forestilling(String name, LocalDate startDato, LocalDate slutDato) {
        this.name = name;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    /**
     * Returnere false hvis plads er ledig, true hvis den er optaget
     */
    public boolean erPladsLedig (int række, int nr, LocalDate dato) {
        boolean ledig = true;
        if (bestillinger.isEmpty()) {
        } else {
            for (Bestilling bestilling : bestillinger ) {
                if (bestilling.getDato().isEqual(dato)) {
                    for (Plads plads : bestilling.getPladser()) {
                        if (plads.getRække() == række && plads.getNr() == nr) {
                            ledig = false;
                        }

                    }
                }
            }
        }
        return ledig;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void addForestilling(Bestilling bestilling) {
        bestillinger.add(bestilling);
    }

    /**
     * Returnere hvor mange pladser der er bestilt til forestillingen på den pågældende dato
     */
    public int antalBestiltePladserPåDag(LocalDate dato) {
        int bestiltePladser = 0;
        for (Bestilling p : bestillinger) {
            if (p.getDato().isEqual(dato)) {
               bestiltePladser = p.getPladser().size();

            }
        }
        return bestiltePladser;
    }

    /**
     * Returnere den dato, hvor flest pladser er bestilt til en forestilling
     */
    public LocalDate succesDato() {
        LocalDate dato = null;
        int max = 0;
        for (LocalDate d = startDato; d.isBefore(slutDato.plusDays(1));
             d = d.plusDays(1)) {
            if (antalBestiltePladserPåDag(d) > max) {
                dato = d;
                max = antalBestiltePladserPåDag(d);
            }
        }
        return dato;
    }


    @Override
    public String toString() {
        return  "Name: " + name +
                " (fra startDato: " + startDato +
                " til slutDato: " + slutDato + ")";
    }
}
