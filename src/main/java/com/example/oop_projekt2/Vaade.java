package com.example.oop_projekt2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Vaade extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        List<String[]> s = new ArrayList<>(Arrays.asList(new String[]{"KASS", "-*-/*-/***/***"}, new String[]{"KOER", "-*-/---/*/*-*"}, new String[]{"EMA", "*/--/*-"}, new String[]{"ISA", "**/***/*-"}));
        Tähed tähed = new Tähed();
        Sõnad sõnad = new Sõnad(s, tähed);


        //MAIN MENÜÜ


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
        ülemine.setSpacing(5);
        alumine.setSpacing(5);

        Button juhis = new Button("?");


        VBox vertikaal = new VBox(pealkiri, juhend, ülemine, alumine);
        vertikaal.setAlignment(Pos.CENTER);
        vertikaal.setSpacing(5);
        BorderPane juur = new BorderPane(vertikaal);
        juur.setRight(juhis);

        Scene main = new Scene(juur, 500, 500);

        //juhised
        Text tekst = new Text(" Selles programmis saab 4 erinevat ülesannet lahendada: \n" +
                "1) tähti morse koodi teisendada \n selleks klõpsa ruudul kirjaga TÄHT\n" +
                "2) sõnasid morse koodi teisendada \n selleks klõpsa ruudul kirjaga SÕNA\n" +
                "3) tähti morse koodist eesti keelde teisendada \n selleks klõpsa ruudul kirjaga" +
                " -/*-*-/****/- \n" +
                "4) sõnasid morse koodist eesti keelde teisendada\n selleks klõpsa ruudul kirjaga" +
                " ***/**--*/-*/*-");

        BorderPane juurMJ = new BorderPane(tekst);
        Scene stseenMJ = new Scene(juurMJ, 400, 200);
        Stage lavaMJ = new Stage();
        lavaMJ.setScene(stseenMJ);

        juhis.setOnMouseEntered(event -> lavaMJ.show());
        juhis.setOnMouseExited(event -> lavaMJ.hide());


        //TÄHT -> MORSE


        //küsimus
        Text TMlause = new Text("Kirjutage morse koodis: ");
        Text TMsuvalineTäht = new Text(tähed.suvaline()[0]);
        TMsuvalineTäht.setFont(new Font(25));
        TMlause.setFont(new Font(25));
        HBox TMküsimus = new HBox(TMlause, TMsuvalineTäht);
        TMküsimus.setAlignment(Pos.CENTER);

        //nupud, mida vajutada
        Button tärn = new Button("*");
        Button kriips = new Button("-");

        HBox nupud = new HBox(tärn, kriips);
        nupud.setAlignment(Pos.CENTER);

        TextField sisestus = new TextField();
        Button TMnupp = new Button("Kontrolli");
        Text TMvastuseÕigsus = new Text("");

        HBox tekstiväli = new HBox(sisestus, TMnupp);
        tekstiväli.setAlignment(Pos.CENTER);
        tekstiväli.setSpacing(5);

        VBox keskmineOsa = new VBox(TMküsimus, tekstiväli, TMvastuseÕigsus, nupud);
        keskmineOsa.setAlignment(Pos.CENTER);

        Button TMtagasi = new Button("Tagasi");
        Button TMjuhis = new Button("?");

        BorderPane tähtMorseksJuur = new BorderPane(keskmineOsa);
        tähtMorseksJuur.setBackground(Background.fill(Color.rgb(250, 231, 215)));
        tähtMorseksJuur.setBottom(TMtagasi);
        tähtMorseksJuur.setRight(TMjuhis);

        Scene tähtMorseksStseen = new Scene(tähtMorseksJuur, 500, 400);

        Stage tähtMorseksLava = new Stage();
        tähtMorseksLava.setScene(tähtMorseksStseen);

        //aktiveerime nuppude töö
        tärn.setOnMouseClicked(event -> { //tärni lisamine
            String tärnike = tärn.getText();
            sisestus.appendText(tärnike);
        });

        kriips.setOnMouseClicked(event -> { //kriipsu lisamine
            String kriipsuke = kriips.getText();
            sisestus.appendText(kriipsuke);
        });

        TMnupp.setOnMouseClicked(event -> { // tegevused kui on 'kontrolli' nupp vajutatud
            String sisestatudVastus = sisestus.getText();
            try {
                for (Character sümbol : sisestatudVastus.toCharArray()) {
                    if ("*-".indexOf(sümbol) == -1) {
                        throw new ValeSisestusErind("Sisestada võib ainult * ja -");
                    }
                }
                if (tähed.kontrolli(sisestatudVastus, TMsuvalineTäht.getText(), 0, 1)) {
                    TMvastuseÕigsus.setText("Õige vastus!");
                } else TMvastuseÕigsus.setText("Vale vastus!");
                TMsuvalineTäht.setText(tähed.suvaline()[0]);
                sisestus.setText("");
            } catch (ValeSisestusErind e) {
                TMvastuseÕigsus.setText("Sisestada võib ainult * ja -");
                sisestus.setText("");
            }
        });

        tähtMorseks.setOnMouseClicked(event -> { //ülesandesse minemine
            tähtMorseksLava.show();
            primaryStage.hide();
        });

        TMtagasi.setOnMouseClicked(event -> { //tagasi menüüsse
            TMsuvalineTäht.setText(tähed.suvaline()[0]);
            TMvastuseÕigsus.setText("");
            tähtMorseksLava.hide();
            primaryStage.show();
        });

        //juhised
        Text TMtekst = new Text("Kirjuta teksitlahtrisse oma vastuseks * ja - kombinatsioon või \n" +
                "kasuta kirjutamiseks nuppe\n" +
                "Tulemuse teada saamiseks vajuta kontrolli nupul.");

        BorderPane TMjuhisJuur = new BorderPane(TMtekst);
        Scene TMjuhisStseen = new Scene(TMjuhisJuur, 400, 100);
        Stage TMjuhisLava = new Stage();
        TMjuhisLava.setScene(TMjuhisStseen);

        TMjuhis.setOnMouseEntered(event -> TMjuhisLava.show());
        TMjuhis.setOnMouseExited(event -> TMjuhisLava.hide());


        // MORSE -> TÄHEKS

        //küsimus
        Text MTlause = new Text("Kirjutage täht: ");
        Text MTsuvalineTäht = new Text(tähed.suvaline()[1]);
        MTsuvalineTäht.setFont(new Font(25));
        MTlause.setFont(new Font(25));
        HBox MTküsimus = new HBox(MTlause, MTsuvalineTäht);
        MTküsimus.setAlignment(Pos.CENTER);

        TextField MTsisestus = new TextField();

        Button MTnupp = new Button("Kontrolli");

        HBox MTtekstiväli = new HBox(MTsisestus, MTnupp);
        MTtekstiväli.setSpacing(5);
        MTtekstiväli.setAlignment(Pos.CENTER);

        Text MTvastuseÕigsus = new Text("");


        VBox MTkeskmineOsa = new VBox(MTküsimus, MTtekstiväli, MTvastuseÕigsus);
        MTkeskmineOsa.setAlignment(Pos.CENTER);


        Button MTtagasi = new Button("Tagasi");
        Button MTjuhis = new Button("?");

        BorderPane morseTäheksjuur = new BorderPane(MTkeskmineOsa);
        morseTäheksjuur.setBackground(Background.fill(Color.rgb(190, 225, 240)));
        morseTäheksjuur.setBottom(MTtagasi);
        morseTäheksjuur.setRight(MTjuhis);

        Scene morseTäheksStseen = new Scene(morseTäheksjuur, 500, 400);

        Stage morseTäheksLava = new Stage();
        morseTäheksLava.setScene(morseTäheksStseen);

        //nuppude aktiveerimine
        MTnupp.setOnMouseClicked(event -> { // 'kontroll' nupule vajutamine
            String MTsisestatudVastus = MTsisestus.getText().toUpperCase(Locale.ROOT);
            try {
                for (Character sümbol : MTsisestatudVastus.toCharArray()) {
                    if (!Character.isLetter(sümbol)) {
                        throw new ValeSisestusErind("Sisestada võib ainult tähti");
                    }
                }
                if (tähed.kontrolli(MTsisestatudVastus, MTsuvalineTäht.getText(), 1, 0)) {
                    MTvastuseÕigsus.setText("Õige vastus!");
                } else MTvastuseÕigsus.setText("Vale vastus!");
                MTsuvalineTäht.setText(tähed.suvaline()[1]);
                MTsisestus.setText("");
            } catch (ValeSisestusErind e) {
                MTvastuseÕigsus.setText("Sisestada võib ainult tähti");
                MTsisestus.setText("");
            }

        });


        morseTäheks.setOnMouseClicked(event -> { //ülesandesse
            morseTäheksLava.show();
            primaryStage.hide();
        });

        MTtagasi.setOnMouseClicked(event -> { //tagasi menüüsse
            MTsuvalineTäht.setText(tähed.suvaline()[1]);
            MTvastuseÕigsus.setText("");
            morseTäheksLava.hide();
            primaryStage.show();
        });

        //juhised
        Text MTtekst = new Text("Kirjuta teksitlahtrisse oma vastuseks üks täht.\n" +
                "Tulemuse teada saamiseks vajuta kontrolli nupul. ");

        BorderPane MTjuhisJuur = new BorderPane(MTtekst);
        Scene MTjuhisStseen = new Scene(MTjuhisJuur, 400, 100);
        Stage MTjuhisLava = new Stage();
        MTjuhisLava.setScene(MTjuhisStseen);

        MTjuhis.setOnMouseEntered(event -> MTjuhisLava.show());
        MTjuhis.setOnMouseExited(event -> MTjuhisLava.hide());


        // SÕNA -> MORSEKS

        //küsimus
        Text SMlause = new Text("Kirjutage morse koodis: ");
        Text SMsuvalineSõna = new Text(sõnad.suvaline()[0]);
        SMsuvalineSõna.setFont(new Font(25));
        SMlause.setFont(new Font(25));
        HBox SMküsimus = new HBox(SMlause, SMsuvalineSõna);
        SMküsimus.setAlignment(Pos.CENTER);


        Button SMtärn = new Button("*");
        Button SMkriips = new Button("-");
        Button kaldkriips = new Button("/");

        HBox SMnupud = new HBox(SMtärn, SMkriips);
        SMnupud.getChildren().add(kaldkriips);
        SMnupud.setAlignment(Pos.CENTER);

        TextField SMsisestus = new TextField();

        Button SMnupp = new Button("Kontrolli");

        HBox SMtekstiväli = new HBox(SMsisestus, SMnupp);
        SMtekstiväli.setAlignment(Pos.CENTER);
        SMtekstiväli.setSpacing(5);

        Text SMvastuseÕigsus = new Text("");

        VBox SMkeskmineOsa = new VBox(SMküsimus, SMtekstiväli, SMvastuseÕigsus, SMnupud);
        SMkeskmineOsa.setAlignment(Pos.CENTER);

        Button SMtagasi = new Button("Tagasi");
        Button SMjuhis = new Button("?");

        BorderPane sõnaMorseksjuur = new BorderPane(SMkeskmineOsa);
        sõnaMorseksjuur.setBackground(Background.fill(Color.rgb(122, 122, 250)));
        sõnaMorseksjuur.setBottom(SMtagasi);
        sõnaMorseksjuur.setRight(SMjuhis);

        Scene sõnaMorseksStseen = new Scene(sõnaMorseksjuur, 500, 400);

        Stage sõnaMorseksLava = new Stage();
        sõnaMorseksLava.setScene(sõnaMorseksStseen);

        //nupude aktiveerimine

        SMtärn.setOnMouseClicked(event -> { //tärni lisamine
            String SMtärnike = SMtärn.getText();
            SMsisestus.appendText(SMtärnike);
        });

        SMkriips.setOnMouseClicked(event -> { //kriipsu lisamine
            String SMkriipsuke = SMkriips.getText();
            SMsisestus.appendText(SMkriipsuke);
        });

        kaldkriips.setOnMouseClicked(event -> { //kaldkriipsu lisamine
            String kaldkriipsuke = kaldkriips.getText();
            SMsisestus.appendText(kaldkriipsuke);
        });

        SMnupp.setOnMouseClicked(event -> { // tegevused kui on 'kontrolli' nupp vajutatud
            String SMsisestatudVastus = SMsisestus.getText();
            try {
                for (Character sümbol : SMsisestatudVastus.toCharArray()) {
                    if ("*-/".indexOf(sümbol) == -1) {
                        throw new ValeSisestusErind("Sisestada võib ainult * ja -");
                    }
                }
                if (sõnad.kontrolli(SMsisestatudVastus, SMsuvalineSõna.getText(), 0, 1)) {
                    SMvastuseÕigsus.setText("Õige vastus!");
                } else SMvastuseÕigsus.setText("Vale vastus!");
                SMsuvalineSõna.setText(sõnad.suvaline()[0]);
                SMsisestus.setText("");
            } catch (ValeSisestusErind e) {
                SMvastuseÕigsus.setText("Sisestada võib ainult *,- ja /");
                SMsisestus.setText("");
            }
        });

        sõnaMorseks.setOnMouseClicked(event -> { //ülesandesse minemine
            sõnaMorseksLava.show();
            primaryStage.hide();
        });

        SMtagasi.setOnMouseClicked(event -> { //tagasi menüüsse
            SMsuvalineSõna.setText(sõnad.suvaline()[0]);
            SMvastuseÕigsus.setText("");
            sõnaMorseksLava.hide();
            primaryStage.show();
        });

        //juhised
        Text SMtekst = new Text("Kirjuta teksitlahtrisse oma vastuseks *, - ja / kombinatsioon või \n" +
                "kasuta kirjutamiseks nuppe. \n" +
                "Tulemuse teada saamiseks vajuta kontrolli nupul.");

        BorderPane SMjuhisJuur = new BorderPane(SMtekst);
        Scene SMjuhisStseen = new Scene(SMjuhisJuur, 400, 100);
        Stage SMjuhisLava = new Stage();
        SMjuhisLava.setScene(SMjuhisStseen);

        SMjuhis.setOnMouseEntered(event -> SMjuhisLava.show());
        SMjuhis.setOnMouseExited(event -> SMjuhisLava.hide());


        // MORSE -> SÕNAKS


        Text MSlause = new Text("Kirjutage sõna: ");
        Text MSsuvalineSõna = new Text(sõnad.suvaline()[1]);
        MSsuvalineSõna.setFont(new Font(25));
        MSlause.setFont(new Font(25));
        HBox MSküsimus = new HBox(MSlause, MSsuvalineSõna);
        MSküsimus.setAlignment(Pos.CENTER);

        TextField MSsisestus = new TextField();

        Button MSnupp = new Button("Kontrolli");

        HBox MStekstiväli = new HBox(MSsisestus, MSnupp);
        MStekstiväli.setAlignment(Pos.CENTER);
        MStekstiväli.setSpacing(5);

        Text MSvastuseÕigsus = new Text("");

        VBox MSkeskmineOsa = new VBox(MSküsimus, MStekstiväli, MSvastuseÕigsus);
        MSkeskmineOsa.setAlignment(Pos.CENTER);

        Button MStagasi = new Button("Tagasi");
        Button MSjuhis = new Button("?");

        BorderPane morseSõnaksjuur = new BorderPane(MSkeskmineOsa);
        morseSõnaksjuur.setBackground(Background.fill(Color.rgb(250, 174, 212)));
        morseSõnaksjuur.setBottom(MStagasi);
        morseSõnaksjuur.setRight(MSjuhis);

        Scene morseSõnaksStseen = new Scene(morseSõnaksjuur, 500, 400);

        Stage morseSõnaksLava = new Stage();
        morseSõnaksLava.setScene(morseSõnaksStseen);

        //nuppude aktiveerimine
        MSnupp.setOnMouseClicked(event -> { // tegevused kui on 'kontrolli' nupp vajutatud
            String MSsisestatudVastus = MSsisestus.getText().toUpperCase(Locale.ROOT);
            try {
                for (Character sümbol : MSsisestatudVastus.toCharArray()) {
                    if (!Character.isLetter(sümbol)) {
                        throw new ValeSisestusErind("Sisestada võib ainult tähti");
                    }
                }
                if (sõnad.kontrolli(MSsisestatudVastus, MSsuvalineSõna.getText(), 1, 0)) {
                    MSvastuseÕigsus.setText("Õige vastus!");
                } else MSvastuseÕigsus.setText("Vale vastus!");
                MSsuvalineSõna.setText(sõnad.suvaline()[1]);
                MSsisestus.setText("");
            } catch (ValeSisestusErind e) {
                MSvastuseÕigsus.setText("Sisestada võib ainult tähti");
                MSsisestus.setText("");
            }
        });

        morseSõnaks.setOnMouseClicked(event -> { //ülesande avamine
            morseSõnaksLava.show();
            primaryStage.hide();
        });

        MStagasi.setOnMouseClicked(event -> { //tagasi menüüsse
            MSsuvalineSõna.setText(sõnad.suvaline()[1]);
            MSvastuseÕigsus.setText("");
            morseSõnaksLava.hide();
            primaryStage.show();
        });
        //juhised
        Text MStekst = new Text("Kirjuta teksitlahtrisse oma vastus. \n" +
                "Tulemuse teada saamiseks vajuta kontrolli nupul.");

        BorderPane MSjuhisJuur = new BorderPane(MStekst);
        Scene MSjuhisStseen = new Scene(MSjuhisJuur, 400, 100);
        Stage MSjuhisLava = new Stage();
        MSjuhisLava.setScene(MSjuhisStseen);

        MSjuhis.setOnMouseEntered(event -> MSjuhisLava.show());
        MSjuhis.setOnMouseExited(event -> MSjuhisLava.hide());


        primaryStage.setTitle("Morse koodi õppimine");
        primaryStage.setScene(main);
        primaryStage.show();
    }
}
