package ForestillingProjekt.GUI;

import ForestillingProjekt.Controller.Controller;
import ForestillingProjekt.Model.Bestilling;
import ForestillingProjekt.Model.Forestilling;
import ForestillingProjekt.Model.Kunde;
import ForestillingProjekt.Model.Plads;
import ForestillingProjekt.Storage.Storage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.w3c.dom.Text;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Optional;

public class ForestillingGUI extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Forestillinger demo");
        GridPane pane = new GridPane();
        this.initContent(pane);
        pane.setGridLinesVisible(false);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfKunder = new TextField();
    private final TextField txfForestillinger = new TextField();
    private final ListView<Forestilling> lvwForestilling = new ListView<>();
    private final ListView<Kunde> lvwKunder = new ListView<>();
    private final ListView<Plads> lvwPladser = new ListView<>();


    // -----

    private final TextField txfForestillingNavn = new TextField();
    private final TextField txfForestillingStartDato = new TextField();
    private final TextField txfForestillingSlutDato = new TextField();

    // -----

    private final TextField txfKundeNavn = new TextField();
    private final TextField txfKundeMobil = new TextField();

    // -----

    private final TextField txfDato = new TextField();
    private Label lblError = new Label();








    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblForestillinger = new Label("Forestillinger");
        pane.add(lblForestillinger, 0, 0);

        // add a label to the pane: Title
        Label lblKunder = new Label("Kunder:");
        pane.add(lblKunder, 2, 0);

        Label lblDato = new Label("Pladser:");
        pane.add(lblDato, 4, 0);

        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 2);

        Label lblStartDato = new Label("Start dato:");
        pane.add(lblStartDato, 0, 3);

        Label lblSlutDato = new Label("Slut dato:");
        pane.add(lblSlutDato, 0, 4);

        Label lblKundeNavn = new Label("Kunde navn:");
        pane.add(lblKundeNavn, 2, 2);

        Label lblKundeMobil = new Label("Kunde mobil:");
        pane.add(lblKundeMobil, 2, 3);

        Label lblDato2 = new Label("Dato:");
        pane.add(lblDato2, 4, 2);

        // ------ ListViews

        // add a listView to the pane(at col=1, row=1)
        pane.add(lvwForestilling, 0, 1, 2,1);
        lvwForestilling.setPrefWidth(200);
        lvwForestilling.setPrefHeight(200);
        lvwForestilling.getItems().setAll(Storage.getForestillinger());

        pane.add(lvwKunder, 2, 1, 2, 1);
        lvwKunder.setPrefWidth(200);
        lvwKunder.setPrefHeight(200);
        lvwKunder.getItems().setAll(Storage.getKunder());

        pane.add(lvwPladser, 4, 1, 2, 1);
        lvwPladser.setPrefWidth(200);
        lvwPladser.setPrefHeight(200);
        lvwPladser.getItems().setAll(Storage.getPladser());
        lvwPladser.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // ----- TextFields

        pane.add(txfForestillingNavn, 1, 2);
        txfForestillingNavn.setPrefWidth(140);
        txfForestillingNavn.setPromptText("Frank Hvam");

        pane.add(txfForestillingStartDato, 1, 3);
        txfForestillingStartDato.setPrefWidth(140);
        txfForestillingStartDato.setPromptText("YYYY-MM-DD");

        pane.add(txfForestillingSlutDato, 1, 4);
        txfForestillingSlutDato.setPrefWidth(140);
        txfForestillingSlutDato.setPromptText("YYYY-MM-DD");

        pane.add(txfKundeNavn, 3, 2);
        txfKundeNavn.setPrefWidth(140);
        txfKundeNavn.setPromptText("Mikael Christensen");

        pane.add(txfKundeMobil, 3, 3);
        txfKundeMobil.setPrefWidth(140);
        txfKundeMobil.setPromptText("22176433");

        pane.add(txfDato, 5, 2);
        txfDato.setPrefWidth(140);
        txfDato.setPromptText("YYYY-MM-DD");

        pane.add(lblError, 1, 6, 4, 1);


        // --- Buttons

        Button btnOpretForestilling = new Button("Opret forestilling");
        pane.add(btnOpretForestilling, 1, 5);
        GridPane.setMargin(btnOpretForestilling, new Insets(1, 0, 0, 0));
        btnOpretForestilling.setOnAction(event -> this.opretForestilling());

        Button btnOpretKunde = new Button("Opret kunde");
        pane.add(btnOpretKunde, 3, 4);
        GridPane.setMargin(btnOpretKunde, new Insets(1, 0, 0, 0));
        btnOpretKunde.setOnAction(event -> this.opretKunde());

        Button btnOpretBestilling = new Button("Opret bestilling");
        pane.add(btnOpretBestilling, 5, 3);
        GridPane.setMargin(btnOpretBestilling, new Insets(1, 0 , 0, 0));
        btnOpretBestilling.setOnAction(event -> this.opretBestilling());

    }

    // -------------------------------------------------------------------------

    private void opretForestilling() {
        String navn = txfForestillingNavn.getText().trim();
        if (navn.length() == 0) {
            lblError.setText("Forestllingsnavn er tom");
            return;
        }

        LocalDate startDato = LocalDate.parse(txfForestillingStartDato.getText().trim());
        if (startDato.isBefore(LocalDate.now())) {
            lblError.setText("Startdato kan ikke være før i dag");
            return;
        }

        if (!erDatoValid(txfForestillingStartDato.getText().trim())) {
            lblError.setText("Fejl i startdatoen");
            return;
        }

        LocalDate slutDato = LocalDate.parse(txfForestillingSlutDato.getText().trim());
        if (slutDato.isBefore(startDato)) {
            lblError.setText("Slutdato kan ikke være før startdato");
            return;
        }
        if (!erDatoValid(txfForestillingSlutDato.getText().trim())) {
            lblError.setText("Fejl i slutdatoen");
            return;
        }

        Forestilling nyForestilling = Controller.createForestilling(navn, startDato, slutDato);
        lvwForestilling.getItems().add(nyForestilling);
        Storage.storeForestilling(nyForestilling);
        txfForestillingNavn.clear();
        txfForestillingStartDato.clear();
        txfForestillingSlutDato.clear();
        lblError.setText("");
    }

    private void opretKunde() {
        String navn = txfKundeNavn.getText().trim();
        if (navn.length() == 0) {
            lblError.setText("Kundenavn mangler");
            return;
        }


        String mobilnr = txfKundeMobil.getText().trim();
        if (mobilnr.length() != 8 || !mobilnr.matches("\\d+")) {
            lblError.setText("Fejl i mobilnummer");
            return;
        }

        Kunde nyKunde = Controller.createKunde(navn, mobilnr);
        lvwKunder.getItems().add(nyKunde);
        Storage.StoreKunde(nyKunde);
        txfKundeNavn.clear();
        txfKundeMobil.clear();
    }

    private boolean erDatoValid(String dato) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-d");
        boolean valid = true;
        try {
            format.parse(dato);
        } catch (DateTimeParseException e) {
            valid = false;
        }
        return valid;
    }

    private void opretBestilling() {
        if (!erDatoValid(txfDato.getText().trim())) {
            lblError.setText("Fejl i pladsdato");
            return;
        }

        Forestilling forestilling = lvwForestilling.getSelectionModel().getSelectedItem();
        Kunde kunde = lvwKunder.getSelectionModel().getSelectedItem();
        LocalDate dato = LocalDate.parse(txfDato.getText().trim());
        ArrayList<Plads> pladser = new ArrayList<>(lvwPladser.getSelectionModel().getSelectedItems());

        Bestilling nyBestilling = Controller.opretBestillingMedPladser(forestilling, kunde, dato, pladser);



        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Status");
        dialog.setHeaderText("Status på bestilling");

        if (nyBestilling != null) {
            for (Plads p : pladser) {
                dialog.getContentText();
            }
            dialog.setContentText("Bestillingen er gennemført" + pladser);

        } else {
            dialog.setContentText("Bestillingen fejlet \n" +
                    "Pladser allerede optaget, eller fejl i dato");
        }
        dialog.show();
        Window window = dialog.getDialogPane().getScene().getWindow();
        window.setOnCloseRequest(event -> window.hide());
    }
}


