package io.vinicius.common.repository

import io.vinicius.common.model.Token
import io.vinicius.sak.util.PrivateFlow

class Session : PrivateFlow {
    val token = privateStateFlow<Token?>(null)

    fun setToken(value: Token?) {
        token.mutable = value
    }
}