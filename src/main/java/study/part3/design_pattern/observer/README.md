# Observer Pattern

어떤 대상의 상태 변화에 관심 있어하는 대상들에게 상태가 변화 됐다고 전파할 수 있는 패턴

- 게시글 작성 시
  - 문자 메시지 발송
  - 알림톡 발송
  - 이메일 발송

### 패턴이 필요한 경우

```java
public ... createPost(...) {
    postRepository.save(...);
    
    smsSender.send(...);
    kakaoSender.send(...);
    emailSender.send(...);
}
```

- 댓글 작성 시
    - 문자 메시지 발송
    - 알림톡 발송
    - 이메일 발송

```java
public ... createPost(...) {
    postRepository.save(...);
    
    smsSender.send(...);
    kakaoSender.send(...);
    emailSender.send(...);
}

public ... createComment(...) {
    commentRepository.save(...);

    smsSender.send(...);
    kakaoSender.send(...);
    emailSender.send(...);
}
```

위 코드는 알림이 필요한 경우 중복 되는 코드가 계속 늘어난다.

### 개선 - 클래스 생성

```java
class AlarmService {
    // ...
    
    public void sendAlarm() {
        smsSender.send(...);
        kakaoSender.send(...);
        emailSender.send(...);
    }
}

public ... createPost(...) {
    postRepository.save(...);

    alarmService.sendAlarm();
}

public ... createComment(...) {
    commentRepository.save(...);

    alarmService.sendAlarm();
}
```

위 코드의 구조상 다른 알림 발송 매체를 추가하거나, 제거하는 것이 힘듦

### 개선 - 옵저버 패턴

```java
class AlarmPublisher {
    private List<AlarmSubscriber> alarmSubscribers = new ArrayList();
    
    public void sendAlarm(...) {
        alarmSubscribers.forEach((subscriber) -> {
            subscriber.send(...);
        });
    }
    
    public void addSubscriber(...) {
        // alarmSubscribers에 새로운 알림 매체 추가
    }

    public void removeSubscriber(...) {
        // alarmSubscribers에 해당 알림 매체 제거
    }
}

interface AlarmSubscriber {
    void send(...);
}

class SmsSender implements AlarmSubscriber {
    @Override
    public void send(...) {
        // 문자 발송
    }
}
```

### 패턴의 장점

- 이벤트가 발생되는 곳에서 이벤트를 처리하는 주체들로의 의존성을 제거  
- 실행 시점에 이벤트 구독 대상을 추가하거나 제거