# 최신 11-jdk 이미지로 부터 시작
FROM openjdk:11-jdk

# 인자 정리
ARG JAR_FILE=build/libs/*.jar

# 앞에는 HOST OS의 현재 폴더를 의미
# 뒤에는 컨테이너의 현재 폴더(WORKDIR)를 의미
COPY ${JAR_FILE} app.jar

# docker container에서 실행되는 명령어
ENTRYPOINT ["java","-jar","/app.jar"]