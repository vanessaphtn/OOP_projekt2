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

        Text TMküsimus = new Text("Küsimus");
        TMküsimus.setFont(new Font(25));

        Button tärn = new Button("*");
        Button kriips = new Button("-");

        HBox nupud = new HBox(tärn,kriips);
        nupud.setAlignment(Pos.CENTER);

        TextField sisestus = new TextField();
        Text kontrolliTekst = new Text(20,10,"Kontrolli");
        kontrolliTekst.setFont(new Font(11));
        Circle nupp = new Circle(20,Color.GREEN);
        StackPane stackPane = new StackPane(nupp,kontrolliTekst);

        HBox tekstiväli = new HBox(sisestus,stackPane);
        tekstiväli.setAlignment(Pos.CENTER);

        VBox keskmineOsa = new VBox(TMküsimus,tekstiväli,nupud);
        keskmineOsa.setAlignment(Pos.CENTER);

        Button TMtagasi = new Button("Tagasi");

        BorderPane tähtMorseksJuur = new BorderPane(keskmineOsa);
        tähtMorseksJuur.setBottom(TMtagasi);

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

        TMtagasi.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tähtMorseksLava.hide();
                primaryStage.show();
            }
        });



        // MORSE -> TÄHEKS
        Text MTküsimus = new Text("Küsimus");
        MTküsimus.setFont(new Font(25));

        TextField MTsisestus = new TextField();
        Text MTkontrolliTekst = new Text(20,10,"Kontrolli");
        MTkontrolliTekst.setFont(new Font(11));
        Circle MTnupp = new Circle(20,Color.GREEN);
        StackPane MTstackPane = new StackPane(MTnupp,MTkontrolliTekst);

        HBox MTtekstiväli = new HBox(MTsisestus,MTstackPane);
        MTtekstiväli.setAlignment(Pos.CENTER);

        VBox MTkeskmineOsa = new VBox(MTküsimus, MTtekstiväli);
        MTkeskmineOsa.setAlignment(Pos.CENTER);

        Button MTtagasi = new Button("Tagasi");

        BorderPane morseTäheksjuur = new BorderPane(MTkeskmineOsa);
        morseTäheksjuur.setBottom(MTtagasi);

        Scene morseTäheksStseen = new Scene(morseTäheksjuur);

        Stage morseTäheksLava = new Stage();
        morseTäheksLava.setScene(morseTäheksStseen);


        morseTäheks.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                morseTäheksLava.show();
                primaryStage.hide();
            }
        });

        MTtagasi.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                morseTäheksLava.hide();
                primaryStage.show();
            }
        });



        // SÕNA -> MORSEKS

        Text SMküsimus = new Text("Küsimus");
        SMküsimus.setFont(new Font(25));

        Button SMtärn = new Button("*");
        Button SMkriips = new Button("-");
        Button kaldkriips = new Button("/");

        HBox SMnupud = new HBox(SMtärn,SMkriips);
        SMnupud.getChildren().add(kaldkriips);
        SMnupud.setAlignment(Pos.CENTER);

        TextField SMsisestus = new TextField();
        Text SMkontrolliTekst = new Text(20,10,"Kontrolli");
        SMkontrolliTekst.setFont(new Font(11));
        Circle SMnupp = new Circle(20,Color.GREEN);
        StackPane SMstackPane = new StackPane(SMnupp,SMkontrolliTekst);

        HBox SMtekstiväli = new HBox(SMsisestus,SMstackPane);
        SMtekstiväli.setAlignment(Pos.CENTER);

        VBox SMkeskmineOsa = new VBox(SMküsimus, SMtekstiväli,SMnupud);
        SMkeskmineOsa.setAlignment(Pos.CENTER);

        Button SMtagasi = new Button("Tagasi");

        BorderPane sõnaMorseksjuur = new BorderPane(SMkeskmineOsa);
        sõnaMorseksjuur.setBottom(SMtagasi);

        Scene sõnaMorseksStseen = new Scene(sõnaMorseksjuur);

        Stage sõnaMorseksLava = new Stage();
        sõnaMorseksLava.setScene(sõnaMorseksStseen);

        sõnaMorseks.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sõnaMorseksLava.show();
                primaryStage.hide();
            }
        });

        SMtagasi.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sõnaMorseksLava.hide();
                primaryStage.show();
            }
        });

        // MORSE -> SÕNAKS

        Text MSküsimus = new Text("Küsimus");
        MSküsimus.setFont(new Font(25));

        TextField MSsisestus = new TextField();
        Text MSkontrolliTekst = new Text(20,10,"Kontrolli");
        MSkontrolliTekst.setFont(new Font(11));
        Circle MSnupp = new Circle(20,Color.GREEN);
        StackPane MSstackPane = new StackPane(MSnupp,MSkontrolliTekst);

        HBox MStekstiväli = new HBox(MSsisestus,MSstackPane);
        MStekstiväli.setAlignment(Pos.CENTER);

        VBox MSkeskmineOsa = new VBox(MSküsimus, MStekstiväli);
        MSkeskmineOsa.setAlignment(Pos.CENTER);

        Button MStagasi = new Button("Tagasi");

        BorderPane morseSõnaksjuur = new BorderPane(MSkeskmineOsa);
        morseSõnaksjuur.setBottom(MStagasi);

        Scene morseSõnaksStseen = new Scene(morseSõnaksjuur);

        Stage morseSõnaksLava = new Stage();
        morseSõnaksLava.setScene(morseSõnaksStseen);


        morseSõnaks.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                morseSõnaksLava.show();
                primaryStage.hide();
            }
        });

        MStagasi.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                morseSõnaksLava.hide();
                primaryStage.show();
            }
        });





        primaryStage.setTitle("Morse koodi õppimine");
        primaryStage.setScene(main);
        primaryStage.show();
    }
}
