# 의존 관계

- 의존성이 강하면 변화에 취약하다.
- 프로그래밍에서 의존성은 클래스 간의 의존을 얘기한다.
1. 다른 클래스의 레퍼런스 변수를 사용하는 경우
2. 다른 클래스의 인스턴스를 생성하는 경우
3. 다른 클래스를 상속 받는 경우

### 의존성 개선

#### 인터페이스를 통한 의존 관계 맺기

- 클래스가 아닌 인터페이스에 의존하는 것이 더 유연하고, 테스트하기 에도 용이
```java
// before
class GoogleLoginProvider {
    User login() {
        //...
    }
}

User user = GoogleLoginProvider().login();
```
```java
// after
interface LoginProvider {
    User login();
}

class GoogleLoginProvider implements LoginProvider {
    
    @Override
    User login() {
        //...
    }
}

User user = LoginProvider.login();
```

#### 필드를 공개하지 않는 방법

- 클래스의 필드를 공개하지 않고 (private), 메서드만 공개해서 의존성을 낮출 수 있음
```java
// before
class Product {
    public int price;
    public int quantity;
    // ...
}

class Client {
    public int getTotalPrice(Product product) {
        return product.price * product.quantity;
    }
}
```
```java
// after
class Product {
    private int price;
    private int quantity;
    
    public int getTotalPrice() {
        return this.price * this.quantity;
    }
}

class Client {
    public int getTotalPrice(Product product) {
        return product.getTotalPrice();
    }
}
```
### 강한 의존과 약한 의존 - 클래스 간의 의존 관계

- 강한 의존: A클래스가 B클래스에 직접 의존하는 것
- 약한 의존: B클래스가 C인터페이스를 상속 받고, A클래스가 C인터페이스를 의존하며 B클래스를 사용할 때


# 의존 역전

- __고수준 컴포넌트__ 가 __저수준 컴포넌트__ 에 의존하지 않도록 의존 관계를 역전 시키는 것
- 컴포넌트: 클래스
- 고수준 컴포넌트
  - 구체적인 기술을 사용하지 않는 클래스 
  - 기술에 종속적이지 않음
  - ex) service, 정책, 비즈니스 로직 등
- 저수준 컴포넌트
  - 구체적인 기술을 사용하는 클래스, 기술에 종속적
  - ex) repository impl, controller 등
- 의존 역전을 하지 않은 의존성: controller -> service (고수준) -> repository impl (저수준)

### 의존 역전 방법

- interface를 사용해서 저수준 컴포넌트가 고수준 컴포넌트에 의존하도록 변경
- controller -> service (고수준) -> repository interface(고수준) <- repository impl (저수준)

# 의존 주입 패턴

- 의존 하고 있는 컴포넌트의 구현체를 다른 곳에서 주입 받는 패턴

### 의존 관계가 생기는 경우

1. 클래스 또는 인터페이스의 레퍼런스 변수 사용
2. 클래스의 인스턴스를 생성
3. 클래스 또는 인터페이스를 상속

### 의존 주입 패턴의 장점

- 어떤 클래스의 인스턴스를 사용할지 코드 수정 없이, 실행 시점에 지정할 수 있음

# 의존성을 주입 해주는 주체

- 의존, 의존성 -> Dependency
- 의존성 주입 -> Dependency Injection (DI)
- 의존 관계 역전 -> Dependency Inversion (DI)

특정 프로젝트에서 사용하고 있는 라이브러리를 __의존성__ 이라고 부름