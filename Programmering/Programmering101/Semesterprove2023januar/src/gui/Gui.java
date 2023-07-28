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
import model.Salg;
import model.Salgsannonce;
import model.Vare;

public class Gui extends Application {

        @Override
        public void start(Stage stage) {
            stage.setTitle("Handelsplatform 🤝");
            GridPane pane = new GridPane();
            this.initContent(pane);

            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.show();
        }

        //-----------------------------------------------------------

        private final ListView<Salgsannonce> lvwSalgsannoncer = new ListView<>();
        private final ListView<Vare> lvwVarer = new ListView<>();
        private final TextField txfKøber = new TextField();
        private final TextField txfAftaltPris = new TextField();
        private final TextField txfFil = new TextField();

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
            Label lblBaner = new Label("Aktive Annoncer:");
            pane.add(lblBaner, 2, 1);

            Label lblSpillere = new Label("Varer:");
            pane.add(lblSpillere, 4, 1);

            Label lblSpilBook = new Label("Køber: ");
            pane.add(lblSpilBook, 5, 3);

            Label lblOpretBooking = new Label("Aftalt pris: ");
            pane.add(lblOpretBooking, 5, 4);

            Label lblDato = new Label("Fil navn:");
            pane.add(lblDato, 5, 13);


            // -------------------------------------------------------------------------


            //Textfields
            pane.add(txfKøber, 6, 3, 1, 1);

            pane.add(txfAftaltPris, 6, 4, 1, 1);

            pane.add(txfFil, 6, 13, 1, 1);


            // -------------------------------------------------------------------------


            // add a listView to the pane(at col=2, row=3)
            pane.add(lvwSalgsannoncer, 2, 3, 1, 5);
            lvwSalgsannoncer.setPrefWidth(350);
            lvwSalgsannoncer.setPrefHeight(250);
            lvwSalgsannoncer.getItems().setAll(Controller.getSalgsAnnoncer());
            lvwSalgsannoncer.getSelectionModel().clearSelection();

            // add a listView to the pane(at col=4, row=3)
            pane.add(lvwVarer, 4, 3, 1, 5);
            lvwVarer.setPrefWidth(350);
            lvwVarer.setPrefHeight(250);
            lvwVarer.getSelectionModel().clearSelection();
            lvwVarer.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            ChangeListener<Salgsannonce> listener = (ov, o, n) -> this.VareChanged();
            lvwSalgsannoncer.getSelectionModel().selectedItemProperty().addListener(listener);

            // -------------------------------------------------------------------------


            Button btnSalg = new Button("Opret salg");
            pane.add(btnSalg, 5, 5);
            GridPane.setHalignment(btnSalg, HPos.LEFT);
            btnSalg.setOnAction(event -> this.addActionSalg());

            Button btnFil = new Button("Salgs fil");
            pane.add(btnFil, 5, 14);
            GridPane.setHalignment(btnFil, HPos.LEFT);
            btnFil.setOnAction(event -> this.addActionFil());

        }

    public void VareChanged() {
        Salgsannonce salgsannonce = lvwSalgsannoncer.getSelectionModel().getSelectedItem();
        if (salgsannonce != null) {
            lvwVarer.getItems().setAll(Controller.VareTilhørendeSalgannonce(salgsannonce));
        }
    }

    public void addActionSalg() {
        Vare vare = lvwVarer.getSelectionModel().getSelectedItem();
        if (txfKøber.getText().isEmpty() || txfAftaltPris.getText().isEmpty() || vare.isSolgt() == true) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Fejl");
            dialog.setContentText("Prøv igen");
            dialog.setHeaderText("Muuuh");
            dialog.show();
            return;
        }

        Controller.createSalg(txfKøber.getText(), Integer.parseInt(txfAftaltPris.getText().trim()));
    }

    public void addActionFil() {
        Controller.salgTilFil(String.valueOf(txfFil.getText().trim()));
    }
}
