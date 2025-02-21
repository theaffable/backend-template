plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "backend-template"
include("domain")
include("primary-adapters")
include("secondary-adapters")
include("application")
