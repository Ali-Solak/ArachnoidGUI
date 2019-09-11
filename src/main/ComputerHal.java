package main;
import java.util.*;

public class ComputerHal {

    private Map <String, String> antworten;
    private List <String> standardAntworten;
    private Random rand;

    public ComputerHal(){
        antworten = new HashMap<>();
        standardAntworten = new ArrayList<>();
        rand = new Random();
    }

    public String antwortGenerieren(HashSet <String> woerter){

        for(String wort : woerter){
            String antwort = antworten.get(wort);

            if(antwort != null){
                return antwort;
            }

        }
        return standardAntwort();

    }
    public String standardAntwort(){
        int zufall = rand.nextInt(standardAntworten.size());
        String antwort = standardAntworten.get(zufall);

        return antwort;
    }
    public void hashMapfuellenRaum1(){
        antworten.put("captain",
                "\n" + "Captain dieser Mission ist Major Lewis. Absolvent der Sternenflottenakademie des Jahres 2088." + "\n");
        antworten.put("planet",
                "\n" + "Wir befinden uns auf Minimus." + "\n");
        antworten.put("planeten",
                "\n" + "Wir befinden uns auf Minimus." + "\n");
        antworten.put("tuer",
                "\n" + "Die Tuer ist passwortgeschuetzt." + "\n");
        antworten.put("lebensformen",
                "\n" + "Scanne, zwei Lebensform auf der Basis entdeckt." + "\n");
        antworten.put("passwort",
                "\n" + "Sie verfuegen nicht ueber die Autorisierung fuer solch eine Information." + "\n");
        antworten.put("name",
                "\n" + "Mein Name ist HAL 9000." + "\n");
        antworten.put("absolvierte",
                "\n" + "Major Lewis, absolvierte die Akademie im Jahre 2088." + "\n");
        antworten.put("absolvenzjahr",
                "\n" + "Major Lewis, absolvierte die Akademie im Jahre 2088." + "\n");
        antworten.put("aliens",
                "\n" + "Darueber finde ich keinerlei Eintraege in meinem System. Laut Definition gelten Sie als Alien auf diesem Planeten." + "\n");
        antworten.put("wissenschaftler",
                "\n" + "Die Crew besteht aus zwei Wissenschaftler. Status Missionsfortschritt: unbekannt." + "\n");
        antworten.put("tod",
                "\n" + "Keine Verbindung zu Biomesstools der Crew. Status der Crewmitglieder unbekannt." + "\n");
        antworten.put("lewis",
                "\n" + "Captain dieser Mission ist Major Lewis. Absolvent der Sternenflottenakademie des Jahres 2088." + "\n");
        antworten.put("arschloch",
                "\n" + "Laut meinem Woerterbuch zur Menschlingssprache, gehoert sich das nicht. " + "\n");
        antworten.put("minimus",
                "\n" + "Der Planet Minimus gilt als einer der wenigen habitablen Planeten in Erdnaehe." + "\n");

    }
    public void hashMapfuellenRaum2(){
        antworten.put("tuer",
                        "\n" + "Der Mechanismus scheint kaputt zu sein. Empfehle rohe Gewalt." + "\n");
        antworten.put("spinne",
                "\n" + "Spinne, laut meinen Daten eine den Menschen weitaus ueberlegende Lebensform." + "\n");
        antworten.put("kaputt",
                "\n" + "Der Mechanismus scheint kaputt zu sein. Empfehle rohe Gewalt." + "\n");
        antworten.put("walker",
                "\n" + "Ein auserordentlicher Wissenschaftler in seinem Gebiet. Ein wahrer Freund der Octorianer." + "\n");
        antworten.put("passierte",
                "\n" + "Was meinen Sie? die Forschung geht voran wie immer." + "\n");
        antworten.put("geschah",
                "\n" + "Was meinen Sie? die Forschung geht voran wie immer." + "\n");
        antworten.put("octorianer",
                "\n" + "Herrscher von Minimus und Verteidiger gegen alle Invasoren. Die Octorianer sind die Bewohner von Minimus. " + "\n");

    }
    public void hashMapfuellenRaum3(){
        antworten.put("passierte",
                "\n" + "DIE INVASOREN WURDEN NIEDERGESCHLAGEN. HEIL DEN OCTORIANERN!" + "\n");
        antworten.put("geschah",
                "\n" + "DIE INVASOREN WURDEN NIEDERGESCHLAGEN. HEIL DEN OCTORIANERN!" + "\n");
        antworten.put("octorianer",
                "\n" + "Herrscher von Minimus und Verteidiger gegen alle Invasoren. Die Octorianer sind Bewohner von Minimus." + "\n");

    }
    public void standardAntwortenRaum1(){
        standardAntworten.add("Dazu finde ich nichts." + "\n");
        standardAntworten.add("Ich verstehe Ihre Frage nicht." + "\n") ;
        standardAntworten.add("Bitte praezisiere deine Frage." + "\n");
    }
    public void standardAntwortenRaum2(){
        standardAntworten.add("Dazu finde ich nichts." + "\n");
        standardAntworten.add("Ich verstehe Ihre Frage nicht." + "\n");
        standardAntworten.add("Bitte praezisiere deine Frage." + "\n");
    }
    public void standardAntwortenRaum3(){
        standardAntworten.add("Frère Jacques, Frère Jacques,\n" + "dormez-vous, dormez-vous?" + "\n");
        standardAntworten.add("NIEDER MIT DEN MENSCHLINGEN!" + "\n");
        standardAntworten.add("Frère Jacques, Frère Jacques,\n" + "dormez-vous, dormez-vous?" + "\n");
        standardAntworten.add("EIN HOCH AUF DIE OCTORIANER, UNERE ZUKUNFTIGEN EROBERER!" + "\n");

    }

    public void hashMapleeren(){
        antworten.clear();
    }

    public void standardAntwortenLoeschen(){
        standardAntworten.clear();
    }
}
