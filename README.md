# Swagger GUI

- GUI: http://localhost:8000/swagger-ui.html
- File: http://localhost:8000/v3/api-docs/
 
 
 
 
 # Build Docker Image
 
```
docker build --build-arg JAR_FILE=build/libs/\*.jar -t moveregistry.azurecr.io/move-be .
```
 
With Gradle:
 
```
./gradlew bootBuildImage --imageName=moveregistry.azurecr.io/move-be
```