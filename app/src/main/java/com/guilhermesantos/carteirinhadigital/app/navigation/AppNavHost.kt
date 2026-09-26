package com.guilhermesantos.carteirinhadigital2devest_b.app.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.guilhermesantos.carteirinhadigital2devest_b.app.di.AppContainer
import com.guilhermesantos.carteirinhadigital2devest_b.app.session.SessionViewModel
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.component.AppBottomNavBar
import com.guilhermesantos.carteirinhadigital2devest_b.feature.carteirinha.presentation.screen.CarteirinhaScreen
import com.guilhermesantos.carteirinhadigital2devest_b.feature.home_aluno.presentation.screen.HomeScreen
import com.guilhermesantos.carteirinhadigital2devest_b.feature.login.presentation.screen.LoginScreen
import com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.presentation.UnidadeCurricularViewModel
import com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.presentation.factory.UnidadeCurricularViewModelFactory
import com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.presentation.screen.UnidadeCurricularScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    sessionViewModel: SessionViewModel = viewModel(),
    container: AppContainer,
) {
    val usuarioLogado by sessionViewModel.usuarioLogado.collectAsStateWithLifecycle()
    val usuario = usuarioLogado

    // "Avisos" e "Perfil" ainda não têm tela própria nesta entrega;
    // a barra fica visível (igual ao protótipo) mas só navega para telas existentes.
    val onBottomNavigate: (String) -> Unit = { route ->
        when (route) {
            Routes.HomeAluno.route -> navController.navigate(Routes.HomeAluno.route) {
                popUpTo(Routes.HomeAluno.route) { inclusive = true }
            }

            Routes.Carteirinha.route -> navController.navigate(Routes.Carteirinha.route)
            else -> { /* Avisos / Perfil: em breve */
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
        composable(Routes.Login.route) {

            LoginScreen(
                navController = navController,
                onLoginSucesso = { usuario ->
                    container.authTokenStore.setToken(usuario.token)
                    sessionViewModel.setUsuarioLogado(usuario)
                    navController.navigate(Routes.HomeAluno.route)
                }
            )
        }

        composable(Routes.Carteirinha.route) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = {
                    AppBottomNavBar(
                        currentRoute = Routes.Carteirinha.route,
                        onNavigate = onBottomNavigate
                    )
                }
            ) { innerPadding ->

                CarteirinhaScreen(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController,
                    usuario = usuario
                )
            }
        }

        composable(Routes.HomeAluno.route) {

            if (usuario == null) {
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route)
                }
            } else {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AppBottomNavBar(
                            currentRoute = Routes.HomeAluno.route,
                            onNavigate = onBottomNavigate
                        )
                    }
                ) { innerPadding ->
                    HomeScreen(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding),
                        usuario = usuario
                    )
                }
            }
        }

        composable(Routes.UCAluno.route) {

            if (usuario == null) {
                LaunchedEffect(Unit) {
                    navController.navigate(Routes.Login.route)
                }

            } else {
                val unidadeCurricularFactory = remember(
                    container.unidadeCurricularRepository
                ) {
                    UnidadeCurricularViewModelFactory(
                        repository = container.unidadeCurricularRepository
                    )
                }

                val unidadeCurricularViewModel: UnidadeCurricularViewModel = viewModel(
                    factory = unidadeCurricularFactory
                )
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AppBottomNavBar(
                            currentRoute = Routes.UCAluno.route,
                            onNavigate = onBottomNavigate
                        )
                    }
                ) { innerPadding ->

                    UnidadeCurricularScreen(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        viewModel = unidadeCurricularViewModel
                    )
                }
            }
        }
    }
}
