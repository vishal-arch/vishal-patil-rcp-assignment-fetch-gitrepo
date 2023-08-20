# Popular github repositories 
A project fetches the list of public Git repositories by calling the Git api.

## Table of Contents

* **[Installation](#installation)**
* **[Running the application](#running-the-application)**
* **[Deploy in minikube locally](#minikube-deployments)**
* **[Environment Variables](#environment-variables)**

## Installation

Use Maven to compile and package

```bash
mvn clean package
```

## Running the application

To run it on local environment add the following VM parameters

## Environment Variables
```bash
-Dspring.profiles.active=prod
```

```bash
GIT_REPO_BASE_URL: Define base url for the Git api endpoint
```
## Minikube-deployments

To deploy the project locally on minikube please follow the below steps. As of now it uses the core kubernetes manifest yml. and any form of charting.

1) Start minikube.
```bash
minikube start
```
2) To load the image to minikube.
```bash
-- window poweeshell
minikube docker-env | Invoke-Expression

-- other linux based system
eval $(minikube docker-env)
```
3) Build image in docker.

```bash
docker build . -t git-repositories:v1
```
4) Apply the deployment from the project base path.
```bash
kubectl apply -f .\deployments\k8s-manifest\deployment.yml
```
Note: please use ```bash kubectl get deployment ``` and ```bash kubectl get pods ``` to check if they are running
5) Apply the service from the project base path.
```bash
kubectl apply -f .\deployments\k8s-manifest\service.yml
```
Note: please use ```bash kubectl get svc ``` to check if its are showing
7) Start the tunnel to test it locally
```bash
minikube service git-repositories-svc
```

## REST

The Open Api details describing the Rest endpoints can be found at bellow link once the service is deployed:
```bash
http://<hostname>/v3/swagger-ui.html
```