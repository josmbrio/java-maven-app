def buildJar() {
  echo "building the application"
  sh 'mvn package'
}

def buildImage() {
  echo "building the application"
  withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh 'docker build -t josmbrio/my-repo:jma-2.0 .'
    sh "echo $PASS | docker login -u $USER --password-stdin"
    sh "docker push josmbrio/my-repo:jma-2.0"
  }
}

def deployApp() {
  echo 'deploying the application...'
}

return this
Footer
