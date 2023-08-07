package study.chapter5.to_string;

import java.util.Objects;

public class SomeObject {

    private final int intField;
    private final String stringField;

    public SomeObject(int intField, String stringField) {
        this.intField = intField;
        this.stringField = stringField;
    }

    @Override
    public String toString() {
        return "SomeObject{" +
                "intField=" + intField +
                ", stringField='" + stringField + '\'' +
                '}';
    }
}
