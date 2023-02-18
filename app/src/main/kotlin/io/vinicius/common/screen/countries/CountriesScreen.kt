package io.vinicius.common.screen.countries

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.vinicius.common.LocalNavController
import io.vinicius.common.ui.component.defaultOverlaidStates
import io.vinicius.common.ui.theme.AndroidCommonTheme
import io.vinicius.sak.view.OverlaidLazyColumn
import org.koin.androidx.compose.koinViewModel

@Composable
fun CountriesScreen(viewModel: CountriesViewModel = koinViewModel()) {
    val navController = LocalNavController.current
    val countries by viewModel.countries.collectAsState()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCountries()
    }

    OverlaidLazyColumn(
        state = state,
        overlaidStates = defaultOverlaidStates(errorButton = "Try again") { viewModel.fetchCountries() },
    ) {
        items(countries) {
            CountryRow(
                country = it,
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clickable {
                        // navController.navigate(it.code)
                    }
            )
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AndroidCommonTheme {
        CountriesScreen()
    }
}