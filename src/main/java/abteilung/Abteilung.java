package abteilung;

import mitarbeiter.Manager;
import mitarbeiter.Mitarbeiter;

import java.util.ArrayList;

public class Abteilung implements IAbteilungsPart
{
    private String name;
    private ArrayList<IAbteilungsPart> mitarbeiter = new ArrayList<>();
    private Manager leiter;

    public Abteilung(String name, Manager leiter)
    {
        this.setName(name);
        this.setLeiter(leiter);
        mitarbeiter.add(leiter);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    public void setLeiter(Manager leiter)
    {
        mitarbeiter.remove(this.leiter);
        this.leiter = leiter;
        mitarbeiter.add(leiter);
    }

    public Manager getLeiter()
    {
        return this.leiter;
    }

    public void setMitarbeiter(ArrayList<IAbteilungsPart> mitarbeiter)
    {
        this.mitarbeiter = mitarbeiter;
    }

    public ArrayList<IAbteilungsPart> getMitarbeiter()
    {
        return mitarbeiter;
    }

    public void add(Mitarbeiter neuer)
    {
        mitarbeiter.add(neuer);
    }

    public void remove(Mitarbeiter welcher)
    {
        mitarbeiter.remove(welcher);
    }

    public Manager changeLeiter(Manager neuer)
    {
        this.setLeiter(neuer);
        return this.getLeiter();
    }

    public String gehaltsliste()
    {
        String rueck = "";
        for(int i = 0; i < mitarbeiter.size(); i++)
        {
            rueck += mitarbeiter.get(i).getName() + mitarbeiter.get(i).getEinkommen();
        }
        return rueck;
    }

    @Override
    public double getEinkommen() {
        double erg = 0;
        for(IAbteilungsPart m: mitarbeiter){
            erg = erg + m.getEinkommen();
        }
        return erg;
    }

    @Override
    public String toString() {
        String erg = "In der Abteilung " + this.getName() + " sind " + this.zaehlen() + " Mitarbeiter.\n";
        for (IAbteilungsPart m:mitarbeiter)
        {
            erg += m.toString();
        }
        return erg;
    }

    @Override
    public int zaehlen() {
        int erg = 0;
        for(IAbteilungsPart m: mitarbeiter)
        {
            erg += m.zaehlen();
        }
        return erg;
    }
}
