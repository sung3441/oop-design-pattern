package study.chapter10.with_stream_optional;

import java.util.Arrays;
import java.util.List;

public class StreamOptionalMain {

    public static void main(String[] args) {
        int[] integerArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> integerList = Arrays.stream(integerArray)
                .boxed()
                .toList();

        Integer findNumber = integerList.stream()
                .filter(i -> i.equals(1234))
                .findAny()
                .orElseThrow();

        System.out.println("findNumber = " + findNumber);
    }
}
