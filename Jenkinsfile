pipeline {
   agent {
    docker { image 'maven' }
     }

   stages {
      stage('Build') {
         steps {
            git 'https://github.com/zeke89/lesson2.git'
         }
      }
      stage('Clean') {
          steps {
             echo "tests execute"
             sh 'uname -a'
             sh 'export JAVA_HOME=$(/usr/libexec/java_home)'
             sh 'curl -N https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_mac64.zip -P ~/ '
             sh 'unzip ~/chromedriver_mac64.zip -d ~/'
             sh ' rm ~/chromedriver_mac64.zip'
             sh ' mv -f ~/chromedriver /usr/local/bin/chromedriver '
             sh 'chown root:root /usr/local/bin/chromedriver '
             sh 'chmod 0755 /usr/local/bin/chromedriver'
             sh 'mvn clean'

          }
      }
      stage('Test') {
          steps {
             echo "tests execute"
             sh 'mvn test'

          }
      }
      stage('Results') {
          steps {
             sh 'sudo apt-add-repository ppa:qameta/allure'
             sh 'sudo apt-get update'
             sh 'sudo apt-get install allure'
             allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
          }
      }
   }
}
