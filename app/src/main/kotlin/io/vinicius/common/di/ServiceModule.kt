package io.vinicius.common.di

import io.vinicius.common.service.CountriesGraphqlService
import io.vinicius.common.service.CountriesRestService
import io.vinicius.common.service.CountriesService
import io.vinicius.sak.network.LogHandler
import org.koin.core.qualifier.named
import org.koin.dsl.module
import timber.log.Timber

val serviceModule = module {
    // CountriesRestService
    single<CountriesService>(named("restCountries")) {
        CountriesRestService(
            baseUrl = "https://countries.vinicius.io/api/",
            logHandler = LogHandler(Timber::d, "NONE")
        )
    }

    // CountriesGraphqlService
    single<CountriesService>(named("graphqlCountries")) {
        CountriesGraphqlService(
            url = "https://countries.vinicius.io/graphql"
        )
    }
}