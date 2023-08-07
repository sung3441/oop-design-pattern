package study.chapter6.with_optional;

import java.util.Optional;

public class WithOptionalExample1 {

    public static void main(String[] args) {
        MapRepository mapRepository = new MapRepository();
        Optional<String> string = mapRepository.getOptionalValue("TEST");

        string.ifPresentOrElse(
                str -> System.out.println(str.toUpperCase()), // Optional이 empty가 아닐 때 실행
                () -> {
                    throw new RuntimeException("key 존재 x"); // Optional이 empty일 때 실행
                }
        );
    }
}
