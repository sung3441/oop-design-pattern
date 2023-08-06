package study.chapter3.enum_after;

public class CalculateCommand {

    private final CalculateType calculateType;
    private final int num1;
    private final int num2;

    public CalculateCommand(CalculateType calculateType, int num1, int num2) {
        this.calculateType = calculateType;
        this.num1 = num1;
        this.num2 = num2;
    }

    public CalculateType getCalculateType() {
        return calculateType;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}
