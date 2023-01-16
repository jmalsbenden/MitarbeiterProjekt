package mitarbeiter;

import GPS.GPS;
import kfz.KFZNew;

public class Fahrer extends Malocher
{
    private String fuehrerscheinKlasse;
    
    public Fahrer(int id, String name, double stundenSatz, String fuehrerschein)
    {
        super(id, name, stundenSatz);
        this.setFuehrerscheinKlasse(fuehrerschein);
    }

    public void setFuehrerscheinKlasse(String fuehrerschein)
    {
        this.fuehrerscheinKlasse = fuehrerschein;
    }

    public String getFuehrerscheinKlasse()
    {
        return this.fuehrerscheinKlasse;
    }

    public boolean fahreZu(KFZNew fahrzeug, GPS ziel)
    {
        if (fahrzeug.einsteigenFahrer(this))
        {
            fahrzeug.fahrenZu(ziel);
            return true;
        }
        else
        {
            return false;
        }
           
    }
}
