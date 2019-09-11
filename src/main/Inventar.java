package main;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventar
{
    private ArrayList<Item> inventar1;

    public Inventar()
    {
        inventar1 = new ArrayList<Item>();
    }

    public void gegenstandHinzufuegen(Item geg)
    {
        inventar1.add(geg);
    }

    public void inventarAusgeben()
    {
        for(Item inventarinhalt : inventar1)
        {
            System.out.println(inventarinhalt.getName());
        }
    }

    public boolean gegenstandVorhanden(String name)
    {
        for(Item gegenstand : inventar1)
        {
            if(gegenstand.getName().contains(name))
            {
                return true;
            }
        }
        return false;
    }

    public void inventarLoeschen()
    {
        Iterator<Item> it = inventar1.iterator();
        while(it.hasNext())
        {
            Item geg = it.next();
            it.remove();
        }
    }

    public void inventarGegenstandLoeschen(String name)
    {
        Iterator<Item> it = inventar1.iterator();
        while(it.hasNext())
        {
            Item geg = it.next();
            if(geg.getName().contains(name))
            {
                it.remove();
            }
        }
    }
}
