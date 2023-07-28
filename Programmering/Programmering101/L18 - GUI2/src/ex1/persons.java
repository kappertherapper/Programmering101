package ex1;

import guidemoespart2.demotwowindows.Movie;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class persons extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("???");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        addPersonWindow = new PersonInputWindow("Create Person", stage);
    }

    // -------------------------------------------------------------------------

    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<Person>();
    private final TextField txfName = new TextField();
    private final TextField txftitle = new TextField();
    private final CheckBox cbx = new CheckBox();
    private final TextField txfResult = new TextField();
    private PersonInputWindow addPersonWindow;

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
        //Label lblName = new Label("Name:");
        //pane.add(lblName, 0, 0);

        //Label lblTitle = new Label("Title:");
        //pane.add(lblTitle, 0, 1);

        Label lblNames = new Label("Persons:");
        pane.add(lblNames, 0, 3);

        //Text fields
        // pane.add(txfName, 1, 0, 2, 1);
        // pane.add(txftitle, 1, 1, 2, 1);

        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwPersons, 1, 3, 1, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(2000);
        lvwPersons.getItems().setAll(persons);

        ChangeListener<Person> listener = (ov, oldPerson, newPerson) -> this.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwPersons.getSelectionModel().clearSelection();

        //Button addPerson = new Button("Add person");
        //pane.add(addPerson, 6, 3);

        //Button for new window
        Button addPerson = new Button("Create Person");
        pane.add(addPerson, 6, 3);
        GridPane.setMargin(addPerson, new Insets(10, 10, 0, 10));
        addPerson.setOnAction(event -> this.createMovieAction());

        //Checkbox
        //pane.add(cbx, 1, 2);
        //cbx.setText("Senior?");
        //cbx.setSelected(false);
        // cbx.setOnAction(event -> this.checkBoxAction());

        // connect a method to the button
        //btnCreateMovie.setOnAction(event -> this.addAction());

    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        String name = txfName.getText().trim();
        if (name.length() > 0) {
            Person p = new Person(txfName.getText(), txftitle.getText(), cbx.isSelected());
            persons.add(p);
            lvwPersons.getItems().setAll(persons);

        } else {
            //Alert alert = new Alert (Alert.AlertType.WARNING);
            //alert.setTitle("Add person");
            //alert.setHeaderText("No name or title typed");
           // alert.setContentText("Please type the name of the person and/or title");
            //alert.show();

        }
    }

    private void createMovieAction() {
        addPersonWindow.showAndWait();

        // wait for the dialog to close ...

        if (addPersonWindow.getActualPerson() != null) {
            Person person = addPersonWindow.getActualPerson();
            lvwPersons.getItems().add(person);

        }
    }
            private void initPersons () {
                persons.add(new Person("Henrik", "MASTER", true));

            }

            // -------------------------------------------------------------------------
            // Selection changed action

            private void selectionChanged () {
                Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
                if (newPerson != null) {
                    txfName.setText(newPerson.getName());
                } else {
                    txfName.clear();
                }
            }

            private void checkBoxAction () {
                if (cbx.isSelected())
                    txfName.setEditable(true);
                else
                    txfName.setEditable(false);
            }
        }
