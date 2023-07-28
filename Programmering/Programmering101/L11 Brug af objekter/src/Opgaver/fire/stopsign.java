package Opgaver.fire;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class stopsign extends Application {

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
        // Rectangle
        Rectangle rektangel = new Rectangle(0, 0, 400, 400);
        pane.getChildren().add(rektangel);
        rektangel.setFill(Color.CORAL);

        // Circle
        Circle circle = new Circle(200, 200, 100);
        pane.getChildren().add(circle);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.WHITE);

        // Circle
        Circle hvid = new Circle(200,  200, 90);
        pane.getChildren().add(hvid);
        hvid.setFill(Color.RED);
        hvid.setStroke(Color.BLACK);

        // Rectangle
        Rectangle firkant = new Rectangle(135, 185, 130, 30);
        pane.getChildren().add(firkant);
        firkant.setFill(Color.WHITE);
    }
}
