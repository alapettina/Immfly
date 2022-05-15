# web

- You have the pages objects in the path src/main/java/pages
Here are declared the elements of the page.

- You have the steps in the path src/main/java/stepDefinitions
There you have the hooks with the Before and After methods, and in the steps are defined the methods of the steps

- The features are in src/resources/features
There you defined the cases with a BDD redaction

- In the Pom you have the dependencies, in the console, positioned in the project you have to do the command:
mvn clean install
and all the dependencies will be installed

- Run local the execution class is in src/main/java/TestRunner
- The reports are generated in target/Report with the index name.
