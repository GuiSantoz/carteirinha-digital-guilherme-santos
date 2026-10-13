package com.guilhermesantos.carteirinhadigital.app.navigation.auth

import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.guilhermesantos.carteirinhadigital.app.navigation.GraphRoutes
import com.guilhermesantos.carteirinhadigital.feature.login.domain.model.UsuarioLogado
import com.guilhermesantos.carteirinhadigital.feature.login.domain.repository.LoginRepository
import com.guilhermesantos.carteirinhadigital.feature.login.presentation.LoginViewModel
import com.guilhermesantos.carteirinhadigital.feature.login.presentation.factory.LoginViewModelFactory
import com.guilhermesantos.carteirinhadigital.feature.login.presentation.screen.LoginScreen

fun NavGraphBuilder.authNavGraph(
    loginRepository: LoginRepository,
    onLoginSucesso: (UsuarioLogado) -> Unit
) {
    navigation(
        startDestination = AuthRoutes.LOGIN,
        route = GraphRoutes.AUTH
    ) {
        composable(route = AuthRoutes.LOGIN) {
            val factory = remember(loginRepository) {
                LoginViewModelFactory(
                    repository = loginRepository
                )
            }

            val loginViewModel: LoginViewModel = viewModel(
                factory = factory
            )

            LoginScreen(
                viewModel = loginViewModel,
                onLoginSucesso = onLoginSucesso
            )
        }
    }
}