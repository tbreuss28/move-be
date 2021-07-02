# Swagger GUI

- GUI: http://localhost:8080/swagger-ui.html
- File: http://localhost:8080/v3/api-docs/
 
 
 
 
 # Build Docker Image
 
```
docker build --build-arg JAR_FILE=build/libs/\*.jar -t <repo>/movenow-backend .
```
 
With Gradle:
 
```
./gradlew bootBuildImage --imageName=<repo>/movenow-backend
```