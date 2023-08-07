package study.chapter6.with_optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapRepository {

    private Map<String, String> map = new HashMap<>();

    public MapRepository() {
        map.put("TEST", "value");
    }

    public Optional<String> getOptionalValue(String key) {
        return Optional.ofNullable(map.get(key));
    }

    public String getValue(String key) {
        return map.get(key);
    }
}
