package com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.domain.repository

import com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.domain.model.UnidadeCurricular

interface UnidadeCurricularRepository {
    suspend fun listarUnidadesCurriculares(): Result<List<UnidadeCurricular>>
}