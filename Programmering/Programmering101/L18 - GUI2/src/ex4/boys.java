package ex4;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class boys extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("???");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    // -------------------------------------------------------------------------

    private final ListView<String> lvwPersons = new ListView<>();
    private final ArrayList<String> boys = new ArrayList<String>();
    private final ArrayList<String> girls = new ArrayList<String>();
    private final TextField txfName = new TextField();
    private final RadioButton boy = new RadioButton();
    private final RadioButton girl = new RadioButton();

    //-----------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        this.initPersons();

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        //Labels
        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 10);

        Label lblNames = new Label("Persons:");
        pane.add(lblNames, 0, 3);

        //Text fields
        pane.add(txfName, 1, 10, 2, 1);

        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwPersons, 1, 3, 1, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(boys);

        ChangeListener<String> listener = (ov, oldPerson, newPerson) -> this.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);
        lvwPersons.getSelectionModel().clearSelection();

        Button addPerson = new Button("Add");
        pane.add(addPerson, 6, 10);
        addPerson.setOnAction(event -> this.addAction());


        // add a HBox (horizontal box) to the pane (at col=0, row=0)
        HBox box = new HBox();
        pane.add(box, 1, 0);

        //HBox box1 = new HBox();
        //pane.add(box, 2, 0);

        ToggleGroup group = new ToggleGroup();

        //Radio buttons
        box.getChildren().add(boy);
        boy.setText("Boys");
        boy.setPrefWidth(70);
        boy.setToggleGroup(group);
        boy.selectedProperty().addListener(
                (ov, o, n) -> this.boysSelected());


        box.getChildren().add(girl);
        girl.setText("Girls");
        girl.setPrefWidth(70);
        girl.setToggleGroup(group);
        girl.selectedProperty().addListener(
                (ov, o, n) -> this.girlsSelected());

        boy.setSelected(true);
        lvwPersons.getItems().setAll(boys);
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        String name = txfName.getText().trim();
         if (name.isEmpty()) {
             Alert dialog = new Alert(Alert.AlertType.ERROR);
             dialog.setTitle("Error: Missing input!");
             dialog.setContentText("Name must be entered.");
             dialog.setHeaderText("Error: Missing input.");
             dialog.showAndWait();
             // wait for the dialog to close
         } else {
             if (boy.isSelected()) {
                 boys.add(name);
                 lvwPersons.getItems().setAll(boys);
             } else {
                 girls.add(name);
                 lvwPersons.getItems().setAll(girls);
             }
         }
         txfName.requestFocus();
         txfName.selectAll();
    }

    private void initPersons() {
        boys.add(new String("Henrik"));
        girls.add(new String("Bente"));

    }

    // -------------------------------------------------------------------------
    // Selection changed action

    private void selectionChanged() {
        String boy = lvwPersons.getSelectionModel().getSelectedItem();
        if (boy != null) {
            txfName.setText(boy);
        } else {
            txfName.clear();
        }
    }

    private void boysSelected(){
        lvwPersons.getItems().setAll(boys);

    }

    private void girlsSelected(){
        lvwPersons.getItems().setAll(girls);
    }
}
