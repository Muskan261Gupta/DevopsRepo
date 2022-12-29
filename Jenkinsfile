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
                //echo "install"
                bat 'mvn -Dmaven.test.failure.ignore=true clean package'
                //sh 'mvn install -Dmaven.test.skip=true'
            }
        }
        stage('test') {
            steps {
                //bat "mvn test -f DevopsRepo"
                bat 'mvn install -Dmaven.test.skip=true'
                //echo "test"
            }
        }
        stage('package') {
            steps {
                //bat "mvn package -f DevopsRepo"
                echo "packaging"
            }
        }
    }
    post {
       always {
          junit(
        allowEmptyResults: true,
        testResults: '*/test-reports/.xml'
      )
      }
   }
}
