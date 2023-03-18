FROM amd64/eclipse-temurin:17-jre-alpine

# fix error with linux-amd64-alpine
RUN apk add gcompat
ENV LD_PRELOAD=/lib/libgcompat.so.0

COPY build/libs/leistungsnachweis-service.jar /opt/

EXPOSE 9500

CMD ["java", "-jar", "/opt/leistungsnachweis-service.jar", "-p", "9500"]
