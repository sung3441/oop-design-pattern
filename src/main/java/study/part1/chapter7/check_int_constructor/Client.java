package study.part1.chapter7.check_int_constructor;

public class Client {

    public int someMethod(CalculateCommand calculateCommand) {
        CalculateType calculateType = calculateCommand.getCalculateType();
        int num1 = calculateCommand.getNum1();
        int num2 = calculateCommand.getNum2();

        return calculateType.calculate(num1, num2);
    }
}
