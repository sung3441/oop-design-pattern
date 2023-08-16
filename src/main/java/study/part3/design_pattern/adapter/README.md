# Adapter pattern

220V 동그란 포트 -> 110V 네모난 포트

- 포트 모양의 변경 -> 인터페이스 변경
- 220V와 110V 사이의 변환 -> 호환을 위한 추가 동작

### 패턴을 적용될 수 있는 상황

- 아래 코드는 지저분한 인터페이스 (public 메서드)가 여러 코드에 퍼짐
- Service (class) -> FileStorage (class)

```java
class FileStorage {
    public File openFile(String fileName) {
        // 파일 열기
    }
    
    public String readFile(File file) {
        // 파일 읽기
    }
    
    public void saveFile(File file, String outputStr) {
        // 파일 저장
    }
}
```

- Adapter pattern 적용 후
- Service (class) -> repository (interface) <- FileStorageAdapter (class) -> FileStorage (class)

```java
interface Repository {
    User findById(Long id);
    void save(User user);
}

class FileStorageAdapter implements Repository {
    private FileStorage fileStorage = new FileStorage();
    private String filename = "...";
    
    @Override
    public User findById(Long id) {
        File file = fileStorage.openFile(filename);
        String fileContent = fileStorage.readFile(file);
        
        // find user logic...
        
        return user;
    }
    
    @Override
    public void save(User user) {
        File file = fileStorage.openFile(filename);
        String fileContent = fileStorage.readFile(file);
        
        // add user logic...
        
        fileStorage.saveFile(file, fileContent);
    }
}
```

### 적용 후 장점

- Service에서 FileStorage를 의존하지 않음
  - 고수준 컴포넌트가 저수준 컴포넌트에 의존하지 않음 -> DIP
- Service가 더 이상 FileStorage의 복잡한 인터페이스가 아닌, Repository의 추상적이고 간결한 인터페이스를 사용
  - 가독성 상향
  - FileStorage를 사용하던 클라이언트 코드는 FileStorageAdapter 안으로 캡슐화됨
- Repository interface를 추가함으로써 새로운 Repository 구현체를 쉽게 추가할 수 있다.
  - 확장에 열려있음-> OCP
- Service 클래스가 보호 받는다.
