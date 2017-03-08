package albert.practice.designPattern.template;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Game pokeMonGo;
    private Game superMarioRun;
    
    @Before
    public void setup() {
        pokeMonGo = new PokeMonGo();
        superMarioRun = new SuperMarioRun();
    }
    
    @Test
    public void testGame() {
        pokeMonGo.play();
        superMarioRun.play();
    }
    
}
