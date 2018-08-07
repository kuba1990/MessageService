FROM registry.bisnode.net/dbase/server-jre8:1.8.25

COPY ./build/libs/dismit-rest-svc-0.0.1.jar dismit-rest-svc-0.0.1.jar

CMD ["java", "-jar", "-Djava.security.egd=file:/dev/urandom", "dismit-rest-svc-0.0.1.jar"]
