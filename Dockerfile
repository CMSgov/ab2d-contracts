FROM openjdk:17
WORKDIR /usr/src/ab2d-contracts
#JENKINS=build/libs/Ab2d-*-Contracts-Service.jar
RUN gradle build -x test & gradle jar --info build
ADD build/libs/ab2d-contracts.jar* /usr/src/ab2d-contracts/ab2d-contracts.jar
ADD build/libs/Ab2d-*-Contracts-Service.jar* /usr/src/ab2d-contracts/ab2d-contracts.jar


#RUN #if [[ -f f"build/libs/Ab2d-*-Contracts-Service.jar" ]] ; then  FILE=build/libs/Ab2d-*-Contracts-Service.jar; else $FILE=build/libs/ab2d-contracts.jar; fi

#ADD $FILE /usr/src/ab2d-contracts/ab2d-contracts.jar

CMD java \
    -XX:+UseContainerSupport \
    -jar ab2d-contracts.jar

EXPOSE 8070
