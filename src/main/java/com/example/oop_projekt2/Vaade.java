package com.example.oop_projekt2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class Vaade extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //Main menüü


        Button tähtMorseks = new Button();
        tähtMorseks.setBackground(Background.fill(Color.PEACHPUFF));
        Button morseTäheks = new Button();
        morseTäheks.setBackground(Background.fill(Color.SKYBLUE));
        Button sõnaMorseks = new Button();
        sõnaMorseks.setBackground(Background.fill(Color.BLUE));
        Button morseSõnaks = new Button();
        morseSõnaks.setBackground(Background.fill(Color.HOTPINK));

        HBox ülemine = new HBox(tähtMorseks, morseTäheks);
        HBox alumine = new HBox(sõnaMorseks, morseSõnaks);
        ülemine.setAlignment(Pos.CENTER);
        alumine.setAlignment(Pos.CENTER);

        VBox ruudud = new VBox(ülemine, alumine);
        BorderPane juur = new BorderPane(ruudud);
        ruudud.setAlignment(Pos.CENTER);

        Scene main = new Scene(juur, 500, 500);


        //Täht morseks

        Button tärn = new Button("*");
        Button kriips = new Button("-");

        HBox nupud = new HBox(tärn,kriips);
        nupud.setAlignment(Pos.CENTER);

        TextField sisestus = new TextField();
        Text kontrolliTekst = new Text(20,10,"Kontrolli");
        Circle nupp = new Circle(20,Color.GREEN);
        Button kontroll = new Button("",nupp);
        StackPane stackPane = new StackPane(kontroll,kontrolliTekst);

        HBox tekstiväli = new HBox(sisestus,stackPane);
        tekstiväli.setAlignment(Pos.CENTER);

        VBox keskmineOsa = new VBox(tekstiväli,nupud);
        keskmineOsa.setAlignment(Pos.CENTER);

        BorderPane tähtMorseksJuur = new BorderPane(keskmineOsa);

        Scene tähtMorseksStseen = new Scene(tähtMorseksJuur);

        Stage tähtMorseksLava = new Stage();
        tähtMorseksLava.setScene(tähtMorseksStseen);

        tähtMorseks.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tähtMorseksLava.show();
                primaryStage.hide();
            }
        });







        primaryStage.setTitle("Morse koodi õppimine");
        primaryStage.setScene(main);
        primaryStage.show();
    }
}
