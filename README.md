# Backend Template

A modern backend template for JVM-based applications built with Gradle and Kotlin.

## Features

### Included
- **Multi-module Gradle setup** - Hexagonal architecture
- **Gradle version catalogs** - Dependency management with `.toml` file
- **Ktor** - Web framework
- **Kotlinx serialization** - JSON serialization/deserialization
- **Testing framework** - Kotest & MockK
- **Multi-stage Dockerfile** - Docker image with build caching

### Available (disabled by default)
- **Exposed** - Kotlin SQL framework with PostgreSQL driver

## Building Docker Image

To build the project as a Docker image:

```bash
name="backend-template"
docker build -t ${name}:latest .
```

## Running Docker Image

To run the Docker image with port forwarding:

```bash
docker run -p 8080:8080 backend-template:latest
```