package com.purplestudio

import io.ktor.http.HttpHeaders
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.defaultheaders.DefaultHeaders
import java.time.Duration

fun Application.configureDefaultHeaders() {
    install(DefaultHeaders) {
        header(HttpHeaders.CacheControl, "public, max-age=${Duration.ofDays(365).seconds}, immutable")
    }
}
