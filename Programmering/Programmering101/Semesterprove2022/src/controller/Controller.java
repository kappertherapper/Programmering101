package controller;

import model.Antal;
import model.Funktion;
import model.Medarbejder;
import model.Vagt;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Controller {
    /**
     * Opretter ny funkion
     * Pre: navn empty
     */
    public static Funktion createFunktion(String navn) {
        Funktion funktion = new Funktion(navn);
        Storage.storeFunktion(funktion);
        return funktion;
    }

    /**
     * Opretter ny medarbejder
     * Pre: navn empty, antalTimerPrDag null, typiskMødeTid null
     */
    public static Medarbejder createMedarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        Medarbejder medarbejder = new Medarbejder(navn, antalTimerPrDag, typiskMødetid);
        Storage.storeMedarbejder(medarbejder);
        return medarbejder;
    }

    /**
     * Opretter ny vagt
     * Pre: navn empty, tidFra null, tidTil null
     */
    public static Vagt createVagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil) {
        Vagt vagt = new Vagt(navn, tidFra, tidTil);
        Storage.storeVagt(vagt);
        return vagt;
    }

    public static void addMedarbejderTilVagt(Medarbejder medarbejder, Vagt vagt) {
        vagt.addMedarbejder(medarbejder);
    }

    public static void addAntalTilFunktion(Antal antal, Funktion funktion) {
        funktion.addAntal(antal);
    }

    public static void udskrivVagtplan(Vagt vagt, String filNavn) {
        File in = new File(filNavn);
            try (PrintWriter v = new PrintWriter(in)) {
                v.println("------------------------------------------------");
                v.println(vagt.getTidFra() + " - " + vagt.getTidTil() + " " + "(" + vagt.getNavn() + ")");
                v.println("------------------------------------------------");
                v.println("Funktioner: ");
                v.println(vagt.getFunktioner());
                v.println();
                v.print("Medarbejdere: " + vagt.getMedarbejdere());
                v.println();
                v.println("Status: ");

            } catch (FileNotFoundException ex) {
                System.err.println("Sorry! An unexpected error has occurred.");
                System.err.println("Technical message: " + ex.getMessage());
            }
    }
}