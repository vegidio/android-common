package io.vinicius.common.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.vinicius.common.LocalAuthVM
import io.vinicius.common.repository.Session
import io.vinicius.common.ui.component.defaultOverlaidStates
import io.vinicius.common.ui.theme.AndroidCommonTheme
import io.vinicius.sak.network.NetworkState
import io.vinicius.sak.view.OverlaidColumn
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject

@Composable
fun AuthScreen(viewModel: AuthViewModel = koinViewModel(), session: Session = koinInject()) {
    val token by session.token.collectAsState()
    val state by viewModel.state.collectAsState()

    CompositionLocalProvider(LocalAuthVM provides viewModel) {
        OverlaidColumn(
            state = state,
            overlaidStates = defaultOverlaidStates { viewModel.setState(NetworkState.Idle) },
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            AuthLoginForm(viewModel)

            token?.let {
                HorizontalDivider()
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