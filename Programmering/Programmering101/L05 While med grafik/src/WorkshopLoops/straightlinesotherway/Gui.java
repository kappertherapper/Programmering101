package WorkshopLoops.straightlinesotherway;

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

		int x1 = 35; // start point: (x1,y1)
		int y1 = 35;
		int x2 = 180; // slut point: (x2, y2)
		int y2 = 180;

		while (y1 <= 180) {
			gc.strokeLine(x1, y1, x1, y2);
			y1 = y1 + 35;

			}



		}
	}
