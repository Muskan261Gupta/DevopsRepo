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
                //bat "mvn clean package"
                //bat "mvn clean install -f DevopsRepo"
                bat 'nohup ./mvnw spring-boot:run -Dserver.port=8081 &'
                //echo "install"
            }
        }
        stage('test') {
            steps {
                //bat "mvn test -f DevopsRepo"
                echo "test"
            }
        }
        stage('package') {
            steps {
                bat "mvn package -f DevopsRepo"
            }
        }
    }
}
