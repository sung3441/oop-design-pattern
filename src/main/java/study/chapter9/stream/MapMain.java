package study.chapter9.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapMain {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // stream 적용 전
        List<Integer> forList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            forList.add(list.get(i) * 10);
        }

        // stream 적용 후
        List<Integer> mapList = list.stream().map(i -> i * 10).toList();
    }
}