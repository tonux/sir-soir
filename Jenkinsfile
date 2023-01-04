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
                   sh 'mvn sonar:sonar'
              }
        }

         stage('Approve Deployment') {
             input{
                message "Do you want to proceed for deployment?"
             }
              steps{
                // add deploy steps & alert below
                 sh 'echo "Deployment into Server" '
              }
         }
    } // stages

    post{
        aborted{
            echo "Sending aborted message to Agent"
        }
        failure{
            echo "Sending failure message to Agent"
        }
        success{
            echo "Sending success message to Agent"
        }
    } // post
}