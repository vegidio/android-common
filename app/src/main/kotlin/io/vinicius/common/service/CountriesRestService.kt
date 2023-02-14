package io.vinicius.common.service

import io.vinicius.common.model.Response
import io.vinicius.common.model.SignInRequestDto
import io.vinicius.common.model.Token
import io.vinicius.sak.network.CacheConfig
import io.vinicius.sak.network.LogHandler
import io.vinicius.sak.network.RestFactory
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.POST

class CountriesRestService(
    baseUrl: String,
    logHandler: LogHandler? = null,
    cacheConfig: CacheConfig? = null
) : RestFactory<CountriesApi>(CountriesApi::class, baseUrl, logHandler = logHandler, cacheConfig = cacheConfig),
    CountriesService {

    override fun login(email: String, password: String) = api.login(SignInRequestDto(email, password))
}

interface CountriesApi {
    @POST("v1/auth/signin")
    fun login(@Body dto: SignInRequestDto): Flow<Response<Token>>
}