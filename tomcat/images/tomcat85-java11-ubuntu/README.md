## Apache Tomcat 8.5.32

A simple docker build for installing a vanilla Tomcat 8.5.32 below */opt/tomcat*. It comes out of the box and is intended for use for integration testing.

During startup a directory specified by the environment variable `DEPLOY_DIR` (*/deployments* by default) is checked for .war files. If there are any, they are linked into the *webapps/* directory for automatic deployment. This plays nicely with the [docker-maven-plugin](https://github.com/fabric8io/docker-maven-plugin/) and its 'assembly' mode which can automatically create Docker data container with Maven artifacts exposed from a directory */deployments*.
Features:

* Tomcat Version: **8.5.32**
* Java Base Image: **fabric8/java-centos-openjdk8-jdk:1.5.1**
* Port: **8080**
* User **admin** (Password: **admin**) has been added to access the admin
  applications */host-manager* and */manager*)
* Documentation and examples have been removed
* Command: `/opt/tomcat/bin/deploy-and-run.sh` which links .war files from */maven* to
  */opt/tomcat/webapps* and then calls `undefined run`
* Sets `-Djava.security.egd=file:/dev/./urandom` for faster startup times
  (though a bit less secure)

### Debugging

  You can enable remote debugging by setting `JAVA_DEBUG` to any value:

  * **JAVA_DEBUG** If set remote debugging will be switched on
  * **JAVA_DEBUG_PORT** Port used for remote debugging. Default: 5005
