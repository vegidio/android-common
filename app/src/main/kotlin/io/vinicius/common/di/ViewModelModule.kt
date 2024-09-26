package io.vinicius.common.di

import io.vinicius.common.screen.auth.AuthViewModel
import io.vinicius.common.screen.countries.CountriesViewModel
import io.vinicius.common.screen.user.UserViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {
    val apiType = "restCountries"

    viewModel {
        AuthViewModel(get(named(apiType)), get())
    }

    viewModel {
        UserViewModel(get(named(apiType)))
    }

    viewModel {
        CountriesViewModel(get(named(apiType)))
    }
}