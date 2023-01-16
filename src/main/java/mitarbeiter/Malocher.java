package mitarbeiter;

public class Malocher extends Mitarbeiter
{
    private double stundenSatz;
    private int anzahlStunden = 0;

    public Malocher(int id, String name, double stundenSatz)
    {
        super(id, name);
        this.setId(id);
        this.setStundenSatz(stundenSatz);
    }

    public Malocher(Malocher original)
    {
        super(original);
        this.setId(original.getId());
        this.setStundenSatz(original.getStundenSatz());
    }

    protected void setId(int id) throws IllegalArgumentException
    {
        if (id > 2999 && id < 4000)
        {
            super.setId(id);
        }
        else
        {
            throw new IllegalArgumentException("Invalide ID");
        }
    }

    public void setAnzahlStunden(int anzahlStunden)
    {
        if (anzahlStunden < 0)
        {
            throw new IllegalArgumentException("Stunden können nicht negativ sein.");
        }
        else
        {
            this.anzahlStunden = anzahlStunden;
        }
    }

    public int getAnzahlStunden()
    {
        return this.anzahlStunden;
    }

    public void setStundenSatz(double stundenSatz)
    {
        if (stundenSatz <= 0)
        {
            throw new IllegalArgumentException("Negativer Stundensatz nicht möglich.");
        }
        else
        {
            this.stundenSatz = stundenSatz;
        }
    }

    public double getStundenSatz()
    {
        return this.stundenSatz;
    }

    @Override
    public double getEinkommen()
    {
        return this.anzahlStunden * this.getStundenSatz();
    }

    public String toString()
    {
        String rueck = super.toString();
        rueck += "Der Mitarbeiter hat einen Stundensatz von " + this.getStundenSatz() + " und arbeitet " + this.getAnzahlStunden() + " Stunden.";
        return rueck;
    }
}
