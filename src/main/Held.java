package main;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Random;

public class Held extends Charakter {

    private Scanner scan;
    private String eingabe;
    private Random rand;

    public Held(String name, int lebenspunkte, int angriffspunkte){
        super(name, lebenspunkte, angriffspunkte);
        scan = new Scanner(System.in);
        rand = new Random();
    }

    @Override
    public void angriff(Charakter held, Charakter gegner){
        int zufallszahl = rand.nextInt(held.getAngriffspunkte())+10;

        if(super.getSpecialSkill() == false) {
            System.out.println("Du schlaegst zu und machst " + zufallszahl + " schaden.");
            gegner.schaden(zufallszahl);
            gegner.anzeigen();
        }

        if(super.getSpecialSkill() == true){
            System.out.println("Du schiesst mit der Laserpistole und machst " + zufallszahl + " schaden.");
            gegner.schaden(zufallszahl);
            gegner.anzeigen();
        }
    }

    public HashSet eingabe(){
        System.out.println("Hallo " + super.getName() + ", wie darf ich Ihnen behilflich sein? [Geben Sie 'ade' ein, um Dialog zu beenden']" + "\n");
        eingabe = scan.nextLine();

        HashSet<String> woerter = new HashSet<>();
        String [] wortArray = eingabe.toLowerCase().split(" ");

        for(int i = 0; i < wortArray.length; i ++){

            woerter.add(wortArray[i]);
        }

        return woerter;
    }

    @Override
    public void anzeigen(){
        System.out.println(super.getName() + " hat " +  super.getLebenspunkte() + " uebrig.");
    }
}
