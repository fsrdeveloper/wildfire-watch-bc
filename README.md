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

