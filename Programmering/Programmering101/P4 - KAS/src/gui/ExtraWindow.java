package gui;

import controller.Controller;
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

public class ExtraWindow extends Stage {
    private final Extra extra;

    public ExtraWindow(String title, Extra extra) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.extra = extra;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfPrice = new TextField();
    private final Label lblError = new Label();
    private final ComboBox<Hotel> cbbHotel = new ComboBox<>();

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
        txfName.setPrefWidth(100);

        Label lblPrice = new Label("Price");
        pane.add(lblPrice, 0, 2);
        pane.add(txfPrice, 0, 3);

        // Combobox
        pane.add(cbbHotel, 0, 5);
        cbbHotel.getItems().addAll(Controller.getHotels());

        //Buttons
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 8);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOk = new Button("Ok");
        pane.add(btnOk, 1, 8);
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

        double price = 0;
        try {
            price = Double.parseDouble(txfPrice.getText().trim());
        } catch (NumberFormatException e) {
            lblError.setText("Invalid price");
            return;
        }

        if (cbbHotel.getSelectionModel().getSelectedItem() != null) {
            Hotel hotel = cbbHotel.getValue();
            Extra extra = Controller.createExtra(name, price, hotel);
        }
        this.hide();
    }
}

    // -------------------------------------------------------------------------

