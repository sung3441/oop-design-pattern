package study.chapter2.interface_;

public class ImplementsClass implements SomeInterface, AnotherInterface {

    @Override
    public void anotherMethod() {
        System.out.println("ImplementsClass.anotherInterface");
    }

    @Override
    public void someMethod() {
        System.out.println("ImplementsClass.someMethod");
    }
}
