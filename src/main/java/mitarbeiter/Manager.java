package mitarbeiter;

public class Manager extends Buerohengst
{
    private double bonusSatz;

    public Manager(int id, String name, double festgehalt, double bonusSatz)
    {
        super(id, name, festgehalt);
        this.setId(id);
        this.setBonusSatz(bonusSatz);
    }

    protected void setId(int id) throws IllegalArgumentException
    {
        if (id > 4999 && id < 5100)
        {
            super.setId(id);
        }
        else
        {
            throw new IllegalArgumentException("Invalide ID");
        }
    }

    public double getBonusSatz()
    {
        return this.bonusSatz;
    }

    public void setBonusSatz(double bonusSatz)
    {
        if (bonusSatz <= 0)
        {
            throw  new IllegalArgumentException("Bonussatz kann nicht kleiner gleich 0 sein.");
        }
        else
        {
            this.bonusSatz = bonusSatz;
        }
    }

    public double getEinkommen()
    {
        return this.getFestgehalt() + this.berechneBonus();
    }

    public double berechneBonus()
    {
        return this.getFestgehalt() * (this.getBonusSatz() / 100);
    }

    @Override
    public String toString() {
        return "Der Manager mit der ID " + getId() + " heißt " + getName() + ".\n";
    }
}
