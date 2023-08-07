package study.chapter4;

public class CheckedExceptionExample {

    public static void main(String[] args) throws CheckedException {

        // try-catch 로 예외 감싸기
        try {
            checkedExceptionMethod();
        } catch (CheckedException e) {
            throw new RuntimeException(e);
        }

        // throws 로 예외 던지기
        checkedExceptionMethod();
    }

    static void checkedExceptionMethod() throws CheckedException {
    }
}
