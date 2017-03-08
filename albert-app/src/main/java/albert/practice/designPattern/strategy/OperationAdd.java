package albert.practice.designPattern.strategy;

public class OperationAdd implements CalculationStrategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }

}
