package model;

public class Indtag {
    private int vejetFørIndtagelse;
    private int vejetEfterIndtagelse;
    private String beskrivelse;
    private int anslåetAntalKalorier;
    private PersonligtMåltid personligtMåltid;


    public Indtag(int vejetFørIndtagelse, int vejetEfterIndtagelse, String beskrivelse, int anslåetAntalKalorier) {
        this.vejetFørIndtagelse = vejetFørIndtagelse;
        this.vejetEfterIndtagelse = vejetEfterIndtagelse;
        this.beskrivelse = beskrivelse;
        this.anslåetAntalKalorier = anslåetAntalKalorier;
    }

    // -------------------------------------------------------------------------


    public int getVejetFørIndtagelse() {
        return vejetFørIndtagelse;
    }

    public int getVejetEfterIndtagelse() {
        return vejetEfterIndtagelse;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public int getAnslåetAntalKalorier() {
        return anslåetAntalKalorier;
    }

    public PersonligtMåltid getPersonligtMåltid() {
        return personligtMåltid;
    }


    // -------------------------------------------------------------------------

    public void setPersonligtMåltid(PersonligtMåltid personligtMåltid) {
        this.personligtMåltid = personligtMåltid;
    }
}
