# s2i-java-maven-example

This S2I example is intentionally NOT using Spring Boot, Vert.x, Dropwizard, Wildfly Swarm or whatever other simple "fat JAR" (non-WAR/EAR) Java
server framework, but for clarity simply uses the simplest possible Java server application with a main() class.  You can easily apply this example to whatever standalone Java application you want to container-ize with S2I.  (We're using the Java built-in com.sun.net.httpserver.HttpServer; *JUST* for illustration of S2I.)


## Local

For local building, install s2i either from source https://github.com/openshift/source-to-image/releases/ or e.g. via:

    sudo dnf install source-to-image

    s2i build https://github.com/kubesphere/s2i-java-container --context-dir=java/examples/maven/ kubespheredev/java-8-ubuntu s2i-java-maven-example


_NB The `--copy` ensures that the latest content of the current directory and not only it's commited .git content is used ([see S2I #418](https://github.com/openshift/source-to-image/issues/418))._

Now run it like this:

    docker run -p 8080:8080 s2i-java-example

and see "hello, world" when accessing http://localhost:8080 - it works!


## KubeSphere



## Advanced

### Container options

All JVM options documented on https://github.com/kubesphere/s2i-java-container/tree/master/java/images/ubuntu
are typically specified in [`.s2i/environment`](.s2i/environment), but for quick testing can obviously also be specified on the `docker run` CLI like so:

    docker run -e "JAVA_MAIN_CLASS=io.kubesphere.devops.s2i.example.Server" -p 8080:8080 s2i-java-example


## TODO points

* Why isn't it incremental?  Keeps re-downloading Maven basics, every time..
* Support Gradle!
* Monitoring..
* Sources should not be runtime container?!


## More background

* https://github.com/kubesphere/s2i-java-container
* https://github.com/kubesphere/s2i-java-container/tree/master/java/images/ubuntu
* https://github.com/kubesphere/s2ioperator
