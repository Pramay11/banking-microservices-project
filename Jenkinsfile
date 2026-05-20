pipeline {
    agent any

    tools {
        jdk 'jdk17'
        maven 'maven3'
    }

    environment {
        DOCKER_HUB = 'YOUR_DOCKERHUB_USERNAME'
        IMAGE_NAME = 'account-service'
    }

    stages {

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
                    sh 'docker build -t $IMAGE_NAME:v1 .'
                }
            }
        }

        stage('DockerHub Login') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {

                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                }
            }
        }

        stage('Tag Docker Image') {
            steps {
                sh 'docker tag $IMAGE_NAME:v1 $DOCKER_HUB/$IMAGE_NAME:v1'
            }
        }

        stage('Push Docker Image') {
            steps {
                sh 'docker push $DOCKER_HUB/$IMAGE_NAME:v1'
            }
        }
    }
}
