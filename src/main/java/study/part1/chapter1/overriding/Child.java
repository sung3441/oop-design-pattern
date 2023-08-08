package study.part1.chapter1.overriding;

public class Child extends Parent {

    public void childMethod() {
        System.out.println(this.parentPublic);
        System.out.println(this.parentProtected);

        this.parentPublicMethod();
        this.parentProtectedMethod();
    }

    @Override
    public void parentPublicMethod() {
        System.out.println("Child.parentPublicMethod");
    }

    @Override
    protected void parentProtectedMethod() {
        System.out.println("Child.parentProtectedMethod");
    }
}
