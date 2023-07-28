package WorkshopLoops.soundBarrier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		GridPane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}

	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(200, 200);
		pane.add(canvas, 0, 0);
		this.drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(GraphicsContext gc) {
		double x1 = 180;
		double x = 0.75;
		double y1 = 100 - x1 / 5;
		double y2 = 100 + x1 / 2;

		while (x1 > 5 ) {
			gc.strokeLine(x1, y1, x1, y2);

			x1 = x1 * x;
			y1 = 100 - x1 / 5;
			y2 = 100 + x1 / 2;


		}
	}
}
