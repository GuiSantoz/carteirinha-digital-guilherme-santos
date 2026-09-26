package com.guilhermesantos.carteirinhadigital2devest_b.app.di

import com.guilhermesantos.carteirinhadigital2devest_b.core.auth.AuthTokenStore
import com.guilhermesantos.carteirinhadigital2devest_b.feature.login.data.repository.LoginRepository
import com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository

interface AppContainer {

    val loginRepository: LoginRepository

    val unidadeCurricularRepository: UnidadeCurricularRepository

    val authTokenStore: AuthTokenStore
}