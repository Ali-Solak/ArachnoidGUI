package main;
public class Waffe extends Item {

    public Waffe(String name, int punkte){
        super(name, punkte);
    }

    @Override
    public void benutzen(Charakter held, Inventar inventar, String name){
        if(inventar.gegenstandVorhanden("name")){
            held.setAngriffspunkte(held.getAngriffspunkte() + super.getPunkte());
            held.toggleSpecial();
        }

    }
    @Override
    public void anzeigen(){
        System.out.println(super.getName() + " hat " + super.getPunkte() + " Angriffspunkte.");
    }
}
