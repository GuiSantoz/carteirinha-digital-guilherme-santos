package com.guilhermesantos.carteirinhadigital2devest_b.app.di.

import com.guilhermesantos.carteirinhadigital2devest_b.core.auth.SessionTokenStore
import com.guilhermesantos.carteirinhadigital2devest_b.feature.login.domain.repository.LoginRepository
import com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository

interface AppContainer {
    val sessionTokenStore : SessionTokenStore

    val loginRepository : LoginRepository

    val unidadeCurricularRepository : UnidadeCurricularRepository
}