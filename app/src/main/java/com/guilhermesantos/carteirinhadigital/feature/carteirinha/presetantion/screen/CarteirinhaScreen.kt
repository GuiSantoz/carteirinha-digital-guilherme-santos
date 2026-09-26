package com.guilhermesantos.carteirinhadigital2devest_b.feature.carteirinha.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.component.AppScreenHeader
import com.guilhermesantos.carteirinhadigital2devest_b.feature.carteirinha.presentation.component.CarteirinhaCard
import com.guilhermesantos.carteirinhadigital2devest_b.feature.login.domain.model.UsuarioLogado
import com.guilhermesantos.myapplication.QrCode

@Composable
fun CarteirinhaScreen(
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    usuario: UsuarioLogado? = null
) {
    val nome = usuario?.nome ?: "Guilherme Santos"
    val matricula = usuario?.id ?: "2024-DF8809"

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 16.dp)
    ) {
        AppScreenHeader(
            title = "Carteirinha Digital",
            onBackClick = navController?.let { nav -> { nav.popBackStack() } }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            CarteirinhaCard(
                nome = nome,
                matricula = matricula,
                validade = "Dezembro / 2026"
            )

            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {
                    Text(
                        text = "QR Code de acesso",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    QrCode(
                        conteudo = matricula,
                        modifier = Modifier.size(200.dp)
                    )
                    Text(
                        text = "Apresente este QR Code na catraca ou leitor da instituição.",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CarteirinhaScreenPreview() {
    CarteirinhaScreen()
}
