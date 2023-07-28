package model;

public class Hold {
    private String betegnelse;
    private String holdleder;
    private Tutor tutor;
    private Uddannelse uddannelse;

    public Hold(String betegnelse, String holdleder) {
        this.betegnelse = betegnelse;
        this.holdleder = holdleder;
    }

    public String getBetegnelse() {
        return betegnelse;
    }

    public String getHoldleder() {
        return holdleder;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Uddannelse getUddannelse() {
        return uddannelse;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return "Hold: " + "\n" +
                "Betegnelse = " + betegnelse + "\n" +
                "Holdleder = " + holdleder + "\n" +
                "Uddannelse = " + uddannelse + "\n";
    }

    public double arrangementsPris() {
        double pris = 0;
        for (Arrangement arrangement : tutor.getArrangementer()) {
            pris += arrangement.getPris();
        }
        return pris;
    }

    public boolean harTidsoverlap(Arrangement arrangement) {

        return false;
    }
}

