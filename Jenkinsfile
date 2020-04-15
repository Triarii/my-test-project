pipeline {
    agent {
        docker {
            image 'maven:3.6.3-jdk-8'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Tests') {
            steps {
                sh 'mvn -B test'
            }
        }
    }
}