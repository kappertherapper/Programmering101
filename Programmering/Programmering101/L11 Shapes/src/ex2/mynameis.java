package ex2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class mynameis extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        this.initContent(pane);
        Scene scene = new Scene(pane);

        primaryStage.setTitle("ShowText");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initContent(Pane pane) {
        pane.setPadding(new Insets(200, 200, 200, 200));

        Rectangle r1 = new Rectangle(0, 0, 2000, 2000);
        pane.getChildren().add(r1);
        r1.setStroke(Color.BLACK);
        r1.setFill(Color.YELLOW);

        Text text1 = new Text(100, 100, "Kasper");
        text1.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 100));
        pane.getChildren().add(text1);
        text1.setFill(Color.GREEN);


    }
}
