package com.purplestudio.plugin

import com.purplestudio.routes.getAllHeroes
import com.purplestudio.routes.root
import com.purplestudio.routes.searchHeroes
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        root()
        getAllHeroes()
        searchHeroes()
        staticResources("/images", "images")
    }
}
