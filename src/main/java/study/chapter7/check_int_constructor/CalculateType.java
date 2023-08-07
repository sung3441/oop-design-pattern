package study.chapter7.check_int_constructor;

import java.util.function.BiFunction;

public enum CalculateType {
    ADD(Integer::sum),
    SUB((num1, num2) -> num1 - num2),
    MUL((num1, num2) -> num1 * num2),
    DIV((num1, num2) -> num1 / num2);

    CalculateType(BiFunction<Integer, Integer, Integer> expression) {
        this.expression = expression;
    }

    private final BiFunction<Integer, Integer, Integer> expression;

    public int calculate(int num1, int num2) {
        return this.expression.apply(num1, num2);
    }
}
