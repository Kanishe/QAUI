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
        stage('Backup and Reports') {
            steps {
                archiveArtifacts artifacts: '**/target/', fingerprint: true
            }

            post {
                always {
                                  script {
                                    // Формирование отчета
                                    allure([
                                      includeProperties: false,
                                      jdk: '',
                                      properties: [],
                                      reportBuildPolicy: 'ALWAYS',
                                      results: [[path: 'target/allure-results']]
                                    ])

                                    // Узнаем ветку репозитория (т.к. это не multipipeline job, то вариант через env.BRANCH_NAME увы не работает)
                                    def branch = bat(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD\n').trim().tokenize().last()

                                    // Достаем информацию по тестам из junit репорта
                                    def summary = junit testResults: '**/target/surefire-reports/*.xml'

                                    // Текст оповещения
                                    def message = "${currentBuild.currentResult}: Job ${env.JOB_NAME}, build ${env.BUILD_NUMBER}, branch ${branch}\nDuration - ${duration}\nTest Summary - ${summary.totalCount}, Failures: ${summary.failCount}, Skipped: ${summary.skipCount}, Passed: ${summary.passCount}\nMore info at: ${env.BUILD_URL}"

                                    // Отправка результатов на почту
                                    emailext body: "${message}",
                                        recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                                        subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}",
                                        to: 'elenaa@hflabs.ru'

                                    // Отправка результатов В slack
                                    slackSend(
                                        message: "${message}",
                                        channel: "build"
                                    )
                                  }
            }
        }
    }
}
}