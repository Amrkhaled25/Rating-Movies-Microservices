# Microservices Rating Movies App

This project is a microservices-based application for rating movies. It utilizes Spring Boot for implementing microservices, Docker for containerization, Docker Compose for orchestrating containers, and Eureka for service discovery.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Architecture](#architecture)
- [Contributing](#contributing)
- [License](#license)

## Features

- Allows users to rate movies.
- Retrieves movie ratings.
- Service discovery using Eureka.
- Easy deployment using Docker and Docker Compose.

## Prerequisites

Make sure you have the following installed on your system:

- Docker
- Docker Compose
- JDK 8 or higher
- Maven

## Installation

1. **Clone this repository:**

    ```
    git clone https://github.com/Amrkhaled25/Rating-Movies-Microservices.git
    ```


3. **Build the microservices:**

    ```
    mvn clean install
    ```

## Usage

1. **Start the Docker containers:**

    ```
    docker-compose up
    ```

2. **Access the Eureka dashboard:**

    Open your browser and go to `http://localhost:8761`.



## Architecture

The application consists of the following microservices:

- **Movie Service (movie-service):** Provides endpoints for retrieving and adding movie ratings.
- **Rating Service (rating-service):** Handles the storage and retrieval of movie ratings.
- **Eureka Server (eureka-server):** Service registry and discovery server.
- **API Gateway (api-gateway):** Entry point for accessing microservices.

These microservices are deployed using Docker containers and managed by Docker Compose.



## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
