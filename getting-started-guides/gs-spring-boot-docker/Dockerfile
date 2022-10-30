

# Example 1. Dockerfile
FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


# Example 2. Dockerfile
#FROM openjdk:8-jdk-alpine
#
##RUN addgroup -S spring && adduser -S spring -G spring
##USER spring:spring
#
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]


# Example 3. Dockerfile
#FROM openjdk:8-jdk-alpine
#
##RUN addgroup -S spring && adduser -S spring -G spring
##USER spring:spring
#
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","hello.Application"]
