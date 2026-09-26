package com.guilhermesantos.carteirinhadigital2devest_b.feature.home_aluno.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.guilhermesantos.carteirinhadigital2devest_b.app.navigation.Routes
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.component.AppTopHeader
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.iconTeal
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.iconTealContainer
import com.guilhermesantos.carteirinhadigital2devest_b.feature.carteirinha.presentation.component.CarteirinhaCard
import com.guilhermesantos.carteirinhadigital2devest_b.feature.home_aluno.presentation.component.QuickNavCard
import com.guilhermesantos.carteirinhadigital2devest_b.feature.login.domain.model.UsuarioLogado

@Composable
fun HomeScreen(
    navController: NavController = NavController(
        LocalContext.current
    ),
    modifier: Modifier = Modifier,
    usuario: UsuarioLogado? = null
) {
    val nomeExibicao = usuario?.nome ?: "Aluno(a)"
    val primeiroNome = nomeExibicao.trim().substringBefore(" ")

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item {
            AppTopHeader(
                nome = nomeExibicao,
                subtitulo = usuario?.curso ?: "Carteirinha Digital"
            )
        }

        item {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Olá, $primeiroNome!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Tenha um excelente dia de estudos.",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        item {
            CarteirinhaCard(
                nome = nomeExibicao,
                matricula = usuario?.id ?: "-",
                validade = "Dezembro / 2026",
                compact = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            )
        }

        item {
            Text(
                text = "Navegação Rápida",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                QuickNavCard(
                    icon = Icons.Filled.CreditCard,
                    iconContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    iconTint = MaterialTheme.colorScheme.primary,
                    title = "Carteirinha Digital",
                    subtitle = "Ver carteirinha",
                    onClick = { navController.navigate(Routes.Carteirinha.route) },
                    modifier = Modifier.weight(1f)
                )
                QuickNavCard(
                    icon = Icons.Filled.MenuBook,
                    iconContainerColor = iconTealContainer,
                    iconTint = iconTeal,
                    title = "Unidades Curriculares",
                    subtitle = "Notas e faltas",
                    onClick = { navController.navigate(Routes.UCAluno.route) },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        modifier = Modifier.fillMaxSize(),
        usuario = UsuarioLogado(
            id = "2024-DF8809",
            nome = "Guilherme Santos",
            curso = "Desenvolvimento de Sistemas",
            turma = "Turma A",
            token = ""
        )
    )
}
