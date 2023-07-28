package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Arrangement {
    private String titel;
    private LocalDate date;
    private LocalTime startTid;
    private LocalTime slutTid;
    private Double pris;
    private final ArrayList<Tutor> tutors = new ArrayList<>();

    public Arrangement(String titel, LocalDate date, LocalTime startTid, LocalTime slutTid, Double pris) {
        this.titel = titel;
        this.startTid = startTid;
        this.slutTid = slutTid;
        this.pris = pris;
    }

    public String getTitel() {
        return titel;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public LocalTime getSlutTid() {
        return slutTid;
    }

    public Double getPris() {
        return pris;
    }

    public void addTutor(Tutor tutor) {
        tutors.add(tutor);
    }
}
