package model;

import java.util.ArrayList;

public class Studerende {
    String navn;
    String email;
    ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Studerende(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    // -------------------------------------------------------------------------

    public ArrayList<Deltagelse> getDeltagelser() {
        return deltagelser;
    }

    public void setDeltagelser(ArrayList<Deltagelse> deltagelser) {
        this.deltagelser = deltagelser;
    }
    // -------------------------------------------------------------------------

    public int antalFraværsLektioner() {
        int lektioner = 0;
        for (Deltagelse deltagelse : deltagelser ) {
            if (deltagelse.erRegistreretFraværende() == true) {
                lektioner++;
            }
        }
        return lektioner;
    }

    // -------------------------------------------------------------------------

    public int compareTo(Studerende other) {
        int compare = (this.navn.compareTo(other.navn));
        return compare;
    }
}
