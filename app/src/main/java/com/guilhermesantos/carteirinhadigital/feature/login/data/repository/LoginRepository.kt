package com.guilhermesantos.carteirinhadigital2devest_b.feature.login.data.repository

import com.guilhermesantos.carteirinhadigital2devest_b.feature.login.domain.model.UsuarioLogado

interface LoginRepository {
    suspend fun login(usuario: String, senha: String): Result<UsuarioLogado>
}