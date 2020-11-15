pipeline {
    agent any
    triggers {
        cron('0 1 * * *')
    }
    parameters {
        string(
                name: 'branch_name',
                defaultValue: 'master',
                description: 'Choose your branch',
                massage: 'Build success. Broadcast to channel for better visibility.'
        )
    }
    stages {
        stage("Pull from GitHub") {
            steps {
                git 'https://github.com/Kanishe/QAUI.git'
            }
        }
        stage("Run Maven package") {
            steps {
                sh '/usr/local/bin/mvn package'
            }
            post {
                always {
                    emailext (body: "${message}",
                        recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                        subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}",
                        to: 'a.kan4988@gmail.com')
                    
                    slackSend(
                            channel: 'build',
                            replyBroadcast: true,
                            message: "Build success. Broadcast to channel for better visibility."
                    )
                }
            }
        }
    }

}
