FROM kubespheredev/java-8-centos7

MAINTAINER kubesphere@yunify.com

# Some version information
LABEL io.kubesphere.s2i.version.maven="3.5.4" \
      io.k8s.description="Platform for building and running plain Java war applications" \
      io.k8s.display-name="Tomacat Applications" \
      io.kubesphere.tags="builder,java,war,tomcat" \
      io.kubesphere.s2i.scripts-url="image:///usr/local/s2i" \
      io.kubespehre.s2i.destination="/tmp" \
      io.openshift.s2i.scripts-url="image:///usr/local/s2i" \
      io.openshift.s2i.destination="/tmp" \
      org.jboss.deployments-dir="/deployments" \
      com.yunify.deployments-dir="/deployments" \
      com.yunify.dev-mode="JAVA_DEBUG:false" \
      com.yunify.dev-mode.port="JAVA_DEBUG_PORT:5005"

EXPOSE 8080

ENV TOMCAT_VERSION 8.5.32

USER root

# Add run script as /opt/run-java/run-java.sh and make it executable
COPY run-java.sh /opt/run-java/
RUN chmod 755 /opt/run-java/run-java.sh

# Adding run-env.sh to set app dir
COPY run-env.sh /opt/run-java/run-env.sh
RUN chmod 755 /opt/run-java/run-env.sh


# Get and Unpack Tomcat
RUN curl http://archive.apache.org/dist/tomcat/tomcat-8/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz -o /tmp/catalina.tar.gz \
 && tar xzf /tmp/catalina.tar.gz -C /opt \
 && ln -s /opt/apache-tomcat-${TOMCAT_VERSION} /opt/tomcat \
 && chown -R jboss /opt/tomcat /opt/apache-tomcat-${TOMCAT_VERSION} \
 && rm /tmp/catalina.tar.gz

# Add roles
ADD tomcat-users.xml /opt/apache-tomcat-${TOMCAT_VERSION}/conf/

# Startup script
ADD deploy-and-run.sh /opt/apache-tomcat-${TOMCAT_VERSION}/bin/

RUN chmod 755 /opt/apache-tomcat-${TOMCAT_VERSION}/bin/deploy-and-run.sh \
 && rm -rf /opt/tomcat/webapps/examples /opt/tomcat/webapps/docs  \
 && chgrp -R 0 /opt/tomcat/webapps \
 && chmod -R g=u /opt/tomcat/webapps

COPY s2i /usr/local/s2i
RUN chmod 755 /usr/local/s2i/*
ADD README.md /usr/local/s2i/usage.txt


VOLUME [ "/opt/tomcat/logs", "/opt/tomcat/work", "/opt/tomcat/temp", "/tmp/hsperfdata_root" ]

ENV CATALINA_HOME /opt/tomcat
ENV PATH $PATH:$CATALINA_HOME/bin

CMD /opt/tomcat/bin/deploy-and-run.sh

USER jboss
