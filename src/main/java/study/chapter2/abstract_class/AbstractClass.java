package study.chapter2.abstract_class;

public abstract class AbstractClass {

    public void implementMethod() {
        System.out.println("AbstractClass.implementMethod");
        this.abstractMethod();
    }

    public abstract void abstractMethod();
}
