# Product Selection Page Demo

## Technical Choices

* Spring Boot for main Java application to provide web endpoints and data persistence
* JBehave 

## Running the application

### Requirements

* Java 8

### Github

Clone a copy of this repository

### Using Maven

From the project root directory

	mvn spring-boot:run

or if you don't have maven installed use the packaged maven command (windows ./mvnw.cmd, linux ./mvnw)

	mvnw.cmd spring-boot:run

### Opening the documentation

	curl -H "Content-Type: application/json" -X POST -d '{}' http://localhost:8080/api/roulette/European

## Testing results

To run the JBehave BDD tests using maven

	mvn clean test

During the test phase, the BDD framework will have captured the acceptance criteria report. This will be available at:

	{project_root}/target/jbehave/view/index.html
	
This will report all the stories in `/src/test/resources/stories/`