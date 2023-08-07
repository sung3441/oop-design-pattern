package study.chapter6.with_optional;

public class WithOptionalExample2 {

    public static void main(String[] args) {
        MapRepository mapRepository = new MapRepository();
        String string = mapRepository.getOptionalValue("TEST").orElseThrow(
                () -> new RuntimeException("key 존재 x")
        );

        System.out.println(string.toUpperCase());
    }
}
