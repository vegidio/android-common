package io.vinicius.common.screen.countries

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.vinicius.common.model.Country
import io.vinicius.common.ui.theme.AndroidCommonTheme
import io.vinicius.sak.view.ListRow

@Composable
fun CountryRow(country: Country, modifier: Modifier = Modifier) {
    ListRow(modifier) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(country.name.common)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    AndroidCommonTheme {
    }
}