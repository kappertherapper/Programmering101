package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import model.Conference;
import model.Excursion;
import model.Hotel;
import model.Registration;

public class HotelPane extends GridPane {
    TextArea txaRegistrations = new TextArea();
    private final TextField txfName = new TextField();
    private final TextField txfSingle = new TextField();
    private final ListView<Hotel> lvwHotels = new ListView<>();

    // -------------------------------------------------------------------------

    public HotelPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        //Registrations
        Label lblRegistrations = new Label("Registrations");
        this.add(lblRegistrations, 3, 0);

        this.add(txaRegistrations, 3, 1, 1, 5);
        txaRegistrations.setPrefWidth(300);
        txaRegistrations.setPrefHeight(200);
        txaRegistrations.setEditable(false);

        ChangeListener<Hotel> listener = (ov, o, n) -> this.selectedConferenceChanged();
        lvwHotels.getSelectionModel().selectedItemProperty().addListener(listener);

        //Hotels
        Label lblHotel = new Label("Hotels");
        this.add(lblHotel, 0, 0);

        this.add(lvwHotels, 0, 1, 1, 5);
        lvwHotels.setPrefWidth(300);
        lvwHotels.setPrefHeight(200);
        lvwHotels.getItems().setAll(Controller.getHotels());
        lvwHotels.setOnMouseClicked(event -> selectHotelAction());

        //Buttons
        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 10, 1, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreateHotel = new Button("Create Hotel");
        hbxButtons.getChildren().add(btnCreateHotel);
        btnCreateHotel.setOnAction(event -> this.createHotelAction());

        Button btnCreateExtra = new Button("Create Extra");
        hbxButtons.getChildren().add(btnCreateExtra);
        btnCreateExtra.setOnAction(event -> this.createExtraAction());
    }

    // -------------------------------------------------------------------------

    private void selectHotelAction() {
        Hotel hotel = lvwHotels.getSelectionModel().getSelectedItem();
        if (hotel != null) {
            String cs = "";
            for (Registration r : hotel.getRegistrations()) {
                cs += r.toString();
            }
            txaRegistrations.setText(cs);

        } else {
            txaRegistrations.clear();

        }
    }

    // -------------------------------------------------------------------------

    private void createHotelAction() {
        HotelWindow dialog = new HotelWindow("Create hotel", null);
        dialog.showAndWait();

        lvwHotels.getItems().setAll(Controller.getHotels());
        int index = lvwHotels.getItems().size() - 1;
        lvwHotels.getSelectionModel().select(index);
    }

    // -------------------------------------------------------------------------

    private void createExtraAction() {
        ExtraWindow dialog = new ExtraWindow("Create Extra", null);
        dialog.showAndWait();

        lvwHotels.getItems().setAll(Controller.getHotels());
        int index = lvwHotels.getItems().size() - 1;
        lvwHotels.getSelectionModel().select(index);

    }

    // -------------------------------------------------------------------------

    private void selectedConferenceChanged() {
        this.updateControls();
    }

    // -------------------------------------------------------------------------

    public void updateControls() {
        Hotel hotel = lvwHotels.getSelectionModel().getSelectedItem();
        if (hotel != null) {
            txfName.setText(hotel.getName());
            txfSingle.setText("" + hotel.getPriceSingleRoom());
            StringBuilder sb = new StringBuilder();
            for (Registration emp : hotel.getRegistrations()) {
                sb.append(emp).append("\n");
            }
            txaRegistrations.setText(sb.toString());
        } else {
            txfName.clear();
            txfSingle.clear();
        }
    }
}


