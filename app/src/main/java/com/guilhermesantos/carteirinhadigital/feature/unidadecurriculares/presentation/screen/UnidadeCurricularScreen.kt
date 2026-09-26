package com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.component.AppScreenHeader
import com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.presentation.UnidadeCurricularViewModel
import com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.presentation.component.UnidadeCurricularCard


@Composable
fun UnidadeCurricularScreen(
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    viewModel: UnidadeCurricularViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val errorMessage = uiState.errorMessage

    LaunchedEffect(Unit) { viewModel.carregar() }

    Column(modifier = modifier.fillMaxSize()) {
        AppScreenHeader(
            title = "Unidades Curriculares",
            onBackClick = navController?.let { nav -> { nav.popBackStack() } }
        )

        when {
            uiState.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            errorMessage != null -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = errorMessage,
                        color = MaterialTheme.colorScheme.error
                    )
                    Button(
                        modifier = Modifier.padding(16.dp),
                        onClick = { viewModel.carregar() }
                    ) {
                        Text(text = "Tente Novamente")
                    }
                }
            }

            uiState.listaUnidadesCurriculares.isEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Nenhuma unidade curricular encontrada.")
                }
            }

            else -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    itemsIndexed(uiState.listaUnidadesCurriculares) { index, unidadeCurricular ->
                        UnidadeCurricularCard(unidadeCurricular = unidadeCurricular, index = index)
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun UnidadeCurricularScreenPreview() {
    UnidadeCurricularScreen()
}
