plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.ktor)
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":primary-adapters"))
    implementation(project(":secondary-adapters"))
    implementation(libs.bundles.kotlin)
    implementation(libs.bundles.ktor)

    testImplementation(kotlin("test"))
    testImplementation(libs.bundles.kotest)
}

tasks.test {
    useJUnitPlatform()
}

// disable the jar task added by application plugin, we're using the shadowJar added by ktor
tasks.jar {
    enabled = false
}

kotlin {
    jvmToolchain(21)
    compilerOptions {
        freeCompilerArgs.addAll(
            // enable kotlin built-in Uuid type
            "-opt-in=kotlin.uuid.ExperimentalUuidApi"
        )
    }
}

application {
    mainClass.set("ApplicationKt")
}