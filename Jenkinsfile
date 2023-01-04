pipeline{
    agent any

    tools {
        maven '3.6.3'
    }

    stages{
        stage('Source') {
            steps{
                git branch: 'main', url:'https://github.com/tonux/sir-soir.git'
            }
        }
        stage('Build') {
             steps{
                  sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
             }
        }

        stage('SonarQube Analysis') {
              steps{
                   sh 'mvn sonor:sonar'
              }
        }
    }
}