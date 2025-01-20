package com.purplestudio

import com.purplestudio.plugin.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {

    configureKoin()
    configureSerialization()
    configureMonitoring()
    configureRouting()
    configureDefaultHeaders()
    configureStatusPages()
}
