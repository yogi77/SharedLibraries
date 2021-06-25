def call() {
pipeline {
    agent any
    stages {
        stage('CheckOut') {
            steps {
                git branch: env.BRANCH, credentialsId: '3ee332f3-adb8-4fbf-83ba-4e41e03f5bac', url: env.SCMURL
            }
        }
   
        stage('Init') {
            steps {
                bat 'terraform init'
            }
        }
    
        stage('Plan') {
            steps {
                bat 'terraform plan'
            }
        }
   
        stage('Apply ') {
            steps {
                bat 'terraform apply --auto-approve'
            }
        }
    
        stage('Destroy ') {
            steps {
                bat 'terraform destroy --auto-approve'
            }
        }
    }
}
}
