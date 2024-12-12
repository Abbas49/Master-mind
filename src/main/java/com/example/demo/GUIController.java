package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GUIController {

    @FXML
    private Button btnRed, btnYellow, btnBlue, btnPurple, btnGreen, btnOrange;

    @FXML
    private Circle ball1, ball2, ball3, ball4;

    private Circle[] balls;

    private int currentBallIndex = 0;

    @FXML
    public void initialize() {
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
