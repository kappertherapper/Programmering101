package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Medarbejder;
import model.Vagt;
import storage.Storage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Kantinens Vagtplanlægning");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Medarbejder> lvwMedarbejder = new ListView<>();
    private final ListView<Vagt> lvwVagt = new ListView<>();
    private final TextArea textAreaVagt = new TextArea();

    // -------------------------------------------------------------------------

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
        Label lblFag = new Label("Alle medarbejdere:");
        pane.add(lblFag, 2, 0);

        Label lblLektion = new Label("Alle Vagter:");
        pane.add(lblLektion, 4, 0);

        Label lblDeltagelse = new Label("Valgt Vagt:");
        pane.add(lblDeltagelse, 6, 0);

//        Label lblFravær = new Label("Fraværsårsager:");
//        pane.add(lblFravær, 8, 0);

        // add a listView to the pane(at col=2, row=3)
        pane.add(lvwMedarbejder, 2, 3, 1, 5);
        lvwMedarbejder.setPrefWidth(350);
        lvwMedarbejder.setPrefHeight(250);
        lvwMedarbejder.getItems().setAll(Storage.getMedarbejdere());
        lvwMedarbejder.getSelectionModel().clearSelection();

        // add a listView to the pane(at col=4, row=3)
        pane.add(lvwVagt, 4, 3, 1, 5);
        lvwVagt.setPrefWidth(250);
        lvwVagt.setPrefHeight(250);
        lvwVagt.getItems().setAll(Storage.getVagtere());
        lvwVagt.getSelectionModel().clearSelection();

        // add a listView to the pane(at col=6, row=3)
        pane.add(textAreaVagt, 6, 3, 1, 5);
        textAreaVagt.setPrefWidth(250);
        textAreaVagt.setPrefHeight(250);
        textAreaVagt.setEditable(false);
        lvwVagt.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                String navn = newValue.getNavn();
                LocalDateTime fra = newValue.getTidFra();
                LocalDateTime til = newValue.getTidTil();
                long tid = newValue.elapsedTime();
                ArrayList<Medarbejder> medarbejdere = newValue.getMedarbejdere();

                String text = String.format("Navn: %s%nFra: %s%nTil: %s%nVarrighed: %s%nMedarbejdere: %s", navn, fra, til, tid, medarbejdere);
                textAreaVagt.setText(text);

            }
        });


        Button btnTildel = new Button("Tildel vagt");
        pane.add(btnTildel, 4, 9);
        GridPane.setHalignment(btnTildel, HPos.LEFT);
        btnTildel.setOnAction(event -> this.TildelVagtButtonAction());

        Button btnFil = new Button("Udskriv vagt til fil");
        pane.add(btnFil, 6, 9);
        GridPane.setHalignment(btnFil, HPos.LEFT);
        btnFil.setOnAction(event -> this.VagtTilFilAction());

    }


    public void TildelVagtButtonAction() {
        Medarbejder medarbejder = lvwMedarbejder.getSelectionModel().getSelectedItem();
        Vagt vagt = lvwVagt.getSelectionModel().getSelectedItem();
        for (Vagt vagt1 : medarbejder.getVagter()) {
            if (Duration.between(vagt1.getTidFra(), vagt1.getTidTil()) == Duration.between(vagt.getTidFra(), vagt.getTidTil())) {
                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setTitle("Fejl");
                dialog.setContentText("Medarbejder har allerede vagt på given tidspunkt");
                dialog.setHeaderText("Fejl");
                dialog.show();
                return;
            }
        }

        if (medarbejder != null && vagt != null) {
            Controller.addMedarbejderTilVagt(medarbejder, vagt);

        }
    }

    public void VagtTilFilAction() {
        String fil = "Semesterprove2022/src/controller/Vagtplan.txt";
        Vagt vagt = lvwVagt.getSelectionModel().getSelectedItem();
        Controller.udskrivVagtplan(vagt, fil);

        File in = new File(fil);
        try {
            if (!in.exists()) {
                in.createNewFile();
            }
            // Rest of your file-writing code...
        } catch (IOException e) {
            System.err.println("Sorry! An unexpected error has occurred.");
            System.err.println("Technical message: " + e.getMessage());
        }
    }
}