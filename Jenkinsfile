pipeline {
   agent {
       docker {
           image 'maven'
       }
   }


   stages {
      stage('Build') {
         steps {
            echo "It's Build"
            git credentialsId: 'cd362a1a-3d32-4e69-85a4-a5543f8ba6b4', url: 'https://github.com/SamVyazemsky/example/'
            echo "Stop build"

         }
      }
      stage('Clean') {
          steps {
             echo "tests execute"
             sh 'export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64'
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
             sh "allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]"

          }
      }
   }
}