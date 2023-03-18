FROM amd64/eclipse-temurin:17-jre-alpine

# fix error with linux-amd64-alpine
RUN apk add gcompat
ENV LD_PRELOAD=/lib/libgcompat.so.0

COPY build/libs/stammdaten-service.jar /opt/

EXPOSE 9200

CMD ["java", "-jar", "/opt/stammdaten-service.jar", "-p", "9200"]
