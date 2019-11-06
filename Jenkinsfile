pipeline {
  agent {
    node {
      label 'nodejs'
    }

  }
  stages {
    stage('checkout scm') {
      steps {
        checkout(scm)
      }
    }
    stage('get utils') {
      steps {
        container('nodejs') {
          sh 'yum -y install openssl-devel libcurl-devel.x86_64'
          sh 'npm -g --unsafe-perm=true --allow-root install fish-pepper --build-from-source'
          sh '''wget -O s2i.tar.gz https://github.com/openshift/source-to-image/releases/download/v1.1.13/source-to-image-v1.1.13-b54d75d3-linux-amd64.tar.gz
  tar -xvf s2i.tar.gz
  cp ./s2i /usr/local/bin'''
          sh 'yum install -y maven'
        }

      }
    }
    stage('test') {
      steps {
        container('nodejs') {
          sh './test.sh'
        }

      }
    }
    stage('tag images') {
       when {
         branch 'master'
       }
      steps {
        container('nodejs') {
          sh '''docker tag s2i-java kubespheredev/java-8-centos7
docker tag s2i-java-11 kubespheredev/java-11-centos7
docker tag s2i-tomcat85-java8 kubespheredev/tomcat85-java8-centos7
docker tag s2i-tomcat85-java11 kubespheredev/tomcat85-java11-centos7'''
          sh '''docker tag s2i-java kubespheredev/java-8-centos7:2.1.0
docker tag s2i-java-11 kubespheredev/java-11-centos7:2.1.0
docker tag s2i-tomcat85-java8 kubespheredev/tomcat85-java8-centos7:2.1.0
docker tag s2i-tomcat85-java11 kubespheredev/tomcat85-java11-centos7:2.1.0
'''
        }

      }
    }
    stage('push images') {
      when {
        branch 'master'
      }
      steps {
        container('nodejs') {
          withCredentials([usernamePassword(passwordVariable : 'DOCKER_PASSWORD' ,usernameVariable : 'DOCKER_USERNAME' ,credentialsId : 'dockerhub-id' ,)]) {
            sh 'echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin'
          }

          sh '''docker push kubespheredev/java-8-centos7
docker push kubespheredev/java-11-centos7
docker push kubespheredev/tomcat85-java8-centos7
docker push kubespheredev/tomcat85-java11-centos7'''
        }

      }
    }
  }
}
