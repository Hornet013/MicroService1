FROM jeanblanchard/java:8
MAINTAINER Hornet013
COPY target/listcourse-0.0.1-SNAPSHOT.jar listcourse-0.0.1-SNAPSHOT.jar
CMD java -jar listcourse-0.0.1-SNAPSHOT.jar