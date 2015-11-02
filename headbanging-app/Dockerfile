FROM payaradocker/payara-full:4.1.152.1.oraclejdk8

MAINTAINER sergio morales <sdmoralesma@gmail.com>

RUN \
  ./asadmin start-domain payaradomain && \
  ./asadmin --user admin --passwordfile pwdfile enable-secure-admin && \
  ./asadmin stop-domain payaradomain
