pipeline {
    agent any
    tools {
        maven "Maven"
    }

    environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "172.18.0.4:8081"
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

        stage("publish to nexus") {
            steps {
                script {
                    // Votre script pour publier dans Nexus
                }
            }
        }
    }
}
