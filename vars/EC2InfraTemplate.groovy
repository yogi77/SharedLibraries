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
                bat "C:\\Users\\Administrator\\Downloads\\terraform12\\terraform.exe init"
            }
        }
    
        stage('Plan') {
            steps {
                bat "C:\\Users\\Administrator\\Downloads\\terraform12\\terraform.exe plan"
            }
        }
   
        stage('Apply ') {
            steps {
                bat "C:\\Users\\Administrator\\Downloads\\terraform12\\terraform.exe apply --auto-approve"
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
