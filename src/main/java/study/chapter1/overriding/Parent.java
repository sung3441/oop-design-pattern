package study.chapter1.overriding;

public class Parent {

    public int parentPublic;

    protected int parentProtected;

    private int parentPrivate;

    public void parentPublicMethod() {
        System.out.println("Parent.parentPublicMethod");
    }

    protected void parentProtectedMethod() {
        System.out.println("Parent.parentProtectedMethod");
    }

    private void parentPrivateMethod() {
        System.out.println("Parent.parentPrivateMethod");
    }
}
