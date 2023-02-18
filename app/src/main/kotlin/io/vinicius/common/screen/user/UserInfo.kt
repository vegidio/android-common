package io.vinicius.common.screen.user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import io.vinicius.common.model.User

@Composable
fun UserInfo(user: User) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "User",
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold
            )

            CardRow("ID:", user.id.toString())
            CardRow("Name:", user.name)
            CardRow("Username:", user.username)
            CardRow("E-mail:", user.email)
        }
    }
}

@Composable
private fun CardRow(label: String, value: String) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(label, fontWeight = FontWeight.Bold)
        Text(
            value,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}