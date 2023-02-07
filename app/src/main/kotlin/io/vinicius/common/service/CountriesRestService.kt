package io.vinicius.common.service

import io.vinicius.common.model.Response
import io.vinicius.common.model.Token
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface CountriesRestService {
    @POST("v1/auth/signin")
    @FormUrlEncoded
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Flow<Response<Token>>
}