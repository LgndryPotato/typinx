package com.example.typinx2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Typinx extends Application {
    private Label etteantudsona;
    private TextField kasutajainput;
    private String praegunesona;
    private long algusaeg;
    private long viimaneuuendus = 0;
    private ImageView background;
    private int[] jarjekord = {0, 7, 5, 4};
    private int jarjekorraIndeks = 3;
    private String[] backgrounds = {"/mangija_loob.png", "/mangija_punkt.png", "/mangija_vork.png", "/mangija_wiff.png", "/pall_mangija_pool.png", "/robot_loob.png", "/roboti_punkt.png", "/pall_roboti_pool.png", "/pinxipall.png"};
    private boolean onMangijaKord = false;
    private Random random = new Random();
    private int mangijaPunktid = 0;
    private int robotiPunktid = 0;
    private int sonuKokku = 0;
    private long startAeg = 0;
    private int oigeidsonu = 0;
    private int vigasedsonad = 0;
    private Label statsLabel;
    double wpm = 0;
    double accuracy = 0;

    public static void main(String[] args) {
        launch(args);
    }

    private void muudaBackgroundi(String path) {
        InputStream imageUrl = getClass().getResourceAsStream(path);
        if (imageUrl == null) {
            System.out.println("Cannot find image: " + path);
            return;
        }
        Image image = new Image(imageUrl);
        if (image.isError()) {
            System.out.println("Error loading image: " + path);
        }
        background.setImage(image);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Typinx");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);

        statsLabel = new Label();
        statsLabel.setStyle("-fx-font-size: 14;");
        root.setTop(statsLabel);

        background = new ImageView();
        background.setPreserveRatio(true);

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
        centerPane.getChildren().addAll(background, etteantudsona, kasutajainput);
        root.setCenter(centerPane);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (!onMangijaKord) {
                muudaBackgroundi(backgrounds[jarjekord[jarjekorraIndeks]]);
                sonaEkraanile("");
                jarjekorraIndeks = (jarjekorraIndeks + 1) % jarjekord.length;
                if (jarjekord[jarjekorraIndeks] == 0) {
                    onMangijaKord = true;
                    praegunesona = Sonanetist.valisuvasona();
                    sonaEkraanile(praegunesona);
                    startAeg = System.currentTimeMillis();
                }
            } else {
                muudaBackgroundi(backgrounds[8]);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        primaryStage.show();

        uuendaStatse();

        startGame();
    }

    private Label statsLabel() {
        statsLabel.setStyle("-fx-font-size: 14;");
        uuendaStatse();
        return statsLabel;
    }

    private void uuendaStatse() {
        long currentTime = System.currentTimeMillis();
        double totalMinutes = (currentTime - startAeg) / 60000.0;
        wpm = sonuKokku / totalMinutes;
        accuracy = oigeidsonu / (double) (oigeidsonu + vigasedsonad) * 100;
        String stats = String.format("WPM: %.2f | Accuracy: %.2f%% | Player Points: %d | Robot Points: %d", wpm, accuracy, mangijaPunktid, robotiPunktid);


        try {
            List<String> lines = Files.readAllLines(Paths.get("tulemused.txt"));
            if (lines.size() >= 4) {
                String lastLine = lines.get(lines.size() - 1);
                String secondLastLine = lines.get(lines.size() - 2);
                String thirdLastLine = lines.get(lines.size() - 3);
                String fourthLastLine = lines.get(lines.size() - 4);
                stats += "\nEelmise mängu tulemused:\n" + fourthLastLine + "\n" + thirdLastLine + "\n" + secondLastLine + "\n" + lastLine;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        statsLabel.setText(stats);
    }


    private void startGame() {
        algusaeg = System.currentTimeMillis();
        viimaneuuendus = algusaeg;
    }

    private void kontrolli() {
        long hetkeAeg = System.currentTimeMillis();

        String input = kasutajainput.getText().trim();
        if (!input.isEmpty()) {
            sonuKokku++;
        }
        if (input.equals(praegunesona) && onMangijaKord) {
            oigeidsonu++;
            onMangijaKord = false;
            startGame();
            uuendaStatse();
            startAeg = System.currentTimeMillis();
        } else if (!input.isEmpty() && onMangijaKord) {
            vigasedsonad++;
            int wrongBackgroundIndex = random.nextBoolean() ? 6 : 2;
            muudaBackgroundi(backgrounds[wrongBackgroundIndex]);
            robotiPunktid++;
        }

        if (!onMangijaKord && random.nextInt(10) < 2) {
            muudaBackgroundi(backgrounds[1]);
            mangijaPunktid++;
            onMangijaKord = false;
            startGame();
            uuendaStatse();
        }
        kasutajainput.clear();

        if (hetkeAeg - viimaneuuendus >= 5000) {
            uuendaStatse();
            viimaneuuendus = hetkeAeg;
        }
        if (onMangijaKord) {
            muudaBackgroundi(backgrounds[8]);
        }
    }

    private void sonaEkraanile(String sona) {
        etteantudsona.setText(sona);
        etteantudsona.setTextFill(Color.BLACK);
    }


    @Override
    public void stop() {
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("tulemused.txt", true), "UTF-8"))) {
            writer.println("Mängija punkte: " + mangijaPunktid);
            writer.println("Roboti punkte: " + robotiPunktid);
            writer.println("WPM: " + wpm);
            writer.println("Tapsus: " + accuracy);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
