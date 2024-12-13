package com.example.demo;

import com.example.demo.lib.Guess;
import com.example.demo.lib.GuessResult;
import com.example.demo.lib.MasterMind;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GUIController {

    public Label resultLabel;
    @FXML
    private Button btnRed, btnYellow, btnBlue, btnPurple, btnGreen, btnOrange;

    @FXML
    private Circle ball1, ball2, ball3, ball4;

    private Circle[] balls;

    private int currentBallIndex = 0;
    private MasterMind game;

    @FXML
    public void initialize() {
        game = new MasterMind();

        balls = new Circle[] { ball1, ball2, ball3, ball4 };
        for (Circle ball : balls) {
            ball.setFill(Color.WHITE);
        }
        btnRed.setOnAction(event -> colorBall(Color.RED));
        btnYellow.setOnAction(event -> colorBall(Color.YELLOW));
        btnBlue.setOnAction(event -> colorBall(Color.BLUE));
        btnPurple.setOnAction(event -> colorBall(Color.PURPLE));
        btnGreen.setOnAction(event -> colorBall(Color.GREEN));
        btnOrange.setOnAction(event -> colorBall(Color.ORANGE));
    }
    @FXML
    public void submit(){
        GuessResult result = game.validateGuess(new Guess(getColorsInString()));
        resultLabel.setText("Black: " + result.blackBalls + "   White: " +result.whiteBalls);
    }

    private String getColorsInString(){
        StringBuilder result = new StringBuilder();
        for(Circle ball : balls){
            char ballSymbol = colorToChar(ball.getFill().toString());
            result.append(ballSymbol);
        }
        return result.toString();
    }
    private char colorToChar(String x){
        switch(x){
            case "0xff0000ff":return 'r';
            case "0xffff00ff":return 'y';
            case "0x0000ffff":return 'b';
            case "0x800080ff":return 'p';
            case "0x008000ff":return 'g';
            case "0xffa500ff":return 'o';
            case "0xffffffff":return 'w';
            default:
                throw new IllegalArgumentException("invalid string"+ x);
        }
    }

    private void colorBall(Color color) {
        if (currentBallIndex < balls.length) {
            balls[currentBallIndex].setFill(color);
            currentBallIndex++;
        } else {
            System.out.println("All balls are filled!");
        }
    }

    @FXML
    public void resetGame() {
        for (Circle ball : balls) {
            ball.setFill(Color.WHITE);
        }
        currentBallIndex = 0;
    }
}
