pipeline {
    agent any
    triggers {
        cron('0 1 * * *')
    }
    parameters {
        string(
                name: 'branch_name',
                defaultValue: 'master',
                description: 'Choose your branch'
        )
    }
    stages {
        stage("Pull from GitHub") {
            steps {
                git 'https://github.com/Kanishe/QAUI.git'
            }
            stage('Run maven clean') {
                steps {
                    sh '/usr/local/bin/mvn clean'
                }
            }
            stage('Run maven test') {
                steps {
                    sh '/usr/local/bin/mvn test'
                }
            }

//                post {
//                    always {
//                        slackSend(
//                                channel: 'build',
//                                replyBroadcast: true,
//                                message: "Build failed. Broadcast to channel for better visibility."
//                        )
//                    }
//                }
            }
        }

}
