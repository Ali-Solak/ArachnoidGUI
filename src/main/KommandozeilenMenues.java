package main;

import java.util.HashSet;
import java.util.Scanner;

public class KommandozeilenMenues {


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

    public KommandozeilenMenues() {
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
        scan = new Scanner(System.in);
    }

    public void raum1Start() {
        while (!eingabe.toLowerCase().trim().equals("j")) {

            System.out.println("Auf dem Planeten Minimus wurde eine Basis errichtet, um Forschung ueber die lokale Fauna" + "\n" +
                    "zu betreiben. Wissenschaftler glauben, der Planet erfuelle die Bedingungen, um Leben zu beherbergen." + "\n" +
                    "Seit mehreren Wochen erhaelt das Kontrollzentrum der Mission jedoch kein Signal mehr von der Missionscrew." + "\n" +
                    "Sie werden damit beauftragt zu untersuchen, ob die Crew noch am Leben ist und was auf Minimus geschah.");

            System.out.println("-----------------------------------------------");
            System.out.println("Geben Sie den Name Ihres Charakters ein:");
            this.charakterName = scan.nextLine();
            held.setName(charakterName);

            System.out.println("Spiel starten? [j/n]");
            eingabe = scan.nextLine();
            if (eingabe.toLowerCase().trim().equals("j")) {
                raum1 = true;
            }
        }

        while (raum1) {
            hal.hashMapfuellenRaum1();
            hal.standardAntwortenRaum1();
            logbuch.logBuchR1();
            System.out.println("Sie betreten die Basis und finden einen sterilen Raum vor sich.");
            System.out.println("1. Hallo Computer.");
            System.out.println("2. Medizinschrank untersuchen.");
            System.out.println("3. Tuer zu Raum 2 untersuchen.");
            eingabe = scan.nextLine();

            if (eingabe.equals("1")) {
                computerMenue();
            } else if (eingabe.equals("2")) {
                medizinschrankMenue();
            } else if (eingabe.equals("3")) {
                tuerRaum1Menue();
            }
        }
    }

    public void raum2Start(){
        while (raum2) {
            System.out.println("Sie betreten den zweiten Raum. Der Raum ist vollkommen chaotisch. Ueberall liegen Laborutensilien auf dem Boden." + "\n" +
                    "In einer Ecke des Raumes haengt ein riesen Spinnennetz.");
            System.out.println("1. Hallo Computer.");
            System.out.println("2. Waffenschrank untersuchen.");
            System.out.println("3. Triefendes Spinnennetz untersuchen.");
            System.out.println("4. Tuer zu Raum 3 untersuchen.");
            eingabe = scan.nextLine();

            if (eingabe.equals("1")) {
                computerMenue();
            } else if (eingabe.equals("2")) {
                waffenschrankMenue();
            } else if (eingabe.equals("3")) {
                spinnennetzMenue();
            }
            else if(eingabe.equals("4")){
                tuerRaum2Menue();
            }
        }
    }

    public void raum3Start(){
        while(raum3) {
            System.out.println("Sie treten in den dritten Raum ein. Funken spruehen aus Laborgereatschaften. Alles liegt in Schutt.");
            System.out.println("1. Hallo Computer.");
            System.out.println("2. Verschleimte Tuer untersuchen");
            eingabe = scan.nextLine();

            if (eingabe.trim().equals("1")) {
                computerMenue();
            }
            if(eingabe.trim().equals("2")){
                System.out.println("Als Sie sich der Tuer naehern bricht eine Riesenspinne durch die Tuer.");
                event.fight(held, riesenspinne, inventar);

                if(held.getLebenspunkte() <= 0){
                    raum3 = false;
                    eingabe = "dfjkajdfkla";
                }
                if(riesenspinne.getLebenspunkte() <= 0){
                    raum3 = false;
                    eingabe = "dfjkajdfkla";
                }
            }
        }
    }


    public void computerMenue() {
        System.out.println("1 Mit HAL 9000 sprechen.");
        System.out.println("2 Logbuch ansehen.");
        System.out.println("3 exit.");
        eingabe2 = scan.nextLine();

        switch (eingabe2.trim()) {
            case "1":
                computerAntwort();
                break;

            case "2":
                while (!eingabe2.equals("3")) {
                    System.out.println("1. Eintrag eins ansehen?");
                    System.out.println("2. Eintrag zwei ansehen?");
                    System.out.println("3. exit?");
                    eingabe2 = scan.nextLine();
                    if (eingabe2.trim().equals("1")) {
                        logbuch.getLogBuchEintrag("1");
                    }
                    if (eingabe2.trim().equals("2")) {
                        logbuch.getLogBuchEintrag("2");
                    }
                    if (eingabe2.trim().equals("3")) {
                        eingabe2 = "3";
                    }
                }
            case "3":
                eingabe = "64654";
                break;

            default:
                System.out.println("Falsche Eingabe.");
                break;
        }
    }

    public void tuerRaum2Menue(){
        while (eingabe.equals("4")) {
            System.out.println("Die Tuer scheint zu klemmen. ");
            System.out.println("1. Gegenstand benutzen");
            System.out.println("2. Exit");
            eingabe2 = scan.nextLine();

            if (eingabe2.equals("1")) {
                System.out.println("Ihr Inventar:");
                inventar.inventarAusgeben();
                System.out.println("Geben Sie den Gegenstand ein, den Sie benutzen moechten");
                eingabe2 = scan.nextLine();
                raumBetreten(eingabe2);

            }

            if (eingabe2.equals("2")) {
                eingabe = "65";
            }
        }
    }

