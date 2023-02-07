package io.vinicius.common.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.vinicius.common.repository.Session
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory

val commonModule = module {
    // Session
    singleOf(::Session)

    // MoshiConverterFactory
    single<Converter.Factory> {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        MoshiConverterFactory.create(moshi)
    }
}