node {
   stage('Check out git repository') {
      git 'https://github.com/ollihoo/multithread.git'
   }
   stage('Build and package Spring Boot application') {
      sh "./mvnw verify"
   }
   stage('Results') {
      junit '**/target/*-reports/TEST-*.xml'
   }
}