package io.vinicius.common.service

import io.vinicius.common.model.Country
import io.vinicius.common.model.Response
import io.vinicius.common.model.Token
import io.vinicius.common.model.User
import kotlinx.coroutines.flow.Flow

interface CountriesService {
    var headers: MutableMap<String, String>

    // Auth
    fun login(email: String, password: String): Flow<Response<Token>>

    // User
    fun fetchMe(): Flow<Response<User>>

    // Countries
    fun fetchCountries(): Flow<Response<List<Country>>>
}