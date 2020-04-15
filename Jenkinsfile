pipeline {
    agent {
        docker {
            image 'maven:3.6.3-ibmjava-8-alpine'
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