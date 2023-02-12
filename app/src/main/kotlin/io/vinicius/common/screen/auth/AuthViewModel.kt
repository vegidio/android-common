package io.vinicius.common.screen.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.vinicius.common.repository.Session
import io.vinicius.common.service.CountriesGraphqlService
import io.vinicius.common.service.CountriesRestService
import io.vinicius.sak.network.NetworkState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import timber.log.Timber

class AuthViewModel(private val service: CountriesRestService, private val session: Session) : ViewModel() {
    val state = MutableStateFlow(NetworkState.Idle)
    val graphql = CountriesGraphqlService()

    fun loginTest() = viewModelScope.launch {
        graphql.login("vegidio@gmail.com", "password1")
            .map { it.data }
            .collect {
                Timber.d("Blah: ${it.accessToken}")
                Timber.d("Blah: ${it.refreshToken}")
            }
    }

    fun login(email: String, password: String) = viewModelScope.launch {
        service.login(email, password)
            .onStart { state.value = NetworkState.Loading }
            .catch { state.value = NetworkState.Error }
            .map { it.data }
            .flowOn(Dispatchers.IO)
            .collect {
                session.token.value = it
                state.value = NetworkState.Idle
            }
    }

    fun logout() {
        session.token.value = null
    }
}