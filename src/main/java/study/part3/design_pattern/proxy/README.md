# Proxy Pattern

원래 객체를 대신하여 요청을 받아, 원래 객체를 호출하기 전이나 후에 특정 로직을 실행

### 구현 방법

```java
public interface SomeInterface {
    void someMethod();
}

public class Service implements SomeInterface {
    @Override
    public void someMethod() {
        // ...
    }
}

public class Proxy implements SomeInterface {
    
    private Service service;
    
    public Proxy() {
        this.service = new Service();
    }
    
    @Override
    public void someMethod() {
        // ... 실행 전 로직
        
        service.someMethod();
        
        // ... 실행 후 로직
    }
}

public class Client {
    public final SomeInterface someInterface;
    
    public Client(SomeInterface someInterface) {
        this.someInterface = someInterface;
    }
    
    public void someClientMethod() {
        someInterface.someMethod();
    }
}

public class ProxyPatternMain {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        Client client = new Client(proxy);
        
        client.someClientMethod();
    }
}
```

### AOP

Aspect Oriented Programming: 관점 지향 프로그래밍

```text
어떤 로직을 핵심적인 로직과 부가적인 로직으로 나누고, 반복되는 부가적인 로직을 분리하여 감추는 것
-> 어떤 로직에서 부가적인 로직이 없어지고, 핵심적인 로직만 남기 때문에 핵심적인 로직의 가독성이 올라간다.
```

핵심 로직: 게시글 작성, 댓글 작성 등..
부가 로직: 게시글 작성 알림, 댓글 작성 알림 등..

#### AOP 적용

ex) @SendAlarm이라는 어노테이션이 붙어 있는 메서드 실행 후에 특정 기능 실행

```java
@Around("@annotation(SendAlarm)")
public void sendAlarm(ProceedingJoinPoint pjp) {
    Object returnValue = pjp.proceed();
    
    alarmPublisher.sendAlarm(...);
}

@SendAlarm
public ... createPost(...) {
    postRepository.save(...);    
}

@SendAlarm
public ... createComment(...) {
    commentRepository.save(...);
}
```

#### Self Invocation

- Proxy 객체가 아닌 진짜 객체 내부에서 this.xxx() 를 실행하는 경우

```java
@SendAlarm
public ... createPost(...) {
    postRepository.save(...);
}

@SendAlarm
public ... createComment(...) {
    commentRepository.save(...);
    this.createPost(...);
}
```

### 패턴의 장점

- 핵심적인 로직들 사이에 있는 반복되는 부가 로직을 묶어내고 감출 수 있음
- 코드가 아닌 어노테이션을 통해 aop 설정을 하면 메서드에는 핵심 로직만 남게 된다.