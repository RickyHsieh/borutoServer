package com.purplestudio.di

import com.purplestudio.repository.HeroRepository
import com.purplestudio.repository.HeroRespositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<HeroRepository> {
        HeroRespositoryImpl()
    }
}