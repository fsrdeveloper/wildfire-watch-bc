# Wildfire Watch BC

This project aims to provide real-time wildfire data to the residents of British Columbia, Canada. It's built using Java Spring Boot for backend services, Angular 13 for the frontend, Redis for caching, and Nginx for reverse proxy and static content serving.

## Project Setup

1. Clone the repository
    ```bash
        git clone https://github.com/fsrdeveloper/wildfire-watch-bc.git
    ```
2. Navigate to the project directory
    ```bash
        cd wildfire-watch-bc
    ```

## Backend API Setup

The Backend API is defined in a Spring Boot application. It provides a RESTful API for retrieving fire points data.

### Dependencies

- Java 11
- Gradle 6.3.0

### Setup

1. Navigate to the `wildfire-watch-bc-api` directory
    ```bash
        cd wildfire-watch-bc-api
    ```
2. Build the project with Gradle
    ```bash
        ./gradlew build
    ```
3. Run the application
    ```bash
        ./gradlew bootRun --args='--server.port=8090'
    ```
The API will be available at `http://localhost:8090`.

### Docker Setup

The Dockerfile in the project root directory defines a multi-stage build process for creating a Docker image of the application.

1. From the project root directory, build the Docker image.
    ```bash
    docker build -t wwildfire-watch-bc-api .
    ```
2. Run the Docker container.
    ```bash
    docker run -p 8090:8090 wildfire-watch-bc-api
    ```
The application will then be accessible at `http://localhost:8090`.

### Test
You can run on terminal
    ```bash
     curl "http://localhost:8090/fire-points
    ```


## Licensing

This project is licensed under the terms of Apache License 2.0. See the [LICENSE](./LICENSE) file for license rights and limitations.

