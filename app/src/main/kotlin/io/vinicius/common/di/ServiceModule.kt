package io.vinicius.common.di

import io.vinicius.common.service.CountriesRestService
import io.vinicius.sak.network.FlowCallAdapterFactory
import io.vinicius.sak.network.RestFactory
import org.koin.dsl.module

val serviceModule = module {
    // RestFactory
    single {
        RestFactory(
            context = get(),
            converter = get(),
            callAdapter = FlowCallAdapterFactory()
        )
    }

    // CountriesRestService
    single {
        val restFactory = get<RestFactory>()
        restFactory.create(CountriesRestService::class, "https://countries.vinicius.io/api/")
    }
}