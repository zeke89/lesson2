pipeline {
   agent any
//     {
//        docker {
//            image 'maven'
//        }
//    }

   stages {
      stage('Build') {
         steps {
            git 'https://github.com/zeke89/lesson2.git'
         }
      }
      stage('Clean') {
          steps {
             echo "tests execute"
             sh 'export JAVA_HOME=$(/usr/libexec/java_home)'
             sh 'wget -N https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_mac64.zip -P ~/ '
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
             echo "tests execute"
             sudo apt-add-repository ppa:qameta/allure
             sudo apt-get update
             sudo apt-get install allure
             sh "allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]"

          }
      }
   }
}