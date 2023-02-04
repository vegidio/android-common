package io.vinicius.common.shared

import androidx.compose.runtime.Composable

enum class Router {
    Auth,
    User,
    CountryByCode,
    Countries;

    val view: @Composable () -> Unit
        get() {
            return when (this) {
                Auth -> { {} }
                User -> { {} }
                CountryByCode -> { {} }
                Countries -> { {} }
            }
        }
}