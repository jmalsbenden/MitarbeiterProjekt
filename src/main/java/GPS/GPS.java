package GPS;

public class GPS 
{
    private double laengengrad;
    private double breitengrad;
    
    public GPS(double laengengrad, double breitengrad)
    {
        this.setLaengengrad(laengengrad);
        this.setBreitengrad(breitengrad);
    }

    public void setLaengengrad(double laengengrad)
    {
        this.laengengrad = laengengrad;
    }

    public double getLaengengrad()
    {
        return this.laengengrad;
    }

    public void setBreitengrad(double breitengrad)
    {
        this.breitengrad = breitengrad;
    }

    public double getBreitengrad()
    {
        return this.breitengrad;
    }
}
