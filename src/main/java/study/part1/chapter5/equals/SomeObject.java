package study.part1.chapter5.equals;

import java.util.Objects;

public class SomeObject {

    private final int intField;
    private final String stringField;

    public SomeObject(int intField, String stringField) {
        this.intField = intField;
        this.stringField = stringField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SomeObject)) return false;
        SomeObject that = (SomeObject) o;
        return intField == that.intField && Objects.equals(stringField, that.stringField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intField, stringField);
    }
}
