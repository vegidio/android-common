package io.vinicius.common.screen.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.vinicius.common.model.User
import io.vinicius.common.service.CountriesService
import io.vinicius.sak.network.NetworkState
import io.vinicius.sak.util.PrivateFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class UserViewModel(
    private val service: CountriesService
) : ViewModel(), PrivateFlow {
    val user = privateStateFlow<User?>(null)
    val state = privateStateFlow(NetworkState.Idle)

    fun fetchMe() = viewModelScope.launch {
        service.fetchMe()
            .onStart { state.mutable = NetworkState.Loading }
            .catch { state.mutable = NetworkState.Error }
            .map { it.data }
            .flowOn(Dispatchers.IO)
            .collect {
                user.mutable = it
                state.mutable = NetworkState.Idle
            }
    }
}