package study.part1.chapter2.interface_;

public interface SomeInterface {

    public void someMethod();

    // default를 붙이면 interface에 메서드 정의 가능
    default void defaultMethod() {
        this.someMethod();
    }
}
