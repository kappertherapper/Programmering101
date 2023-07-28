package ex1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class firstLastname extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Jeg har kidnappet din søster");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(30));
        // set horizontal gap between components
        pane.setHgap(20);
        // set vertical gap between components
        pane.setVgap(50);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("First name:");
        pane.add(lblName, 0, 0);

        Label lblName1 = new Label("Last name:");
        pane.add(lblName1, 1, 1);

        Label lblFullName = new Label("Last name:");
        pane.add(lblFullName, 0, 3, 2, 1);


        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        TextField txfName = new TextField();
        pane.add(txfName, 0, 1, 1, 1);

        // add a button to the pane (at col=2, row=1)
        Button btnLowerCase = new Button("Compine ");
        pane.add(btnLowerCase, 1, 4);
        GridPane.setMargin(btnLowerCase, new Insets(10, 10, 0, 10));
    }
}
