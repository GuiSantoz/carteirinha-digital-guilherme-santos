package com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.presentation

import com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val listaUnidadesCurriculares: List<UnidadeCurricular> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
}