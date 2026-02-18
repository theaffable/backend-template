# Use a multi-stage build for efficiency
# Stage 1: Build the application
FROM gradle:8.8-jdk21 AS builder
WORKDIR /app

# Copy the project files
COPY settings.gradle.kts gradle/ ./
COPY gradle/libs.versions.toml gradle/libs.versions.toml

# Pre-download dependencies for caching
RUN gradle dependencies --no-daemon || return 0

COPY application ./application
COPY domain ./domain
COPY primary-adapters ./primary-adapters
COPY secondary-adapters ./secondary-adapters

# Build the application
RUN gradle build --no-daemon

# Stage 2: Create runtime image
FROM openjdk:27-ea-slim
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/application/build/libs/application-all.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
