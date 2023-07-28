package Opgaver.tre;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class house extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        this.initContent(pane);
        Scene scene = new Scene(pane, 400, 400);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(Pane pane) {
        Circle sol = new Circle(150, 150, 30);
        pane.getChildren().add(sol);
        sol.setFill(Color.YELLOW);
        sol.setStroke(Color.BLACK);

        // Rectangle with upper left corner at (x, y), width w, height h
        Rectangle hus = new Rectangle(30, 275, 120, 120);
        pane.getChildren().add(hus);
        hus.setFill(Color.DARKRED);

        // Polygon with 3 points (x,y), (x,y) and (x,y)
        Polygon tag = new Polygon(20, 280, 90, 200, 160, 280);
        pane.getChildren().add(tag);
        tag.setFill(Color.BLUEVIOLET);

        // Rectangle with upper left corner at (x, y), width w, height h
        Rectangle vindue = new Rectangle(50, 300, 35, 35);
        pane.getChildren().add(vindue);
        vindue.setFill(Color.BLACK);

        // Line from (70,70) to (100,70)
        Line line = new Line(0, 395, 395, 395);
        pane.getChildren().add(line);


    }
}
