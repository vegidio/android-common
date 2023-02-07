package io.vinicius.common.repository

import io.vinicius.common.model.Token
import kotlinx.coroutines.flow.MutableStateFlow

class Session {
    val token = MutableStateFlow<Token?>(null)
}