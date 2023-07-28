package Model;

public class Plads {
    private int række;
    private int nr;
    private int pris;
    private PladsType PladsType;

   public Plads (int række, int nr, int pris, PladsType PladsType) {
       this.række = række;
       this.nr = nr;
       this.pris = pris;
       this.PladsType = PladsType;
   }

    public int getRække() {
        return række;
    }

    public int getNr() {
        return nr;
    }

    public int getPris() {
        return pris;
    }


    @Override
    public String toString() {
        return String.format("%s %2d %s %2d %s %d %s%s",
                " Række:", række,
                " Nr:", nr,
                " (kr.", pris,
                PladsType.name(), ")");
    }
}
