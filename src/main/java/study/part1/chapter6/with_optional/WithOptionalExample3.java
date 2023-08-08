package study.part1.chapter6.with_optional;

import java.util.Optional;

public class WithOptionalExample3 {

    public static void main(String[] args) {
        MapRepository mapRepository = new MapRepository();
        String string = Optional.ofNullable(mapRepository.getValue("TEST"))
                .orElseThrow(RuntimeException::new);

        System.out.println(string.toUpperCase());
    }
}
