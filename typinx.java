package com.example.oopiprojekt;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
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

        etteantudsona = new Label();
        etteantudsona.setStyle("-fx-font-size: 24;");
        kasutajainput = new TextField();

        kasutajainput.setAlignment(Pos.CENTER);
        kasutajainput.setStyle("-fx-font-size: 20;");

        kasutajainput.setOnAction(e -> kontrolli());

        StackPane.setAlignment(etteantudsona, Pos.CENTER);
        StackPane.setAlignment(kasutajainput, Pos.BOTTOM_CENTER);

        root.setTop(statsLabel());

        StackPane centerPane = new StackPane();
        centerPane.getChildren().addAll(etteantudsona, kasutajainput);
        root.setCenter(centerPane);

        primaryStage.show();

        startGame();
    }

    private Label statsLabel() {
        Label statsLabel = new Label();
        statsLabel.setStyle("-fx-font-size: 14;");
        uuendaStatse(statsLabel);
        return statsLabel;
    }

    private void uuendaStatse(Label statsLabel) {
        double accuracy = oigeidsonu / (double) (oigeidsonu + vigasedsonad) * 100;
        String stats = String.format("Täpsus: %.2f%% | WPM: %.2f", accuracy, wpm);
        statsLabel.setText(stats);
    }

    private void startGame() {
        praegunesona = sonanetist.valisuvasona();
        sonaEkraanile(praegunesona);
        algusaeg = System.currentTimeMillis();
        viimaneuuendus = algusaeg;
    }

    private void kontrolli() {
        long hetkeAeg = System.currentTimeMillis();
        double kokkuAeg = (hetkeAeg - algusaeg) / 60000.0;

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
        sonaEkraanile(praegunesona);

        if (hetkeAeg - viimaneuuendus >= 5000) {
            wpm = kokkusonu / (kokkuAeg / 5);
            uuendaStatse((Label) ((BorderPane) kasutajainput.getParent().getParent()).getTop());
            kokkusonu = 0;
            viimaneuuendus = hetkeAeg;
        }
    }

    private void sonaEkraanile(String sona) {
        etteantudsona.setText(sona);
        etteantudsona.setTextFill(Color.BLACK);
    }
}
