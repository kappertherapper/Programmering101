package gui;

import controller.Controller;
import model.Indtag;
import model.Patient;
import model.PersonligtMåltid;

public class App {
    public static void main(String[] args) {
        initStorage();
        Gui.launch(Gui.class);

    }
    public static void initStorage() {

        Patient jensen = Controller.createPatient("Jens Jensen", 98.9, 26);
        Patient hansen = Controller.createPatient("Jens Hansen", 56.5, 38);

        PersonligtMåltid morgenmad = Controller.createPersonligtMåltid("Morgenmad", "Katrine");
        PersonligtMåltid middagsmad = Controller.createPersonligtMåltid("Middagsmad", "Karen");
        PersonligtMåltid aftensmad = Controller.createPersonligtMåltid("Aftensmad", "Simon");

        Controller.addMåltidToPatient(morgenmad, jensen);
        Controller.addMåltidToPatient(middagsmad, hansen);
        Controller.addMåltidToPatient(aftensmad, hansen);

        Indtag et = PersonligtMåltid.createIndtag(290, 0, "Cornflakes", 850);
        Indtag to = PersonligtMåltid.createIndtag(100, 0, "Appelsin juice", 250);
        Indtag tre = PersonligtMåltid.createIndtag(350, 100, "Leverpostej", 1200);
        Indtag fire = PersonligtMåltid.createIndtag(150, 0, "Bacon", 600);
        Indtag fem = PersonligtMåltid.createIndtag(450, 150, "Forloren hare", 1500);
        Indtag seks = PersonligtMåltid.createIndtag(100, 0, "Flødesovs", 300);

        Controller.addIndtagToMåltid(et, morgenmad);
        Controller.addIndtagToMåltid(to, morgenmad);
        Controller.addIndtagToMåltid(tre, middagsmad);
        Controller.addIndtagToMåltid(fire, middagsmad);
        Controller.addIndtagToMåltid(fem, aftensmad);
        Controller.addIndtagToMåltid(seks, aftensmad);
    }
}
