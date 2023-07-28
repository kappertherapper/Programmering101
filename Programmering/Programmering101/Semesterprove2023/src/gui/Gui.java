package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Bane;
import model.Booking;
import model.Spiller;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Vent, skal vi spille padel? :D");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Bane> lvwBaner = new ListView<>();
    private final ListView<Spiller> lvwSpillere = new ListView<>();
    private final TextArea textAreaBaneBook = new TextArea();
    private final TextArea textAreaSpillerBook = new TextArea();
    private final TextField txfDato = new TextField();
    private final TextField txfTid = new TextField();
    private final CheckBox cbxSingle = new CheckBox();

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

        // -------------------------------------------------------------------------

        //Labels
        Label lblBaner = new Label("Baner:");
        pane.add(lblBaner, 2, 1);

        Label lblSpillere = new Label("Spillere:");
        pane.add(lblSpillere, 4, 1);

        Label lblSpilBook = new Label("Spillerens bookinger:");
        pane.add(lblSpilBook, 6, 1);

        Label lblOpretBooking = new Label("Opret bookning:");
        pane.add(lblOpretBooking, 6, 9);

        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 5, 12);

        Label lblTid = new Label("Tid:");
        pane.add(lblTid, 5, 13);

        // -------------------------------------------------------------------------

        //Textfields
        pane.add(txfDato, 6, 12, 1, 1);

        pane.add(txfTid, 6, 13, 1, 1);

        // -------------------------------------------------------------------------

        // add a listView to the pane(at col=2, row=3)
        pane.add(lvwBaner, 2, 3, 1, 5);
        lvwBaner.setPrefWidth(250);
        lvwBaner.setPrefHeight(250);
        lvwBaner.getItems().setAll(Storage.getBaner());
        lvwBaner.getSelectionModel().clearSelection();

        // add a listView to the pane(at col=4, row=3)
        pane.add(lvwSpillere, 4, 3, 1, 5);
        lvwSpillere.setPrefWidth(150);
        lvwSpillere.setPrefHeight(250);
        lvwSpillere.getItems().setAll(Storage.getSpillere());
        lvwSpillere.getSelectionModel().clearSelection();

        // -------------------------------------------------------------------------

        // add a textArea to the pane(at col=2, row=9)
        pane.add(textAreaBaneBook, 2, 9, 1, 5);
        textAreaBaneBook.setPrefWidth(200);
        textAreaBaneBook.setPrefHeight(150);
        textAreaBaneBook.setEditable(false);
        lvwBaner.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                ArrayList<Booking> bookinger = newValue.getBookinger();

                String text = String.format("Tid: %s%n", bookinger);
                textAreaBaneBook.setText(text);

            }
        });


        // add a TextArea to the pane(at col=6, row=3)
        pane.add(textAreaSpillerBook, 6, 3, 1, 5);
        textAreaSpillerBook.setPrefWidth(250);
        textAreaSpillerBook.setPrefHeight(250);
        textAreaSpillerBook.setEditable(false);
        lvwSpillere.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                ArrayList<Booking> bookinger = newValue.getBookinger();

                String text = String.format("%s\n", bookinger);
                textAreaSpillerBook.setText(text);

            }
        });

        // -------------------------------------------------------------------------

        Button btnFil = new Button("Book bane til spiller");
        pane.add(btnFil, 6, 15);
        GridPane.setHalignment(btnFil, HPos.LEFT);
        btnFil.setOnAction(event -> this.addActionBooking());

        //Checkbox
        pane.add(cbxSingle, 6, 14);
        cbxSingle.setText("Single?");
        ChangeListener<Boolean> listener = (ov, oldValue, newValue) -> this.selectedSingleChanged(newValue);
        cbxSingle.selectedProperty().addListener(listener);

    }

    // -------------------------------------------------------------------------

    private void selectedSingleChanged(boolean checked) {

    }

    // -------------------------------------------------------------------------

    private void addActionBooking() {
        if (txfDato.getText().isEmpty() || txfTid.getText().isEmpty()) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Fejl");
            dialog.setContentText("Prøv igen");
            dialog.setHeaderText("Muuuh");
            dialog.show();
            return;
        }

        Spiller spiller = lvwSpillere.getSelectionModel().getSelectedItem();
        Bane bane = lvwBaner.getSelectionModel().getSelectedItem();
        LocalDate dato = LocalDate.parse(txfDato.getText());
        LocalTime tid = LocalTime.parse(txfTid.getText());


        Controller.createBooking(spiller, bane, dato, tid, cbxSingle.isSelected());
        System.out.println();
    }
}