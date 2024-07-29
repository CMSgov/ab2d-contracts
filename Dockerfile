FROM amazoncorretto:17-al2-jdk
WORKDIR /usr/src/ab2d-contracts
ADD build/libs/Ab2d-*-Contracts-Service-*.jar /usr/src/ab2d-contracts/ab2d-contracts.jar

CMD java \
    -XX:+UseContainerSupport \
    -jar ab2d-contracts.jar

EXPOSE 8070
