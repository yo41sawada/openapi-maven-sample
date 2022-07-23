FROM openjdk:11.0.14.1-slim-bullseye

RUN apt update && apt install wget git postgresql-client -y

WORKDIR /opt
RUN wget https://dlcdn.apache.org/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.tar.gz && tar -zxvf apache-maven-3.8.6-bin.tar.gz && echo 'export PATH="$PATH:/opt/apache-maven-3.8.6/bin"' > /root/.profile