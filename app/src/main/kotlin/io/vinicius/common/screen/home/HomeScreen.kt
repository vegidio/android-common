package io.vinicius.common.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import io.vinicius.common.shared.Router
import io.vinicius.common.ui.theme.AndroidCommonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    val menuOptions = listOf(
        MenuOption(Router.User, "Me"),
        MenuOption(Router.CountryByCode, "Country By Code"),
        MenuOption(Router.Countries, "Countries"),
    )

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Android Common") },
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            BottomAppBar() {
            }
        }
    ) { padding ->
        LazyColumn(Modifier.padding(padding)) {
            items(menuOptions) {
                HomeMenuRow(menuOption = it)
            }
        }
    }
}

data class MenuOption(
    val id: Router,
    val title: String
)

@Preview
@Composable
private fun DefaultPreview() {
    AndroidCommonTheme {
        HomeScreen()
    }
}