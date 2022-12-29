pipeline {
    agent any
    stages {
        stage('git repo & clean') {
            steps {
                bat "rmdir  /s /q DevopsRepo"
                bat "git clone https://github.com/Muskan261Gupta/DevopsRepo.git"
                bat "mvn clean -f DevopsRepo"
            }
        }
        stage('install') {
            steps {
                sh "mvn clean install -f DevopsRepo"
            }
        }
        stage('test') {
            steps {
                bat "mvn test -f DevopsRepo"
            }
        }
        stage('package') {
            steps {
                bat "mvn package -f DevopsRepo"
            }
        }
    }
}
