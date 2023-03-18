FROM amd64/eclipse-temurin:17-jre-alpine

# fix error with linux-amd64-alpine
RUN apk add gcompat
ENV LD_PRELOAD=/lib/libgcompat.so.0

COPY build/libs/projekt-service.jar /opt/

EXPOSE 9100

CMD ["java", "-jar", "/opt/projekt-service.jar", "-p", "9100"]
