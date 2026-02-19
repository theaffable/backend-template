import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

fun Application.configureRouting() {
    routing {
        get("/health") {
            call.respond(HealthResponse(status = "UP"))
        }

        get("/hello") {
            call.respond(HelloResponse("Hello World!"))
        }
    }
}

@Serializable
data class HealthResponse(val status: String)

@Serializable
data class HelloResponse(val message: String)

