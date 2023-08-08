package study.chapter10.with_stream_optional;

import java.util.ArrayList;
import java.util.List;

public class DuplicateLoginId {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("test1", "김"));
        list.add(new User("test2", "나"));
        list.add(new User("test3", "박"));
        list.add(new User("test4", "이"));

        String newId = "test3";

        list.stream()
                .filter(u -> u.sameId(newId))
                .findAny()
                .ifPresentOrElse(
                        user -> {
                            throw new RuntimeException(String.format("[%s] 가 중복 됩니다.", newId));
                        },
                        () -> System.out.println(String.format("[%s] 를 사용할 수 있습니다.", newId))
                );
    }

    static class User {
        String id;
        String name;

        public User(String id, String name) {
            this.id = id;
            this.name = name;
        }

        boolean sameId(String id) {
            return this.id.equals(id);
        }
    }
}
