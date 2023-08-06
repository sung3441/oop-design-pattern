# 상속과 다형성

1. private 필드와 메서드는 상속 되지 않는다.
2. 부모 타입에 자식 인스턴스를 할당할 수 있다. (다형성)
   - ```Parent ParentTypeChild = new Child();```
   - ```Parent 클래스의 메서드인 printChild()는 parentTypeChild가 호출할 수 없다.```
     - 실제 parentTypeChild에 들어있는 인스턴스는 Child이지만 변수의 타입은 Parent이므로.

### 주의 사항

- 메서드를 재사용하기 위해 상속 받는 것은 좋지 않음
  - 메서드를 재사용 하려면 전략 패턴 구성(Composite) 활용
- 필드를 재사용할 때는 ok
- 부모 타입이 할 수 있는 일은 자식 타입도 할 수 있어야 함
  - 리스코프 치환 원칙을 지켜야 함 (다형성)