FROM jboss/wildfly

COPY ./standalone /opt/jboss/standalone
COPY mysql-connector-java-8.0.11.jar /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/
ADD module.xml /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/
COPY standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml

ADD  ./standalone/deployments/meinBlogGK.war /opt/jboss/wildfly/standalone/deployments/