package study.part1.chapter9.stream;

import java.util.Arrays;
import java.util.List;

public class ForEachMain {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // stream 적용 전
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // stream 적용 후
        list.stream().forEach(i -> System.out.println(i));
    }
}
