package albert.practice.designPattern.template;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Game pokeMonGo;
    private Game spellTower;
    
    @Before
    public void setup() {
        pokeMonGo = new PokeMonGo();
        spellTower = new SpellTower();
    }
    
    @Test
    public void testGame() {
        pokeMonGo.play();
        spellTower.play();
    }
    
}
