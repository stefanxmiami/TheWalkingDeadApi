# 🧟‍♂️ The Walking Dead API 🧟‍♀️

This project provides a RESTful API for managing character data from "The Walking Dead" series. It's built using Spring Boot and PostgreSQL and is fully dockerized for easy setup and deployment.

## ✨ Features

- 🌐 RESTful API to access character data.
- 🗄️ Integrated with PostgreSQL for persistent storage.
- 🐳 Docker and Docker Compose integration for simplified development and deployment.
- 📜 Flyway for database migrations.

## 🛠️ Prerequisites

Before you begin, ensure you have the following installed on your system:

- Docker
- Docker Compose
- Git (for version control)

## 🚀 Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### 📥 Clone the Repository

First, clone the repository to your local machine:

```bash
git clone https://github.com/yourusername/thewalkingdeadapi.git
cd thewalkingdeadapi
```

## 🌍 Environment Setup

Create a `.env` file in the project root directory. This file should contain all the necessary environment variables:

```bash
# PostgreSQL credentials
DB_USERNAME=postgres
DB_PASSWORD=your_password_here
```

## 🏗️ Option 2: Inline Environment Variables

Alternatively, you can set environment variables directly in the terminal when running Docker Compose. This method allows you to specify variables without storing them in a file, ideal for temporary or testing setups.

For Bash (Linux/macOS):

```bash
DB_USERNAME=postgres DB_PASSWORD=your_password_here docker-compose up
```

For PowerShell (Windows):

```bash
$env:DB_USERNAME='postgres'; $env:DB_PASSWORD='your_password_here'; docker-compose up
```

Make sure to replace `your_password_here` with a secure password.

## 🐋 Running with Docker Compose

To start the application along with its dependencies, run the following command:

```bash
docker-compose up
```

This command builds the Docker image if it doesn't exist and starts all services defined in `docker-compose.yml`.

## 🌐 Accessing the Application

Once the application is running, you can access it at:

```bash
http://localhost:8080
```

## 🛑 Stopping the Application

To stop all running services, use the following command:

```bash
docker-compose down
```

## 📖 API Documentation

- **GET** `/api/characters`: List all characters.
- **POST** `/api/characters`: Add a new character.
- **GET** `/api/characters/{id}`: Retrieve a character by ID.

### Filtering Characters

You can filter characters using various query parameters. Here are the available parameters:

- `name` (String): Filter by character name.
- `status` (String): Filter by character status.
- `groupAffiliation` (String): Filter by group affiliation.
- `age` (Integer): Filter by age.
- `gender` (String): Filter by gender.
- `ethnicity` (String): Filter by ethnicity.
- `fanRating` (Double): Filter by fan rating.
- `narrativeRole` (String): Filter by narrative role.

Example request:

```bash
http://localhost:8080/api/characters/?name=Rick+Grimes&status=Alive&groupAffiliation=Survivors
```

## 🚢 Deployment

Include additional notes about how to deploy this on a live system.

## 🛠️ Built With

- Spring Boot - The framework used
- Maven - Dependency Management
- PostgreSQL - Used for the database
- Docker - Containerization

## ✍️ Authors

- Stefan Ivanov
