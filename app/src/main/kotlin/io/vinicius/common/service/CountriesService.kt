package io.vinicius.common.service

import io.vinicius.common.model.Response
import io.vinicius.common.model.Token
import kotlinx.coroutines.flow.Flow

interface CountriesService {
    fun login(email: String, password: String): Flow<Response<Token>>
}