package com.guilhermesantos.carteirinhadigital.app.di

import com.guilhermesantos.carteirinhadigital.core.auth.SessionTokenStore
import com.guilhermesantos.carteirinhadigital.feature.login.domain.repository.LoginRepository
import com.guilhermesantos.carteirinhadigital.feature.aluno.unidadescurriculares.domain.repository.UnidadeCurricularRepository

interface AppContainer {
    val sessionTokenStore : SessionTokenStore

    val loginRepository : LoginRepository

    val unidadeCurricularRepository : com.guilhermesantos.carteirinhadigital.feature.aluno.unidadescurriculares.domain.repository.UnidadeCurricularRepository
}