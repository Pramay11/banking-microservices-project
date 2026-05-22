def services = [
    'account-service',
    'customer-service',
    'loan-service',
    'transaction-service',
    'api-gateway',
    'discovery-server'
]

pipeline {

    agent any

    tools {
        jdk 'jdk17'
        maven 'maven3'
    }

    environment {
        DOCKER_HUB = 'pramay11'
        NVD_API_KEY = credentials('nvd-api-key')
    }

    stages {

        stage('Build Microservices') {
            steps {
                script {
                    for (service in services) {
                        dir(service) {
                            sh 'mvn clean package'
                        }
                    }
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    for (service in services) {
                        dir(service) {
                            withSonarQubeEnv('sonar-server') {
                                sh """
                                    mvn sonar:sonar \
                                    -Dsonar.projectKey=${service} \
                                    -Dsonar.projectName=${service}
                                """
                            }
                        }
                    }
                }
            }
        }

        stage('OWASP Dependency Check') {
            steps {
                dependencyCheck(
                    additionalArguments: """
                        --scan .
                        --format HTML
                        --format XML
                        --nvdApiKey=$NVD_API_KEY
                        --data /var/lib/jenkins/owasp-cache
                    """,
                    odcInstallation: 'OWASP-DC'
                )

                dependencyCheckPublisher(
                    pattern: '**/dependency-check-report.xml'
                )
            }
        }

        stage('Build Docker Images') {
            steps {
                script {
                    for (service in services) {
                        dir(service) {
                            sh """
                                docker build \
                                -t $DOCKER_HUB/${service}:v1 .
                            """
                        }
                    }
                }
            }
        }

        stage('Trivy Scan') {
            steps {
                script {
                    for (service in services) {
                        sh """
                            trivy image \
                            --timeout 20m \
                            --severity HIGH,CRITICAL \
                            --no-progress \
                            $DOCKER_HUB/${service}:v1
                        """
                    }
                }
            }
        }

        stage('DockerHub Login') {
            steps {
                withCredentials([
                    usernamePassword(
                        credentialsId: 'dockerhub-creds',
                        usernameVariable: 'DOCKER_USER',
                        passwordVariable: 'DOCKER_PASS'
                    )
                ]) {
                    sh '''
                        echo $DOCKER_PASS | docker login \
                        -u $DOCKER_USER --password-stdin
                    '''
                }
            }
        }

        stage('Push Docker Images') {
            steps {
                script {
                    for (service in services) {
                        sh """
                            docker push $DOCKER_HUB/${service}:v1
                        """
                    }
                }
            }
        }

        stage('EKS and Kubectl Configuration') {
            steps {
                sh '''
                    aws eks update-kubeconfig \
                    --region ap-south-1 \
                    --name banking-eks
                '''
            }
        }

        stage('Deploy to Kubernetes') {
            when {
                branch 'main'
            }

            steps {
                sh '''
                    kubectl apply -f k8s/
                '''
            }
        }
    }
}