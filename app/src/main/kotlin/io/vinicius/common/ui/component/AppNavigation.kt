package io.vinicius.common.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.vinicius.common.LocalNavController
import io.vinicius.common.screen.auth.AuthScreen
import io.vinicius.common.screen.countries.CountriesScreen
import io.vinicius.common.screen.country.CountryScreen
import io.vinicius.common.screen.home.HomeScreen
import io.vinicius.common.screen.user.UserScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    CompositionLocalProvider(
        LocalNavController provides navController
    ) {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = { MyTopAppBar(navController, scrollBehavior) },
            bottomBar = { MyBottomAppBar(navController, Modifier.height(56.dp)) }
        ) { padding ->
            NavHost(
                navController = navController,
                startDestination = Destination.Home.name,
                modifier = Modifier.padding(padding)
            ) {
                composable(Destination.Auth.name) { AuthScreen() }
                composable(Destination.Countries.name) { CountriesScreen() }
                composable(Destination.CountryByCode.name) { CountryScreen() }
                composable(Destination.Home.name) { HomeScreen() }
                composable(Destination.User.name) { UserScreen() }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyTopAppBar(navController: NavController, scrollBehavior: TopAppBarScrollBehavior) {
    val backStack by navController.currentBackStackEntryAsState()
    val destination = Destination.valueOf(backStack?.destination?.route)

    CenterAlignedTopAppBar(
        title = { Text(destination?.title ?: "") },
        navigationIcon = {
            if (destination != Destination.Home) {
                IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(Icons.Filled.ArrowBack, "Back Button")
                }
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@Composable
private fun MyBottomAppBar(navController: NavController, modifier: Modifier = Modifier) {
    BottomAppBar(
        modifier = modifier.clickable {
            navController.navigate(Destination.Auth.name)
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(Icons.Filled.LockOpen, "Logged out")
            Text("Logged out")
        }
    }
}

enum class Destination(val title: String) {
    Home("Android Common"),
    Auth("Authentication"),
    User("Me"),
    CountryByCode("Country By Code"),
    Countries("Countries");

    companion object {
        fun valueOf(name: String?): Destination? {
            return if (name == null) {
                null
            } else {
                Destination.valueOf(name)
            }
        }
    }
}