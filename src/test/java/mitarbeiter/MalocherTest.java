package mitarbeiter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MalocherTest {
    @Test
    public void IstIdZuKleinThrowIllArg() {
        Malocher malocher = new Malocher(3000, "jeff", 12);
        assertThrows(IllegalArgumentException.class,
                () -> {
                    malocher.setId(2999);
                });
    }

    @Test
    public void IstIdZuGroßThrowIllArg() {
        Malocher malocher = new Malocher(3000, "jeff", 12);
        assertThrows(IllegalArgumentException.class,
                () -> {
                    malocher.setId(4000);
                });
    }

    @Test
    public void WennAnzStundenKleinerNullThrowIllArg(){
        Malocher malocher = new Malocher(3000, "jeff", 12);
        assertThrows(IllegalArgumentException.class,
                () -> {
                    malocher.setAnzahlStunden(-1);
                });
    }

    @Test
    public void WennStundenSatzKleinerNullThrowIllArg(){
        Malocher malocher = new Malocher(3000, "jeff", 12);
        assertThrows(IllegalArgumentException.class,
                () -> {
                    malocher.setStundenSatz(0);
                });
    }
}