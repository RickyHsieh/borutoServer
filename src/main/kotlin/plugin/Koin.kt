package com.purplestudio.plugin

import com.purplestudio.di.koinModule
import com.purplestudio.repository.HeroRepository
import com.purplestudio.repository.HeroRespositoryImpl
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
    install(Koin){
        slf4jLogger()
        modules(koinModule)
    }
}
val koinModule = module {
    single<HeroRepository> { HeroRespositoryImpl() }
}
