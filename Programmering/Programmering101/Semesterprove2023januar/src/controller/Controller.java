package controller;

import model.*;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {
    /**
     * Opretter ny Sælger
     * Pre: navn empty, Uddannelse empty
     */
    public static Sælger createSælger(String navn, int studiekortNummer, String mobil) {
        Sælger sælger = new Sælger(navn, studiekortNummer, mobil);
        Storage.storeSælger(sælger);
        return sælger;
    }

    // -------------------------------------------------------------------------

    /**
     * Opretter ny Vare
     * Pre: nummer null, inde false, førsteTid null, sidsteTid null
     */
    public static Vare createVare(Varekategori kategori, String navn, int udbudspris) {
        Vare vare = new Vare(kategori, navn, udbudspris);
        Storage.storeVare(vare);
        return vare;
    }

    // -------------------------------------------------------------------------

    /**
     * Opretter ny Salg
     * Pre: navn empty, prisKrSingle null, PriskrDouble null
     */
    public static Salg createSalg(String købersNavn, int aftaltSamletPris) {
        Salg salg = new Salg(købersNavn, aftaltSamletPris);
        System.out.println(salg);
        Storage.storeSalg(salg);
        return salg;
    }

    // -------------------------------------------------------------------------

    /**
     * Opretter ny Salg
     * Pre: navn empty, prisKrSingle null, PriskrDouble null
     */
    public static Salgsannonce createSalgsannonce(Sælger sælger, LocalDate udløbsDato) {
        Salgsannonce salgsannonce = new Salgsannonce(sælger, udløbsDato);
        salgsannonce.setSælger(sælger);
        return salgsannonce;
    }

    // -------------------------------------------------------------------------

    public void addVareToSalgannonce(Vare vare, Salgsannonce salgsannonce) {
        vare.setSalgsannonce(salgsannonce);
        salgsannonce.addVare(vare);
    }

    // -------------------------------------------------------------------------

    public void addVareToSalg(Vare vare, Salg salg) {
        salg.addVare(vare);
    }

    // -------------------------------------------------------------------------

    public void addSalgannonceToSælger(Sælger sælger, Salgsannonce salgsannonce) {
        sælger.addSalgsannonce(salgsannonce);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Salgsannonce> getSalgsAnnoncer() {
        ArrayList<Salgsannonce>salgsannoncer = new ArrayList<>();
        for (Sælger sælger : Storage.getSælgere()) {
            salgsannoncer.addAll(sælger.getSalgsannoncer());
        }
        return salgsannoncer;
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Vare> VareTilhørendeSalgannonce(Salgsannonce salgsannonce) {
        ArrayList<Vare>VareSalgsAnnonce = new ArrayList<>();
        VareSalgsAnnonce.addAll(salgsannonce.getVarer());
        return VareSalgsAnnonce;
    }


    // -------------------------------------------------------------------------

    public static void salgTilFil(String filNavn) {
        File in = new File("Semesterprove2023januar/src/controller/" + filNavn + ".txt");
        try (PrintWriter v = new PrintWriter(in)) {
            for (Salg salg : Storage.getSalgs()) {
                int rabat = salg.samletPris() - salg.getAftaltSamletPris();
                v.println();
                v.println(salg.getKøbersNavn() + ":");
                for (Vare vare : salg.getVarer()) {
                    v.println(vare.getNavn() + "   " + vare.getUdbudspris());
                }
                v.println("Aftaltpris: " + salg.getAftaltSamletPris() + "  Rabat: " + rabat);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Sorry! An unexpected error has occurred.");
            System.err.println("Technical message: " + ex.getMessage());
        }
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Sælger> fletteKøb(ArrayList<Sælger> s1, ArrayList<Salg> s2) {
        ArrayList<Sælger> result = new ArrayList<Sælger>();

        int i1 = 0;
        int i2 = 0;
        while (i1 < s1.size() && i2 < s2.size()) {
            if (s1.get(i1).getNavn().equals(s2.get(i2).getKøbersNavn())) {
                result.add(s1.get(i1));
                i1++;
            } else {
                i2++;
            }
        }
        return result;
    }
}