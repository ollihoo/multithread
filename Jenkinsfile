node {
   stage('Check out git repository') {
      git 'https://github.com/ollihoo/multithread.git'
   }
   stage('show all environment vars') {
      sh "env"
   }
   stage('Build and package Spring Boot application') {
      sh "./mvnw package -Dapplication.version=$BUILD_NUMBER"
   }
   stage('Build docker image') {
    sh "docker build -t ollihoo/multithreading:latest ."
   }
   stage('Push docker image') {
     withCredentials([usernamePassword(credentialsId: 'hub.docker.com', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh "docker login -u $USERNAME -p $PASSWORD && docker push $USERNAME/multithreading:latest && docker logout"
     }
   }
   stage('Results') {
      junit '**/target/*-reports/TEST-*.xml'
   }
}