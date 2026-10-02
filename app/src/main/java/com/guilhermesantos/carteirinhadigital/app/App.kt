package com.guilhermesantos.carteirinhadigital2devest_b.app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.guilhermesantos.carteirinhadigital2devest_b.app.di.AppContainer
import com.guilhermesantos.carteirinhadigital2devest_b.app.navigation.AppNavHost
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.CarteirinhaDigital2DEVEST_BTheme

@Composable
fun App(container: AppContainer) {

    val systemDarkTheme = isSystemInDarkTheme()
    var darkTheme by rememberSaveable { mutableStateOf(systemDarkTheme) }

    CarteirinhaDigital2DEVEST_BTheme(
        darkTheme = darkTheme
    ) {
        val navController = rememberNavController()

        AppNavHost(
            navController = navController,
            darkTheme = darkTheme,
            onDarkThemeChange = { darkTheme = it },
            container = container
        )
    }
}