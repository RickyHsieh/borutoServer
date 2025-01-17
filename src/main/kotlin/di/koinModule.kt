package com.purplestudio.di

import com.purplestudio.repository.HeroRespository
import com.purplestudio.repository.HeroRespositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<HeroRespository> {
        HeroRespositoryImpl()
    }
}