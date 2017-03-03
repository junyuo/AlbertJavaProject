package albert.practice.lambda;

import org.junit.Before;
import org.junit.Test;

public class LambdaTestExample2Test {

    private LambdaTestExample2 test;

    @Before
    public void setup() {
        test = new LambdaTestExample2();
    }
    
    @Test
    public void testGreetAllBirthdayChildren() {
        test.greetAllBirthdayChildren();
    }

}
