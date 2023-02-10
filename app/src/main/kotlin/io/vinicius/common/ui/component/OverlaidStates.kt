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

fun defaultOverlaidStates(onErrorClick: () -> Unit): OverlaidStates = mutableMapOf(
    NetworkState.Loading to { LoadingState() },
    NetworkState.Error to { ErrorState(onClick = onErrorClick) }
)

@Composable
fun LoadingState(
    modifier: Modifier = Modifier,
    message: String = "Loading..."
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
    modifier: Modifier = Modifier,
    message: String = "Error connecting to the server",
    onClick: () -> Unit = {}
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
            Text("Close")
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
        ErrorState(message = "Error connecting to the server")
    }
}