package main;

public abstract class Charakter {

    private String name;
    private int lebenspunkte;
    private int angriffspunkte;
    private boolean specialSkill;

    public Charakter(String name, int lebenspunkte, int angriffspunkte){
        this.name = name;
        this.lebenspunkte = lebenspunkte;
        this.angriffspunkte = angriffspunkte;
        this.specialSkill = false;
    }

    public abstract void angriff(Charakter angreifer, Charakter opfer);
    public abstract void anzeigen();

    public void schaden(int schadenspunkte){
        this.lebenspunkte = lebenspunkte - schadenspunkte;
    }

    public int getAngriffspunkte() {
        return angriffspunkte;
    }

    public void setAngriffspunkte(int angriffspunkte) {
        this.angriffspunkte = angriffspunkte;
    }

    public void setLebenspunkte(int lebenspunkte) {
        this.lebenspunkte = lebenspunkte;
    }

    public int getLebenspunkte() {
        return lebenspunkte;
    }

    public String getName() {
        return name;
    }

    public boolean getSpecialSkill(){
        return specialSkill;
    }

    public void toggleSpecial(){
        if(specialSkill == false){
            specialSkill = true;
        }
        else{
            specialSkill = false;
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}
