package com.guilhermesantos.carteirinhadigital.app

import android.app.Application
import com.guilhermesantos.carteirinhadigital.app.di.AppContainer
import com.guilhermesantos.carteirinhadigital.app.di.DefaultAppContainer

class CarteirinhaApplication : Application() {
    val container: AppContainer by lazy {
        DefaultAppContainer()
    }
}