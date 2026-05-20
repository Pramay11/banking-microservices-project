pipeline {
    agent any

    tools {
        jdk 'jdk17'
        maven 'maven3'
    }

    environment {
        DOCKER_HUB = 'pramay11'
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

        stage('SonarQube Analysis') {
    steps {
        dir('account-service') {

            withSonarQubeEnv('sonar-server') {

                sh '''
                mvn sonar:sonar \
                -Dsonar.projectKey=account-service \
                -Dsonar.projectName=account-service \
                -Dsonar.host.url=http://localhost:9000 \
                -Dsonar.login=$SONAR_AUTH_TOKEN
                '''
            }
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

        stage('Trivy Scan') {
            steps {

                 sh '''
                 trivy image --exit-code 1 --severity CRITICAL account-service:v1
                 '''

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
