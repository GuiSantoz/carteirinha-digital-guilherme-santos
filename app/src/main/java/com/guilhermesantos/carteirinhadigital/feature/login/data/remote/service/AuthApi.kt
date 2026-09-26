package com.guilhermesantos.carteirinhadigital2devest_b.feature.login.data.remote.service

import com.guilhermesantos.carteirinhadigital2devest_b.feature.login.data.remote.dto.LoginRequestDto
import com.guilhermesantos.carteirinhadigital2devest_b.feature.login.data.remote.dto.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body body: LoginRequestDto): LoginResponseDto
}