package com.example.oopiprojekt;

import com.example.oopiprojekt.sonanetist;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class typinx extends Application {
    private Label etteantudsona;
    private TextField kasutajainput;
    private String praegunesona;
    private int oigeidsonu = 0;
    private int vigasedsonad = 0;
    private long algusaeg;
    private double wpm = 0;
    private int kokkusonu = 0;
    private long viimaneuuendus = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Typinx");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);

        Button startButton = new Button("Alusta mängu");
        Button exitButton = new Button("Välju");

        startButton.setOnAction(e -> startTypingGame(root));
        exitButton.setOnAction(e -> primaryStage.close());

        VBox menu = new VBox(10, startButton, exitButton);
        menu.setAlignment(Pos.CENTER);

        root.setCenter(menu);

        primaryStage.show();
    }

    private void startTypingGame(BorderPane root) {
        etteantudsona = new Label();
        etteantudsona.setStyle("-fx-font-size: 24;");
        kasutajainput = new TextField();

        kasutajainput.setAlignment(Pos.CENTER);
        kasutajainput.setStyle("-fx-font-size: 20;");

        kasutajainput.setOnAction(e -> kontrolli());

        StackPane.setAlignment(etteantudsona, Pos.CENTER);
        StackPane.setAlignment(kasutajainput, Pos.BOTTOM_CENTER);

        Button exitButton = new Button("Välju");
        exitButton.setOnAction(e -> System.exit(0));

        BorderPane topPane = new BorderPane();
        topPane.setLeft(createStatsLabel());
        topPane.setRight(exitButton);

        root.setTop(topPane);

        StackPane centerPane = new StackPane();
        centerPane.getChildren().addAll(etteantudsona, kasutajainput);
        root.setCenter(centerPane);

        startGame();
    }

    private Label createStatsLabel() {
        Label statsLabel = new Label();
        statsLabel.setStyle("-fx-font-size: 14;");
        updateStatsLabel(statsLabel);
        return statsLabel;
    }

    private void updateStatsLabel(Label statsLabel) {
        double accuracy = oigeidsonu / (double) (oigeidsonu + vigasedsonad) * 100;
        String stats = String.format("Täpsus: %.2f%% | WPM: %.2f", accuracy, wpm);
        statsLabel.setText(stats);
    }

    private void startGame() {
        praegunesona = sonanetist.valisuvasona();
        displayWord(praegunesona);
        algusaeg = System.currentTimeMillis();
        viimaneuuendus = algusaeg;
    }

    private void kontrolli() {
        long currentTime = System.currentTimeMillis();
        double totalTime = (currentTime - algusaeg) / 60000.0;

        String input = kasutajainput.getText().trim();
        if (input.equals(praegunesona)) {
            oigeidsonu++;
            kokkusonu++;
            System.out.println("Tubli! Õige vastus: " + praegunesona);
        } else {
            vigasedsonad++;
            System.out.println("Vale vastus, proovi uuesti: " + praegunesona);
        }
        kasutajainput.clear();
        praegunesona = sonanetist.valisuvasona();
        displayWord(praegunesona);

        if (currentTime - viimaneuuendus >= 5000) {
            wpm = kokkusonu / (totalTime / 5);
            updateStatsLabel((Label) ((BorderPane) kasutajainput.getParent().getParent()).getTop());
            kokkusonu = 0;
            viimaneuuendus = currentTime;
        }
    }

    private void displayWord(String word) {
        etteantudsona.setText(word);
        etteantudsona.setTextFill(Color.BLACK);
    }
}
