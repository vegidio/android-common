package io.vinicius.common.screen.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import io.vinicius.common.LocalAuthVM
import io.vinicius.common.model.Token

@Composable
fun AuthTokenInfo(token: Token) {
    val viewModel = LocalAuthVM.current

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "Tokens",
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold
            )

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Access:", fontWeight = FontWeight.Bold)
                Text(
                    token.accessToken,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Refresh:", fontWeight = FontWeight.Bold)
                Text(
                    token.refreshToken,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Button(
                onClick = { viewModel.logout() },
                modifier = Modifier.fillMaxWidth(fraction = 0.5f)
            ) {
                Text("Logout")
            }
        }
    }
}