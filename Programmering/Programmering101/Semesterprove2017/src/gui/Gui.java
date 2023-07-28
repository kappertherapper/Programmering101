package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Patient;
import model.PersonligtMåltid;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Patienter og Måltider 😋");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    //-----------------------------------------------------------

    private final ListView<Patient> lvwPatienter = new ListView<>();
    private final ListView<PersonligtMåltid> lvwMåltid = new ListView<>();
    private final TextField txfNavn = new TextField();
    private final TextField txfAnbefalet = new TextField();
    private final TextField txfDaglig = new TextField();
    private final TextField txfProcent = new TextField();


    //-----------------------------------------------------------

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        //-----------------------------------------------------------


        //Labels
        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 1, 1);

        Label lblAnbefalet = new Label("Anbefalet Daglig");
        pane.add(lblAnbefalet, 1, 3);

        Label lblDaglig = new Label("Daglig Indtaget: ");
        pane.add(lblDaglig, 1, 4);

        Label lblProcent = new Label("Procent Anbefalet: ");
        pane.add(lblProcent, 1, 5);

        Label lblPatienter = new Label("Patienter");
        pane.add(lblPatienter, 1, 8);


        // -------------------------------------------------------------------------

        //Textfields
        pane.add(txfNavn, 2, 1, 1, 1);
        txfNavn.setEditable(false);

        pane.add(txfAnbefalet, 2, 3, 1, 1);
        txfAnbefalet.setEditable(false);

        pane.add(txfDaglig, 2, 4, 1, 1);
        txfDaglig.setEditable(false);

        pane.add(txfProcent, 2, 5, 1, 1);
        txfProcent.setEditable(false);


        // -------------------------------------------------------------------------

        // add a listView to the pane(at col=2, row=6)
        pane.add(lvwPatienter, 2, 6, 1, 5);
        lvwPatienter.setPrefWidth(350);
        lvwPatienter.setPrefHeight(250);
        lvwPatienter.getItems().setAll(Controller.getPatienter());
        lvwPatienter.getSelectionModel().clearSelection();
        ChangeListener<Patient> listener = (ov, o, n) -> this.PatientSelected();
        lvwPatienter.getSelectionModel().selectedItemProperty().addListener(listener);

        // add a listView to the pane(at col=2, row=6)
        pane.add(lvwMåltid, 4, 4, 1, 5);
        lvwMåltid.setPrefWidth(150);
        lvwMåltid.setPrefHeight(200);
        lvwMåltid.getItems().setAll();
        lvwMåltid.getSelectionModel().clearSelection();

        // -------------------------------------------------------------------------

        Button btnMåltid = new Button("Vis Måltider");
        pane.add(btnMåltid, 4, 3);
        GridPane.setHalignment(btnMåltid, HPos.LEFT);
        btnMåltid.setOnAction(event -> this.VisMålAction());
    }

    // -------------------------------------------------------------------------

    public void PatientSelected() {
        Patient patient = lvwPatienter.getSelectionModel().getSelectedItem();
        if (patient != null) {
            txfNavn.setText(patient.getNavn());
            txfAnbefalet.setText(String.valueOf(patient.beregnAnbefaletKalorierPerDag()));
            txfDaglig.setText(String.valueOf(patient.beregnDagensAntalKalorier()));
            txfProcent.setText(String.valueOf(patient.beregnProcentDagligAnbefalet()));
        }
    }

    public void VisMålAction() {
        Patient patient = lvwPatienter.getSelectionModel().getSelectedItem();
        if (patient != null) {
            lvwMåltid.getItems().setAll(patient.getPersonligeMåltider());
        }
    }
}