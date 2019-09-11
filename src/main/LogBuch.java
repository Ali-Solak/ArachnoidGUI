package main;
import java.util.HashMap;
import java.util.Map;

public class LogBuch {

    private Map<String,String> dateien;

    public LogBuch(){
        dateien = new HashMap<>();
    }

    public void logBuchR1(){
        dateien.put("1",
                "Die Besatzung fuer die Mission FirstContact besteht aus:" + "\n" +
                "- Captain Lewis, Anfuehrer der Mission." + "\n" +
                "- Dr. Morgan, Techniker der Mission." + "\n" +
                "- Dr. Clark, Biowissenschaftler der Mission." + "\n" +
                "- Dr. Walker, weiterer Biowissenschaftler der Mission."  + "\n");

        dateien.put("2",
                "Eintrag Sternzeit 3011, Techniker Morgan:" + "\n" +
                "Ich habe nun dem Captain zum 10 mal gesagt, dass er nicht sein Absolvenzjahr für die Sternenflottenakademie als Passwort benutzen soll." + "\n" +
                "Er moechte es einfach nicht verstehen. Er gefaehrdet die Mission."  + "\n");

    }
    public void logBuchR2(){
        dateien.put("1",
                "Eintrag Sternzeit 3011, Dr. Walker:" + "\n" +
                "Wir machen Fortschritte. Laut Analyse unserer Sensoren gibt es tatsaechlich Leben auf diesem Planeten!" + "\n" +
                "Es scheint, sie Leben in einer der vielen Hoehlensysteme." + "\n" +
                "Es gelang uns zwar noch nicht fotografische Beweise aufzunehmen, unsere Systeme deutet jedoch auf eine arachnoide" + "\n" +
                "Lebensform hin. Man sollte sie definitiv nicht unterschaetzen. Alles deutet auf eine schlaue Lebensform hin."  + "\n");

        dateien.put("2",
                "Eintrag Sternzeit 3011, Dr. Clark:" + "\n" +
                        "Ich glaube Walker hat einen Lagerkoller. Er schreibt nur noch komische Zeichen auf die Waende." + "\n" +
                        "Spricht von Spinnenwesen. Er ist vollkommen uebergeschnappt. Wir haben ihn in Quarantaene in Raum 3 gesteckt." + "\n" +
                        "Jetzt bruellt er nur noch 'LASST UNS REIN!'. Zu allem uebel fiel die Kommunikation nun auch aus. Morgan kuemmert sich drum."  + "\n");

    }
    public void logBuchR3(){
        dateien.put("1",
                "Eintrag Sternzeit 3011, Dr. Walker" +
                "QochQo'chuqlaw' Hegh! QochQo'chuqlaw' Hegh! QochQo'chuqlaw' Hegh!" + "\n");
        dateien.put("2",
                "Eintrag Sternzeit 3011, Dr. Walker" +
                "tlhIngan! tlhIngan! tlhIngan!" + "\n");

    }

    public void logBuchloeschen(){
        dateien.clear();
    }

    public String getLogBuchEintrag(String key){
        String logbucheintrag = dateien.get(key);
        return logbucheintrag;
    }
}
