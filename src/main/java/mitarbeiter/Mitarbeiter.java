package mitarbeiter;

import abteilung.IAbteilungsPart;

import java.util.Comparator;

public abstract class Mitarbeiter implements Comparable<Mitarbeiter>, IAbteilungsPart
{
  private int id;
  private String name;
  
  public Mitarbeiter(int id, String name)
  {
    setId(id);
    setName(name);
  }

  public Mitarbeiter(Mitarbeiter original)
  {
    this.setId(original.getId());
    this.setName(original.getName());
  }

  protected void setId(int id) throws IllegalArgumentException
  {
    if(id > 999 && id < 10000)
    {
      this.id = id;
    }
    else
    {
      throw new IllegalArgumentException("Invalide ID");
    }
  }
  
  public int getId()
  {
    return this.id;
  }

  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return this.name;
  }

  @Override
  public String toString()
  {
    String rueckgabe = "Der Mitarbeiter mit der ID " + this.id + " heißt " + this.name + ".\n";
    return rueckgabe;
  }

  @Override
  public int zaehlen() {
    return 1;
  }

  public abstract double getEinkommen();

  @Override
  public int compareTo(Mitarbeiter o)
  {
    return o.getName().compareTo(this.getName());
  }




  public static class MitarbeiterComperator implements Comparator<Mitarbeiter>
  {
    @Override
    public int compare(Mitarbeiter o1, Mitarbeiter o2) {
      int temp = 0;
      if (o1.getEinkommen() < o2.getEinkommen())
      {
        temp = -1;
      }
      else if (o1.getEinkommen() > o2.getEinkommen())
      {
        temp = 1;
      }
      return temp;
    }
  }
}
