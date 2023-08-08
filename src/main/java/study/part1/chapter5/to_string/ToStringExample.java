package study.part1.chapter5.to_string;

public class ToStringExample {

    public static void main(String[] args) {
        SomeObject someObject1 = new SomeObject(1, "some");
        SomeObject someObject2 = new SomeObject(100, "another");

        System.out.println(someObject1);
        System.out.println(someObject2);
    }
}
