package com.guilhermesantos.carteirinhadigital.app.di

import com.guilhermesantos.carteirinhadigital.core.auth.SessionTokenStore
import com.guilhermesantos.carteirinhadigital.feature.login.domain.repository.LoginRepository
import com.guilhermesantos.carteirinhadigital.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository

interface AppContainer {
    val sessionTokenStore : SessionTokenStore

    val loginRepository : LoginRepository

    val unidadeCurricularRepository : UnidadeCurricularRepository
}