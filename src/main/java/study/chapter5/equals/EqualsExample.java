package study.chapter5.equals;

public class EqualsExample {

    public static void main(String[] args) {
        SomeObject someObject1 = new SomeObject(1, "some");
        SomeObject someObject2 = new SomeObject(1, "some");

        SomeObject anotherObject = new SomeObject(100, "some");
        SomeObject sameObject = anotherObject;

        // 동일성 비교 : false
        System.out.println(someObject1 == someObject2);

        // 동등성 비교 : true
        System.out.println(someObject1.equals(someObject2));

        // 동등성 비교 : false
        System.out.println(someObject1.equals(anotherObject));

        // 동일성 비교 : true
        System.out.println(anotherObject == sameObject);
    }
}
