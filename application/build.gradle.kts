plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlinx.serialization)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":primary-adapters"))
    implementation(project(":secondary-adapters"))
    implementation(libs.bundles.kotlin)

    testImplementation(kotlin("test"))
    testImplementation(libs.bundles.kotest)
}

tasks.test {
    useJUnitPlatform()
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