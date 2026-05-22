# Banking Microservices DevSecOps Project

## Project Overview

This project demonstrates an end-to-end implementation of a Banking Microservices application integrated with modern DevOps and DevSecOps practices.

The application is built using Spring Boot Microservices architecture and incorporates Service Discovery, API Gateway, CI/CD automation, containerization, security scanning, Infrastructure as Code, and Kubernetes deployment manifests.

The primary objective of this project is to simulate a real-world enterprise banking application deployment pipeline and showcase DevOps engineering skills.

---

# Architecture

```text
Client
   │
   ▼
API Gateway
   │
   ▼
Eureka Discovery Server
   │
   ├───────────── Account Service
   │
   ├───────────── Customer Service
   │
   ├───────────── Loan Service
   │
   └───────────── Transaction Service
```

---

# Microservices

## Account Service

Responsible for managing customer account information.

**Port:** 8081

### Endpoints

```http
GET /accounts
```

---

## Customer Service

Responsible for managing customer details.

**Port:** 8082

### Endpoints

```http
GET /customers
```

---

## Loan Service

Responsible for loan-related operations.

**Port:** 8083

### Endpoints

```http
GET /loans
```

---

## Transaction Service

Responsible for transaction management.

**Port:** 8084

### Endpoints

```http
GET /transactions
```

---

## API Gateway

Acts as a single entry point for all client requests.

**Port:** 8085

Routes requests dynamically to microservices using Eureka Service Discovery.

---

## Eureka Discovery Server

Provides service registration and discovery.

**Port:** 8761

Dashboard URL:

```text
http://localhost:8761
```

---

# Technology Stack

## Backend Technologies

- Java 17
- Spring Boot
- Spring Cloud Gateway
- Spring Cloud Netflix Eureka
- Maven

---

## Containerization

- Docker
- Docker Compose

---

## Source Code Management

- Git
- GitHub

---

## CI/CD

- Jenkins Pipeline

---

## Code Quality Analysis

- SonarQube

---

## Dependency Security Scanning

- OWASP Dependency Check

---

## Container Vulnerability Scanning

- Trivy

---

## Container Registry

- DockerHub

---

## Infrastructure as Code

- Terraform

---

## Container Orchestration

- Kubernetes

---

# DevOps Pipeline

The project uses a Jenkins Declarative Pipeline for complete CI/CD automation.

## Pipeline Workflow

```text
Developer Commit
       │
       ▼
GitHub Repository
       │
       ▼
Jenkins Pipeline
       │
       ▼
Maven Build
       │
       ▼
SonarQube Analysis
       │
       ▼
OWASP Dependency Check
       │
       ▼
Docker Image Build
       │
       ▼
Trivy Security Scan
       │
       ▼
DockerHub Push
       │
       ▼
Kubernetes Deployment
```

---

# SonarQube Integration

SonarQube is used for:

- Code Quality Analysis
- Bug Detection
- Security Hotspot Detection
- Maintainability Analysis
- Code Smell Identification

All microservices are analyzed through Jenkins pipeline execution.

---

# OWASP Dependency Check

OWASP Dependency Check is integrated into the Jenkins pipeline to identify vulnerable third-party dependencies.

The scan performs:

- CVE Analysis
- Dependency Risk Assessment
- Vulnerability Reporting

---

# Trivy Security Scan

Trivy is used to scan Docker images for:

- Operating System Vulnerabilities
- Application Vulnerabilities
- Security Misconfigurations
- High and Critical CVEs

---

# Docker Images

The following images are automatically built and pushed to DockerHub through Jenkins.

```text
pramay11/account-service:v1

pramay11/customer-service:v1

pramay11/loan-service:v1

pramay11/transaction-service:v1

pramay11/api-gateway:v1

pramay11/discovery-server:v1
```

---

# Docker Compose Deployment

To start all services locally:

```bash
docker compose up -d
```

To stop all services:

```bash
docker compose down
```

---

# Kubernetes Resources

The project includes Kubernetes manifests for future deployment.

Resources created:

- Namespace
- ConfigMap
- Deployments
- Services
- Ingress

## Kubernetes Folder Structure

```text
k8s/

├── namespace.yaml

├── configmap.yaml

├── discovery-deployment.yaml
├── discovery-service.yaml

├── account-deployment.yaml
├── account-service.yaml

├── customer-deployment.yaml
├── customer-service.yaml

├── loan-deployment.yaml
├── loan-service.yaml

├── transaction-deployment.yaml
├── transaction-service.yaml

├── api-gateway-deployment.yaml
├── api-gateway-service.yaml

└── ingress.yaml
```

---

# Terraform Infrastructure

Terraform configuration is included for provisioning AWS infrastructure.

Resources:

- VPC
- Public Subnet
- Internet Gateway
- Route Table
- Security Group
- EC2 Instance

Terraform Commands:

Initialize:

```bash
terraform init
```

Preview:

```bash
terraform plan
```

Create Infrastructure:

```bash
terraform apply
```

Destroy Infrastructure:

```bash
terraform destroy
```

---

# Local Setup

## Clone Repository

```bash
git clone https://github.com/Pramay11/banking-microservices-project.git
```

```bash
cd banking-microservices-project
```

---

## Build All Services

```bash
mvn clean package
```

---

## Run Using Docker Compose

```bash
docker compose up -d
```

---

## Verify Eureka Dashboard

```text
http://localhost:8761
```

---

## Verify API Gateway

```text
http://localhost:8085/accounts

http://localhost:8085/customers

http://localhost:8085/loans

http://localhost:8085/transactions
```

---

# Project Highlights

✔ Microservices Architecture

✔ Service Discovery using Eureka

✔ API Gateway Routing

✔ Docker Containerization

✔ Docker Compose Orchestration

✔ Jenkins CI/CD Automation

✔ SonarQube Integration

✔ OWASP Dependency Check

✔ Trivy Security Scanning

✔ DockerHub Integration

✔ Terraform Infrastructure as Code

✔ Kubernetes Deployment Manifests

✔ DevSecOps Implementation

---

# Future Enhancements

- AWS EKS Deployment
- Helm Charts
- ArgoCD GitOps
- Prometheus Monitoring
- Grafana Dashboards
- Horizontal Pod Autoscaler (HPA)
- Multi-Environment Deployments (Dev, QA, Prod)

---

# Author

## Pramay Gawali

DevOps Engineer Project

Technologies: Java | Spring Boot | Docker | Jenkins | SonarQube | OWASP | Trivy | Terraform | Kubernetes | AWS
