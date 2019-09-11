package main;
import java.util.Random;
import java.util.Scanner;

public class Event {
    private Scanner scan;
    private Random rand;
    private int eingabe;
    private Item laserpistole = new Waffe("laserpistole", 50);
    private Item medipack = new Medipack("medipack", 100);
    private int runde;

    public Event(){
        scan = new Scanner(System.in);
        rand = new Random();
        runde = 0;
    }

    public void fight(Charakter held, Charakter gegner, Inventar inventar){
        int zufall = rand.nextInt(2)+1;

        while(held.getLebenspunkte() > 0 && gegner.getLebenspunkte() > 0) {
            runde++;

            if (zufall == 1) {
                System.out.println("Runde " + runde + ".");

                if (gegner.getSpecialSkill() == true) {
                    kampfSim(gegner, held);
                    System.out.println("-----------------------------");
                    gegner.toggleSpecial();
                }

                if (gegner.getSpecialSkill() == false) {
                    kampfmenue(held, gegner, inventar);
                    System.out.println("-----------------------------");
                    kampfSim(gegner, held);
                    System.out.println("-----------------------------");
                }
                Sieg(held, gegner);

            }

            if (zufall == 2) {
                if (gegner.getSpecialSkill() == true) {
                    System.out.println("-----------------------------");
                    kampfSim(gegner, held);
                    gegner.toggleSpecial();
                }

                if (gegner.getSpecialSkill() == false) {
                    kampfSim(gegner, held);
                    System.out.println("-----------------------------");
                    kampfmenue(held, gegner, inventar);
                    System.out.println("-----------------------------");
                }
                Sieg(held, gegner);
            }
        }

    }

    public void kampfSim(Charakter spinne, Charakter gegner){
        if(spinne.getLebenspunkte() > 0) {
            System.out.println(spinne.getName() + " am Zug.");
            spinne.angriff(spinne, gegner);
        }
    }

    public void kampfmenue(Charakter held, Charakter gegner, Inventar inventar){

        if(held.getLebenspunkte() > 0) {
            System.out.println(held.getName() + " am Zug.");


            System.out.println("1. angreifen.");
            if (inventar.gegenstandVorhanden("medipack")) {
                System.out.println("2. Medipack benutzen.");
            }
            if (inventar.gegenstandVorhanden("laserpistole")) {
                System.out.println("3. Laserpistole benutzen");
            }
            eingabe = scan.nextInt();

            switch (eingabe) {
                case 1:
                    held.angriff(held, gegner);
                    break;
                case 2:
                    medipack.benutzen(held, inventar, "medipack");

                    break;
                case 3:
                    if (held.getSpecialSkill() == false) {
                        held.toggleSpecial();
                        laserpistole.benutzen(held,inventar,"laserpistole");
                        held.angriff(held, gegner);
                    }
                    else{
                        held.angriff(held, gegner);
                    }
                    break;

                default:
                    System.out.println("Falsche Eingabe.");

            }
        }

    }

    public void Sieg(Charakter held, Charakter gegner){
        if(held.getLebenspunkte() <= 0){
            System.out.println("Die Spinne hat dich getoetet");
        }
        if(gegner.getLebenspunkte() <=0){
            System.out.println("SIEG! Die Spinne ist erledigt. Du fliehst aus der Basis und uebermittelst deine Erkenntnisse was auf Minimus geschah.");
        }
    }
}
