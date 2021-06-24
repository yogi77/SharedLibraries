pipeline {
    agent any
    stages {
        stage('Init') {
            steps {
                git branch: env.BRANCH, credentialsId: '3ee332f3-adb8-4fbf-83ba-4e41e03f5bac', url: env.SCMURL
            }
        }
    }

    stages {
        stage('Init') {
            steps {
                bat 'terraform init'
            }
        }
    }
    stages {
        stage('Plan') {
            steps {
                bat 'terraform plan'
            }
        }
    }
    stages {
        stage('Apply ') {
            steps {
                bat 'terraform apply --auto-approve'
            }
        }
    }
    stages {
        stage('Destroy ') {
            steps {
                bat 'terraform destroy --auto-approve'
            }
        }
    }
}
