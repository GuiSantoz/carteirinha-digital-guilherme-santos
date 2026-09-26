package com.guilhermesantos.carteirinhadigital2devest_b.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.guilhermesantos.carteirinhadigital2devest_b.app.di.AppContainer
import com.guilhermesantos.carteirinhadigital2devest_b.app.navigation.AppNavHost
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.CarteirinhaDigital2DEVEST_BTheme

@Composable
fun App(container: AppContainer) {
    CarteirinhaDigital2DEVEST_BTheme() {
        val navController = rememberNavController()
        AppNavHost(
            navController = navController,
            container = container
        )
    }
}