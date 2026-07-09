**Architectural Design**

To maintain a clean separation of concerns, the project is structured into three distinct layers:
* **Domain**: Contains pure business entities (Cart, Product, User) and business rules (e.g., pricing 
promotions) without any framework dependencies.
* **Application**: Contains incoming/outgoing ports (interfaces) and use-case handlers (services) orchestrating domain logic.
* **Infrastructure**: Framework-specific implementations, including database persistence adapters (Spring Data JPA + 
  PostgreSQL) and web controllers mapping the OpenAPI generated code to the domain ports.

**API First approach**

First I've created the OpenApi yaml file, describing all the endpoints, with all details and the DTOs.
In order to generate the code using the rules from this openapi file, I've added the openapi generator gradle plugin 
in build.gradle.

To generate the source code from openapi file, you must go to root folder of the project and run this command in 
terminal:

**_./gradlew openApiGenerate_**

It will generate all the API interfaces that will be implemented by controllers and all the DTOs.
After this code was generated, I've added the rest of the folders, files and code.

