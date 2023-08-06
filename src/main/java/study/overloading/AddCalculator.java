package study.overloading;

public class AddCalculator {

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public long add(long num1, long num2) {
        return num1 + num2;
    }

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public static void main(String[] args) {
        AddCalculator cal = new AddCalculator();
        cal.add(1, 1);
        cal.add(1L, 1L);
        cal.add(1.0, 1.0);
    }
}
