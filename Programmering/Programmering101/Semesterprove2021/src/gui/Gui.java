package gui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Deltagelse;
import model.DeltagerStatus;
import model.Fag;
import model.Lektion;
import storage.Storage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Fraværssystem");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Fag> lvwFag = new ListView<>();
    private final ListView<Lektion> lvwLektion = new ListView<>();
    private final ListView<Deltagelse> lvwDeltagelse = new ListView<>();
    private final CheckBox checkBox = new CheckBox();
    private final CheckBox checkBox1 = new CheckBox();
    private final CheckBox checkBox2 = new CheckBox();
    private final CheckBox checkBox3 = new CheckBox();

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
        Label lblFag = new Label("Fag:");
        pane.add(lblFag, 2, 0);

        Label lblLektion = new Label("Lektion:");
        pane.add(lblLektion, 4, 0);

        Label lblDeltagelse = new Label("Deltagelser:");
        pane.add(lblDeltagelse, 6, 0);

        Label lblFravær = new Label("Fraværsårsager:");
        pane.add(lblFravær, 8, 0);

        // add a listView to the pane(at col=2, row=3)
        pane.add(lvwFag, 2, 3, 1, 5);
        lvwFag.setPrefWidth(350);
        lvwFag.setPrefHeight(250);
        lvwFag.getItems().setAll(Storage.getFag());
        lvwFag.getSelectionModel().clearSelection();

        ChangeListener<Fag> listener = (ov, o, n) -> this.fagChanged();
        lvwFag.getSelectionModel().selectedItemProperty().addListener(listener);

        // add a listView to the pane(at col=4, row=3)
        pane.add(lvwLektion, 4, 3, 1, 5);
        lvwLektion.setPrefWidth(250);
        lvwLektion.setPrefHeight(250);

        ChangeListener<Lektion> listener1 = (ov, o, n) -> this.lektionChanged();
        lvwLektion.getSelectionModel().selectedItemProperty().addListener(listener1);

        // add a listView to the pane(at col=6, row=3)
        pane.add(lvwDeltagelse, 6, 3, 1, 5);
        lvwDeltagelse.setPrefWidth(250);
        lvwDeltagelse.setPrefHeight(250);
        lvwDeltagelse.getSelectionModel().clearSelection();

        Button btnFravær = new Button("Fravær");
        pane.add(btnFravær, 8, 7);
        GridPane.setHalignment(btnFravær, HPos.LEFT);
        btnFravær.setOnAction(event -> this.fraværButtonAction());


        // CheckBoxes
        checkBox.setText("Tilsted");
        pane.add(checkBox, 8, 3);

        checkBox1.setText("Fravær");
        pane.add(checkBox1, 8, 4);

        checkBox2.setText("Syg");
        pane.add(checkBox2, 8, 5);

        checkBox3.setText("Afbud");
        pane.add(checkBox3, 8, 6);
    }

    private void fagChanged() {
        Fag fag = lvwFag.getSelectionModel().getSelectedItem();
        if (fag != null) {
            lvwLektion.getItems().setAll(fag.getLektioner());
        }
  }

    public void lektionChanged() {
        Lektion lektion = lvwLektion.getSelectionModel().getSelectedItem();
        if (lektion != null) {
            lvwDeltagelse.getItems().setAll(lektion.getDeltagelser());
        }
    }

    public void fraværButtonAction() {
        Deltagelse deltagelse = lvwDeltagelse.getSelectionModel().getSelectedItem();
        if (checkBox.isSelected()) {
            deltagelse.setStatus(DeltagerStatus.TILSTEDE);
        } else if (checkBox1.isSelected()) {
            deltagelse.setStatus(DeltagerStatus.FRAVÆR);
        } else if (checkBox2.isSelected()) {
            deltagelse.setStatus(DeltagerStatus.SYG);
        } else {
            deltagelse.setStatus(DeltagerStatus.AFBUD);
        }
        lektionChanged();
    }
}