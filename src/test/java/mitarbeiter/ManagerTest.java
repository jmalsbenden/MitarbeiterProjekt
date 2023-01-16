package mitarbeiter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    public void IstBonusKleinerNullThrowIllArg(){
        Manager manager = new Manager(5000, "jeff", 12, 23);
        assertThrows(IllegalArgumentException.class,
                ()->{
                    manager.setBonusSatz(0);
                });
    }

    @Test
    public void IstIdZuKleinThrowIllArg(){
        Manager manager = new Manager(5000, "jeff", 12,23);
        assertThrows(IllegalArgumentException.class,
                ()->{
                    manager.setId(4999);
                });
    }
    @Test
    public void IstIdZuGroßThrowIllArg(){
        Manager manager = new Manager(5000, "jeff", 12,23);
        assertThrows(IllegalArgumentException.class,
                ()->{
                    manager.setId(5100);
                });
    }

}