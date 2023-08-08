# Optional

### Optional 사용한 코드와 사용 하지 않은 코드

- 사용한 코드
```java
stream.getFirst().orElseThrow(() -> new MyException())
```

- 사용하지 않은 코드
```java
Object o = stream.getFirst();

if (o == null) {
    new MyException();
}
```

두 코드의 차이는 깔끔함의 차이도 있지만, 결정적인 차이는 객체를 가져오는 행위와  
가져온 결과가 null 이면 예외를 던지는 행위가 함께 있는 것과 분리 되어 있는 차이다.

### Optional 인스턴스 생성 메서드

- Optional.of();
- Optional.ofNullable();
- Optional.empty();

### Optional 활용

- 사용 중인 메서드 반환 타입이 Optional인 경우
  - orElseThrow 같은 메서드로 사용
- Optional이 아닌 경우
  - Optional.ofNullable로 Optional 객체 생성 후 orElseThrow 같은 메서드 사용

### Optional 사용 시 주의사항

[Optional 사용 시 주의사항 26](https://dzone.com/articles/using-optional-correctly-is-not-optional)