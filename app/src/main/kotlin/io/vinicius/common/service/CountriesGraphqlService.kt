package io.vinicius.common.service

import io.vinicius.common.graphql.SignInMutation
import io.vinicius.common.graphql.type.SignInRequestDto
import io.vinicius.common.model.Response
import io.vinicius.common.model.Token
import io.vinicius.sak.network.GraphqlFactory
import kotlinx.coroutines.flow.Flow

class CountriesGraphqlService : GraphqlFactory(
    "https://countries.vinicius.io/graphql",
    Token::class
) {
    fun login(email: String, password: String): Flow<Response<Token>> {
        val mutation = SignInMutation(SignInRequestDto(email, password))
        return sendMutation(mutation)
    }
}