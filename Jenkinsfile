pipeline {
    agent any

    tools {
        jdk 'jdk17'
        maven 'maven3'
    }

    stages {

        stage('Git Checkout') {
            steps {
                git 'https://github.com/Pramay11/banking-microservices-project.git'
            }
        }

        stage('Build Account Service') {
            steps {
                dir('account-service') {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                dir('account-service') {
                    sh 'docker build -t account-service:v1 .'
                }
            }
        }

    }
}
