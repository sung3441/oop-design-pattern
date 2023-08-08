package study.part1.chapter3.enum_before;

public class Main {

    public static void main(String[] args) {
        CalculateCommand calculateCommand = new CalculateCommand(CalculateType.ADD, 2, 1);
        Client client = new Client();
        int result = client.someMethod(calculateCommand);

        System.out.println("result = " + result);
    }
}
