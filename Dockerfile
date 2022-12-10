FROM openjdk:17-oracle
ADD target/ms-customer-0.0.1-SNAPSHOT.jar ms-customer.jar
ENTRYPOINT ["java","-jar","ms-customer.jar"]