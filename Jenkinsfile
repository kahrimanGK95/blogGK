pipeline{
	agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }
    tools {
        maven 'Apache Maven 3.5.2'
        jdk 'JDK 1.8.0_144'
    }
	
	environment {
		IMAGE = ""
		VERSION = ""
		
	}
	
	stages{
	
		stage ('build meinBlog') {
			steps{
				
				/* Version des Docker Images ueber die pom beziehen */
				script{
					dir('./meinBlogGK/') {
						VERSION = readMavenPom().getVersion()
						echo "${VERSION}"
						
					}
				}
				
				dir('./meinBlogGK/') {
					sh 'mvn -U clean install -P docker -DskipTests=true'
				}
			
			}
		}
		
		stage ('docker-build mysql image') {
			steps{
				
				/* Image bauen, ohne Pushen*/
				dir('./docker/dockerbuild/mysql/'){
					script{
						docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
							db_image_name = "goekhan1995/meinblog_db"
							db_image = docker.build("${db_image_name}").push("${VERSION}")				
						}
					}
				}
			}
		}
		
		
		stage ('docker-build meinBlog image') {
			steps{
			
				/* Deployments*/
				sh "cp ./meinBlogGK/target/meinBlogGK.war ./docker/dockerbuild/jboss/standalone/deployments"
				
				/* Image bauen, ohne Pushen*/
				dir('./docker/dockerbuild/jboss'){
					script{
						docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
							image_name = "goekhan1995/meinblog"
							docker.build("${image_name}").push("${VERSION}")
							
						}
					}
				}
			}
		}
	}
		
	post{
		failure{
            script{
				mail (
					from: 'gokhan_1995@hotmail.de',
					to: 'gokhan_1995@hotmail.de',
					subject: "Failure: MeinBlog-Build-Pipeline '${env.JOB_NAME}' (${env.BUILD_NUMBER})",
					body: "Die MeinBlog-Pipeline zum Docker-Bau ist fehlgeschlagen. Einsehbar unter ${env.BUILD_URL}."
				)
            }             
        }
		success{
            script{
				mail (
					from: 'gokhan_1995@hotmail.de',
					to: 'gokhan_1995@hotmail.de',
					subject: "Failure: MeinBlog-Build-Pipeline '${env.JOB_NAME}' (${env.BUILD_NUMBER})",
					body: "Die MeinBlog-Pipeline zum Docker-Bau war erfolgreich. Einsehbar unter ${env.BUILD_URL}."
				)
            }             
        }
	}
}