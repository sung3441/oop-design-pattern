package study.chapter5.hash_code;

import java.util.HashSet;
import java.util.Set;

public class HashCodeExample {

    public static void main(String[] args) {
        // Hash 관련 컬렉션이 같은 인스턴스를 구분하는 방법
        // hashCode 비교 -> equals 비교
        SomeObject sameObject1 = new SomeObject(1, "some");
        SomeObject sameObject2 = new SomeObject(1, "some");

        Set<SomeObject> set = new HashSet<>();

        set.add(sameObject1);
        set.add(sameObject2);

        System.out.println(set.size());
    }
}
