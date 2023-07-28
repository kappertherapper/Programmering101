package model;

public class Kategori {
    String navn;
    int prisKrSingle;
    int prisKrDouble;

    public Kategori(String navn, int prisKrSingle, int prisKrDouble) {
        this.navn = navn;
        this.prisKrSingle = prisKrSingle;
        this.prisKrDouble = prisKrDouble;
    }

    // -------------------------------------------------------------------------

    public String getNavn() {
        return navn;
    }

    public int getPrisKrSingle() {
        return prisKrSingle;
    }

    public int getPrisKrDouble() {
        return prisKrDouble;
    }

    // -------------------------------------------------------------------------


    @Override
    public String toString() {
        return navn;
    }
}
