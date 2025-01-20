package com.purplestudio.plugin


import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import javax.security.sasl.AuthenticationException

fun Application.configureStatusPages() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound) { status ->
            call.respond(
                message = "Page Not Found.",
                status = status
            )
        }
//        exception<AuthenticationException> { call, exception ->
//            call.respond(
//                message = "we caught an exception: ${exception.localizedMessage}",
//                status = HttpStatusCode.OK
//            )
//        }

    }


}