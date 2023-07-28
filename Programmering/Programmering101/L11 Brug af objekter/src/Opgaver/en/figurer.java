package en;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class figurer extends Application {

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
        // Circle with centrum in 70, 70 and a radius of 30
        Circle circle = new Circle(70, 70, 30);
        pane.getChildren().add(circle);
        circle.setFill(Color.YELLOW);
        circle.setStroke(Color.YELLOW);

        // Rectangle with upper left corner at (100,40), width 75, height 25
        Rectangle rektangel = new Rectangle(150, 80, 75, 25);
        pane.getChildren().add(rektangel);
        rektangel.setFill(Color.DARKOLIVEGREEN);

        // Line from (70,70) to (100,70)
        Line line = new Line(30, 30, 150, 30);
        pane.getChildren().add(line);
        line.setStroke(Color.MEDIUMPURPLE);
    }
}
