pipeline {
    agent {
        docker {
            image 'maven:3.6.3-jdk-8'
            args '-v /root/.m2:/root/.m2'
        }
    }
    parameters {
        string(name: 'RUN_THREADS', defaultValue: '1', description: 'Parallel run')
        string(name: 'HUB', defaultValue: 'http://localhost:4445/wd/hub', description: 'Selenium grid hub')
        string(name: 'BROWSER', defaultValue: 'chrome', description: 'Selenium browser')
        string(name: 'TEST_USER_NAME', defaultValue: 'username', description: 'Test user name')
        password(name: 'TEST_USER_PASSWORD', defaultValue: 'SECRET', description: 'Test user password')
    }
    stages {
        stage('Tests') {
            steps {
                sh 'mvn -B \
                    -Dmaven.repo.local=/root/.m2 \
                    -Dconfig.run.threads=${params.RUN_THREADS} \
                    -Dconfig.selenium.local=false \
                    -Dconfig.selenium.hub=${params.HUB} \
                    -Dconfig.selenium.browser=${params.BROWSER} \
                    -Dconfig.test.user.name=${params.TEST_USER_NAME} \
                    -Dconfig.test.user.password=${params.TEST_USER_PASSWORD} \
                test'
            }
        }
    }
}