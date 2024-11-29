# msaInflearn

## 인프런 강의 따라하기

### ✅ 강좌명: Spring Cloud로 개발하는 마이크로서비스 애플리케이션(MSA)
### 👨‍💻 강사명: Dowon Lee
### 📌 정보
1. IntelliJ IDEA 2024.2.4
2. SpringBoot 3.3.5

### ⭐ 상세내용
#### [1] Service Discovery
* Spring Cloud Netflix Eureka
  1. @EnableDiscoveryClient

  2. @EnableEurekaServer


#### [2] Service 등록
1. User-service

2. 랜덤 포트 설정


#### [3] API GATEWAY 설정
1. Netflix Zuul
(※ 2018. 12. ~ : Maintenance Mode -> SpringBoot 2.4.x부터 제공되지 않음)

 2. Spring Cloud Gateway

    (1) Java Code 로 Routing 설정

    (2) Property 에서 Routing 설정

#### ※ spring-cloud-starter-gateway-mvc 를 주입하여 실행 시, apigateway-service의 Application.yml 설정 주의할 것.

3. Custom Filter 설정

4. Global Filter 설정

5. Logging Filter 설정

6. Load Balancer 설정 (Eureka Discovery Server + Random port)


#### [4] User-service 생성

1. User-service 기본 설정

2. H2 Database 연동

3. 회원가입(H2 Database save)

4. 비밀번호 암호화 설정

5. 기능 추가: 전체 사용자 조회, 아이디로 사용자 조회

#### [5] catalog-service 생성

1. catalog-service 기본 설정

2. H2 Database에 초기 데이터 INSERT

3. 기능 추가: 전체 카탈로그 조회

#### [6] order-service 생성

1. order-service 기본 설정

2. 기능 추가: 주문번호로 조회, 주문 추가

#### [7] 로그인 기능

1. WebSecurity, AuthenticationFilter 설정

2. JWT 인증 추가 (user-service)

3. 인가 추가(api gateway service)

#### [8] Config Service 

1. config-service 생성

2. user-service 에 config 서버 연결

3. Api Gateway에 Config 서버 연결

4. user-service, Api Gateway에 Actuator 설정 추가

5. multiple environment 추가

#### [9] Spring Cloud Bus (AMQP) 설정

1. RabbitMQ 설치

2. API Gateway Service, Config Server, User-service 에 rabbitMQ 설정 정보 등록

#### [10] Config 설정 정보 암호화

1. H2 Datasource password Encrypt #1 (대칭키)

2. H2 Datasource password Encrypt #2 (비대칭키)

#### [11] 마이크로서비스 간 통신

1. Rest Template 사용: User-service 에서 Order-service 호출

2. OpenFeign 사용: User-service 에서 Order-service 호출

#### [12] 예외 처리

1. Log 추가

2. FeignException 처리

3. FeginErrorDecoder 사용하여 에러 처리

