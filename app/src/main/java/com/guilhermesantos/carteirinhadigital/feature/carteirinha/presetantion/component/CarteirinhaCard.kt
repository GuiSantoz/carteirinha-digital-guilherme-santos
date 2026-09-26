package com.guilhermesantos.carteirinhadigital2devest_b.feature.carteirinha.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.component.StatusPill
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.cardMaroonEnd
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.cardMaroonStart
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.successContainer
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.successGreen

/**
 * Card da Carteirinha Digital com o mesmo visual (gradiente bordô, selo "ATIVO",
 * avatar circular e dados em destaque) usado tanto na Home (resumo) quanto na
 * tela cheia da Carteirinha.
 */
@Composable
fun CarteirinhaCard(
    nome: String,
    matricula: String,
    validade: String,
    modifier: Modifier = Modifier,
    compact: Boolean = false
) {
    Surface(
        shape = RoundedCornerShape(24.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .background(
                    Brush.linearGradient(
                        colors = listOf(cardMaroonStart, cardMaroonEnd),
                        start = Offset(0f, 0f),
                        end = Offset(1000f, 1000f)
                    )
                )
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(if (compact) 12.dp else 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.School,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Text(
                        text = "CARTEIRINHA DIGITAL",
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                StatusPill(
                    text = "ATIVO",
                    containerColor = successContainer,
                    contentColor = successGreen,
                    dot = true
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Surface(
                    shape = CircleShape,
                    color = Color.White,
                    modifier = Modifier.size(if (compact) 56.dp else 72.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Foto do aluno",
                        tint = cardMaroonStart,
                        modifier = Modifier.padding(if (compact) 10.dp else 14.dp)
                    )
                }
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(
                        text = nome,
                        color = Color.White,
                        fontSize = if (compact) 16.sp else 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    if (!compact) {
                        CardLabelValue(label = "MATRÍCULA", value = matricula)
                        CardLabelValue(label = "VALIDADE", value = validade)
                    } else {
                        Text(
                            text = "Matrícula $matricula",
                            color = Color.White.copy(alpha = 0.85f),
                            fontSize = 13.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CardLabelValue(label: String, value: String) {
    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
        Text(
            text = label,
            color = Color.White.copy(alpha = 0.65f),
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = value,
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CarteirinhaCardPreview() {
    MaterialTheme {
        CarteirinhaCard(
            nome = "Guilherme Santos",
            matricula = "2024-DF8809",
            validade = "Dezembro / 2026"
        )
    }
}
