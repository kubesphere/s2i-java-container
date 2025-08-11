# s2i-java-gradle-example

## Usage

### S2I

    s2i build https://github.com/kubesphere/s2i-java-container --context-dir=java/examples/gradle/ kubespheredev/java-8-ubuntu s2i-java-gradle-example
    docker run -p 8080:8080 s2i-java-gradle-example
 

### Gradle locally

    ./gradlew build
    java -jar build/libs/s2i-java-gradle-example.jar

See the [README of the Maven example](../maven/README.md) for more information.
