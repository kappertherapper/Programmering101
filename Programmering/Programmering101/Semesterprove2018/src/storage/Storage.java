package storage;

import model.Arrangement;
import model.Hold;
import model.Tutor;
import model.Uddannelse;

import java.util.ArrayList;

    public abstract class Storage {

        private static final ArrayList<Uddannelse> uddannelser = new ArrayList<>();
        private static final ArrayList<Tutor> tutore = new ArrayList<>();
        private static final ArrayList<Arrangement> arrangementer = new ArrayList<>();
        private static final ArrayList<Hold> holds = new ArrayList<>();

        // -------------------------------------------------------------------------

        public static ArrayList<Uddannelse> getUddannelser() {
            return new ArrayList<Uddannelse>(uddannelser);
        }

        public static void storeUddannelse(Uddannelse uddannelse) {
            uddannelser.add(uddannelse);
        }

        // -------------------------------------------------------------------------

        public static ArrayList<Tutor> getTutore() {
            return new ArrayList<>(tutore);
        }

        public static void storeTutor(Tutor tutor) {
            tutore.add(tutor);
        }

        // -------------------------------------------------------------------------

        public static ArrayList<Arrangement> getArrangementer() {
            return new ArrayList<>(arrangementer);
        }

        public static void StoreArrangement(Arrangement arrangement) {
            arrangementer.add(arrangement);
        }

        // -------------------------------------------------------------------------

        public static ArrayList<Hold> getHolds() {
            return new ArrayList<>(holds);
        }

        public static void storeHold(Hold hold) {
            holds.add(hold);
        }
    }

