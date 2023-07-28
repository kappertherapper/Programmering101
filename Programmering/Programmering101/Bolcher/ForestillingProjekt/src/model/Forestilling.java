package ForestillingProjekt.Model;

import ForestillingProjekt.Storage.Storage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class Forestilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public void addBestilling(Bestilling bestilling) {
        bestillinger.add(bestilling);
    }

    public int antalBestiltePladserPåDag(LocalDate dato) {
        int antalPladserBesilte = 0;

        for (Bestilling b : bestillinger) {
            if (b.getDato().isEqual(dato)) {
                antalPladserBesilte += b.getPladser().size();
            }
        }
        return antalPladserBesilte;
    }

    public LocalDate succesDato() {
        LocalDate dato = startDato;
        int flestPladser = 0;

        for (LocalDate d = startDato; d.isBefore(slutDato.plusDays(1)); d = d.plusDays(1)) {
            if (antalBestiltePladserPåDag(d) > 0) {
                dato = d;
            }
        }
        return dato;
    }

    public boolean erPladsenLedig(int række, int nr, LocalDate dato) {
        boolean ledig = true;
        if (bestillinger.isEmpty()) {
        } else {
            for (Bestilling b : bestillinger) {
                if (b.getDato().isEqual(dato)) {
                    for (Plads plads : b.getPladser()) {
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

    @Override
    public String toString() {
        return "Forestilling: " + navn +
                "\nStartdato: " + startDato +
                "\nSlutdato:  " + slutDato;
    }
}


