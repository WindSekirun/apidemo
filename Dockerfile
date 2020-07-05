FROM openjdk:8-jdk-alpine

RUN apk update && apk add --no-cache bash tzdata
ENV TZ Asia/Seoul

ADD build/libs/*.jar apidemo.jar
ENTRYPOINT ["java", "-jar", "apidemo.jar"]