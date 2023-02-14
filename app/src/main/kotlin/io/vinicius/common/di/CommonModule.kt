package io.vinicius.common.di

import io.vinicius.common.repository.Session
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonModule = module {
    // Session
    singleOf(::Session)
}