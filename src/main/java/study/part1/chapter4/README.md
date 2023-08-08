# 예외 (Exception)

## ```checked exception``` vs ```unchecked exception```

### checked exception 과 unchecked exception의 차이는?

#### 틀린 답변

- checked exception은 compile 시점에 발생하는 예외이고, unchecked exception은 runtime에 발생하는 예외이다.

#### 옳은 답변

- checked exceptino은 예외 처리를 강제하고, unchecked exception은 예외 처리를 강제하지 않는다.

### roll back 여부

- checked exception: roll back 하지 않음
- unchecked exception: roll back 됨

### unchecked exception을 권장

- checked exception을 써야 되는 명확한 이유가 있지 않으면 unchecked exception을 권장

## 예외 계층 구조

- Object
  - Throwable
    - Error
      - Error...
    - Exception
      - Checked Exception...
      - Runtime Exception
        - Unchecked Exception...