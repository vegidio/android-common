package io.vinicius.common.di

import io.vinicius.common.screen.auth.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        AuthViewModel(get(named("graphqlCountries")), get())
    }
}