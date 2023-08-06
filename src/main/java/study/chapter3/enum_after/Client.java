package study.chapter3.enum_after;

public class Client {

    public int someMethod(CalculateCommand calculateCommand) {
        CalculateType calculateType = calculateCommand.getCalculateType();
        int num1 = calculateCommand.getNum1();
        int num2 = calculateCommand.getNum1();

        int result = calculateType.calculate(num1, num2);
        return result;
    }
}
