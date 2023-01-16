package kfz;

import GPS.GPS;
import mitarbeiter.Fahrer;

public class LKW extends KFZNew
{
    private double ladeFlaeche;
    private double ladung;    

    public LKW(double maxTank, double nowTank, Fahrer fahrer, GPS aktuellePos, boolean motorAn, double ladeFlaeche, double ladung)
    {
        super(maxTank, nowTank, fahrer, aktuellePos, motorAn);
        this.setLadeFlaeche(ladeFlaeche);
        this.setLadung(ladung);
    }

    public void setLadeFlaeche(double ladeFlaeche)
    {
        if (ladeFlaeche <= 0)
        {
            throw new IllegalArgumentException("Ladefläche kann nicht negativ sein.");
        }
        else
        {
            this.ladeFlaeche = ladeFlaeche;
        }
    }

    public double getLadeFlaeche()
    {
        return this.ladeFlaeche;
    }

    public void setLadung(double ladung)
    {
        if (ladung <= 0)
        {
            throw new IllegalArgumentException("Ladung kann nicht negativ sein.");
        }
        else
        {
            this.ladung = ladung;
        }
    }

    public double getLadung()
    {
        return this.ladung;
    }

    public boolean beladen(double menge)
    {
        if ((this.getLadung() + menge) <= this.getLadeFlaeche())
        {
            this.setLadung(this.getLadung() + menge);
            return true;
        }
        else 
        {
            return false;
        }

    }

    public void entladen(double menge)
    {
        if ((this.getLadung() - menge) > 0)
        {
            this.setLadung(this.getLadung() - menge);
        }
        else
        {
            this.setLadung(0);
        }
    }

    public boolean einsteigenFahrer(Fahrer fahrer)
    {
        String fuehrerschein = fahrer.getFuehrerscheinKlasse();
        switch (fuehrerschein)
        {
            case "C":
            case "CE":
                super.einsteigenFahrer(fahrer);
                return true;
            default:
                return false;
        }
    }

    public double auslastung()
    {
        return this.getLadung() / this.getLadeFlaeche();
    }
}

