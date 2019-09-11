package main;
public abstract class Item {

    private String name;
    private int punkte;

    public Item(String name, int punkte){
        this.name = name;
        this.punkte = punkte;
    }

    public abstract void benutzen(Charakter charakter, Inventar inventar, String name);
    public abstract void anzeigen();

    public String getName() {
        return name;
    }

    public int getPunkte() {
        return punkte;
    }
}

