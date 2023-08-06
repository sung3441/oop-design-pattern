package study.chapter3.enum_before;

public class Client {

    public int someMethod(CalculateCommand calculateCommand) {
        CalculateType calculateType = calculateCommand.getCalculateType();
        int num1 = calculateCommand.getNum1();
        int num2 = calculateCommand.getNum2();

        int result = 0;

        if (calculateType.equals(CalculateType.ADD)) {
            result = num1 + num2;
        } else if (calculateType.equals(CalculateType.SUB)) {
            result = num1 - num2;
        } else if (calculateType.equals(CalculateType.MUL)) {
            result = num1 * num2;
        } else if (calculateType.equals(CalculateType.DIV)) {
            result = num1 / num2;
        }

        return result;
    }
}
