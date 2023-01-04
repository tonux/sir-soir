pipeline{
    agent any

    stages{
        stage('Source') {
            steps{
                git branch: 'main', url:'https://github.com/tonux/sir-soir.git'
            }
        }
        stage('Build') {
             steps{
                  sh 'echo "build in process"'
             }
        }
    }
}