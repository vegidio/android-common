package io.vinicius.common.service

import io.vinicius.common.graphql.CountriesQuery
import io.vinicius.common.graphql.MeQuery
import io.vinicius.common.graphql.SignInMutation
import io.vinicius.common.graphql.type.SignInRequestDto
import io.vinicius.common.model.Country
import io.vinicius.common.model.Response
import io.vinicius.common.model.Token
import io.vinicius.common.model.User
import io.vinicius.sak.network.GraphqlFactory
import kotlinx.coroutines.flow.Flow

class CountriesGraphqlService(
    url: String
) : GraphqlFactory(url, Token::class), CountriesService {

    override fun login(email: String, password: String): Flow<Response<Token>> {
        val mutation = SignInMutation(SignInRequestDto(email, password))
        return sendMutation(mutation)
    }

    override fun fetchMe(): Flow<Response<User>> {
        val query = MeQuery()
        return sendQuery(query)
    }

    override fun fetchCountries(): Flow<Response<List<Country>>> {
        val query = CountriesQuery()
        return sendQuery(query)
    }
}