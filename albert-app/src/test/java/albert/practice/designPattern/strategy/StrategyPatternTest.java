package albert.practice.designPattern.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StrategyPatternTest {

    Context addContext;
    Context subtractContext;
    Context multiplyContext;
    Context divideContext;

    @Before
    public void setup() {
        addContext = new Context(new OperationAdd());
        subtractContext = new Context(new OperationSubstract());
        multiplyContext = new Context(new OperationMultiply());
        divideContext = new Context(new OperationDivide());
    }

    @Test
    public void testOperation() {
        assertEquals(35, addContext.executeStrategy(10, 25));
        assertEquals(5, subtractContext.executeStrategy(15, 10));
        assertEquals(20, multiplyContext.executeStrategy(5, 4));
        assertEquals(20, divideContext.executeStrategy(60, 3));
    }

}
