package study.part1.chapter9.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterMapMain {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // stream 적용 전
        List<Integer> forList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                forList.add(list.get(i) * 10);
            }
        }

        // stream 적용 후
        List<Integer> filterMapList = list.stream().filter(i -> i % 2 == 0).map(i -> i * 10).collect(Collectors.toList());
    }
}
