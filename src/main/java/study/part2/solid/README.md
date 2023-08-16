# SOLID

의존성이 잘못 관리될 경우 변경하기 어렵고 재사용하기 어려운 코드  
의존성이 잘 관리된 코드는 유연하며 재사용이 가능한 코드. (결합도는 낮고, 응집도가 높은 코드)  
의존성을 잘 관리하기 위한 5가지 원칙이 solid원칙이다.

## 5가지 원칙

- SRP : Single Responsibility Principle
- OCP : Open Closed Principle
- LSP : Lskov Substitution Principle
- ISP : Interface Segregation Principle
- DIP : Dependency Inversion Principle

### SRP:단일 책임 원칙

하나의 클래스는 하나의 책임만을 가져야 한다.

```text
단일 책임 원칙을 지키는 코드는 각각의 클래스가 응집력이 높기 때문에 코드의 재사용성이
높아지고, 캡슐화를 통해 한 클래스의 변경이 다른 클래스에 영향을 미치지 않도록 만든다.
```

### OCP:개방 폐쇄 원칙

소프트웨어는 확장에는 열려 있고, 변경에는 닫혀 있어야 한다.

```text
개방 폐쇄 원칙을 지키는 코드는 클라이언트 코드가 추상화에 의존하고 있기
때문에 확장될 때와 변경될 때 모두 다른 코드에 영향을 주지 않게 만든다.
```

#### 꼭 인테페이스가 필요하지는 x

enum, design pattern, 이벤트 기반 프로그래밍 등을 사용할 수도 있음

### LSP:리스코프 치환 원칙

부모 클래스가 할 수 있는 행동은 자식 클래스도 할 수 있어야 한다.

```text
리스코프 치환 원칙을 지키는 코드는 진정한 의미에서의 다형성을 제공해주기
때문에 코드의 분기 없이도 올바르게 확장 가능한 코드를 만든다.
```

#### 부모 클래스가 할 수 있는걸 자식이 할 수 없는 상황

```java
public class Parent {
    public void someMethod(int input) {
        // input 상관에 상관 없이 메서드 호출
        System.out.println("Parent 호출");
    }
}

public class Child extends Parent {
    @Override
    public void someMethod(int input) {
        if (input <= 0) {
            throw new RuntimeException("잘못된 입력 입니다.");
        }
        System.out.println("Child 호출");
    }
}

public class Client {
    public static void main(String[] args) {
        Parent parentOrChild = new Parent();
        parentOrChild.someMethod(-1); // Runtime exception
    }
}
```

Parent에서는 -1을 입력 받았을 때 결과를 도출할 수 있지만, Child에서는 -1을 가지고 결과를 도출 x

#### 계약에 의한 설계

사전 조건은 자식 클래스에서 더 강해지면 x

### ISP:인터페이스 분리 원칙

클라이언트 별로 세분화된 인터페이스를 만들어야 한다.

```text
인터페이스 분리 원칙을 지키는 코드는 구현 클래스에는 불필요한 메서드를 구현하지 않도록 만들고,
인터페이스를 사용하는 클래스에게는 불필요한 메서드를 노출 시키지 않아 유지 보수하기 좋은 코드를 만들어준다.
```

#### SRP와 차이점
__SRP__ 와 결과는 비슷하나 분리의 관점이 다르다.  
SRP: 책임을 하나만 두기 위해 분리  
ISP: 구현 클래스에서 구현하지 않거나, 클라이언트가 사용되지 않는 메서드를 분리

### DIP:의존 역전 원칙

고수준 컴포넌트는 저수준 컴포넌트에 의존하지 않아야 한다.

```text
의존 역전 원칙을 지키는 코드는 인터페이스를 통해 고수준 컴포넌트가 더 이상 저수준
컴포넌트에 의존하지 않도록 만드는 것으로, 의존 방향이 역전 되기 때문에 의존 역전이라고 한다.
```

#### OCP와 차이점

구현 클래스에 직접 의존하지 않고 인터페이스를 추가하여 문제를 해결하는 방법은 비슷하다.
OCP: 프로그램이 확장될 때 다른 코드들이 영향을 받지 않으면 ok
DIP: 고수준 컴포넌트가 저수준 컴포넌트에 의존하지 않으면 ok

#### 간접적으로 의존 역전 원칙이 깨지는 상황

```java
public class Service {
    private Repository repository;
    
    public Object findById(Long id) {
        Object obj = null;
        
        try {
            obj = repository.findById(id);
        } catch (RecordNotFoundException recordNotFoundException) {
            // ...
        } catch (TextNotFoundException textNotFoundException) {
            // ...
        } catch (NoSuchNotFoundException noSuchNotFoundException) {
            // ...
        }
        
        return obj;
    }
}
```

위 코드의 경우 특정 Repository 구현체가 추가 될 때 catch가 추가 되어야 한다.  
즉, Service 코드도 같이 수정 되므로, OCP와 DIP를 위반한다.

- 해결법 : NotFoundException의 의미를 가지는 추상 클래스를 만들어서 던진다.
- ex) EntityNotFoundException으로 공통 처리

```java
public class Service {
    private Repository repository;
    
    public Object findById(Long id) {
        Object obj = null;
        
        try {
            obj = repository.findById(id);
        } catch (EntityNotFoundException entityNotFoundException) {
            // ...
        }
        
        return obj;
    }
}
```

## 객체지향의 4대 원칙

- 캡슐화
- 상속
- 추상화
- 다형성