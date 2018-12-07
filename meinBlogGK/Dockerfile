FROM jboss/wildfly
MAINTAINER Goekhan Kahriman

# MySql-Connector und das module.xml werden in das Modules-Verzeichnis des Containers kopiert
COPY mysql-connector-java-8.0.11.jar /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/
ADD module.xml /opt/jboss/wildfly/modules/system/layers/base/com/mysql/main/

# Die angepasste Standalone.xml wird im Dateisystem des Containers aktualisiert
COPY standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml

# Die .War-Datei wird in das Deployments-Verzeichnis hinzugefuegt
ADD ./target/meinBlogGK.war /opt/jboss/wildfly/standalone/deployments/