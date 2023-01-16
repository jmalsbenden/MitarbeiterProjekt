package mitarbeiter;

import GPS.GPS;
import kfz.LKW;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FahrerTest {

    @Test
    public void IstFahreZuTrueWennFuehrerscheinKlasseRichtig(){
        Fahrer fahrer = new Fahrer(3000, "jeff",12, "C");
        LKW lkw = new LKW(12,12, fahrer,new GPS(12, 12), true, 12, 12);
        assertTrue(fahrer.fahreZu(lkw, new GPS(34, 59)));
    }

    @Test
    public void IstFahreZuFalseWennFuehrerscheinKlasseFalsch(){
        Fahrer fahrer = new Fahrer(3000, "jeff",12, "B");
        LKW lkw = new LKW(12,12, fahrer,new GPS(12, 12), true, 12, 12);
        assertFalse(fahrer.fahreZu(lkw, new GPS(13, 13)));
    }
}