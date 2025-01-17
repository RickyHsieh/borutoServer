package com.purplestudio.routes

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.root() {
    get("/") {
        call.respond(
            message = "welcome to Boruto API !",
            status = HttpStatusCode.OK
        )
    }
}