package com.example.oop_projekt2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
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


        Text pealkiri = new Text(20, 40, "Menüü");
        pealkiri.setFont(new Font(50));
        Text juhend = new Text(5, 20, "Klõpsa ühel valikuruudul");
        juhend.setFill(Color.GRAY);

        Rectangle tähtMorseks = new Rectangle(40, 40, Color.PEACHPUFF);
        tähtMorseks.widthProperty().bind(primaryStage.widthProperty().divide(5));
        tähtMorseks.heightProperty().bind(tähtMorseks.widthProperty());
        Rectangle morseTäheks = new Rectangle(40, 40, Color.SKYBLUE);
        morseTäheks.widthProperty().bind(primaryStage.widthProperty().divide(5));
        morseTäheks.heightProperty().bind(morseTäheks.widthProperty());
        Rectangle sõnaMorseks = new Rectangle(40, 40, Color.BLUE);
        sõnaMorseks.widthProperty().bind(primaryStage.widthProperty().divide(5));
        sõnaMorseks.heightProperty().bind(sõnaMorseks.widthProperty());
        Rectangle morseSõnaks = new Rectangle(40, 40, Color.HOTPINK);
        morseSõnaks.widthProperty().bind(primaryStage.widthProperty().divide(5));
        morseSõnaks.heightProperty().bind(morseSõnaks.widthProperty());


        HBox ülemine = new HBox(tähtMorseks, morseTäheks);
        HBox alumine = new HBox(sõnaMorseks, morseSõnaks);
        ülemine.setAlignment(Pos.CENTER);
        alumine.setAlignment(Pos.CENTER);

        Button juhis = new Button("?");


        VBox vertikaal = new VBox(pealkiri, juhend, ülemine, alumine);
        vertikaal.setAlignment(Pos.CENTER);
        BorderPane juur = new BorderPane(vertikaal);
        juur.setRight(juhis);

        Scene main = new Scene(juur, 500, 500);

        //juhised
        Text tekst = new Text(" Selles programmis saab 4 erinevat ülesannet lahendada: \n" +
                "1) tähti morse koodi teisendada \n" +
                "2) sõnasid morse koodi teisendada \n" +
                "3) tähti morse koodist eesti keelde teisendada \n" +
                "4) sõnasid morse koodist eesti keelde teisendada");

        BorderPane juurMJ = new BorderPane(tekst);
        Scene stseenMJ = new Scene(juurMJ, 400,150);
        Stage lavaMJ = new Stage();
        lavaMJ.setScene(stseenMJ);

        juhis.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                lavaMJ.show();
            }
        });
        juhis.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                lavaMJ.hide();
            }
        });


        //Täht morseks


        Button tärn = new Button("*");
        Button kriips = new Button("-");

        HBox nupud = new HBox(tärn, kriips);
        nupud.setAlignment(Pos.CENTER);

        TextField sisestus = new TextField();
        Text kontrolliTekst = new Text(20, 10, "Kontrolli");
        Circle nupp = new Circle(20, Color.GREEN);
        StackPane stackPane = new StackPane(nupp, kontrolliTekst);

        HBox tekstiväli = new HBox(sisestus, stackPane);
        tekstiväli.setAlignment(Pos.CENTER);

        VBox keskmineOsa = new VBox(tekstiväli, nupud);
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
