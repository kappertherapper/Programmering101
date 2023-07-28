package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Model.Bestilling;
import Model.Forestilling;
import Model.Kunde;
import Model.Plads;
import storage.Storage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Teater bestillinger");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    // -------------------------------------------------------------------------

    private final ListView<Forestilling> lvwForstillinger = new ListView<>();
    private final ListView<Kunde> lvwKunder = new ListView<>();
    private final ListView<Plads> lvwPladser = new ListView<>();
    private final TextField txfNavn = new TextField();
    private final TextField txfStart = new TextField();
    private final TextField txfSlut = new TextField();
    private final TextField txfKundeNavn = new TextField();
    private final TextField txfKundeMobil = new TextField();
    private final TextField txfDato = new TextField();

    //-----------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);


        //Labels
        Label lblForstillinger = new Label("Forstillinger:");
        pane.add(lblForstillinger, 2, 1);

        Label lblKunder = new Label("Kunder:");
        pane.add(lblKunder, 4, 1);

        Label lblPladser = new Label("Pladser:");
        pane.add(lblPladser, 6, 1);

        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 1, 10);


        Label lblStart = new Label("Start dato:");
        pane.add(lblStart, 1, 11);

        Label lblSlut = new Label("Slut dato:");
        pane.add(lblSlut, 1, 12);


        Label lblKundeNavn = new Label("Kunde Navn:");
        pane.add(lblKundeNavn, 3, 10);

        Label lblKundeMobil = new Label("Kunde Mobil:");
        pane.add(lblKundeMobil, 3, 11);

        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 5, 10);


        //Text fields
        pane.add(txfNavn, 2, 10, 1, 1);

        pane.add(txfStart, 2, 11, 1, 1);

        pane.add(txfSlut, 2, 12, 1, 1);

        pane.add(txfKundeNavn, 4, 10, 1, 1);

        pane.add(txfKundeMobil, 4, 11, 1, 1);

        pane.add(txfDato, 6, 10, 1, 1);


        // add a listView to the pane(at col=1, row=3)
        pane.add(lvwForstillinger, 2, 3, 1, 5);
        lvwForstillinger.setPrefWidth(350);
        lvwForstillinger.setPrefHeight(250);
        lvwForstillinger.getItems().setAll(Storage.getForestillinger());
        lvwForstillinger.getSelectionModel().clearSelection();

        // add a listView to the pane(at col=4, row=3)
        pane.add(lvwKunder, 4, 3, 1, 5);
        lvwKunder.setPrefWidth(250);
        lvwKunder.setPrefHeight(250);
        lvwKunder.getItems().setAll(Storage.getKunder());
        lvwKunder.getSelectionModel().clearSelection();

        // add a listView to the pane(at col=4, row=3)
        pane.add(lvwPladser, 6, 3, 1, 5);
        lvwPladser.setPrefWidth(250);
        lvwPladser.setPrefHeight(250);
        lvwPladser.getItems().setAll(Storage.getPladser());
        lvwPladser.getSelectionModel().clearSelection();
        lvwPladser.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Buttons
        Button addForstilling = new Button("Opret Forstilling ");
        pane.add(addForstilling, 2, 14);
        addForstilling.setOnAction(event -> this.addActionForstilling());

        Button addKunde = new Button("Opret Kunde ");
        pane.add(addKunde, 4, 12);
        addKunde.setOnAction(event -> this.addActionKunde());

        Button addBestilling = new Button("Opret Bestilling ");
        pane.add(addBestilling, 6, 12);
        addBestilling.setOnAction(event -> this.OpretBestilling());

    }

    // -------------------------------------------------------------------------
    private void addActionForstilling() {
        if (txfNavn.getText().isEmpty()) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error: Missing input!");
            dialog.setContentText("Information must be entered.");
            dialog.setHeaderText("Error: Missing input.");
            dialog.show();
            return;
        }

        ArrayList<String> forestillinger = new ArrayList<>();
        for (Forestilling f : Storage.getForestillinger()) {
            forestillinger.add(f.toString());
        }

        String name = txfNavn.getText();
        LocalDate start = LocalDate.parse(txfStart.getText());
        LocalDate slut = LocalDate.parse(txfSlut.getText());

        Controller.createForstilling(name, start, slut);
        lvwForstillinger.getItems().setAll(Storage.getForestillinger());
    }

    private void addActionKunde() {
        if (txfKundeNavn.getText().isEmpty() || txfKundeMobil.getText().isEmpty()) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error: Missing input!");
            dialog.setContentText("Information must be entered.");
            dialog.setHeaderText("Error: Missing input.");
            dialog.show();
            return;
            // wait for the dialog to close
        }

        ArrayList<String> kunder = new ArrayList<>();
        for (Kunde f : Storage.getKunder()) {
            kunder.add(f.toString());
        }

        String kundeNavn = txfKundeNavn.getText();
        String kundeMobil = txfKundeMobil.getText();

        Controller.createKunde(kundeNavn, kundeMobil);
        lvwKunder.getItems().setAll(Storage.getKunder());
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

    private void OpretBestilling() {
        if (!erDatoValid(txfDato.getText().trim())) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error: Missing input!");
            dialog.setContentText("Date must be entered.");
            dialog.setHeaderText("Error: Missing input.");
            dialog.show();
            return;
            // wait for the dialog to close
        }

        Forestilling forestilling = lvwForstillinger.getSelectionModel().getSelectedItem();
        Kunde kunde = lvwKunder.getSelectionModel().getSelectedItem();
        LocalDate dato = LocalDate.parse(txfDato.getText().trim());
        ArrayList<Plads> pladser = new ArrayList<>(lvwPladser.getSelectionModel().getSelectedItems());

        Bestilling nyBestilling = Controller.opretBestillingMedPladser(forestilling, kunde, dato, pladser);

    if (nyBestilling != null) {
            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setTitle("Bestilling");
            dialog.setContentText("Din ordre bekræfelse er sendt afsted");
            dialog.setHeaderText("Bestilling er oprettet");
            dialog.show();

            } else
                if (nyBestilling == null) {

        Alert dialog = new Alert(Alert.AlertType.ERROR);
                    dialog.setTitle("Error: Missing input!");
                    dialog.setContentText("Name must be entered.");
                    dialog.setHeaderText("Error: Missing input.");
                    dialog.show();
    }

            System.out.println("Oprettet " + nyBestilling);
        }
    }
    // -------------------------------------------------------------------------


