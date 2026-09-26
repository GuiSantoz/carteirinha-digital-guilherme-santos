package com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.component.StatusPill
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.iconBlue
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.iconBlueContainer
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.iconOrange
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.iconOrangeContainer
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.iconPurple
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.iconPurpleContainer
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.iconTeal
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.iconTealContainer
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.successContainer
import com.guilhermesantos.carteirinhadigital2devest_b.core.designsystem.theme.successGreen
import com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.domain.model.UnidadeCurricular

private data class UcVisual(val icon: ImageVector, val container: Color, val tint: Color)

private val ucVisuals = listOf(
    UcVisual(Icons.Filled.Code, iconBlueContainer, iconBlue),
    UcVisual(Icons.Filled.Storage, iconPurpleContainer, iconPurple),
    UcVisual(Icons.Filled.Public, iconTealContainer, iconTeal),
    UcVisual(Icons.Filled.AccountTree, iconOrangeContainer, iconOrange)
)

@Composable
fun UnidadeCurricularCard(
    modifier: Modifier = Modifier,
    unidadeCurricular: UnidadeCurricular,
    index: Int = 0
) {
    val visual = ucVisuals[index % ucVisuals.size]

    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .background(visual.container, RoundedCornerShape(14.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(imageVector = visual.icon, contentDescription = null, tint = visual.tint)
                }
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = unidadeCurricular.nome,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Professor: ${unidadeCurricular.professor}",
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Icon(
                    imageVector = Icons.Filled.ChevronRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                StatusPill(
                    text = "N1: ${unidadeCurricular.nota1}",
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    contentColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
                StatusPill(
                    text = "N2: ${unidadeCurricular.nota2}",
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    contentColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
                StatusPill(
                    text = "Média: ${unidadeCurricular.media}",
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary
                )
            }

            val faltasOk = unidadeCurricular.faltas <= 5
            StatusPill(
                text = "Faltas: ${unidadeCurricular.faltas}",
                containerColor = if (faltasOk) successContainer else MaterialTheme.colorScheme.errorContainer,
                contentColor = if (faltasOk) successGreen else MaterialTheme.colorScheme.error
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnidadeCurricularCardPreview() {
    UnidadeCurricularCard(
        unidadeCurricular = UnidadeCurricular(
            id = "1",
            nome = "Matemática",
            professor = "Dr. Silva",
            nota1 = 8.5,
            nota2 = 7.0,
            media = 7.75,
            faltas = 2
        )
    )
}
