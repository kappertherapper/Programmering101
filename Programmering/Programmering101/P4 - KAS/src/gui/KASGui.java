package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class KASGui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Konference Administrations Systemet");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        Tab tabConferences = new Tab("Confere$nces");
        tabPane.getTabs().add(tabConferences);

        //ComferencePane comferencePane = new ComferencePane();
        //tabConferences.setContent(comferencePane);

        Tab tabExcursions = new Tab("Hotels");
        tabPane.getTabs().add(tabExcursions);

        HotelPane hotelPane = new HotelPane();
        tabExcursions.setContent(hotelPane);
    }
}
