# microservice-coffeeshop
"자바 기반의 마이크로서비스 이해와 아키텍쳐 구축하기" 커피 전문점 서비스 프로젝트 실습 

[이론 정리 글](https://mingyum119.tistory.com/228)

### 서비스 설명

커피 주문 및 회원 확인, 주문 처리 상태를 조회하고 고객에게 알림 서비스를 제공하는 커피 전문점 서비스이다.

### 서비스 시스템 구성도

![image](https://user-images.githubusercontent.com/67851124/228434692-6c0887a0-cfc0-4260-b9bb-554482e3cd0d.png)

### 에코시스템 기동 순서  및 설명 

- `Kafka Server` : 커피주문 microservice에서 커피 주문 내역 메시지를 발행하고, 메시지 큐잉 시스템을 이용해서 메시지를 구독한 정보를 주문 처리 상태 확인 microservice가 수신 및 저장한다.
- `Config Server` : 마이크로서비스 프로파일 정보 관리
- `Eureka Server` : 마이크로서비스 등록 및 감지
- `Zuul Server` : Service Gateway. 클라이언트 요청에 대해 알맞는 마이크로서비스로의 로드 밸런싱 라우팅과 Circuir Breaker 등을 담당한다.
- `Turbine Server` : 마이크로서비스의 히스트릭스 클라이언트 스트림 메시지를 수집한다.
- `Hystrix Dashboard` : 터빈 서버에서 취합된 스트림 메시지를 대시보드에 보여준다.
