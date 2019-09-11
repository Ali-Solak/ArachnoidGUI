package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.HashSet;
import java.util.Scanner;


public class Controller {

    @FXML
    private TextField txtEingabe;
    @FXML
    private Button buttonVerify;
    @FXML
    private Button buttonOption1;
    @FXML
    private Button buttonOption2;
    @FXML
    private Button buttonOption3;
    @FXML
    private Button buttonOption4;
    @FXML
    private Button buttonOption5;
    @FXML
    private Label lblAusgabe;
    @FXML
    private ImageView imgBildBereich;
    @FXML
    private MenuItem helpItem;

    private boolean raum1;
    private boolean raum2;
    private boolean raum3;

    private Charakter held;
    private Charakter riesenspinne;

    private LogBuch logbuch;

    private ComputerHal hal;

    private Inventar inventar;
    private Inventar waffenkammer;
    private Inventar medizinschrank;
    private Inventar spinnennetz;

    private Item medipack;
    private Item laserpistole;
    private Item auge;

    private Event event;
    private Scanner scan;

    private String eingabe;
    private String eingabe2;
    private String charakterName;


    @FXML
    private void initialize() {

        raum1 = false;
        raum2 = false;
        raum3 = false;

        eingabe = new String("");
        eingabe2 = new String("");
        charakterName = new String("");

        held = new Held(this.charakterName, 100, 30);
        riesenspinne = new RiesenSpinne("Riesenspinne", 100, 20);

        logbuch = new LogBuch();

        hal = new ComputerHal();

        inventar = new Inventar();
        waffenkammer = new Inventar();
        medizinschrank = new Inventar();
        spinnennetz = new Inventar();

        medipack = new Medipack("medipack", 100);
        laserpistole = new Waffe("laserpistole", 50);
        auge = new Waffe("auge", 1);

        waffenkammer.gegenstandHinzufuegen(laserpistole);
        medizinschrank.gegenstandHinzufuegen(medipack);
        spinnennetz.gegenstandHinzufuegen(auge);

        event = new Event();

        javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResource("./images/beginn.jpg").toExternalForm());
        imgBildBereich.setImage(image);
        buttonOption1.setVisible(false);
        buttonOption2.setVisible(false);
        buttonOption3.setVisible(false);
        buttonOption4.setVisible(false);
        buttonOption5.setVisible(false);

        lblAusgabe.setText("Auf dem Planeten Minimus wurde eine Basis errichtet, um Forschung ueber die lokale Fauna" +
                "zu betreiben. Wissenschaftler glauben, der Planet erfuelle die Bedingungen, um Leben zu beherbergen." +
                "Seit mehreren Wochen erhaelt das Kontrollzentrum der Mission jedoch kein Signal mehr von der Missionscrew." +
                "Sie werden damit beauftragt zu untersuchen, ob die Crew noch am Leben ist und was auf Minimus geschah." + "\n" + "\n" + "Geben Sie den Name Ihres Charakters ein:");

