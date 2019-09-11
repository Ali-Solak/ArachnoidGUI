package main;
import java.util.Random;

public class RiesenSpinne extends Charakter {

    private Random rand;

    public RiesenSpinne(String name, int lebenspunkte, int angriffspunkte){
        super(name, lebenspunkte, angriffspunkte);
        rand = new Random();
    }
    @Override
    public void angriff(Charakter angreifer, Charakter opfer){
        int zufallszahl = rand.nextInt(angreifer.getAngriffspunkte())+1;

        if(wahrscheinlichkeitSpecial() == false) {
            System.out.println("Die Riesenspinne greift an und macht " + zufallszahl + " schaden.");
            opfer.schaden(zufallszahl);
            opfer.anzeigen();
        }
        if(wahrscheinlichkeitSpecial() == true){
            System.out.println("Die Riesenspinne bespuckt dich mit Plasma und macht " + zufallszahl + " schaden.");
            System.out.println("Du setzt eine Runde aus");
            opfer.schaden(zufallszahl);
            opfer.anzeigen();
            super.toggleSpecial();
        }

    }

    private boolean wahrscheinlichkeitSpecial(){
        int zufall = rand.nextInt(10)+1;

        if(zufall > 9 && super.getLebenspunkte() > 80){
            return true;
        }
        if(zufall < 7 && super.getLebenspunkte() < 50){
            return true;
        }
        return false;

    }

    public void anzeigen(){
        System.out.println(super.getName() + " hat " +  super.getLebenspunkte() + " Lebenspunkte uebrig.");
    }
}
