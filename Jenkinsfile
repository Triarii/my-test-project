pipeline {
    agent {
        docker {
            image 'maven:3.6.3-jdk-8'
            args '-v /root/.m2:/root/.m2'
        }
    }
    parameters {
        string(name: 'RUN_THREADS', defaultValue: '1', description: 'Parallel run')
        string(name: 'RUN_REPORT_EMAIL', defaultValue: 'user', description: 'Run report email address')
        string(name: 'HUB', defaultValue: 'http://localhost:4445/wd/hub', description: 'Selenium grid hub')
        string(name: 'BROWSER', defaultValue: 'chrome', description: 'Selenium browser')
        string(name: 'TEST_USER_NAME', defaultValue: 'username', description: 'Test user name')
        password(name: 'TEST_USER_PASSWORD', defaultValue: 'SECRET', description: 'Test user password')
    }
    stages {
        stage('Tests') {
            steps {
                sh "mvn -B \
                    -Dmaven.repo.local=/root/.m2 \
                    -Dconfig.run.threads=${params.RUN_THREADS} \
                    -Dconfig.selenium.local=false \
                    -Dconfig.selenium.hub=${params.HUB} \
                    -Dconfig.selenium.browser=${params.BROWSER} \
                    -Dconfig.test.user.name=${params.TEST_USER_NAME} \
                    -Dconfig.test.user.password=${params.TEST_USER_PASSWORD} \
                test \
                antrun:run"
            }
        }
        stage('Allure-report') {
            steps {
                script {
                    allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'allure-results']]
                    ])
                }
            }
        }
    }
    post {
        always {
            emailext to: "${params.RUN_REPORT_EMAIL}",
                subject: "My-test-project: tests report ( ${env.BUILD_NUMBER} )",
                mimeType: 'text/html',
                body: "<h1>Job Build Links</h1>\n" +
                    "<p><a href=\"${env.BUILD_URL}allure/\">Allure Report</a></p>\n" +
                    "<p><a href=\"${env.BUILD_URL}console\">Console</a></p>\n" +
                    '${FILE, path="target/surefire-reports/junit-noframes.html"}',
                attachLog: true
        }
    }
}