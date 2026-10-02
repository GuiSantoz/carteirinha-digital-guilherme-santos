package com.guilhermesantos.carteirinhadigital2devest_b.app.di

import com.guilhermesantos.carteirinhadigital2devest_b.core.auth.SessionTokenStore
import com.guilhermesantos.carteirinhadigital2devest_b.core.network.NetworkClient
import com.guilhermesantos.carteirinhadigital2devest_b.feature.login.data.remote.service.AuthApi
import com.guilhermesantos.carteirinhadigital2devest_b.feature.login.data.repository.ApiLoginRepositoryImpl
import com.guilhermesantos.carteirinhadigital2devest_b.feature.login.data.repository.FakeAuthRepository
import com.guilhermesantos.carteirinhadigital2devest_b.feature.login.domain.repository.LoginRepository
import com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.data.remote.service.UnidadeCurricularApi
import com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.data.repository.ApiUnidadeCurricularRepositoryImpl
import com.guilhermesantos.carteirinhadigital2devest_b.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository

class DefaultAppContainer : AppContainer {
    override val sessionTokenStore : SessionTokenStore = SessionTokenStore()
    private val networkClient =
        NetworkClient(
            baseUrl = BASE_URL,
            sessionTokenStore = sessionTokenStore
        )

    private val authApi : AuthApi by lazy {
        networkClient.createPublic(
            AuthApi::class.java
        )
    }
    private val unidadeCurricularApi : UnidadeCurricularApi by lazy {
        networkClient.createAuthenticated(
            UnidadeCurricularApi::class.java
        )
    }
    override val loginRepository : LoginRepository by lazy {
        if (USE_FAKE_LOGIN_REPOSITORY ) {
            FakeAuthRepository()
        } else {
            ApiLoginRepositoryImpl(
                api =authApi
            )
        }
    }
    override val unidadeCurricularRepository : UnidadeCurricularRepository by lazy {
        ApiUnidadeCurricularRepositoryImpl(
            api = unidadeCurricularApi
        )
    }
    companion object {
        private const val BASE_URL = "http://10.0.2.2:8080/"
        private const val USE_FAKE_LOGIN_REPOSITORY = false
    }
}