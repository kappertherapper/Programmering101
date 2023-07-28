package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import Model.YatzyDice;

import java.util.ArrayList;
import java.util.List;

public class YatzyGui extends Application {
    // txfValues shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // cbxHolds shows the hold status of the 5 dice.
    private final CheckBox[] cbxHolds = new CheckBox[5];

    // -------------------------------------------------------------------------
    // txfResults shows the obtained results.
    // For results not set yet, the possible result of
    // the actual face values of the 5 dice are shown.
    private final ArrayList<TextField> txfResults = new ArrayList<>(15);
    // Shows points in sums, bonus and total.
    private final TextField txfSumSame = new TextField();
    private final TextField txfBonus = new TextField();
    private final TextField txfSumOther = new TextField();
    private final TextField txfTotal = new TextField();
    private final Label lblThrowCount = new Label();
    private final Button btnThrow = new Button(" Throw ");
    private final boolean[] hold = new boolean[5];
    private YatzyDice dice = new YatzyDice();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(100));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");


        //Textfields for dice values
        for (int i = 0; i < 5; i++) {
            TextField dices = new TextField();
            dice.throwDice(hold);
            dices.setText(String.valueOf(dice.getValues()[i]));
            dices.setPrefWidth(100);
            dices.setPrefHeight(100);
            dices.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
            txfValues[i] = dices;
            dicePane.add(txfValues[i], 0 + i, 0);
            dices.setEditable(false);

        }

        // Checkboxes for hold
        for (int i = 0; i < 5; i++) {
            CheckBox hold = new CheckBox();
            hold.setText("Hold");
            dicePane.add(hold, i, 1);
            cbxHolds[i] = hold;
        }


        // Throw button
        dicePane.add(btnThrow, 4, 2);
        btnThrow.setOnAction(actionEvent -> throwDiceAction());

        // Throw Count Button
        dicePane.add(lblThrowCount, 2, 2);
        lblThrowCount.setFont(Font.font("Verdana", 10));
        lblThrowCount.setText("Throw count = 0");


        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 5);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int width = 50; // width of the text fields

        // add labels for results
        // add txfResults,
        // TODO
        // add labels and text fields for sums, bonus and total.
        // TODO


        ArrayList<String> lblNames = new ArrayList<>(15);
        lblNames.addAll(List.of("1's", "2's", "3's", "4's", "5's", "6's", "", "One Pair", "Two Pairs", "Three same", "Four same", "Full House", "Small Str", "Large str", "Chance", "Yatzy"));
        for (int i = 0; i < lblNames.size(); i++) {
            Label lbl = new Label(lblNames.get(i));
            scorePane.add(lbl, 0, 0 + i);
        }
        for (int i = 0; i < 6; i++) {
            TextField txf = new TextField();
            txfResults.add(txf);
            scorePane.add(txf, 1, 0 + i);
            txf.setPrefWidth(50);
            txf.setEditable(false);
            txfResults.get(i).setOnMouseClicked(event -> this.mouseClicked(event));
        }
        for (int i = 6; i < 15; i++) {
            TextField txf = new TextField();
            txfResults.add(txf);
            scorePane.add(txf, 1, 1 + i);
            txf.setPrefWidth(50);
            txf.setEditable(false);
            txfResults.get(i).setOnMouseClicked(event -> this.mouseClicked(event));
        }

        // add labels and text fields for sums, bonus and total.
        ArrayList<String> lblNames2 = new ArrayList<>(16);
        lblNames2.addAll(List.of("Sum", "Bonus", "Sum", "TOTAL"));
        for (int i = 0; i < 2; i++) {
            Label lbl = new Label(lblNames2.get(i));
            scorePane.add(lbl, 2, 5 + i);
        }

        for (int i = 2; i < 4; i++) {
            Label lbl = new Label(lblNames2.get(i));
            scorePane.add(lbl, 2, 13 + i);
        }

        scorePane.add(txfSumSame, 3, 5);
        txfSumSame.setEditable(false);
        scorePane.add(txfBonus, 3, 6);
        txfBonus.setEditable(false);
        scorePane.add(txfSumOther, 3, 15);
        txfSumOther.setEditable(false);
        scorePane.add(txfTotal, 3,16 );
        txfTotal.setEditable(false);

        resetDice();




        }

    // -------------------------------------------------------------------------

    public void throwDiceAction() {
        for (int i = 0; i < 5; i++) {
            if (cbxHolds[i].isSelected()) {
                hold[i] = true;
            }
        }


        dice.throwDice(hold);
        dice.increaseThrowCount();
        lblThrowCount.setText("Throw count = " + dice.getThrowCount());

        if (dice.getThrowCount() == 3) {
            btnThrow.setDisable(true);

            for (int i = 0; i < 5; i++) {
                cbxHolds[i].setSelected(false);
                hold[i] = false;
            }

        }

        for (int i = 0; i < 5; i++) {
            txfValues[i].setText(String.valueOf(dice.getValues()[i]));

        }

        for (int i = 0; i < 15; i++) {
            if (!txfResults.get(i).isDisabled()) {
                txfResults.get(i).setText(String.valueOf(dice.getResults()[i]));
            }


        }
    }


    // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.

    private void mouseClicked(MouseEvent event) {
        TextField txf = (TextField) event.getSource();
        int sumSame = 0;
        int sumOther = 0;
        int Total = 0;


        if (dice.getThrowCount() > 0) {
            txf.setDisable(true);
            for (int i = 0; i < 6; i++) {
                if (txfResults.get(i).isDisabled()) {
                    sumSame += Integer.valueOf(txfResults.get(i).getText());
                }
            }

            for (int j = 6; j < 15; j++) {
                if (txfResults.get(j).isDisabled()) {
                    sumOther += Integer.valueOf(txfResults.get(j).getText());
                }
            }

            if (sumSame > 63) {
                sumSame += 50;
                txfBonus.setText("50");
            }

            Total = sumSame + sumOther;
            txfSumSame.setText(String.valueOf(sumSame));
            txfSumOther.setText(String.valueOf(sumOther));
            txfTotal.setText(String.valueOf(Total));
            dice.resetThrowCount();
            btnThrow.setDisable(false);
            lblThrowCount.setText("Throw count = 0");

            for (int i = 0; i < 5; i++) {
                cbxHolds[i].setSelected(false);
                hold[i] = false;

            }
            resetDice();
        }
    }

    public void resetDice() {
        for (int i = 0; i < 5; i++) {
            txfValues[i].setText("");
        }

    }
}






