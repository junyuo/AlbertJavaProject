package albert.practice.designPattern.simpleFactory;

public class OrderFactory {

    public static Order createOrder(TeaEnum teaName) {
        Order order = null;
        if (teaName == TeaEnum.BLACK_TEA) {
            order = new BlackTea();
        } else if (teaName == TeaEnum.GREEN_TEA) {
            order = new GreenTea();
        } else if (teaName == TeaEnum.OOLONG_TEA) {
            order = new OolongTea();
        }
        return order;
    }
}
