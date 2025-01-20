package com.purplestudio.routes

import com.purplestudio.models.ApiResponse
import com.purplestudio.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getAllHeroes() {

    val heroRepository: HeroRepository by inject()

    get("/boruto/heroes") {
        try {
            call.application.log.info("Injected HeroRepository instance ==============================>: $heroRepository")

            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5)
            call.respond(message = heroRepository.getAllHeroes(page))
        }catch (e: NumberFormatException) {
            call.respond(
                message = ApiResponse(success = false, message = "Only Number Allowed"),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(success = false, message = "Heroes not found."),
                status = HttpStatusCode.NotFound
            )
        } catch (e: Exception) {
            call.application.log.error("An unexpected error occurred", e)
            call.respond(
                message = e.printStackTrace(),
                status = HttpStatusCode.NotFound
            )
        }
    }
}