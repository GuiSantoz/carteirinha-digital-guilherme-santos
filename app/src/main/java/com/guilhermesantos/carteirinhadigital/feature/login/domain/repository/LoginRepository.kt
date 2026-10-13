package com.guilhermesantos.carteirinhadigital.feature.login.domain.repository

import com.guilhermesantos.carteirinhadigital.feature.login.domain.model.UsuarioLogado

interface LoginRepository {
    suspend fun login(login: String, senha: String): Result<UsuarioLogado>
}