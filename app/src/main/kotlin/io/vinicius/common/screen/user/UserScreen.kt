package io.vinicius.common.screen.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import io.vinicius.common.ui.theme.AndroidCommonTheme

@Composable
fun UserScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    )
}

@Preview
@Composable
private fun DefaultPreview() {
    AndroidCommonTheme {
        UserScreen()
    }
}