package io.vinicius.common.screen.user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.vinicius.common.ui.component.defaultOverlaidStates
import io.vinicius.common.ui.theme.AndroidCommonTheme
import io.vinicius.sak.view.OverlaidColumn
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserScreen(viewModel: UserViewModel = koinViewModel()) {
    val user by viewModel.user.collectAsState()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchMe()
    }

    OverlaidColumn(
        state = state,
        overlaidStates = defaultOverlaidStates { },
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        user?.let {
            UserInfo(it)
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    AndroidCommonTheme {
        UserScreen()
    }
}