        buttonVerify.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = txtEingabe.getText();
                held.setName(name);
                raum1 = true;
                raum1();
            }
        });
    }

    private void raum1() {
        hal.hashMapfuellenRaum1();
        hal.standardAntwortenRaum1();
        logbuch.logBuchR1();

        txtEingabe.setVisible(false);
        buttonVerify.setVisible(false);
        javafx.scene.image.Image image2 = new javafx.scene.image.Image(getClass().getResource("./images/raum1.jpg").toExternalForm());
        imgBildBereich.setImage(image2);
        buttonOption1.setVisible(true);
        buttonOption2.setVisible(true);
        buttonOption3.setVisible(true);
        buttonOption1.setText(" Hallo Computer.");
        buttonOption2.setText(" Medizinschrank untersuchen.");
        buttonOption3.setText(" Tuer zu Raum 2 untersuchen.");

        lblAusgabe.setText("Sie betreten die Basis und finden einen sterilen Raum vor sich.");


        buttonOption1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                computerMenue();
            }
        });
        buttonOption2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                medizinschrankMenue();
            }
        });
        buttonOption3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tuerRaum1Menue();
            }
        });
    }

    private void computerMenue() {

        lblAusgabe.setText("");
        javafx.scene.image.Image image3 = new javafx.scene.image.Image(getClass().getResource("./images/computer.png").toExternalForm());
        imgBildBereich.setImage(image3);

        buttonOption1.setText("Mit HAL 9000 sprechen.");
        buttonOption2.setText("Logbuch ansehen.");
        buttonOption3.setText("exit.");

        buttonOption1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                computerAntwort();
            }
        });
        buttonOption2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                buttonOption1.setText("Eintrag eins ansehen?");
                buttonOption2.setText("Eintrag zwei ansehen?");
                buttonOption3.setText("exit?");

                buttonOption1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        lblAusgabe.setText(logbuch.getLogBuchEintrag("1"));
                    }
                });
                buttonOption2.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        lblAusgabe.setText(logbuch.getLogBuchEintrag("2"));
                    }
                });
                buttonOption3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        computerMenue();
                    }
                });
            }
        });
        buttonOption3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                raum1();
            }
        });
    }

    private void computerAntwort() {
        buttonOption2.setVisible(false);
        buttonOption3.setVisible(false);
        buttonVerify.setVisible(true);
        buttonVerify.setText("Bestätigen");
        txtEingabe.clear();
        txtEingabe.setVisible(true);

        lblAusgabe.setText("Hallo " + held.getName() + ", wie darf ich Ihnen behilflich sein?");
        buttonOption1.setText("Exit");

        buttonVerify.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HashSet<String> frage = eingabe();

                String antwort = hal.antwortGenerieren(frage);
                lblAusgabe.setText(antwort);
            }
        });

        buttonOption1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                raum1();
            }
        });

    }

    private HashSet eingabe() {

        String eingabe = txtEingabe.getText();

        HashSet<String> woerter = new HashSet<>();
        String[] wortArray = eingabe.toLowerCase().split(" ");

        for (int i = 0; i < wortArray.length; i++) {

            woerter.add(wortArray[i]);
        }

        return woerter;
    }

    private void medizinschrankMenue() {
        buttonOption3.setVisible(false);
        javafx.scene.image.Image image4 = new javafx.scene.image.Image(getClass().getResource("./images/medPack.jpg").toExternalForm());
        imgBildBereich.setImage(image4);
        buttonOption1.setText("Medipack nehmen.");
        buttonOption2.setText("exit");
        lblAusgabe.setText("Der Schrank laesst sich oeffnen. Es befindet sich ein Medipack im Schrank");


        buttonOption1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (medizinschrank.gegenstandVorhanden("medipack")) {
                    lblAusgabe.setText("Sie nehmen das Medipack an sich.");
                    inventar.gegenstandHinzufuegen(medipack);
                    medizinschrank.inventarGegenstandLoeschen("medipack");
                } else {
                    lblAusgabe.setText("Keine medipacks mehr vorhanden.");
                }
            }
        });

        buttonOption2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                raum1();
            }
        });
    }

    private void tuerRaum1Menue() {
        buttonOption3.setVisible(false);
        buttonOption1.setVisible(false);
        javafx.scene.image.Image image4 = new javafx.scene.image.Image(getClass().getResource("./images/tuer.jpg").toExternalForm());
        imgBildBereich.setImage(image4);
        txtEingabe.setVisible(true);
        txtEingabe.clear();
        buttonVerify.setVisible(true);

        buttonVerify.setText("Code bestätigen");
        buttonOption2.setText("Exit");
        lblAusgabe.setText("Die Tuer ist mit einer Vorrichtung geschützt, welche" + "\n" + "einen vierstelligen Code benoetigt.");


        buttonVerify.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                eingabe2 = txtEingabe.getText();
                if(eingabe2.equals("2088")){
                    lblAusgabe.setText("Tür öffnet sich");
                }
                else{
                    lblAusgabe.setText("Falscher Code, Zugang verweigert");
                }
            }
        });
        buttonOption2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                raum1();
            }
        });
    }

    @FXML
    private void openHelpWindow(){
        Stage stage = new Stage();

        VBox root = new VBox();

        Label label = new Label("Computer nach Captain Lewis fragen. Passwort für Tür erhalten. -> Auge aus \n Spinnennetz nehmen bei Waffenkammer für Irisscan\n" +
                "nutzen. Laserpistole erhalten. Laserpistole \n bei kaputter Tür nutzen -> Im letzen Raum Riesenspinne besiegen.");

        root.getChildren().addAll(label);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Help");
        stage.setHeight(300);
        stage.setWidth(600);
        stage.show();
    }
}


