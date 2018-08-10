FROM jboss/wildfly
MAINTAINER Goekhan Kahriman

# Ordner für mysql erstellen
# connector in den ordner main kopieren
# module.xml in den ordner hinzufügen
# standalone.xml aktualisieren
COPY mysql-connector-java-8.0.11.jar /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/
ADD module.xml /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/
COPY standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml

ADD /target/meinBlogGK.war /opt/jboss/wildfly/standalone/deployments/