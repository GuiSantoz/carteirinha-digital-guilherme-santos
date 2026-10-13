package com.guilhermesantos.carteirinhadigital.feature.unidadecurriculares.data.remote.service

import com.guilhermesantos.carteirinhadigital.feature.unidadecurriculares.data.remote.dto.UnidadeCurricularDto
import retrofit2.http.GET

interface UnidadeCurricularApi {

    @GET("unidades-curriculares")
    suspend fun listar(): List<UnidadeCurricularDto>
}