package WorkshopLoops.målebånd;

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


				int y1 = 172; // start point: (x,y1)
				int y2 = 178; // end point: (x,y2)

			for (int i = 0; i < 11; i++) {
				int x = 10 + i * 16;
				if (i % 5 == 0) {
					y1 = 170;
					y2 = 180;

				} else {
					y1 = 172;
					y2 = 178;

					}

				gc.strokeLine(x, y1, x, y2);

				int x1 = 0; // start point: (x1,y3)
				int x2 = 180; // end point: (x2,y4)
				int y3 = 175;
				int y4 = 175;
				gc.strokeLine(x1, y3, x2, y4);

				// draw an arrowhead at (20,50)
				int lenght = 5;
				int x3 = 180;
				int y = 175;
				gc.strokeLine(x3, y, x3 - lenght, y + 4);
				gc.strokeLine(x3, y, x3 - lenght, y - 4);
			}
		String s = "0";
			gc.fillText(s, 5, 195);

		String d = "5";
		gc.fillText(d, 85, 195);

		String f = "10";
		gc.fillText(f, 165, 195);
		}
	}
