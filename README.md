# Backend Template

A modern backend template for JVM-based applications built with Gradle and Kotlin.

## Features

### Included
- **Multi-module Gradle setup** - Hexagonal architecture
- **Gradle version catalogs** - Dependency management with `.toml` file
- **Kotlinx serialization** - JSON serialization/deserialization
- **Testing framework** - Kotest & MockK
- **Multi-stage Dockerfile** - Docker image with build caching

### Available (disabled by default)
- **Ktor** - Web framework
- **Exposed** - Kotlin SQL framework with PostgreSQL driver

## Building Docker Image

To build the project as a Docker image:

```bash
docker build -t backend-template:latest .
```

This will create a containerized version of the application using the multi-stage Dockerfile, which:
- Builds the application using Gradle 8.8 and JDK 21
- Creates a slim runtime image with OpenJDK 21
- Exposes port 8080 for the application