    public void spinnennetzMenue(){
        while (eingabe.equals("3")) {
            System.out.println("Als Sie auf das Spinnennetz blicken, finden sich ein Auge darauf.");
            System.out.println("1. Auge nehmen");
            System.out.println("2. Exit");
            eingabe2 = scan.nextLine();

            if (eingabe2.equals("1")) {
                if (spinnennetz.gegenstandVorhanden("auge")) {
                    inventar.gegenstandHinzufuegen(auge);
                    spinnennetz.inventarGegenstandLoeschen("auge");
                    System.out.println("Sie nehmen das Auge an sich.");
                } else {
                    System.out.println("Keine Augen zu entnehmen vorhanden.");
                }

            }

            if (eingabe2.equals("2")) {
                eingabe = "65";
            }
        }
    }

    public void medizinschrankMenue() {
        while (eingabe.equals("2")) {
            System.out.println("Der Schrank laesst sich oeffnen. Es befindet sich ein Medipack im Schrank" + "\n" +
                    "1. Medipack nehmen." + "\n" +
                    "2. exit");
            eingabe2 = scan.nextLine();

            if (eingabe2.equals("1")) {
                if (medizinschrank.gegenstandVorhanden("medipack")) {
                    System.out.println("Sie nehmen das Medipack an sich.");
                    inventar.gegenstandHinzufuegen(medipack);
                    medizinschrank.inventarGegenstandLoeschen("medipack");
                } else {
                    System.out.println("Keine medipacks mehr vorhanden.");
                }
            }
            if (eingabe2.equals("2")) {
                eingabe = "564";
            }
        }
    }

    public void tuerRaum1Menue() {
        while (eingabe.equals("3")) {
            System.out.println("Die Tuer ist mit einer Vorrichtung geschützt, welche einen vierstelligen Code benoetigt.");
            System.out.println("1. Code eingeben");
            System.out.println("2. Exit");
            eingabe2 = scan.nextLine();

            if (eingabe2.equals("1")) {
                System.out.println("Geben Sie das Passwort ein.");
                eingabe2 = scan.nextLine();

                raumBetreten(eingabe2);
            }

            if (eingabe2.equals("2")) {
                eingabe = "55545";
            }
        }
    }

    public void waffenschrankMenue(){
        while (eingabe.equals("2")) {
            System.out.println("Der Schrank benoetigt einen Irisscan" + "\n" +
                    "1. Gegenstand benutzen." + "\n" +
                    "2. exit");
            eingabe2 = scan.nextLine();

            if (eingabe2.equals("1")) {
                System.out.println("Ihr Inventar:");
                inventar.inventarAusgeben();
                System.out.println("Geben Sie den gegenstand ein, den Sie benutzen moechten");
                eingabe2 = scan.nextLine();

                if (eingabe2.trim().toLowerCase().equals("auge") && inventar.gegenstandVorhanden("auge") && waffenkammer.gegenstandVorhanden("laserpistole")) {
                    System.out.println("Der Schrank oefnnet sich, Sie finden eine Laserpistole und nehmen sie an sich.");
                    inventar.gegenstandHinzufuegen(laserpistole);
                    waffenkammer.inventarGegenstandLoeschen("laserpistole");
                }
                else if (eingabe2.trim().toLowerCase().equals("auge") && inventar.gegenstandVorhanden("auge") && waffenkammer.gegenstandVorhanden("laserpistole") == false) {

                    System.out.println("Der Schrank ist leer");
                }
                else {
                    System.out.println("Das funktioniert nicht");
                }
            }
            if (eingabe2.equals("2")) {
                eingabe = "564";
            }
        }
    }

    public void computerAntwort() {
        boolean fertig = false;

        while (!fertig) {
            HashSet<String> frage = ((Held) held).eingabe();
            if (frage.contains("ade")) {
                fertig = true;
            } else {
                String antwort = hal.antwortGenerieren(frage);
                System.out.println(antwort);
            }
        }

    }

    public void raumBetreten(String eingabe2) {
        if (eingabe2.equals("2088")) {
            raum1 = false;
            raum2 = true;
            hal.standardAntwortenLoeschen();
            hal.hashMapleeren();
            logbuch.logBuchloeschen();
            hal.standardAntwortenRaum2();
            hal.hashMapfuellenRaum2();
            logbuch.logBuchR2();
            eingabe2 = "2";
            eingabe = "54554";
        } else if (eingabe2.toLowerCase().trim().equals("laserpistole") && inventar.gegenstandVorhanden("laserpistole")) {
            System.out.println("Sie schiessen auf den Mechanismus der Tuer. Sie oeffnet sich.");
            raum2 = false;
            raum3 = true;
            hal.standardAntwortenLoeschen();
            hal.hashMapleeren();
            hal.standardAntwortenRaum3();
            hal.hashMapfuellenRaum3();
            logbuch.logBuchloeschen();
            logbuch.logBuchR3();
            eingabe2 = "2";
            eingabe = "54554";
        } else {
            System.out.println("Das funktioniert nicht.");
        }

    }

}
