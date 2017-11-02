pipeline {
    agent any
    stages {
        stage('Clone sources') {
            git url: 'https://github.com/ollihoo/multithread.git'
        }
        stage('Build') {
            steps {
               echo 'This is a minimal pipeline.'
            }
        }
    }
}