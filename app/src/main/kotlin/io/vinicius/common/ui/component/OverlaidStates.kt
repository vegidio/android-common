package io.vinicius.common.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.vinicius.common.ui.theme.AndroidCommonTheme
import io.vinicius.sak.network.NetworkState
import io.vinicius.sak.view.OverlaidStates

fun defaultOverlaidStates(
    loadingMessage: String = "Loading...",
    errorMessage: String = "Error fetching data from the server",
    errorButton: String = "Try again",
    onErrorClick: () -> Unit
): OverlaidStates = mutableMapOf(
    NetworkState.Loading to { LoadingState(loadingMessage) },
    NetworkState.Error() to { ErrorState(errorMessage, errorButton, onClick = onErrorClick) }
)

@Composable
fun LoadingState(
    message: String,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        CircularProgressIndicator(Modifier.size(56.dp))

        Text(message)
    }
}

@Composable
fun ErrorState(
    message: String,
    button: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Icon(
            imageVector = Icons.Default.Error,
            contentDescription = "Error",
            modifier = Modifier.size(56.dp)
        )

        Text(message)

        Button(onClick) {
            Text(button)
        }
    }
}

@Preview
@Composable
private fun DefaultPreview1() {
    AndroidCommonTheme {
        LoadingState(message = "Loading...")
    }
}

@Preview
@Composable
private fun DefaultPreview2() {
    AndroidCommonTheme {
        ErrorState("Error connecting to the server", "Close", onClick = {})
    }
}