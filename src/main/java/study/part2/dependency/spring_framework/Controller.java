package study.part2.dependency.spring_framework;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @RequestMapping(value = "/some-api")
    public void someApi() {
        service.createArticle("test data");
    }
}
