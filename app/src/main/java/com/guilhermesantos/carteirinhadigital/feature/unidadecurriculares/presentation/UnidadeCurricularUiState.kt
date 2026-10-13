package com.guilhermesantos.carteirinhadigital.feature.unidadecurriculares.presentation

import com.guilhermesantos.carteirinhadigital.feature.unidadecurriculares.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val isLoading: Boolean = false,
    val unidades: List<UnidadeCurricular> = emptyList(),
    val errorMessage: String? = null
)