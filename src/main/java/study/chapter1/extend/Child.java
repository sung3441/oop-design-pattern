package study.chapter1.extend;

public class Child extends Parent {

    public void childMethod() {
        System.out.println(this.parentPublic);
        System.out.println(this.parentProtected);

        this.parentPublicMethod();
        this.parentProtectedMethod();
    }
}
