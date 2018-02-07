node {
   stage('Check out git repository') {
      git 'https://github.com/ollihoo/multithread.git'
   }
   stage('Build and package Spring Boot application') {
      sh "./mvnw package"
   }
   stage('Build docker image') {
    sh "docker build -t ollihoo/multithreading:latest ."
   }
   stage('Results') {
      junit '**/target/*-reports/TEST-*.xml'
   }
}