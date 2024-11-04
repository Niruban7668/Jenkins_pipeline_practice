pipeline {
    agent any
    
    environment {
        DOCKER_COMPOSE_FILE = 'docker-compose.yml'
    }
    
    stages {
        
        stage('Clone Repository') {
            steps {
                // Clone the repository from GitHub
                git branch: 'main', url: 'https://github.com/Niruban7668/cloned.git'
            }
        }
        
        stage('Build Docker Images') {
            steps {
                // Build the images as defined in docker-compose.yml
                sh 'docker-compose -f $DOCKER_COMPOSE_FILE build'

            }
        }
        
        stage('Run Docker Containers') {
            steps {
                // Bring up the containers
                sh 'docker-compose -f $DOCKER_COMPOSE_FILE up -d > docker_build.log 2>&1'
            }
        }
        
        stage('Read') {
            steps {
                // Archive the Docker build log
                archiveArtifacts artifacts: 'docker_build.log', allowEmptyArchive: true
            }
        }
        
        stage('Test Application') {
            steps {
                script {
                    def response = sh(script: 'curl -s -o /dev/null -w "%{http_code}" http://localhost:5000/api/v1.0/test', returnStdout: true).trim()
                    if (response == "200") {
                        echo "Test passed! Application is responding as expected."
                    } else {
                        error "Test failed! Application returned status code ${response}."
                    }
                    sh 'docker ps'
                }
            }
        }
        
    }
    
    post {
        always {
            // Cleanup Docker resources after the build
            sh 'docker-compose -f $DOCKER_COMPOSE_FILE down'
        }
    }
}
