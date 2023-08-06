package study.chapter2.abstract_class;

public class Main {

    public static void main(String[] args) {
        AbstractClass abstractClass = new AbstractClass() {
            @Override
            public void abstractMethod() {
                System.out.println("Main.abstractMethod");
            }
        };

        abstractClass.implementMethod();
        abstractClass.abstractMethod();

        AbstractClass extendedClass = new ExtendedClass();
        extendedClass.implementMethod();
        extendedClass.abstractMethod();
    }
}
