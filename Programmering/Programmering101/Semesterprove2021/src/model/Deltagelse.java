package model;

public class Deltagelse {
    boolean registreret;
    DeltagerStatus status;
    Studerende studerende;
    Lektion lektion;


    public Deltagelse(boolean registreret, DeltagerStatus status, Lektion lektion, Studerende studerende) {
        this.registreret = false;
        this.status = DeltagerStatus.TILSTEDE;
        this.lektion = lektion;
        this.studerende = studerende;
    }

    // -------------------------------------------------------------------------

    public Studerende getStuderende() {
        return studerende;
    }
    public void setStuderende(Studerende studerende) {
        this.studerende = studerende;
    }

    // -------------------------------------------------------------------------

    public void setStatus(DeltagerStatus status) {
        this.status = status;
    }

    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return  studerende.getNavn() + " " +  registreret + " " + status;
    }

    public boolean erRegistreretFraværende() {
        if (studerende.equals(DeltagerStatus.FRAVÆR) && registreret == true) {
            return true;
        }
        return false;
    }
}
