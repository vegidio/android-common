package io.vinicius.common.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.vinicius.common.shared.Router
import io.vinicius.common.ui.theme.AndroidCommonTheme

@Composable
fun HomeMenuRow(menuOption: MenuOption) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Text(text = menuOption.title)
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AndroidCommonTheme {
        val menuOption = MenuOption(Router.Auth, "Auth")
        HomeMenuRow(menuOption)
    }
}