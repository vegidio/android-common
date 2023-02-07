package io.vinicius.common.screen.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.vinicius.common.LocalAuthVM
import io.vinicius.common.repository.Session
import io.vinicius.common.ui.theme.AndroidCommonTheme
import org.koin.androidx.compose.get
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthScreen(viewModel: AuthViewModel = koinViewModel(), session: Session = get()) {
    val token by session.token.collectAsState()

    CompositionLocalProvider(LocalAuthVM provides viewModel) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            AuthLoginForm(viewModel)

            token?.let {
                Divider()
                AuthTokenInfo(it)
            }
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AndroidCommonTheme {
        AuthScreen()
    }
}