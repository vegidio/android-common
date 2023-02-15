package io.vinicius.common.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.vinicius.common.ui.component.Destination
import io.vinicius.common.ui.theme.AndroidCommonTheme
import io.vinicius.sak.view.ListRow

@Composable
fun HomeMenuRow(menuOption: MenuOption, modifier: Modifier = Modifier) {
    ListRow(modifier) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = menuOption.title)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    AndroidCommonTheme {
        val menuOption = MenuOption(Destination.Auth, "Auth")
        HomeMenuRow(menuOption, Modifier.size(200.dp, 40.dp))
    }
}