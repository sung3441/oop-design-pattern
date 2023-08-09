package study.part2.dependency.spring_framework;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")
@Component
public class DatabaseRepository implements Repository {

    @Override
    public void someMethod(String articleContent) {
        System.out.println("DatabaseRepository.someMethod");
    }
}
