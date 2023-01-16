package Verwaltung;

import abteilung.Abteilung;
import kfz.KFZNew;
import mitarbeiter.Malocher;
import mitarbeiter.Mitarbeiter;

import java.util.ArrayList;
import java.util.Collections;

public class Unternehmensverwaltung
{
    private ArrayList<Mitarbeiter> mitarbeiterList = new ArrayList<>();
    private ArrayList<KFZNew> kfzNewList = new ArrayList<>();
    private ArrayList<Malocher> malocherList = new ArrayList<>();
    private ArrayList<Abteilung> abteilungList = new ArrayList<>();

    public Unternehmensverwaltung()
    {

    }

    public void add(KFZNew neues)
    {
        this.kfzNewList.add(neues);
    }

    public void remove(KFZNew welches)
    {
        this.kfzNewList.remove(welches);
    }

    public void addMalocher(Malocher neues)
    {
        this.malocherList.add(neues);
    }

    public void removeMalocher(Malocher welcher) {
        this.malocherList.remove(welcher);
        this.remove(welcher);
    }

    public void add(Mitarbeiter neues)
    {
        mitarbeiterList.add(neues);
        Collections.sort(this.mitarbeiterList);
    }

    public void remove(Mitarbeiter welcher)
    {
        this.mitarbeiterList.remove(welcher);
    }

    public void add(Abteilung neue)
    {
        this.abteilungList.add(neue);
    }

    public void remove(Abteilung welche)
    {
        this.abteilungList.remove(welche);
    }

    public void arbeitstag(int arbeitszeit)
    {
        for (int i = 0; i < malocherList.size(); i++)
        {
            malocherList.get(i).setAnzahlStunden(malocherList.get(i).getAnzahlStunden() + arbeitszeit);
        }
    }

    public void mitarbeiterGehaltsSortierung()
    {
        Collections.sort(this.mitarbeiterList, new Mitarbeiter.MitarbeiterComperator());
    }

    public ArrayList<Mitarbeiter> getMitarbeiterList(){
        return this.mitarbeiterList;
    }
}
