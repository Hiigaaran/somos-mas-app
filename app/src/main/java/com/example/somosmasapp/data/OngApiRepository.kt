package com.example.somosmasapp.data

import com.example.somosmasapp.data.dto.Login
import com.example.somosmasapp.data.dto.Register

class OngApiRepository(private val ongApiDatasource: OngApiDatasource) {
    fun doRegister(body: Register, listener: ResponseListener<Void>) {
        this.ongApiDatasource.doRegister(body, listener)
    }

    fun doLogin(body: Login, listener: ResponseListener<Void>) {
        this.ongApiDatasource.doLogin(body, listener)
    }
}