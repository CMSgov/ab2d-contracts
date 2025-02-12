FROM amazoncorretto:17-al2-jdk
WORKDIR /usr/src/ab2d-contracts
COPY build/libs/ab2d-properties-1.0.3.jar /usr/src/ab2d-properties/ab2d-properties.jar
CMD java -jar /usr/src/ab2d-contracts/ab2d-contracts.jar

CMD java \
    -XX:+UseContainerSupport \
    -jar ab2d-contracts.jar

EXPOSE 8070
