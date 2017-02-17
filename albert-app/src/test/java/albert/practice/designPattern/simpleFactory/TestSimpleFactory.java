package albert.practice.designPattern.simpleFactory;

import org.junit.Test;

public class TestSimpleFactory {

    @Test
    public void testBlackTea() {
        Order order = OrderFactory.createOrder(TeaEnum.BLACK_TEA);
        order.acceptOrder();
        order.processOrder();
        order.deliverOrder();
    }
    
    @Test
    public void testGreenTea() {
        Order order = OrderFactory.createOrder(TeaEnum.GREEN_TEA);
        order.acceptOrder();
        order.processOrder();
        order.deliverOrder();
    }
    
    @Test
    public void testOolongTea() {
        Order order = OrderFactory.createOrder(TeaEnum.OOLONG_TEA);
        order.acceptOrder();
        order.processOrder();
        order.deliverOrder();
    }

}
