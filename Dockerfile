FROM openjdk:8u111-jdk as build
LABEL Name=java-base Version=1.0.2


# RUN apt-get update && \
# apt install -y -t jessie-backports openjdk-8-jre-headless ca-certificates-java && \
# apt-get install -y xvfb wget openjdk-8-jre && \
# wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb && \
# dpkg --unpack google-chrome-stable_current_amd64.deb && \
# apt-get install -f -y && \
# apt-get clean && \
# rm google-chrome-stable_current_amd64.deb && \
# apt-get install -y pkg-mozilla-archive-keyring

# Failed to fetch jessie backports repository
RUN echo "deb [check-valid-until=no] http://cdn-fastly.deb.debian.org/debian jessie main" > /etc/apt/sources.list.d/jessie.list
RUN echo "deb [check-valid-until=no] http://archive.debian.org/debian jessie-backports main" > /etc/apt/sources.list.d/jessie-backports.list
RUN sed -i '/deb http:\/\/deb.debian.org\/debian jessie-updates main/d' /etc/apt/sources.list
RUN echo "Acquire::Check-Valid-Until \"false\";" > /etc/apt/apt.conf.d/100disablechecks

# Google Chrome
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'
RUN apt-get update && apt-get install -y google-chrome-stable


WORKDIR /appbase
COPY .mvn .mvn
COPY ./mvnw ./mvnw
COPY ./pom.xml ./pom.xml
RUN ./mvnw dependency:go-offline
COPY . .
RUN ./mvnw install -DskipTests
CMD ["./mvnw", "test"]
