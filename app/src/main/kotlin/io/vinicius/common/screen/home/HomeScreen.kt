package io.vinicius.common.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.vinicius.common.LocalNavController
import io.vinicius.common.ui.component.Destination
import io.vinicius.common.ui.theme.AndroidCommonTheme

@Composable
fun HomeScreen() {
    val navController = LocalNavController.current

    val menuOptions = listOf(
        MenuOption(Destination.User, "Me"),
        MenuOption(Destination.CountryByCode, "Country By Code"),
        MenuOption(Destination.Countries, "Countries"),
    )

    LazyColumn {
        items(menuOptions) {
            HomeMenuRow(
                menuOption = it,
                Modifier.clickable {
                    navController.navigate(it.id.name)
                }
            )
        }
    }
}

data class MenuOption(
    val id: Destination,
    val title: String
)

@Preview
@Composable
private fun DefaultPreview() {
    AndroidCommonTheme {
        HomeScreen()
    }
}