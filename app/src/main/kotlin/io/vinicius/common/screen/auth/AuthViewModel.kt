package io.vinicius.common.screen.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.vinicius.common.repository.Session
import io.vinicius.common.service.CountriesService
import io.vinicius.sak.network.NetworkState
import io.vinicius.sak.util.DataFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class AuthViewModel(
    private val service: CountriesService,
    private val session: Session
) : ViewModel(), DataFlow {
    val state = privateStateFlow(NetworkState.Idle)

    fun login(email: String, password: String) = viewModelScope.launch {
        service.login(email, password)
            .onStart { state.mutable = NetworkState.Loading }
            .catch { state.mutable = NetworkState.Error }
            .map { it.data }
            .flowOn(Dispatchers.IO)
            .collect {
                session.setToken(it)
                state.mutable = NetworkState.Idle
            }
    }

    fun logout() {
        session.setToken(null)
    }

    fun setState(value: NetworkState) {
        state.mutable = value
    }
}