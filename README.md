## APIDemo

Spring Boot 2 + Kotlin 으로 서비스 만들고 배포하기 

### 기능
* 서버 시간을 가져오는 API 만들기
* Swagger 2 로 API 문서 만들기
* Docker로 배포하기 

### 빌드

JAR 파일은 아래와 같이 컴파일 가능합니다.

```shell script
./gradlew build
```

도커 이미지는 아래와 같이 빌드 가능합니다.

```shell script
docker build -t windsekirun/apidemo .
```

### 사용

```shell script
docker run -d -p 8080:8080 windsekirun/apidemo
```

* API 문서: http://localhost:8080/swagger-ui.html
* 서버 시간 API: GET http://localhost:8080/api/time

또는, docker-compose를 사용하고 있다면 아래와 같이 사용하세요.
```shell script
dcoker-compose up -d --build
```