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

## Frontend Setup

1. Navigate to the `wildfire-watch-bc-ui` directory
    ```bash
        cd ../wildfire-watch-bc-ui
    ```
2. Install Angular dependencies
    ```bash
        npm install
    ```
3. Serve the application
    ```bash
        ng serve --port 4200
    ```
The frontend will be accessible at `http://localhost:4200`.

## Docker Setup

1. Navigate back to the root directory
2. Build and run all services using docker-compose
    ```bash
        docker-compose up
    ```
This will make the API, frontend application and Redis available at their respective host ports as defined in the docker-compose.yml file.

## App Usage

Navigate to the frontend on your browser and interact with the application to monitor active wildfires in BC. You can filter fire points by Fire Status, Fire Cause, and Geographic Description using the provided interface.

The frontend will be accessible at `http://localhost`.

## Contribution

This is an open-source project, feel free to contribute by submitting a pull request.


## Licensing

This project is licensed under the terms of Apache License 2.0. See the [LICENSE](./LICENSE) file for license rights and limitations.

