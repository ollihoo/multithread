node {
   stage('Check out git repository') {
      git 'https://github.com/ollihoo/multithread.git'
   }
   stage('Build and package Spring Boot application') {
      sh "./mvnw package"
   }
   stage('Build docker image') {
    sh "./mvnw dockerfile:build"
   }
   stage('Results') {
      junit '**/target/*-reports/TEST-*.xml'
   }
}