package study.chapter2.interface_;

public class Main {

    public static void main(String[] args) {
        SomeInterface someInterface = new ImplementsClass();
        AnotherInterface anotherInterface = new ImplementsClass();

        someInterface.someMethod();
        anotherInterface.anotherMethod();

        someInterface.defaultMethod();
    }
}
