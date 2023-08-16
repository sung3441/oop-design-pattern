# Facade Pattern

Facade: 건물의 정면 (출입구가 있는)

### 패턴이 필요한 상황

#### 중복되는 로직이 있을 때

특정 로직이 여러 클래스의 메서드에서 중복 되는 경우, 이 로직을 처리하는 클래스를 별도로 생생해서 처리할 수 있다.

- 패턴이 적용 전

```java
class Some1Service {
    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private DeliveryRepository deliveryRepository;
    
    public void order(Order order) {
        productRepository.reduceQuantity(order);    // 제품 수량 - 주문 수량
        orderRepository.save(order);                // 주문 저장
        deliveryRepository.delivery(order);         // 배송 시작
        
        // ... 그 외 로직
    }
}

class Some2Service {
    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private DeliveryRepository deliveryRepository;

    public void order(Order order) {
        productRepository.reduceQuantity(order);    // 제품 수량 - 주문 수량
        orderRepository.save(order);                // 주문 저장
        deliveryRepository.delivery(order);         // 배송 시작

        // ... 그 외 로직
    }
}
```

- 패턴 적용 후

```java

class Some1Service {
    private FacadeCreateOrder facadeCreateOrder;

    public void order(Order order) {
        facadeCreateOrder.order(order);

        // ... 그 외 로직
    }
}

class Some2Service {
    private FacadeCreateOrder facadeCreateOrder;

    public void order(Order order) {
        facadeCreateOrder.order(order);

        // ... 그 외 로직
    }
}

class FacadeCreateOrder {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private DeliveryRepository deliveryRepository;

    public void order(Order order) {
        productRepository.reduceQuantity(order);    // 제품 수량 - 주문 수량
        orderRepository.save(order);                // 주문 저장
        deliveryRepository.delivery(order);         // 배송 시작

        // ... 그 외 로직
    }
}
```

#### 순환 참조가 발생하는 경우

- 서로 참조를 한다는 것은 변경이 있을 경우 양 쪽 전부 코드 수정이 필요하다.
- 퍼사드 패턴을 사용하면 순환 참조를 방지할 수 있다.

### 퍼사드 패턴의 장점

- 복잡한 로직 호출을 캡슐화 해서, 간단한 인터페이스 호출만으로 동일한 동작을 하게 만든다.
- 복잡한 A로직의 내용이 바뀌어도 그 변경의 여파가 퍼사드 클래스에서 끝난다.