package main;
public class Medipack extends Item {

    public Medipack(String name, int punkte){
        super(name, punkte);
    }

    @Override
    public void benutzen(Charakter held, Inventar inventar, String name){
        if(inventar.gegenstandVorhanden(name)){
            held.setLebenspunkte(super.getPunkte());
            System.out.println("Deine Lebsenspunkte wurde wiederhergestellt");
            inventar.inventarGegenstandLoeschen(name);
        }
    }
    @Override
    public void anzeigen(){
        System.out.println(super.getName() + " kann " + super.getPunkte() + " Lebenspunkte wiederherstellen.");
    }
}
