pipeline {
    agent any
    tools { 
      maven 'jenkinsmaven' 
      jdk 'JAVA17'
    }
    stages {
      stage('Checkout') {
        steps {
          checkout([
            $class: 'GitSCM', 
            branches: [[name: 'main']],
            userRemoteConfigs: [[url: 'git@github.com:dcarvajal99/carrito-de-compras.git']]
          ])
        }
        post {
          failure {
            notifySlack('Checkout')
          }
        }
      }
      stage('Build') {
        steps {
          sh 'mvn -B -DskipTests clean package'
        }
        post {
          failure {
            notifySlack('Build')
          }
        }
      }
      stage('Archive') {
        steps {
          archiveArtifacts artifacts: "**/target/*.jar", fingerprint: true
        }
        post {
          failure {
            notifySlack('Archive')
          }
        }
      }
      stage('Test') {
        steps {
          sh "mvn test"
          junit '**/target/surefire-reports/TEST-*.xml'
        }
        post {
          failure {
            notifySlack('Test')
          }
           success {
            notifySlack('Pipeline completo')
          }
        }
      }
    }
}

def notifySlack(String stageName) {
  def COLOR_MAP = [
    SUCCESS: 'good',
    FAILURE: 'danger',
  ]

  echo 'Slack Notification'
  slackSend (
    channel: '#integracion-de-slack-a-jenkins',
    color: COLOR_MAP[currentBuild.currentResult],
    message: "${stageName} - ${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n Detalles: ${env.BUILD_URL}"
  )
}
