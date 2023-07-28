package ex1;

import guidemoespart2.demotwowindows.Movie;
import guidemoespart2.demotwowindows.MovieInputWindow;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInputWindow extends Stage {

    public PersonInputWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfTitle = new TextField();
    private final TextField txfName = new TextField();
    private Person actualPerson = null;
    private final CheckBox cbx = new CheckBox();

    private void initContent(GridPane pane) {
//        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 0);

        Label lblActor = new Label("Name:");
        pane.add(lblActor, 0, 1);

        pane.add(txfTitle, 1, 0);

        pane.add(txfName, 1, 1);

        pane.add(cbx, 1, 3);
        cbx.setText("Senior?");
        cbx.setSelected(false);
        cbx.setOnAction(event -> this.checkBoxAction());

        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 2, 2, 1);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.CENTER);

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void cancelAction() {
        txfTitle.clear();
        txfTitle.requestFocus();
        txfName.clear();
        actualPerson = null;
        PersonInputWindow.this.hide();
    }

    // -------------------------------------------------------------------------

    private void okAction() {
        String title = txfTitle.getText().trim();
        String name = txfName.getText().trim();

        if (title.length() > 0 && name.length() > 0) {
            actualPerson = new Person(title, name, cbx.isSelected());
            txfTitle.clear();
            txfName.clear();
            txfTitle.requestFocus();
            PersonInputWindow.this.hide();

        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Create movie");
            alert.setHeaderText("Information missing");
            alert.setContentText("Type title and actor");
            alert.show();
        }
    }

    public Person getActualPerson() {
        return actualPerson;
    }

    public void clearActualPerson() {
        actualPerson = null;
    }

            //Alert alert = new Alert (Alert.AlertType.WARNING);
            //alert.setTitle("Add person");
            //alert.setHeaderText("No name or title typed");
            // alert.setContentText("Please type the name of the person and/or title");
            //alert.show();


    private void checkBoxAction () {
        if (cbx.isSelected())
            txfName.setEditable(true);
        else
            txfName.setEditable(false);
    }
}
