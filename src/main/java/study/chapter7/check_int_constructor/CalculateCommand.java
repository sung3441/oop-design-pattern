package study.chapter7.check_int_constructor;

public class CalculateCommand {

    private final CalculateType calculateType;
    private final int num1;
    private final int num2;

    public CalculateCommand(CalculateType calculateType, int num1, int num2) {

        if (calculateType == null) {
            throw new RuntimeException("CalculateType은 필수 입니다.");
        }

        if (calculateType.equals(CalculateType.DIV) && num2 == 0) {
            throw new RuntimeException("0으로 나눌 수 없습니다.");
        }

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
