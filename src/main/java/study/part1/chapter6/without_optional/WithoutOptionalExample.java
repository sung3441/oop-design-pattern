package study.part1.chapter6.without_optional;

public class WithoutOptionalExample {

    public static void main(String[] args) {
        MapRepository mapRepository = new MapRepository();
        String string = mapRepository.getValue("TEST");

        System.out.println("string = " + string);

        if (string != null) {
            System.out.println(string.toUpperCase());
        }
    }
}
