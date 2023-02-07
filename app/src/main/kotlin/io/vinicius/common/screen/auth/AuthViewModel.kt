package io.vinicius.common.screen.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.vinicius.common.model.Token
import io.vinicius.common.service.CountriesRestService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class AuthViewModel constructor(
    private val service: CountriesRestService
) : ViewModel() {
    val token = MutableStateFlow<Token?>(null)

    fun login(email: String, password: String) = viewModelScope.launch {
        service.login(email, password)
            .map { it.data }
            .flowOn(Dispatchers.IO)
            .collect {
                println(it.accessToken)
                token.value = it
            }
    }
}