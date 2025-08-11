## Spring Boot basic web application

Basic Spring Boot web application serving static content.

### Build and run

#### Prerequisites

- Java 8
- Maven 3.0+

#### Using the terminal

Go on the project's root folder, then type:

    $ mvn spring-boot:run

#### From Eclipse (Spring Tool Suite)

Import as *Existing Maven Project* and run it as *Spring Boot App*.


### Usage

- Launch the application and go on http://localhost:8080/
- You can see the content from the static page `hello.html`

#### s2i 

    s2i build https://github.com/kubesphere/s2i-java-container --context-dir=java/examples/spring-boot-maven/ kubespheredev/java-8-ubuntu s2i-java-spring-maven-example
    docker run -p 8080:8080 s2i-java-spring-maven-example
