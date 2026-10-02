package com.guilhermesantos.carteirinhadigital2devest_b.core.auth

class SessionTokenStore {

    @Volatile
    private var token: String? = null

    fun salvar(token: String) {
        this.token = token
    }

    fun obter(): String? {
        return token
    }

    fun limpar() {
        token = null
    }
}