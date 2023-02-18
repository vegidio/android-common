package io.vinicius.common.screen.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.vinicius.common.model.Country
import io.vinicius.common.service.CountriesService
import io.vinicius.sak.network.NetworkState
import io.vinicius.sak.util.PrivateFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CountriesViewModel(
    private val service: CountriesService
) : ViewModel(), PrivateFlow {
    val countries = privateStateFlow(emptyList<Country>())
    val state = privateStateFlow(NetworkState.Idle)

    fun fetchCountries() = viewModelScope.launch {
        service.fetchCountries()
            .onStart { state.mutable = NetworkState.Loading }
            .catch { state.mutable = NetworkState.Error }
            .map { it.data }
            .flowOn(Dispatchers.IO)
            .collect {
                countries.mutable = it
                state.mutable = NetworkState.Idle
            }
    }

    fun setState(value: NetworkState) {
        state.mutable = value
    }
}