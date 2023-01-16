package mitarbeiter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuerohengstTest {

    @Test
    public void IstIdZuKleinThrowIllArg(){
        Buerohengst buerohengst = new Buerohengst(5000, "jeff", 12);
        assertThrows(IllegalArgumentException.class,
                ()->{
                    buerohengst.setId(4999);
                });
    }
    @Test
    public void IstIdZuGroßThrowIllArg(){
        Buerohengst buerohengst = new Buerohengst(5000, "jeff", 12);
        assertThrows(IllegalArgumentException.class,
                ()->{
                    buerohengst.setId(6000);
                });
    }

    @Test
    public void IstFestgehaltKleinerNullThrowIllArg(){
        Buerohengst buerohengst = new Buerohengst(5000, "jeff", 12);
        assertThrows(IllegalArgumentException.class,
                ()->{
                    buerohengst.setFestgehalt(0);
                });
    }
}