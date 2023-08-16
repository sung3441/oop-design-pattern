# Singleton Pattern

해당 클래스의 인스턴스를 오직 하나만 만들 수 있도록 제한하는 패턴  
인스턴스를 새로 생성하는 때는 자원(메모리, 시간)을 소모

### 패턴이 필요한 상황

- http request를 받을 때 마다 Controller나 Service 클래스를 새로 생성하면 너무 많이 시간과 자원이 소모된다.

### 패턴을 사용해도 충분한 이유

- 다른 쓰레드와 공유 되어도 문제가 없는 상황에서 사용해야 한다.
- 인스턴스가 다른 참조 변수를 가지고 있더라도, 참조 변수로 인해 로직에 영향을 주지 않는 경우 "무상태성 빈" 이라고 부른다.
- 무상태성 빈 <-> 싱글턴 bean 서로의 조건을 만족하는 경우 사용하면 성능상 이득을 볼 수 있다.

### 구현 코드

```java
class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

### 패턴이 사용되는 경우

- Database Connection Pool
- Thread Pool
- xxxPool이 들어가는 경우 Singleton으로 구현 됐을 확률이 높다.

### 패턴의 장점

- 하나의 인스턴스만 만들어서 성능상 이점
  - 플라이웨이트 패턴과 유사