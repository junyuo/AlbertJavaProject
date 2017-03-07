package albert.practice.designPattern.adapter;

import org.junit.Before;
import org.junit.Test;

public class DogAdapterTest {

    private DogAdapter taiwaneseDog;
    private DogAdapter shiba;
    private DogAdapter husky;

    @Before
    public void setup() {
        taiwaneseDog = new DogAdapter(new TaiwaneseDog());
        shiba = new DogAdapter(new Shiba());
        husky = new DogAdapter(new Husky());
    }

    @Test
    public void testTaiwaneseDog() {
        taiwaneseDog.bark();
        taiwaneseDog.eat();
        taiwaneseDog.walk();
    }
    
    @Test
    public void testShiba() {
        shiba.bark();
        shiba.eat();
        shiba.walk();
    }
    
    @Test
    public void testHusky() {
        husky.bark();
        husky.eat();
        husky.walk();
    }

}
