package ex3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class smiley extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        this.initContent(pane);
        Scene scene = new Scene(pane, 200, 200);

        primaryStage.setTitle("ShowCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initContent(Pane pane) {
        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(50);
        circle.setStrokeWidth(5);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.GOLD);
        pane.getChildren().add(circle);

        Circle circle1 = new Circle();
        circle1.setCenterX(90);
        circle1.setCenterY(90);
        circle1.setRadius(10);
        circle1.setStrokeWidth(1);
        circle1.setStroke(Color.BLACK);
        circle1.setFill(Color.WHITE);
        pane.getChildren().add(circle1);
    }
}
