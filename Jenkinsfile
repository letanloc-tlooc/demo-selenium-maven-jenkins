pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean site'
            }
        }
        
        stage('Publish HTML Report') {
            steps {
                publishHTML(target: [
                    reportDir: 'target/site',
                    reportFiles: 'index.html',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false,
                    title: 'My HTML Report'
                ])
            }
        }
    }
}
