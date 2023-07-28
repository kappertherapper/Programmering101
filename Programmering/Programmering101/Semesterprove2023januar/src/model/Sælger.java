package model;

import java.util.ArrayList;

public class Sælger {
    private String navn;
    private int studiekortNummer;
    private String mobil;
    private final ArrayList<Salgsannonce>salgsannoncer = new ArrayList<>();

    public Sælger(String navn, int studiekortNummer, String mobil) {
        this.navn = navn;
        this.studiekortNummer = studiekortNummer;
        this.mobil = mobil;
    }

    public String getNavn() {
        return navn;
    }

    public int getStudiekortNummer() {
        return studiekortNummer;
    }

    public String getMobil() {
        return mobil;
    }

    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return navn;
    }

    // -------------------------------------------------------------------------

    public void addSalgsannonce(Salgsannonce salgsannonce) {
        salgsannoncer.add(salgsannonce);

    }

    public ArrayList<Salgsannonce> getSalgsannoncer() {
        return salgsannoncer;
    }

    // -------------------------------------------------------------------------

    public ArrayList<Vare> alleIkkesolgteVarerIKategori(Varekategori kategori) {
        ArrayList<Vare>købminevarer = new ArrayList<>();
        for (Salgsannonce s : salgsannoncer) {
            for (Vare v : s.getVarer()) {
                if (v.getKategori() == kategori) {
                    købminevarer.add(v);
                }
            }
            }
        return købminevarer;
    }
}
