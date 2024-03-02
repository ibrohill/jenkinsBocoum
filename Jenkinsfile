pipeline {
    agent any
    tools {
        maven "Maven"
    }

    environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "http://172.18.0.4:8081"  // Ajout de "http://"
        NEXUS_REPOSITORY = "repoJenkinsLy"
        NEXUS_CREDENTIAL_ID = "nexusCredential"
        ARTIFACT_VERSION = "${BUILD_NUMBER}"
    }
  
    stages {
        stage('Git Check out') {
            steps {
                checkout scm
            } 
        }

        stage('Maven build') {
            steps {
                sh "mvn clean package"
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonar-server') {
                    sh "mvn clean verify sonar:sonar -Dsonar.projectKey=hibernate-app-l3glg2 -Dsonar.projectName=hibernate-app-l3glg2"
                }
            }
        }

        stage("Publish to Nexus") {
            steps {
                script {
                    def nexusUrl = "${NEXUS_PROTOCOL}://${NEXUS_URL}/repository/${NEXUS_REPOSITORY}/"
                    def nexusRepositoryUrl = "${nexusUrl}${ARTIFACT_VERSION}/"

                    // Example Maven deployment command
                    sh "mvn deploy:deploy-file -Durl=${nexusRepositoryUrl} -DrepositoryId=${NEXUS_CREDENTIAL_ID} -DgroupId=your.groupId -DartifactId=your.artifactId -Dversion=${ARTIFACT_VERSION} -Dpackaging=jar -Dfile=target/your-artifact.jar"
                }
            }
        }
    }
}
