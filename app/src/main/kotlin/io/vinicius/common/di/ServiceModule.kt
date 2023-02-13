package io.vinicius.common.di

import io.vinicius.common.service.CountriesGraphqlService
import io.vinicius.common.service.CountriesRestService
import io.vinicius.common.service.CountriesService
import io.vinicius.sak.network.FlowCallAdapterFactory
import io.vinicius.sak.network.RestFactory
import org.koin.core.qualifier.named
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
    single<CountriesService>(named("restCountries")) {
        val restFactory = get<RestFactory>()
        restFactory.create(CountriesRestService::class, "https://countries.vinicius.io/api/")
    }

    // CountriesGraphqlService
    single<CountriesService>(named("graphqlCountries")) {
        CountriesGraphqlService()
    }
}