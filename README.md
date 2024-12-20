# Jenkins_pipeline_practice
# Project: Cloned Repository with Jenkins Pipeline

This project involves cloning a Git repository, updating dependencies, and setting up a Jenkins pipeline to automate build and deployment processes.

## Table of Contents
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Cloning and Updating the Repository](#cloning-and-updating-the-repository)
- [Setting Up Jenkins](#setting-up-jenkins)
- [Jenkins Pipeline Configuration](#jenkins-pipeline-configuration)
- [Running the Pipeline](#running-the-pipeline)

## Getting Started

These instructions will help you set up and run the project on your local machine.

## Prerequisites

- **Git**: Required for cloning and managing repositories.
- **Jenkins**: Used for CI/CD pipeline automation.
- **Docker** (optional): If your Jenkins pipeline involves containerized applications.

## Cloning and Updating the Repository

1. **Clone the Original Repository**:

   ```bash
   https://github.com/Niruban7668/jenkins_practice_repository.git
   cd jenkins_practice_repository
   bash
2. **Update Dependencies**:

   Update the dependencies if any by modifying requirements.txt

3. **Create a New Repository and Push Changes**:

   After modifying the repository, push it to your own GitHub repository:
   
   bash
   
       git init
       git add .
       git commit -m "Initial commit with updated requirements"
       git remote add origin https://github.com/yourusername/cloned.git
       git push -u origin main

## Setting Up Jenkins

   ### Download and Install Jenkins on Linux

   ### Update your packages and install Jenkins

   bash

      sudo apt update
      sudo apt install openjdk-11-jdk -y
      curl -fsSL https://pkg.jenkins.io/debian/jenkins.io-2023.key | sudo tee \
          /usr/share/keyrings/jenkins-keyring.asc > /dev/null
      echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
          https://pkg.jenkins.io/debian binary/ | sudo tee \
          /etc/apt/sources.list.d/jenkins.list > /dev/null
      sudo apt update
      sudo apt install jenkins -y

   ### Start Jenkins and Access the Web Interface:

   bash

      sudo systemctl start jenkins
      sudo systemctl status jenkins

   Access Jenkins at http://localhost:8080, and use the initial admin password:

   bash

    sudo cat /var/lib/jenkins/secrets/initialAdminPassword

   ### Install Plugins and Configure Jenkins:

   Follow the setup instructions on the Jenkins web interface to install recommended plugins.

## Jenkins Pipeline Configuration

   ### Create a New Pipeline

   In the Jenkins dashboard, select New Item > Pipeline, and name it as per your wish.

   ### Add Pipeline Script:

   Use the [groovy script](./pipeline_configuration.groovy) to setup configuration

   Save the Pipeline

## Running the Pipeline

   Once your pipeline is set up in Jenkins:

   Trigger the build manually or configure a webhook for automatic triggering.
   View logs and status on the Jenkins dashboard.
