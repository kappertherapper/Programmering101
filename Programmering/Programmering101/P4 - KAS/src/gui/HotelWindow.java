package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Extra;
import model.Hotel;
import storage.Storage;

public class HotelWindow extends Stage {
    private final Hotel hotel;
    public HotelWindow(String title, Hotel hotel) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.hotel = hotel;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfSingle = new TextField();
    private final TextField txfDouble = new TextField();
    private final CheckBox cbxExtras = new CheckBox();
    private final ListView<Extra> listView = new ListView<>();
    private final Label lblError = new Label();

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        //Labels
        Label lblName = new Label("Name");
        pane.add(lblName, 0, 0);
        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(200);

        Label lblSingle = new Label("Single room");
        pane.add(lblSingle, 0, 2);
        pane.add(txfSingle, 0, 3);

        Label lblDouble = new Label("Double room");
        pane.add(lblDouble, 0, 4);
        pane.add(txfDouble, 0, 5);

        //Checkbox
        pane.add(cbxExtras, 0, 6);
        cbxExtras.setText("Extras");
        ChangeListener<Boolean> listener = (ov, oldValue, newValue) -> this.selectedCompanyChanged(newValue);
        cbxExtras.selectedProperty().addListener(listener);

        //Listview
        pane.add(listView, 0, 7);
        listView.getItems().addAll(Controller.getExtras());
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.setDisable(true);

        //Buttons
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 8);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOk = new Button("Ok");
        pane.add(btnOk, 2, 8);
        GridPane.setHalignment(btnOk, HPos.LEFT);
        btnOk.setOnAction(event -> this.okAction());

        //Error
        pane.add(lblError, 0, 9);
        lblError.setStyle("-fx-text-fill: red");
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        this.hide();
    }

    // -------------------------------------------------------------------------

    private void okAction() {
        String name = txfName.getText().trim();
        if (name.isEmpty()) {
            lblError.setText("Name is empty");
            return;
        }

        double single = 0;
        try {
            single = Double.parseDouble(txfSingle.getText().trim());
        } catch (NumberFormatException e) {
            lblError.setText("Invalid single room price");
            return;
        }

        double storseng = 0;
        try {
            storseng = Double.parseDouble(txfDouble.getText().trim());
        } catch (NumberFormatException e) {
            lblError.setText("Invalid double room price");
            return;
        }

        if (cbxExtras.isSelected()) {
            Hotel hotel = Controller.createHotel(name, single, storseng);
            for (Extra selectedItem : listView.getSelectionModel().getSelectedItems()) {
                Controller.addExtraToHotel(selectedItem, hotel);
            }
        } else {
            Controller.createHotel(name, single, storseng);
        }
            this.hide();
        }


    // -------------------------------------------------------------------------

    private void selectedCompanyChanged(boolean checked) {
        listView.setDisable(!checked);
    }
}
