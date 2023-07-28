public class asdasf {
    package controller;

import model.*;
import storage.Storage;

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
            Storage.storeSalg(salg);
            return salg;
        }

        public static Salgsannonce createSalgsannonce(Sælger sælger, LocalDate udløbsDato) {
            Salgsannonce salgsannonce = new Salgsannonce(sælger, udløbsDato);
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

        public static void salgTilFil(String filNavn) {

        }
    }
}
