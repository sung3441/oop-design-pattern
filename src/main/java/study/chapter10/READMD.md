# stream API, Optional

### Stream API는 for문 보다 느린가

- 경우에 따라 다르지만, 실제로 느릴 수 있음 
- 가독성 우선하여 개발 후 성능이 필요한 경우 튜닝
- 성능과, 가독성으로 고민 될 때, 가독성 우선으로 개발 후 성능 튜닝하라는 의미!

[Stream API 성능 관련 포스팅](https://bit.ly/3UmoGTz)

### Parallel Stream

- stream api와 다르게 병렬, 멀티 쓰레드로 실행 가능
- 상황에 따라 성능이 향상될 수 있지만, 순서를 보장할 수 없음