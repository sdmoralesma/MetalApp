FROM ubuntu:14.04.3

MAINTAINER Sergio Morales "sdmoralesma@gmail.com"

#Install packages on ubuntu base image
RUN \
  export DEBIAN_FRONTEND=noninteractive && \
  apt-get update && \
  apt-get install -y unzip && \
  apt-get install -y software-properties-common python-software-properties

# Install Java 8, agree to oracle jdk license
RUN \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \ 
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y oracle-java8-installer && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer

ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

# Install WildFly to /opt
ENV WILDFLY_VERSION 9.0.1.Final
RUN cd /opt && wget http://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz && \
  tar xvf wildfly-$WILDFLY_VERSION.tar.gz && \
  ln -s /opt/wildfly-$WILDFLY_VERSION /opt/wildfly && \
  rm wildfly-$WILDFLY_VERSION.tar.gz

ENV JBOSS_HOME /opt/wildfly

# Create admin user for wildfly
RUN $JBOSS_HOME/bin/add-user.sh admin admin123 --silent

#add datasource to wildfly
ADD wildfly-config/scripts $JBOSS_HOME/scripts/
ADD wildfly-config/connector $JBOSS_HOME/connector/
RUN $JBOSS_HOME/scripts/execute.sh

# Solves bug in history
RUN rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history/current

# Create the wildfly user and group
RUN groupadd -r wildfly-group -g 433 && \
  useradd -u 431 -r -g wildfly-group -s /bin/false wildfly -m

# Run everything below as the wildfly user
RUN chown -R wildfly:wildfly-group $JBOSS_HOME/* && \
  chmod -R 777 $JBOSS_HOME/*

USER wildfly

# Expose the ports
EXPOSE 8080 9990 8787

# Boot WildFly in the standalone mode and bind to all interfaces
CMD ["sh", "-c", "${JBOSS_HOME}/bin/standalone.sh", "--debug", "8787", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
