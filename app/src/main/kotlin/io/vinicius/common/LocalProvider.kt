package io.vinicius.common

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController
import io.vinicius.common.screen.auth.AuthViewModel

val LocalNavController = staticCompositionLocalOf<NavController> { error("No NavController found") }
val LocalAuthVM = compositionLocalOf<AuthViewModel> { error("No AuthViewModel found") }